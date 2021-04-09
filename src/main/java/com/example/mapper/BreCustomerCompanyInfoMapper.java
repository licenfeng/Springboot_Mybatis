package com.example.mapper;

import com.example.entity.BreCustomerCompanyInfoDto;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BreCustomerCompanyInfoMapper {

   List<BreCustomerCompanyInfoDto>  getBreCustomerCompanyInfoList(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto);

   int addBreCustomerCompanyInfo(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto);

   int updateBreCustomerCompanyInfo(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto);
}
