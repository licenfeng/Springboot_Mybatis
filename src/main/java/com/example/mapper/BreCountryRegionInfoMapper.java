package com.example.mapper;

import com.example.entity.BreCustomerCompanyInfoDto;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.example.entity.BreCountryRegionInfoDto;

@Repository
public interface BreCountryRegionInfoMapper {

    List<BreCustomerCompanyInfoDto>  getBreCustomerCompanyInfoList(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto);

    List<BreCountryRegionInfoDto> getBreCountryRegionInfoList(BreCountryRegionInfoDto breCountryRegionInfoDto);

    int updateBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto);

    int delBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto);

    int addBreCountryRegionInfoInfo(BreCountryRegionInfoDto breCountryRegionInfoDto);

    int insertBreCurrencyRegionInfoInfoBatch(List<BreCountryRegionInfoDto> list);

}
