package com.example.service;

import com.example.entity.BreCustomerCompanyInfoDto;
import com.example.entity.BreCustomerContactsInfoDto;
import com.example.mapper.BreCustomerCompanyInfoMapper;
import com.example.mapper.BreCustomerContactsInfoMapper;
import com.example.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class TreatyCustomerInfoService {

    @Autowired
    BreCustomerCompanyInfoMapper breCustomerCompanyInfoMapper;

    @Autowired
    BreCustomerContactsInfoMapper breCustomerContactsInfoMapper;

    public List<BreCustomerCompanyInfoDto> getBreCustomerCompanyInfoList(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto){
        return breCustomerCompanyInfoMapper.getBreCustomerCompanyInfoList(breCustomerCompanyInfoDto);
    }

    public int addBreCustomerCompanyInfo(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto){

        return breCustomerCompanyInfoMapper.addBreCustomerCompanyInfo(breCustomerCompanyInfoDto);
    }

    public int updateBreCustomerCompanyInfo(BreCustomerCompanyInfoDto breCustomerCompanyInfoDto){

        return breCustomerCompanyInfoMapper.updateBreCustomerCompanyInfo(breCustomerCompanyInfoDto);
    }

    public List<BreCustomerContactsInfoDto>  getBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto){

        List<BreCustomerContactsInfoDto> list=  breCustomerContactsInfoMapper.getBreCustomerContactsInfo(breCustomerContactsInfoDto);
        list.forEach(breCustomer->{String departureDate =breCustomer.getDepartureDate();
            try {
                int result = CommonUtils.compareStringDate(departureDate,"yyyy-MM-dd");
                if(result<0){
                    breCustomer.setDepartureFlag("Y");
                    breCustomerContactsInfoMapper.updateBreCustomerContactsInfo(breCustomer);
                }else{
                    breCustomer.setDepartureFlag("N");
                    breCustomerContactsInfoMapper.updateBreCustomerContactsInfo(breCustomer);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        return list;
    }

    public int  addBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto){

        return breCustomerContactsInfoMapper.addBreCustomerContactsInfo(breCustomerContactsInfoDto);
    }

    public int updateBreCustomerContactsInfo(BreCustomerContactsInfoDto breCustomerContactsInfoDto){

        return breCustomerContactsInfoMapper.updateBreCustomerContactsInfo(breCustomerContactsInfoDto);
    }

}
