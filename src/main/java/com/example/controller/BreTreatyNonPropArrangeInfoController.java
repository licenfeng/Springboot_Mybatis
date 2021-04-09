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

import com.example.entity.BreTreatyNonPropArrangeInfoDto;
import com.example.service.BreTreatyNonPropArrangeInfoService;

@RestController
@ResponseBody
@RequestMapping("/breTreatyNonPropArrangeInfo")
public class BreTreatyNonPropArrangeInfoController {
    @Autowired
    BreTreatyNonPropArrangeInfoService breTreatyNonPropArrangeInfoService;
    private Logger logger = LogManager.getLogger(BreTreatyNonPropArrangeInfoController.class);

    @RequestMapping("/getBreTreatyNonPropArrangeInfoList")
    public ResultInfoDto getBreTreatyNonPropArrangeInfoList(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto) {
        try {
            List<BreTreatyNonPropArrangeInfoDto> list = breTreatyNonPropArrangeInfoService.getBreTreatyNonPropArrangeInfoList(breTreatyNonPropArrangeInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/updateBreTreatyNonPropArrangeInfoInfo")
    public ResultInfoDto updateBreTreatyNonPropArrangeInfoInfo(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto) {
        try {
            int size = breTreatyNonPropArrangeInfoService.updateBreTreatyNonPropArrangeInfoInfo(breTreatyNonPropArrangeInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/delBreTreatyNonPropArrangeInfoInfo")
    public ResultInfoDto delBreTreatyNonPropArrangeInfoInfo(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto) {
        try {
            int size = breTreatyNonPropArrangeInfoService.delBreTreatyNonPropArrangeInfoInfo(breTreatyNonPropArrangeInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

}