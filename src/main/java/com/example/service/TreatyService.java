package com.example.service;

import com.example.entity.*;
import com.example.mapper.BreTreatyArrangeInfoMapper;
import com.example.mapper.BreTreatyBasisMapper;
import com.example.mapper.BreTreatyNonPropArrangeInfoMapper;
import com.example.mapper.BreTreatyReinsurerInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class TreatyService extends BreLogInfoService {

    @Autowired
    BreTreatyBasisMapper basisMapper;

    @Autowired
    BreTreatyReinsurerInfoMapper breTreatyReinsurerInfoMapper;

    @Autowired
    BreTreatyNonPropArrangeInfoMapper breTreatyNonPropArrangeInfoMapper;

    @Autowired

    BreTreatyReinsurerInfoService breTreatyReinsurerInfoService;

    @Autowired
    private TreatyCommonService treatyCommonService;

    @Autowired
    private BreTreatyArrangeInfoMapper breTreatyArrangeInfoMapper;

    public List<BreTreatAllInfoDto> selectBreTreatyBasisAllName() {
        return basisMapper.selectBreTreatyBasisAllName();
    }


    public List<BreTreatAllInfoDto> getBreTreatyBasisInfoList(BreTreatAllInfoDto breTreatAllInfoDto) {

        return basisMapper.getBreTreatyBasisInfoList(breTreatAllInfoDto);
    }


//    public int addBreTreatyNonPropArrangeInfoInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
//        int size = breTreatyNonPropArrangeInfoMapper.addBreTreatyNonPropArrangeInfoInfo(breTreatAllInfoDto);
//        return size;
//    }

    /**
     * @param breTreatAllInfoDto
     * @return
     */
    public int addBreTreatyNonPropArrangeInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        int size = breTreatyNonPropArrangeInfoMapper.addBreTreatyNonPropArrangeInfo(breTreatAllInfoDto);
        return size;
    }

    /**
     * @param breTreatAllInfoDto
     * @return
     */
    public Map getBreTreatyBasisNonPropAllList(BreTreatAllInfoDto breTreatAllInfoDto) {
        Map map = new HashMap();
        String breSlipNumber = breTreatAllInfoDto.getBreSlipNumber();
        //合约基本信息
        List<BreTreatAllInfoDto> list = getBreTreatyBasisInfoList(breTreatAllInfoDto);
        map.put("basisList", list);
        //合约信息
        List<BreTreatAllInfoDto> propList = getBreTreatyNonPropInfoList(breTreatAllInfoDto);
        map.put("nonPropList", propList);
        //再保人信息
        BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto = new BreTreatyReinsurerInfoDto();
        breTreatyReinsurerInfoDto.setBreSlipNumber(breSlipNumber);
        List<BreTreatyReinsurerInfoDto> reinsureList = breTreatyReinsurerInfoService.getBreTreatyReinsurerAndArrangeList(breTreatyReinsurerInfoDto, "Y");
        map.put("reinsureList", reinsureList);
        return map;
    }

    /**
     * ========================================================================================================
     * renew 一个新的非比例Non   通过BreSlipNumber查到数据，然后生成一个新的BreSlipNumber把所查到的数据插入
     *
     * @param
     * @return
     */
    public Map copyNewGetBreTreatyBasisNonPropAllListByBreSlipNumber(BreTreatAllInfoDto breTreatAllInfoDto) {
        //重新得到breSlipNumber
        String breSlipNumberNew = treatyCommonService.getBreSlipNumber();
        String breSlipNumber = breTreatAllInfoDto.getBreSlipNumber();  //再保人查询时候需要用到
        HashMap map = new HashMap();
        //合约基本信息
        List<BreTreatAllInfoDto> list = getBreTreatyBasisInfoList(breTreatAllInfoDto);
        if (list.size() <= 0) {
            return map;
        }
        BreTreatAllInfoDto breTreatAllInfoDtoNew1 = list.get(0);
        breTreatAllInfoDtoNew1.setBreSlipNumber(breSlipNumberNew);
        breTreatAllInfoDtoNew1.setBreBoundNo("");
        breTreatAllInfoDtoNew1.setWrittenLine("");
        breTreatAllInfoDtoNew1.setSignedLine("");
        breTreatAllInfoDtoNew1.setStatusReinsurer("");
       this.addBreTreatyBasisInfo(breTreatAllInfoDtoNew1);
        //合约信息
        List<BreTreatAllInfoDto> propList = getBreTreatyNonPropInfoList(breTreatAllInfoDto);
        if (propList.size() <= 0) {
            return getBreTreatyBasisNonPropAllList(breTreatAllInfoDtoNew1);
        } else {
            BreTreatAllInfoDto breTreatAllInfoDtoNew2 = propList.get(0);
            breTreatAllInfoDtoNew2.setBreSlipNumber(breSlipNumberNew);
            breTreatAllInfoDtoNew2.setBreBoundNo("");
            breTreatAllInfoDtoNew2.setWrittenLine("");
            breTreatAllInfoDtoNew2.setSignedLine("");
            breTreatAllInfoDtoNew2.setStatusReinsurer("");
            this.addBreTreatyNonPropInfo(breTreatAllInfoDtoNew2);
        }
        //再保人信息
        BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto = new BreTreatyReinsurerInfoDto();
        breTreatyReinsurerInfoDto.setBreSlipNumber(breSlipNumber);
        List<BreTreatyReinsurerInfoDto> reinsureList = breTreatyReinsurerInfoService.getBreTreatyReinsurerAndArrangeList(breTreatyReinsurerInfoDto, "Y");
        if (reinsureList.size() <= 0) {
            return getBreTreatyBasisNonPropAllList(breTreatAllInfoDtoNew1);
        } else {
            BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto3 = reinsureList.get(0);
            breTreatyReinsurerInfoDto3.setBreSlipNumber(breSlipNumberNew);
            breTreatyReinsurerInfoDto3.setWrittenLine("");
            breTreatyReinsurerInfoDto3.setSignedLine("");
            breTreatyReinsurerInfoDto3.setStatusReinsurer("");
            breTreatyReinsurerInfoService.addBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto3);

            //排分信息
            List list1 = breTreatyReinsurerInfoDto3.getList();
            BreTreatyNonPropArrangeInfoDto breTreatyNonPropArrangeInfoDto = (BreTreatyNonPropArrangeInfoDto) list1.get(0);
            breTreatyNonPropArrangeInfoDto.setBreSlipNumber(breSlipNumberNew);
            breTreatyNonPropArrangeInfoMapper.addBreTreatyNonPropArrangeInfoInfo(breTreatyNonPropArrangeInfoDto);  //自己添加一个插入方法
            //通过新的BreSlipNumber重新获取返回
            map = (HashMap) getBreTreatyBasisNonPropAllList(breTreatAllInfoDtoNew1);
        }
        return map;
    }

    /**
     * renew 一个新的比例  通过BreSlipNumber查到数据，然后生成一个新的BreSlipNumber把所查到的数据插入
     *
     * @param breTreatAllInfoDto
     * @return
     */
    public Map copyNewGetBreTreatyBasisPropAllListByBreSlipNumber(BreTreatAllInfoDto breTreatAllInfoDto) {
        //重新得到breSlipNumber
        String breSlipNumberNew = treatyCommonService.getBreSlipNumber();
        String breSlipNumber = breTreatAllInfoDto.getBreSlipNumber();  //再保人查询时候需要用到
        HashMap map = new HashMap();
        //合约基本信息
        List<BreTreatAllInfoDto> list = getBreTreatyBasisInfoList(breTreatAllInfoDto);
        if (list.size() <= 0) {
            return map;
        }
        BreTreatAllInfoDto breTreatAllInfoDtoNew1 = list.get(0);
        breTreatAllInfoDtoNew1.setBreSlipNumber(breSlipNumberNew);
        breTreatAllInfoDtoNew1.setBreBoundNo("");
        breTreatAllInfoDtoNew1.setWrittenLine("");
        breTreatAllInfoDtoNew1.setSignedLine("");
        breTreatAllInfoDtoNew1.setStatusReinsurer("");
      this.addBreTreatyBasisInfo(breTreatAllInfoDtoNew1);
        //合约信息
        List<BreTreatAllInfoDto> propList = selectBreTreatyPropInfo(breTreatAllInfoDto);
        if (propList.size() <= 0) {
            return getBreTreatyBasisNonPropAllList(breTreatAllInfoDtoNew1);
        } else {
            BreTreatAllInfoDto breTreatAllInfoDtoNew2 = propList.get(0);
            breTreatAllInfoDtoNew2.setBreSlipNumber(breSlipNumberNew);
            breTreatAllInfoDtoNew2.setBreBoundNo("");
            breTreatAllInfoDtoNew2.setWrittenLine("");
            breTreatAllInfoDtoNew2.setSignedLine("");
            breTreatAllInfoDtoNew2.setStatusReinsurer("");
            this.addBreTreatyPropInfo(breTreatAllInfoDtoNew2);
        }
        //再保人信息
        BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto = new BreTreatyReinsurerInfoDto();
        breTreatyReinsurerInfoDto.setBreSlipNumber(breSlipNumber);
        List<BreTreatyReinsurerInfoDto> reinsureList = breTreatyReinsurerInfoService.getBreTreatyReinsurerAndArrangeList(breTreatyReinsurerInfoDto, "");

        if (reinsureList.size() <= 0) {
            return getBreTreatyBasisPropAllList(breTreatAllInfoDtoNew1);
        } else {
            BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto3 = reinsureList.get(0);
            breTreatyReinsurerInfoDto3.setBreSlipNumber(breSlipNumberNew);
            breTreatyReinsurerInfoDto3.setWrittenLine("");
            breTreatyReinsurerInfoDto3.setSignedLine("");
            breTreatyReinsurerInfoDto3.setStatusReinsurer("");
            breTreatyReinsurerInfoService.addBreTreatyReinsurerInfoInfo(breTreatyReinsurerInfoDto3);
            //排分信息
            List list1 = breTreatyReinsurerInfoDto3.getList();
            BreTreatyArrangeInfoDto breTreatyArrangeInfoDto = (BreTreatyArrangeInfoDto) list1.get(0);
            breTreatyArrangeInfoDto.setBreSlipNumber(breSlipNumberNew);
            breTreatyArrangeInfoMapper.addBreTreatyArrangeInfoInfo(breTreatyArrangeInfoDto);
            //通过新的BreSlipNumber重新获取返回
            map = (HashMap) getBreTreatyBasisPropAllList(breTreatAllInfoDtoNew1);
        }
        return map;
    }

