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

import com.example.entity.BreCountryRegionInfoDto;
import com.example.service.BreCountryRegionInfoService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@RestController
@ResponseBody
@RequestMapping("/breCountryRegionInfo")
public class BreCountryRegionInfoController {
    @Autowired
    BreCountryRegionInfoService breCountryRegionInfoService;
    private Logger logger = LogManager.getLogger(BreCountryRegionInfoController.class);

    @RequestMapping("/getBreCountryRegionInfoList")
    public ResultInfoDto getBreCountryRegionInfoList(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        //edit by licenfeng
        //edit by  dev
        try {
            List<BreCountryRegionInfoDto> list = breCountryRegionInfoService.getBreCountryRegionInfoList(breCountryRegionInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/updateBreCountryRegionInfo")
    public ResultInfoDto updateBreCountryRegionInfo(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        try {
            int size = breCountryRegionInfoService.updateBreCountryRegionInfoInfo(breCountryRegionInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/delBreCountryRegionInfoInfo")
    public ResultInfoDto delBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        try {
            int size = breCountryRegionInfoService.delBreCountryRegionInfoInfo(breCountryRegionInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/addBreCountryRegionInfoInfo")
    public ResultInfoDto addBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        try {
            int size = breCountryRegionInfoService.addBreCountryRegionInfoInfo(breCountryRegionInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }
    @RequestMapping("/uploadCurrencyRegion")
    public ResultInfoDto uploadCurrencyRegion(HttpServletRequest request, @RequestParam(value = "isAll") String isAll, @RequestParam("file") MultipartFile multipartFile) {
        try {
            String msg="";
            InputStream inputStream = multipartFile.getInputStream();
            List<Part> list = (List) request.getParts();// input的name值
            if (list.size() < 0) {
                return ResultUtils.error(-1, "没有获取到上传文件。");
            }
            String fileName = multipartFile.getOriginalFilename();
            msg = breCountryRegionInfoService.uploadCurrencyRegion(fileName,isAll, inputStream);
            return ResultUtils.success(msg);
        } catch (Exception e) {
            return ResultUtils.error(-1, "没有获取到上传文件");
        }
    }

}