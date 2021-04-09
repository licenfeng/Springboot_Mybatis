package com.example.controller;

import com.example.entity.ResultInfoDto;
import com.example.entity.BreCustomerCompanyInfoDto;
import com.example.entity.BreCustomerContactsInfoDto;
import com.example.service.TreatyCustomerInfoService;
import com.example.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/breCustomerInfo")
public class BreCustomerInfoController {
    @Autowired
    TreatyCustomerInfoService treatyCustomerInfoService;

    @RequestMapping("/getBreCustomerCompanyInfoList")
    public ResultInfoDto getBreCustomerCompanyInfoList(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto){
        try{
            List<BreCustomerCompanyInfoDto> list=treatyCustomerInfoService.getBreCustomerCompanyInfoList(breCustomerCompanyInfoDto);
            return ResultUtils.success(list);
        }catch (Exception e){
            return ResultUtils.error("数据查询异常");
        }
    }

    @RequestMapping("/addBreCustomerCompanyInfo")
    public ResultInfoDto addBreCustomerCompanyInfo(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto){
        try{
            int state=treatyCustomerInfoService.addBreCustomerCompanyInfo(breCustomerCompanyInfoDto);
            return ResultUtils.success(state);
        }catch (Exception e){
            return ResultUtils.error("addBreCustomerCompanyInfo 数据添加异常");
        }
    }

    @RequestMapping("/updateBreCustomerCompanyInfo")
    public ResultInfoDto updateBreCustomerCompanyInfo(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto){
        try{
        int state=treatyCustomerInfoService.updateBreCustomerCompanyInfo(breCustomerCompanyInfoDto);
        return ResultUtils.success(state);
        }catch (Exception e){
            return ResultUtils.error("updateBreCustomerCompanyInfo 数据修改异常");
        }
    }

    @RequestMapping("/getBreCustomerContactsInfo")
    public ResultInfoDto getBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto){
        try{
            List<BreCustomerContactsInfoDto> list= treatyCustomerInfoService.getBreCustomerContactsInfo(breCustomerContactsInfoDto);
            return ResultUtils.success(list);
        }catch (Exception e){
            return ResultUtils.error("数据查询异常");
        }

    }

    @RequestMapping("/addBreCustomerContactsInfo")
    public ResultInfoDto addBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto){
        try{
            int state= treatyCustomerInfoService.addBreCustomerContactsInfo(breCustomerContactsInfoDto);
           return ResultUtils.success(state);
        }catch (Exception e){
            return ResultUtils.error("数据添加异常");
        }
    }

    @RequestMapping("/updateBreCustomerContactsInfo")
    public ResultInfoDto updateBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto){
        try{
            int state= treatyCustomerInfoService.updateBreCustomerContactsInfo(breCustomerContactsInfoDto);
            return ResultUtils.success(state);
        }catch (Exception e){
            return ResultUtils.error("数据更新异常");
        }

    }
}
