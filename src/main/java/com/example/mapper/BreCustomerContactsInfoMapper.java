package com.example.mapper;
import com.example.entity.BreCustomerCompanyInfoDto;
import com.example.entity.BreCustomerContactsInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface BreCustomerContactsInfoMapper {

    List<BreCustomerContactsInfoDto>  getBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto);

    int  addBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto);

    int updateBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto);
}
