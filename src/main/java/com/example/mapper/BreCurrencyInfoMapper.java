package com.example.mapper;

import org.springframework.stereotype.Repository;

import java.util.*;

import com.example.entity.BreCurrencyInfoDto;

@Repository
public interface BreCurrencyInfoMapper {
     List<BreCurrencyInfoDto> getBreCurrencyInfoList(BreCurrencyInfoDto breCurrencyInfoDto);

     int updateBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto);

     int delBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto);

     int addBreCurrencyInfoInfo(BreCurrencyInfoDto breCurrencyInfoDto);

     int insertBreCurrencyInfoInfoBatch(List<BreCurrencyInfoDto> list);


}
