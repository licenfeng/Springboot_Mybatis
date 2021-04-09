package com.example.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.entity.BreFieldExportInfoDto;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.junit.platform.commons.util.StringUtils;

public class ExcelExportUtils {
    // 显示的导出表的标题
    private String title;
    // 导出表的列名
    private List<BreFieldExportInfoDto> headList;
    // 表的内容
    private List<Object> dataList = new ArrayList<Object>();

    private Class clazz;

    // 构造方法，传入要导出的数据
    public ExcelExportUtils(String title, List<BreFieldExportInfoDto> headList, List<Object> dataList, Class clazz) {
        this.dataList = dataList;
        this.headList = headList;
        this.title = title;
        this.clazz = clazz;
    }

    /*
     * 导出数据
     */
    public HSSFWorkbook exclExport() {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(); // 创建工作簿对象
            HSSFSheet sheet = workbook.createSheet(title); // 创建工作表
            // 产生表格标题行
            HSSFRow rowm = sheet.createRow(0);
            HSSFCell cellTiltle = rowm.createCell(0);

            // sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面 - 可扩展】
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);// 获取列头样式对象
            HSSFCellStyle style = this.getStyle(workbook); // 单元格样式对象

            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (headList.size() - 1)));
            cellTiltle.setCellStyle(columnTopStyle);
            cellTiltle.setCellValue(title);

            // 定义所需列数
            int columnNum = headList.size();
            HSSFRow rowRowName = sheet.createRow(2); // 在索引2的位置创建行(最顶端的行开始的第二行)
            //添加 文件头对应英文名字 id
            List<String> strHead = new ArrayList<>();
            // 将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                BreFieldExportInfoDto breDto = headList.get(n);
                HSSFCell cellRowName = rowRowName.createCell(n); // 创建列头对应个数的单元格
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING); // 设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(breDto.getFieldDesc());
                cellRowName.setCellValue(text); // 设置列头单元格的值
                cellRowName.setCellStyle(columnTopStyle); // 设置列头单元格样式
                strHead.add(breDto.getFieldId());
            }

            // 将查询出的数据设置到sheet对应的单元格中
            for (int i = 0; i < dataList.size(); i++) {
                Object obj = dataList.get(i);// 遍历每个对象
                HSSFRow row = sheet.createRow(i + 3);// 创建所需的行数

                //根据文件头的个数添加对应的值
                for (int j = 0; j < strHead.size(); j++) {
                    // 获取文件头，对应变量名
                    String strName = strHead.get(i);
                    String end = CommonUtils.get_ToAa(strName);
                    Field[] fields = clazz.getDeclaredFields();
                    Object value = "";
                    for (Field field : fields) {
                        //获取文件头对应数值
                        if (end.equals(field.getName())) {
                            field.setAccessible(true);
                            value = field.get(obj);
                            break;
                        }
                    }
                    // 设置单元格的数据类型
                    HSSFCell cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
                    if (!"".equals(value) && value != null) {
                        cell.setCellValue(value.toString()); // 设置单元格的值
                    } else {
                        cell.setCellValue("");
                    }
                    cell.setCellStyle(style); // 设置单元格样式
                }
            }
            // 让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    // 当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell == null) {
                            continue;
                        }
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            if (currentCell.getStringCellValue() == null) {
                                continue;
                            }
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * 列头单元格样式
     */
    HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        // 字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
     * 列数据信息单元格样式
     */
    HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        // font.setFontHeightInPoints((short)10);
        // 字体加粗
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        // 设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        // 设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        // 设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;

    }

    public static void main(String[] args) {
        String[] rowName = {"id", "姓名", "city", "用户名", "省份"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        //   List<BmAgent> list = bmAgentService.selectList(agent);
        for (int i = 0; i < 10; i++) {
            //  Object[] element = {list.get(i).getId(),list.get(i).getAgentName(),list.get(i).getCityName(),list.get(i).getAdminId(),list.get(i).getProvinceName()};
            //   dataList.add(element);
        }
        //ExcelExportUtils utils = new ExcelExportUtils("测试", rowName, dataList);
        try {
            //   utils.export(response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

