package com.example.mapper;

import com.example.entity.BreFieldExportInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreFieIdExportInfoMapper {
     List<BreFieldExportInfoDto> getBreFieldExportInfoList(BreFieldExportInfoDto breFieldExportInfoDto);

     int updateBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto);

     int addBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto);

     int deleteBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto);

     List<BreFieldExportInfoDto> getFiledWorkIdList();



}
