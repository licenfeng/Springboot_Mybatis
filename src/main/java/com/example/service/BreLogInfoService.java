package com.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.entity.BreLogInfoDto;
import com.example.mapper.BreLogInfoMapper;

@Service
public class BreLogInfoService {
    @Autowired
    BreLogInfoMapper breLogInfoMapper;
    private Logger logger = LogManager.getLogger(BreLogInfoService.class);

    public List<BreLogInfoDto> getBreLogInfoList(BreLogInfoDto breLogInfoDto) {
        List<BreLogInfoDto> list = breLogInfoMapper.getBreLogInfoList(breLogInfoDto);
        return list;
    }

    public int updateBreLogInfoInfo(BreLogInfoDto breLogInfoDto) {
        int size = breLogInfoMapper.updateBreLogInfoInfo(breLogInfoDto);
        return size;
    }

    public int delBreLogInfoInfo(BreLogInfoDto breLogInfoDto) {
        int size = breLogInfoMapper.delBreLogInfoInfo(breLogInfoDto);
        return size;
    }

    public int addBreLogInfoInfo(BreLogInfoDto breLogInfoDto) {
        int size = breLogInfoMapper.addBreLogInfoInfo(breLogInfoDto);
        return size;
    }

}