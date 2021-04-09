package com.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.entity.BreTreatyArrangeInfoDto;
import com.example.mapper.BreTreatyArrangeInfoMapper;

@Service
public class BreTreatyArrangeInfoService {
    @Autowired
    BreTreatyArrangeInfoMapper breTreatyArrangeInfoMapper;
    private Logger logger = LogManager.getLogger(BreTreatyArrangeInfoService.class);

    public List<BreTreatyArrangeInfoDto> getBreTreatyArrangeInfoList(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        List<BreTreatyArrangeInfoDto>   list = breTreatyArrangeInfoMapper.getBreTreatyArrangeInfoList(breTreatyArrangeInfoDto);
        return list;
    }

    public int updateBreTreatyArrangeInfoInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        int size = breTreatyArrangeInfoMapper.updateBreTreatyArrangeInfoInfo(breTreatyArrangeInfoDto);
        return size;
    }

    public int delBreTreatyArrangeInfoInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        int size = breTreatyArrangeInfoMapper.delBreTreatyArrangeInfoInfo(breTreatyArrangeInfoDto);
        return size;
    }

    public int addBreTreatyArrangeInfoInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto) {
        int size = breTreatyArrangeInfoMapper.addBreTreatyArrangeInfoInfo(breTreatyArrangeInfoDto);
        return size;
    }

}