package com.example.mapper;

import com.example.entity.BreFieldInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreFieIdInfoMapper {

     List<BreFieldInfoDto> getBreFieldInfoList(BreFieldInfoDto breFieldInfoDto);


}
