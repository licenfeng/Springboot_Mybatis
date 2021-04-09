package com.example.service;

import com.example.entity.BreCurrencyInfoDto;
import com.example.entity.BreCustomerCompanyInfoDto;
import com.example.entity.ResultInfoDto;
import com.example.utils.ExcelUploadUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

import com.example.entity.BreCountryRegionInfoDto;
import com.example.mapper.BreCountryRegionInfoMapper;

@Service
public class BreCountryRegionInfoService {
    @Autowired
    BreCountryRegionInfoMapper breCountryRegionInfoMapper;
    private Logger logger = LogManager.getLogger(BreCountryRegionInfoService.class);

    public List<BreCountryRegionInfoDto> getBreCountryRegionInfoList(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        List<BreCountryRegionInfoDto> list = breCountryRegionInfoMapper.getBreCountryRegionInfoList(breCountryRegionInfoDto);
        return list;
    }


    public List<BreCustomerCompanyInfoDto> getBreCustomerCompanyInfoList(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto){
        return breCountryRegionInfoMapper.getBreCustomerCompanyInfoList(breCustomerCompanyInfoDto);
    }

    public int updateBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        int size = breCountryRegionInfoMapper.updateBreCountryRegionInfoInfo(breCountryRegionInfoDto);
        return size;
    }

    public int delBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        int size = breCountryRegionInfoMapper.delBreCountryRegionInfoInfo(breCountryRegionInfoDto);
        return size;
    }

    public int addBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto) {
        int size = breCountryRegionInfoMapper.addBreCountryRegionInfoInfo(breCountryRegionInfoDto);
        return size;
    }

    /**
     * @param fileName  文件名字，判断上传文件类型
     * @param isAll  Y 数据全覆盖 否则追加
     * @param inputStream
     * @return
     */
    public String uploadCurrencyRegion(String fileName,String isAll, InputStream inputStream){
        if("Y".equals(isAll)){
            try{
                //不传值，全部删除。
                breCountryRegionInfoMapper.delBreCountryRegionInfoInfo(null);
            }catch (Exception e){
                logger.error("数据删除失败：getBreCurrencyExcelUpload"+e.toString(),e);
                return "数据清理异常，请联系开发人员";
            }
        }
        Map map=new HashMap();
        map.put("序号","number");
        map.put("英文简称","englishAbbreviation");
        map.put("中文简称","chineseAbbreviation");
        map.put("英文全称","englishName");
        map.put("两字母代码","towCode");
        map.put("三字母代码","threeCode");
        map.put("数字代码","numberCode");
        map.put("备注","countryDesc");
        try {
            ResultInfoDto resultInfoDto = ExcelUploadUtils.excelUpload(inputStream,fileName,map,BreCountryRegionInfoDto.class);
            Object object=resultInfoDto.getData();
            if(object==null){
                return resultInfoDto.getMsg();
            }
            List<BreCountryRegionInfoDto> listUpdate= (List<BreCountryRegionInfoDto>) object;
            breCountryRegionInfoMapper.insertBreCurrencyRegionInfoInfoBatch(listUpdate);
            return "文件上传成功";
        }catch (Exception e){
            logger.error("文件上传异常"+e.toString(),e);
            return "文件上传异常";
        }


    }

}