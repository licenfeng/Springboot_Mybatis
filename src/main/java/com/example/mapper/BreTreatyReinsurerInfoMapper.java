package com.example.mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.entity.BreTreatyReinsurerInfoDto;
@Repository
public interface BreTreatyReinsurerInfoMapper{
 List<BreTreatyReinsurerInfoDto> getBreTreatyReinsurerInfoList(BreTreatyReinsurerInfoDto  breTreatyReinsurerInfoDto);
 int updateBreTreatyReinsurerInfoInfo(BreTreatyReinsurerInfoDto  breTreatyReinsurerInfoDto);
 int delBreTreatyReinsurerInfoInfo(BreTreatyReinsurerInfoDto  breTreatyReinsurerInfoDto);
 int addBreTreatyReinsurerInfoInfo(BreTreatyReinsurerInfoDto  breTreatyReinsurerInfoDto);

}
