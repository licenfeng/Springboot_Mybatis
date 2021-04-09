package com.example.controller;

import com.example.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.entity.ResultInfoDto;
import java.util.*;

import com.example.entity.BreTreatyReinsurerInfoDto;
import com.example.service.BreTreatyReinsurerInfoService;

@RestController
@ResponseBody
@RequestMapping("/breTreatyReinsurerInfo")
public class BreTreatyReinsurerInfoController {
    @Autowired
    BreTreatyReinsurerInfoService breTreatyReinsurerInfoService;
    private Logger logger = LogManager.getLogger(BreTreatyReinsurerInfoController.class);

    @RequestMapping("/getBreTreatyReinsurerInfoList")
    public ResultInfoDto getBreTreatyReinsurerInfoList(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        try {
            List<BreTreatyReinsurerInfoDto> list = breTreatyReinsurerInfoService.getBreTreatyReinsurerInfoList(breTreatyReinsurerInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/updateBreTreatyReinsurerInfo")
    public ResultInfoDto updateBreTreatyReinsurerInfo(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        try {
            int size = breTreatyReinsurerInfoService.updateBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/delBreTreatyReinsurerInfo")
    public ResultInfoDto delBreTreatyReinsurerInfo(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        try {
            int size = breTreatyReinsurerInfoService.delBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/addBreTreatyReinsurerInfo")
    public ResultInfoDto addBreTreatyReinsurerInfo(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        try {
            int size = breTreatyReinsurerInfoService.addBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

}