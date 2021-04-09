package com.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.entity.BreTreatyNonPropArrangeInfoDto;
import com.example.mapper.BreTreatyNonPropArrangeInfoMapper;

@Service
public class BreTreatyNonPropArrangeInfoService {
    @Autowired
    BreTreatyNonPropArrangeInfoMapper breTreatyNonPropArrangeInfoMapper;
    private Logger logger = LogManager.getLogger(BreTreatyNonPropArrangeInfoService.class);

    public List<BreTreatyNonPropArrangeInfoDto> getBreTreatyNonPropArrangeInfoList(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto) {
        List<BreTreatyNonPropArrangeInfoDto> list = breTreatyNonPropArrangeInfoMapper.getBreTreatyNonPropArrangeInfoList(breTreatyNonPropArrangeInfoDto);
        return list;
    }

    public int updateBreTreatyNonPropArrangeInfoInfo(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto) {
        int size = breTreatyNonPropArrangeInfoMapper.updateBreTreatyNonPropArrangeInfoInfo(breTreatyNonPropArrangeInfoDto);
        return size;
    }

    public int delBreTreatyNonPropArrangeInfoInfo(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto) {
        int size = breTreatyNonPropArrangeInfoMapper.delBreTreatyNonPropArrangeInfoInfo(breTreatyNonPropArrangeInfoDto);
        return size;
    }


}