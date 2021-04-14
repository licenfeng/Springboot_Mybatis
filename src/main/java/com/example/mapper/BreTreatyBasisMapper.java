package com.example.mapper;

import com.example.entity.BreTreatAllInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreTreatyBasisMapper {
    List<BreTreatAllInfoDto> selectBreTreatyBasisAllName();

    List<BreTreatAllInfoDto> getBreTreatyBasisInfoList(BreTreatAllInfoDto breTreatAllInfoDto);

    List<BreTreatAllInfoDto> selectBreTreatyPropAllInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    List<BreTreatAllInfoDto> selectBreTreatyNonPropAllInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    List<BreTreatAllInfoDto> selectBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int addBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int addBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int addBreTreatyNonPropInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int addBreTreatyReinsureInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int addBreTreatyArrangeInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int updateBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int updateBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int updateBreTreatyNonPropInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int updateBreTreatyReinsureInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    int updateBreTreatyArrangePropInfo(BreTreatAllInfoDto breTreatAllInfoDto);

    List<BreTreatAllInfoDto> selectBreTreatyArrangeAllList(BreTreatAllInfoDto breTreatAllInfoDto);

    List<BreTreatAllInfoDto> getBreTreatyNonPropInfoList(BreTreatAllInfoDto breTreatAllInfoDto);

    String getTreatyPropInfoId();

    String getTreatyNonPropInfoId();
    int selectTreatyTypeBySlipNumber(BreTreatAllInfoDto breTreatAllInfoDto);

}
