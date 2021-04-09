package com.example.controller;

import com.example.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.entity.ResultInfoDto;

import java.io.InputStream;
import java.util.*;

import com.example.entity.BreCurrencyInfoDto;
import com.example.service.BreCurrencyInfoService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@ResponseBody
@RequestMapping("/breCurrencyInfo")
public class BreCurrencyInfoController {
    @Autowired
    BreCurrencyInfoService breCurrencyInfoService;
    private Logger log = LogManager.getLogger(BreCurrencyInfoController.class);

    @RequestMapping("/getBreCurrencyInfoList")
    public ResultInfoDto getBreCurrencyInfoList(BreCurrencyInfoDto breCurrencyInfoDto) {
        try {
            List<BreCurrencyInfoDto> list = breCurrencyInfoService.getBreCurrencyInfoList(breCurrencyInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/updateBreCurrencyInfo")
    public ResultInfoDto updateBreCurrencyInfo(BreCurrencyInfoDto breCurrencyInfoDto) {
        try {
            int size = breCurrencyInfoService.updateBreCurrencyInfoInfo(breCurrencyInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/delBreCurrencyInfoInfo")
    public ResultInfoDto delBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto) {
        try {
            int size = breCurrencyInfoService.delBreCurrencyInfoInfo(breCurrencyInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/addBreCurrencyInfoInfo")
    public ResultInfoDto addBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto) {
        try {
            int size = breCurrencyInfoService.addBreCurrencyInfoInfo(breCurrencyInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/uploadCurrency")
    public ResultInfoDto uploadCurrency(HttpServletRequest request, @RequestParam(value = "isAll") String isAll, @RequestParam("file") MultipartFile multipartFile) {
        try {
            InputStream inputStream = multipartFile.getInputStream();
            String msg="";
            // input的name值
            List list = (List) request.getParts();
            if (list.size() < 0) {
                return ResultUtils.error(-1, "没有获取到上传文件。");
            }
            String fileName = multipartFile.getOriginalFilename();
            msg = breCurrencyInfoService.uploadCurrency(fileName,isAll, inputStream);
            return ResultUtils.success(msg);
        } catch (Exception e) {
            return ResultUtils.error(-1, "没有获取到上传文件");
        }
    }

}