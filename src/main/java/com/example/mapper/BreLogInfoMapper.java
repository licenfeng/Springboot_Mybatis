package com.example.mapper;

import org.springframework.stereotype.Repository;

import java.util.*;

import com.example.entity.BreLogInfoDto;

@Repository
public interface BreLogInfoMapper {
    List<BreLogInfoDto> getBreLogInfoList(BreLogInfoDto breLogInfoDto);

    int updateBreLogInfoInfo(BreLogInfoDto breLogInfoDto);

    int delBreLogInfoInfo(BreLogInfoDto breLogInfoDto);

    int addBreLogInfoInfo(BreLogInfoDto breLogInfoDto);

}