//====================================================================================================================

    /**
     * @param breTreatAllInfoDto
     * @return
     */
    public Map getBreTreatyBasisPropAllList(BreTreatAllInfoDto breTreatAllInfoDto) {
        Map map = new HashMap();
        String breSlipNumber = breTreatAllInfoDto.getBreSlipNumber();
        //合约基本信息
        List<BreTreatAllInfoDto> list = getBreTreatyBasisInfoList(breTreatAllInfoDto);
        map.put("basisList", list);
        //合约信息
        List<BreTreatAllInfoDto> propList = selectBreTreatyPropInfo(breTreatAllInfoDto);
        map.put("propList", propList);
        //再保人信息
        BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto = new BreTreatyReinsurerInfoDto();
        breTreatyReinsurerInfoDto.setBreSlipNumber(breSlipNumber);
        List<BreTreatyReinsurerInfoDto> reinsureList = breTreatyReinsurerInfoService.getBreTreatyReinsurerAndArrangeList(breTreatyReinsurerInfoDto, "");
        map.put("reinsureList", reinsureList);
        return map;
    }


    public PageInfo getBreTreatyBasisInfoListPage(BreTreatAllInfoDto breTreatAllInfoDto) {

        PageHelper.startPage(breTreatAllInfoDto.getPageNo(), breTreatAllInfoDto.getPageSize());
        List<BreTreatAllInfoDto> list = basisMapper.getBreTreatyBasisInfoList(breTreatAllInfoDto);
        PageInfo<BreTreatAllInfoDto> pageInfo = new PageInfo<BreTreatAllInfoDto>(list);
        return pageInfo;
    }

    public List<BreTreatAllInfoDto> getBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.getBreTreatyBasisInfoList(breTreatAllInfoDto);
    }


    public List<BreTreatAllInfoDto> selectBreTreatyPropAllInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.selectBreTreatyPropAllInfo(breTreatAllInfoDto);
    }

    public List<BreTreatAllInfoDto> selectBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.selectBreTreatyPropInfo(breTreatAllInfoDto);
    }

    public List<BreTreatAllInfoDto> selectBreTreatyNonPropAllInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.selectBreTreatyNonPropAllInfo(breTreatAllInfoDto);
    }


    public int addBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        BreLogInfoDto breLogInfoDto = new BreLogInfoDto();
        breLogInfoDto.setCreatedBy(breTreatAllInfoDto.getUsername());
        breLogInfoDto.setFlagType("1");
        breLogInfoDto.setRemarks("创建数据");
        breLogInfoDto.setKeyValue(breTreatAllInfoDto.getBreSlipNumber());
        addBreLogInfoInfo(breLogInfoDto);
        return basisMapper.addBreTreatyBasisInfo(breTreatAllInfoDto);
    }

    public int addBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.addBreTreatyPropInfo(breTreatAllInfoDto);
    }

    public int addBreTreatyNonPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.addBreTreatyNonPropInfo(breTreatAllInfoDto);
    }

    public int addBreTreatNonPropAndArrange(BreTreatAllInfoDto breTreatAllInfoDto) throws Exception {
        String nonPropId = basisMapper.getTreatyNonPropInfoId();
        breTreatAllInfoDto.setPropId(nonPropId);
        String nonPropLimit = "(" + breTreatAllInfoDto.getNonPropLimitNumber() + " xs " + breTreatAllInfoDto.getNonPropLimitPercentage() + "）";
        breTreatAllInfoDto.setNonPropLimit(nonPropLimit);
        int size = basisMapper.addBreTreatyNonPropInfo(breTreatAllInfoDto);
        BreTreatyReinsurerInfoDto dto = new BreTreatyReinsurerInfoDto();
        dto.setBreSlipNumber(breTreatAllInfoDto.getBreSlipNumber());
        List<BreTreatyReinsurerInfoDto> list = breTreatyReinsurerInfoMapper.getBreTreatyReinsurerInfoList(dto);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto = list.get(i);
                breTreatAllInfoDto.setReinsurerId(breTreatyReinsurerInfoDto.getId());
                addBreTreatyArrangeInfo(breTreatAllInfoDto);
            }
        }
        return size;
    }

    public int addBreTreatyReinsureInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.addBreTreatyReinsureInfo(breTreatAllInfoDto);
    }

    public int addBreTreatyArrangeInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.addBreTreatyArrangeInfo(breTreatAllInfoDto);
    }

    public int updateBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        BreLogInfoDto breLogInfoDto = new BreLogInfoDto();
        breLogInfoDto.setCreatedBy(breTreatAllInfoDto.getUsername());
        breLogInfoDto.setFlagType("2");
        breLogInfoDto.setRemarks("修改数据");
        breLogInfoDto.setKeyValue(breTreatAllInfoDto.getBreSlipNumber());
        addBreLogInfoInfo(breLogInfoDto);
        return basisMapper.updateBreTreatyBasisInfo(breTreatAllInfoDto);
    }

    public int updateBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {


        return basisMapper.updateBreTreatyPropInfo(breTreatAllInfoDto);
    }

    public int updateBreTreatyNonPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.updateBreTreatyNonPropInfo(breTreatAllInfoDto);
    }

    public int updateBreTreatyReinsureInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.updateBreTreatyReinsureInfo(breTreatAllInfoDto);
    }

    public int updateBreTreatyArrangePropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.updateBreTreatyArrangePropInfo(breTreatAllInfoDto);
    }

    public List<BreTreatAllInfoDto> selectBreTreatyArrangeAllList(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.selectBreTreatyArrangeAllList(breTreatAllInfoDto);
    }

    public List<BreTreatAllInfoDto> getBreTreatyNonPropInfoList(BreTreatAllInfoDto breTreatAllInfoDto) {
        return basisMapper.getBreTreatyNonPropInfoList(breTreatAllInfoDto);
    }

    public String getTreatyPropInfoId() {
        return basisMapper.getTreatyPropInfoId();
    }

    public String getTreatyNonPropInfoId() {
        return basisMapper.getTreatyNonPropInfoId();
    }
}
