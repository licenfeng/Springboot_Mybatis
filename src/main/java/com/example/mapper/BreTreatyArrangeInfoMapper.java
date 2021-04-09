package com.example.mapper;

import org.springframework.stereotype.Repository;

import java.util.*;

import com.example.entity.BreTreatyArrangeInfoDto;

@Repository
public interface BreTreatyArrangeInfoMapper {
    List<BreTreatyArrangeInfoDto> getBreTreatyArrangeInfoList(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto);

    int updateBreTreatyArrangeInfoInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto);

    int delBreTreatyArrangeInfoInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto);

    int addBreTreatyArrangeInfoInfo(BreTreatyArrangeInfoDto breTreatyArrangeInfoDto);

}
