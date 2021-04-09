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

import com.example.entity.BreTreatyArrangeInfoDto;
import com.example.service.BreTreatyArrangeInfoService;

@RestController
@ResponseBody
@RequestMapping("/breTreatyArrangeInfo")
public class BreTreatyArrangeInfoController {
    @Autowired
    BreTreatyArrangeInfoService breTreatyArrangeInfoService;
    private Logger logger = LogManager.getLogger(BreTreatyArrangeInfoController.class);

    @RequestMapping("/getBreTreatyArrangeInfoList")
    public ResultInfoDto getBreTreatyArrangeInfoList(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        try {
            List<BreTreatyArrangeInfoDto> list = breTreatyArrangeInfoService.getBreTreatyArrangeInfoList(breTreatyArrangeInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            logger.error("getBreTreatyArrangeInfoList 接口异常"+e.toString(),e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/updateBreTreatyArrangeInfo")
    public ResultInfoDto updateBreTreatyArrangeInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        try {
            int size = breTreatyArrangeInfoService.updateBreTreatyArrangeInfoInfo(breTreatyArrangeInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            logger.error("updateBreTreatyArrangeInfo 接口异常"+e.toString(),e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/delBreTreatyArrangeInfo")
    public ResultInfoDto delBreTreatyArrangeInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        try {
            int size = breTreatyArrangeInfoService.delBreTreatyArrangeInfoInfo(breTreatyArrangeInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            logger.error("delBreTreatyArrangeInfo 接口异常"+e.toString(),e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }
    @RequestMapping("/addBreTreatyArrangeInfo")
    public ResultInfoDto addBreTreatyArrangeInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        try {
            int size = breTreatyArrangeInfoService.addBreTreatyArrangeInfoInfo(breTreatyArrangeInfoDto);
            return ResultUtils.success(size);
        } catch (Exception e) {
            logger.error("addBreTreatyArrangeInfo 接口异常"+e.toString(),e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

}