package com.example.mapper;

import com.example.entity.BreTreatAllInfoDto;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.example.entity.BreTreatyNonPropArrangeInfoDto;

@Repository
public interface BreTreatyNonPropArrangeInfoMapper {
    List<BreTreatyNonPropArrangeInfoDto> getBreTreatyNonPropArrangeInfoList(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto);

    int updateBreTreatyNonPropArrangeInfoInfo(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto);

    int delBreTreatyNonPropArrangeInfoInfo(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto);

    //补写一个方法
    int addBreTreatyNonPropArrangeInfoInfo(BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto);

//    int addBreTreatyNonPropArrangeInfoInfo(BreTreatAllInfoDto breTreatAllInfoDto); //此方法没有用到

    int addBreTreatyNonPropArrangeInfo(BreTreatAllInfoDto breTreatAllInfoDto);






}
