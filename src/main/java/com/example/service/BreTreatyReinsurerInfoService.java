package com.example.service;

import com.example.entity.BreTreatyArrangeInfoDto;
import com.example.entity.BreTreatyNonPropArrangeInfoDto;
import com.example.mapper.BreTreatyArrangeInfoMapper;
import com.example.mapper.BreTreatyNonPropArrangeInfoMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.entity.BreTreatyReinsurerInfoDto;
import com.example.mapper.BreTreatyReinsurerInfoMapper;

@Service
public class BreTreatyReinsurerInfoService {
    @Autowired
    BreTreatyArrangeInfoMapper breTreatyArrangeInfoMapper;
    @Autowired
    BreTreatyReinsurerInfoMapper breTreatyReinsurerInfoMapper;

    @Autowired
    BreTreatyNonPropArrangeInfoMapper breTreatyNonPropArrangeInfoMapper;
    public List<BreTreatyReinsurerInfoDto> getBreTreatyReinsurerInfoList(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        List<BreTreatyReinsurerInfoDto> list = breTreatyReinsurerInfoMapper.getBreTreatyReinsurerInfoList(breTreatyReinsurerInfoDto);
        return list;
    }

    /**
     *  获取再保人和对应的排分信息
     * @param breTreatyReinsurerInfoDto
     * @return
     */
    public List<BreTreatyReinsurerInfoDto> getBreTreatyReinsurerAndArrangeList(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto,String isNonProp){
        List<BreTreatyReinsurerInfoDto> list = breTreatyReinsurerInfoMapper.getBreTreatyReinsurerInfoList(breTreatyReinsurerInfoDto);
        for(int i=0;i<list.size();i++){

            BreTreatyReinsurerInfoDto breDto=list.get(i);
            String reinsurerId=breDto.getId();
            String breSlipNumber=breTreatyReinsurerInfoDto.getBreSlipNumber();
            if("Y".equals(isNonProp)){
                BreTreatyNonPropArrangeInfoDto  arrangeInfoDto=new BreTreatyNonPropArrangeInfoDto();
                arrangeInfoDto.setBreSlipNumber(breSlipNumber);
                arrangeInfoDto.setReinsurerId(reinsurerId);
                List arrangeList=breTreatyNonPropArrangeInfoMapper.getBreTreatyNonPropArrangeInfoList(arrangeInfoDto);
                breDto.setList(arrangeList);
            }else{
                //获取在保人名下的排分信息
                BreTreatyArrangeInfoDto breTreatyArrangeInfoDto=new BreTreatyArrangeInfoDto();
                breTreatyArrangeInfoDto.setBreSlipNumber(breSlipNumber);
                breTreatyArrangeInfoDto.setReinsurerId(reinsurerId);
                List<BreTreatyArrangeInfoDto> arrangeList= breTreatyArrangeInfoMapper.getBreTreatyArrangeInfoList(breTreatyArrangeInfoDto);
                breDto.setList(arrangeList);
            }

        }
        return list;
    }

    public int updateBreTreatyReinsurerInfoInfo(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        int size = breTreatyReinsurerInfoMapper.updateBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto);
        return size;
    }

    public int delBreTreatyReinsurerInfoInfo(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        int size = breTreatyReinsurerInfoMapper.delBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto);
        return size;
    }

    public int addBreTreatyReinsurerInfoInfo(BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto) {
        int size = breTreatyReinsurerInfoMapper.addBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto);
        return size;
    }

}