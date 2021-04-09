package com.example.service;

import com.example.entity.ResultInfoDto;
import com.example.utils.ExcelUploadUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

import com.example.entity.BreCurrencyInfoDto;
import com.example.mapper.BreCurrencyInfoMapper;

@Service
public class BreCurrencyInfoService {
    @Autowired
    BreCurrencyInfoMapper breCurrencyInfoMapper;
    private Logger logger = LogManager.getLogger(BreCurrencyInfoService.class);

    public List<BreCurrencyInfoDto> getBreCurrencyInfoList(BreCurrencyInfoDto breCurrencyInfoDto) {
        List<BreCurrencyInfoDto> list = breCurrencyInfoMapper.getBreCurrencyInfoList(breCurrencyInfoDto);
        return list;
    }

    public int updateBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto) {
        int size = breCurrencyInfoMapper.updateBreCurrencyInfoInfo(breCurrencyInfoDto);
        return size;
    }

    public int delBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto) {
        int size = breCurrencyInfoMapper.delBreCurrencyInfoInfo(breCurrencyInfoDto);
        return size;
    }

    public int addBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto) {
        int size = breCurrencyInfoMapper.addBreCurrencyInfoInfo(breCurrencyInfoDto);
        return size;
    }

    /**
     * @param fileName  文件名字，判断上传文件类型
     * @param isAll  Y 数据全覆盖 否则追加
     * @param inputStream
     * @return
     */
    public String uploadCurrency(String fileName,String isAll, InputStream inputStream){
        if("Y".equals(isAll)){
            try{
                //不传值，全部删除。
                breCurrencyInfoMapper.delBreCurrencyInfoInfo(null);
            }catch (Exception e){
                logger.error("数据删除失败：getBreCurrencyExcelUpload"+e.toString(),e);
                return "数据清理异常，请联系开发人员";
            }
        }
        Map map=new HashMap();
        map.put("序号","number");
        map.put("ENTITY","entity");
        map.put("Currency","currency");
        map.put("AlphabeticCode","alphabeticCode");
        map.put("NumericCode","numericCode");
        map.put("MinorUnit","minorUnit");
        try {
            ResultInfoDto resultInfoDto = ExcelUploadUtils.excelUpload(inputStream,fileName,map,BreCurrencyInfoDto.class);
            Object object=resultInfoDto.getData();
            if(object==null){
                return resultInfoDto.getMsg();
            }
            List<BreCurrencyInfoDto> listUpdate= (List<BreCurrencyInfoDto>)object;
            breCurrencyInfoMapper.insertBreCurrencyInfoInfoBatch(listUpdate);
            return "文件上传成功";
        }catch (Exception e){
           logger.error("文件上传异常"+e.toString(),e);
            return "文件上传异常";
        }


    }

}