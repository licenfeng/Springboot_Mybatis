package com.example.utils;

import com.example.entity.ResultInfoDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUploadUtils {

    static Map<Integer,String > mapKey = new HashMap<>();
    private static Logger log = LogManager.getLogger(ExcelUploadUtils.class);
    private final static String excel2003L =".xls";    //2003- 版本的excel
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel

    public static ResultInfoDto excelUpload(InputStream inputStream, String fileName, Map<String,String> map, Class clazz) throws Exception {
        Workbook wb=getWorkbook(inputStream,fileName);
        ResultInfoDto resultInfoDto=getExcelXls(wb,map,clazz);
        return resultInfoDto;
    }

    static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception{
        Workbook wb = null;
        if(StringUtils.isBlank(fileName)){
            return null;
        }
        String fileType = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        if(excel2003L.equals(fileType)){
            wb = new HSSFWorkbook(inStr);  //2003-
        }else if(excel2007U.equals(fileType)){
            wb = new XSSFWorkbook(inStr);  //2007+
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 获取数据
     * @param cell
     * @return
     */
    static String getCellValue(Cell cell) {
        String value;
        if (cell == null){
            return "";
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:    //数字
                if (HSSFDateUtil.isCellDateFormatted(cell)) {//是否为时间类型
                    Date d = cell.getDateCellValue();
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    value = format.format(d);
                } else {
                    value = new DecimalFormat("#").format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING:        //字符串
                value = cell.getStringCellValue().trim();
                break;
            case Cell.CELL_TYPE_BOOLEAN:    //Boolean
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:    //公式
                value = cell.getCellFormula();
                break;
            default:
                value = "";
                break;
        }
        return value;

    }

    static ResultInfoDto getExcelXls(Workbook book, Map<String, String> map,Class clazz)  {

        List list=new ArrayList();
        Sheet sheet = book.getSheetAt(0);

        //获取第一个sheet页

        //获取行数
        int rowNum = sheet.getPhysicalNumberOfRows();
        log.info("sheet name:" + sheet.getSheetName() + ", rowNum:" + rowNum);
        if (rowNum < 1) {
            log.error("没有内容");
            return ResultUtils.error("文件没有内容");
        }
        //获得总列数
        int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
        //获得总行数
        for (int i = 0; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            try {
                Object obj = clazz.newInstance();
                for (int m = 0; m < cellNum; m++) {
                    if (0 == i) {
                        String name=getCellValue(row.getCell(m));
                        mapKey.put(m,map.get(name));
                    }else{
                        if(mapKey.containsKey(m)){
                            String methodName = "set"+CommonUtils.aaToAa(mapKey.get(m)) ;
                            Method method = clazz.getDeclaredMethod(methodName, String.class);
                            method.invoke(obj, getCellValue(row.getCell(m)));
                        }
                    }
                }
                if(i>0){
                    list.add(obj);
                }
            }catch (Exception e){
               e.printStackTrace();
            }
        }
        return ResultUtils.success(list);
    }

}
