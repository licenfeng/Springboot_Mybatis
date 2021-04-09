package com.example.controller;


import com.example.entity.*;

import com.example.service.TreatyCommonService;
import com.example.utils.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/breTreatyCommon")
public class BreTreatyCommonController {
    @Autowired
    TreatyCommonService treatyCommonService;

    private Logger logger = LogManager.getLogger(BreTreatyCommonController.class);

    @RequestMapping("/getBreFieldExportInfoList")
    public ResultInfoDto getBreFieldExportInfoList(BreFieldExportInfoDto breFieldExportInfoDto) {
        try {
            List<BreFieldExportInfoDto> list = treatyCommonService.getBreFieldExportInfoList(breFieldExportInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            logger.error("getBreFieldExportInfoList" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }

    }

    @RequestMapping("/updateBreFieldExportInfo")
    public ResultInfoDto updateBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto) {

        try {
            int i = treatyCommonService.updateBreFieldExportInfo(breFieldExportInfoDto);
            return ResultUtils.success(i);

        } catch (Exception e) {
            logger.error("updateBreFieldExportInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }


    }

    @RequestMapping("/addBreFieldExportInfo")
    public ResultInfoDto addBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto) {
        try {
            int i = treatyCommonService.addBreFieldExportInfo(breFieldExportInfoDto);
            return ResultUtils.success(i);
        } catch (Exception e) {
            logger.error("addBreFieldExportInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }

    }

    @RequestMapping("/deleteBreFieldExportInfo")
    public ResultInfoDto deleteBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto) {
        try {
            int i = treatyCommonService.deleteBreFieldExportInfo(breFieldExportInfoDto);
            return ResultUtils.success(i);
        } catch (Exception e) {
            logger.error("deleteBreFieldExportInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }

    @RequestMapping("/getBreWordbookInfoPage")
    public ResultInfoDto getBreWordbookInfoPage(BreWordbookInfoDto breWordbookInfoDto) {
        try {
            PageInfo pageInfo = treatyCommonService.getBreWordbookInfoPage(breWordbookInfoDto);
            return ResultUtils.success(pageInfo);
        } catch (Exception e) {
            logger.error("getBreWordbookInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }

    @RequestMapping("/getBreWordbookInfo")
    public ResultInfoDto getBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto) {
        try {
            List<BreWordbookInfoDto> list = treatyCommonService.getBreWordbookInfo(breWordbookInfoDto);

            return ResultUtils.success(list);
        } catch (Exception e) {
            logger.error("getBreWordbookInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }

    @RequestMapping("/getBreWordbookInfoGroupByType")
    public ResultInfoDto getBreWordbookInfoGroupByType() {
        try {
            List<BreWordbookInfoDto> list = treatyCommonService.getBreWordbookInfoGroupByType();
            return ResultUtils.success(list);
        } catch (Exception e) {
            logger.error("getBreWordbookInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }


    @RequestMapping("/getBreWordbookInfoGroupByKeyType")
    public ResultInfoDto getBreWordbookInfoGroupByKeyType(BreWordbookInfoDto breWordbookInfoDto) {

        try {
            List<BreWordbookInfoDto> list = treatyCommonService.getBreWordbookInfoGroupByKeyType(breWordbookInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            logger.error("getBreWordbookInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }

    @RequestMapping("/addBreWordbookInfo")
    public ResultInfoDto addBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto) {
        try {
            int state = treatyCommonService.addBreWordbookInfo(breWordbookInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            logger.error("addBreWordbookInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }

    @RequestMapping("/updateBreWordbookInfo")
    public ResultInfoDto updateBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto) {
        try {
            int state = treatyCommonService.updateBreWordbookInfo(breWordbookInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            logger.error("updateBreWordbookInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }

    }

    @RequestMapping("/deleteBreWordbookInfo")
    public ResultInfoDto deleteBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto) {


        try {
            int state = treatyCommonService.deleteBreWordbookInfo(breWordbookInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            logger.error("deleteBreWordbookInfo" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }

    @RequestMapping("/getFiledWorkIdList")
    public ResultInfoDto getFiledWorkIdList() {
        try {
            List<BreFieldExportInfoDto> list = treatyCommonService.getFiledWorkIdList();
            return ResultUtils.success(list);

        } catch (Exception e) {
            logger.error("getFiledWorkIdList" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }

    @RequestMapping("/getBreFieldInfoList")
    public ResultInfoDto getBreFieldInfoList(BreFieldInfoDto breFieldInfoDto) {
        try {
            List<BreFieldInfoDto> list = treatyCommonService.getBreFieldInfoList(breFieldInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            logger.error("getBreFieldInfoList" + e.toString(), e);
            return ResultUtils.error(e.toString());
        }
    }


    @RequestMapping("/exportBreTreatAllCsv")
    public void exportBreTreatAllCsv(HttpServletResponse response, BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            String fileText = treatyCommonService.exportBreTreatAllCsv(null, breTreatAllInfoDto);
            response.setContentType("application/octet-stream;charset=utf-8");
            OutputStream os = response.getOutputStream();
            response.setHeader("Content-disposition", "attachment;filename=flg.csv");//默认Excel名称
            os.write(fileText.getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {
            logger.error("文件导出异常" + e.toString(), e);
        }
    }

    @RequestMapping("/exportBreTreatAllExcl")
    public void exportBreTreatAllExcl(HttpServletResponse response, BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            HSSFWorkbook workbook = treatyCommonService.exportBreTreatAllExcl(null, breTreatAllInfoDto);
            if (workbook != null) {
                OutputStream out = null;
                try {
                    // 取当前时间的4-13位作名字
                    String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
                    // 给出位置选择框
                    String headStr = "attachment; filename=\"" + fileName + "\"";
                    response.setContentType("application/vnd.ms-excel;charset=utf-8");
                    response.setHeader("Content-Disposition", headStr);
                    out = new BufferedOutputStream(response.getOutputStream());
                    /***************/
                    workbook.write(out);
                    out.flush();
                } catch (IOException e) {
                    logger.error("文件导出异常" + e.toString(), e);
                } finally {
                    if (out != null)
                        out.close();
                }
            }
        } catch (Exception e) {
            logger.error("文件导出异常" + e.toString(), e);
        }
    }


}
