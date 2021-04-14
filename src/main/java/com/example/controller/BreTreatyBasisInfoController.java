package com.example.controller;

import com.example.entity.BreTreatyReinsurerInfoDto;
import com.example.entity.ResultInfoDto;
import com.example.entity.BreTreatAllInfoDto;
import com.example.service.BreTreatyArrangeInfoService;
import com.example.service.BreTreatyReinsurerInfoService;
import com.example.service.TreatyCommonService;
import com.example.service.TreatyService;
import com.example.utils.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@ResponseBody
@RequestMapping("/breTreatyBasisInfo")
public class BreTreatyBasisInfoController{

    @Autowired
    private TreatyCommonService treatyCommonService;

    @Autowired
    private TreatyService treatyService;

    @Autowired
    private BreTreatyReinsurerInfoService breTreatyReinsurerInfoService;
    @Autowired
    private BreTreatyArrangeInfoService breTreatyArrangeInfoService;
    private Logger log = LogManager.getLogger(BreTreatyBasisInfoController.class);


    @RequestMapping("/selectBreTreatyBasisAllName")
    public ResultInfoDto selectBreTreatyBasisAllName() {
        try {
            List<BreTreatAllInfoDto> list = treatyService.selectBreTreatyBasisAllName();
            return ResultUtils.success(list);
        } catch (Exception e) {
            log.error("selectBreTreatyBasisAllName 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据查询异常");
        }
    }

    @RequestMapping("/getBreTreatyBasisInfoList")
    public ResultInfoDto getBreTreatyBasisInfoList(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            PageInfo pageInfo = treatyService.getBreTreatyBasisInfoListPage(breTreatAllInfoDto);
            return ResultUtils.success(pageInfo);
        } catch (Exception e) {
            log.error("getBreTreatyBasisInfoList 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");

        }

    }

    @RequestMapping("/getBreTreatyBasisInfo")
    public ResultInfoDto getBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            List<BreTreatAllInfoDto> list = treatyService.getBreTreatyBasisInfo(breTreatAllInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            log.error("getBreTreatyBasisInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");
        }

    }

    @RequestMapping("/getBreTreatyBasisPropAllList")
    public ResultInfoDto getBreTreatyBasisPropAllList(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            Map map = treatyService.getBreTreatyBasisPropAllList(breTreatAllInfoDto);
            return ResultUtils.success(map);
        } catch (Exception e) {
            log.error("getBreTreatyBasisPropAllList 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/getBreTreatyBasisNonPropAllList")
    public ResultInfoDto getBreTreatyBasisNonPropAllList(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            Map map = treatyService.getBreTreatyBasisNonPropAllList(breTreatAllInfoDto);
            return ResultUtils.success(map);
        } catch (Exception e) {
            log.error("getBreTreatyBasisNonPropAllList 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }
//====================================================================

    @RequestMapping("/getBreTreatyBasisPropAllListByBreSlipNumber")
    public ResultInfoDto getBreTreatyBasisPropAllListByBreSlipNumber(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            Map map = treatyService.copyNewGetBreTreatyBasisPropAllListByBreSlipNumber(breTreatAllInfoDto);
            return ResultUtils.success(map);
        } catch (Exception e) {
            log.error("getBreTreatyBasisPropAllList 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/copyNewBreTreatyBasisNonPropAllListByBreSlipNumber")
    public ResultInfoDto getBreTreatyBasisNonPropAllListByBreSlipNumber(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            Map map = treatyService.copyNewGetBreTreatyBasisNonPropAllListByBreSlipNumber(breTreatAllInfoDto);
            return ResultUtils.success(map);
        } catch (Exception e) {
            log.error("getBreTreatyBasisNonPropAllList 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }
//=====================================================================



    @RequestMapping("/selectBreTreatyPropAllInfo")
    public ResultInfoDto selectBreTreatyPropAllInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            List<BreTreatAllInfoDto> list = treatyService.selectBreTreatyPropAllInfo(breTreatAllInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            log.error("selectBreTreatyPropAllInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }

    @RequestMapping("/getBreTreatyNonPropInfoList")
    public ResultInfoDto getBreTreatyNonPropInfoList(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            List<BreTreatAllInfoDto> list = treatyService.getBreTreatyNonPropInfoList(breTreatAllInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            log.error("getBreTreatyNonPropInfoList 接口异常：" + e.toString(), e);
            return ResultUtils.error(-1, "数据查询异常");
        }
    }




    @RequestMapping("/selectBreTreatyPropInfo")
    public ResultInfoDto selectBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            List<BreTreatAllInfoDto> list = treatyService.selectBreTreatyPropInfo(breTreatAllInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            log.error("selectBreTreatyPropInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }
    }

    @RequestMapping("/selectBreTreatyNonPropAllInfo")
    public ResultInfoDto selectBreTreatyNonPropAllInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            List<BreTreatAllInfoDto> list = treatyService.selectBreTreatyNonPropAllInfo(breTreatAllInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            log.error("selectBreTreatyNonPropAllInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }
    }


    @RequestMapping("/addBreTreatyBasisInfo")
    public ResultInfoDto addBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            String breSlipNumber = treatyCommonService.getBreSlipNumber();
            breTreatAllInfoDto.setBreSlipNumber(breSlipNumber);
            int state = treatyService.addBreTreatyBasisInfo(breTreatAllInfoDto);
            if (state < 1) {
                breTreatAllInfoDto.setBreSlipNumber("");
            }
            return ResultUtils.success(breTreatAllInfoDto);
        } catch (Exception e) {
            log.error("addBreTreatyBasisInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }

    }

    @RequestMapping("/addBreTreatyPropInfo")
    public ResultInfoDto addBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {

            String propId = treatyService.getTreatyPropInfoId();
            breTreatAllInfoDto.setPropId(propId);
            int state = treatyService.addBreTreatyPropInfo(breTreatAllInfoDto);
            BreTreatyReinsurerInfoDto dto = new BreTreatyReinsurerInfoDto();
            dto.setBreSlipNumber(breTreatAllInfoDto.getBreSlipNumber());
            List<BreTreatyReinsurerInfoDto> list = breTreatyReinsurerInfoService.getBreTreatyReinsurerInfoList(dto);
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    BreTreatyReinsurerInfoDto breTreatyReinsurerInfoDto = list.get(i);
                    breTreatAllInfoDto.setReinsurerId(breTreatyReinsurerInfoDto.getId());
                    treatyService.addBreTreatyArrangeInfo(breTreatAllInfoDto);
                }

            }
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("addBreTreatyPropInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }
    }

    /**
     * @param breTreatAllInfoDto
     * @return
     */
    @RequestMapping("/addBreTreatyNonPropInfo")
    public ResultInfoDto addBreTreatyNonPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            int state = treatyService.addBreTreatNonPropAndArrange(breTreatAllInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("addBreTreatyNonPropInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }
    }

    /**
     * @param
     * @return
     */
    @RequestMapping("/addBreTreatyArrangeAllInfo")
    public ResultInfoDto addBreTreatyArrangeAllInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            //获取在保人主健
            String id = treatyCommonService.getReinsurerId();
            breTreatAllInfoDto.setReinsurerId(id);
            //添加再保人信息
            treatyService.addBreTreatyReinsureInfo(breTreatAllInfoDto);
            if("Y".equals(breTreatAllInfoDto.getIsNonProp())){
                //添加非比例合约排分信息
                treatyService.addBreTreatyNonPropArrangeInfo(breTreatAllInfoDto);
            }else{
                //添加比例合约排分信息
                treatyService.addBreTreatyArrangeInfo(breTreatAllInfoDto);
            }
            return ResultUtils.success(0);
        } catch (Exception e) {
            log.error("addBreTreatyArrangeAllInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }

    }

    @RequestMapping("/selectBreTreatyArrangeAllList")
    public ResultInfoDto selectBreTreatyArrangeAllList(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            List<BreTreatAllInfoDto> list = treatyService.selectBreTreatyArrangeAllList(breTreatAllInfoDto);
            return ResultUtils.success(list);
        } catch (Exception e) {
            log.error("selectBreTreatyArrangeAllList 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }

    }


    @RequestMapping("/addBreTreatyArrangePropInfo")
    public ResultInfoDto addBreTreatyArrangePropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            int state = treatyService.addBreTreatyArrangeInfo(breTreatAllInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("addBreTreatyArrangePropInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据添加异常");
        }
    }

    @RequestMapping("/updateBreTreatyBasisInfo")
    public ResultInfoDto updateBreTreatyBasisInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            int state = treatyService.updateBreTreatyBasisInfo(breTreatAllInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("updateBreTreatyBasisInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据修改异常");
        }
    }

    @RequestMapping("/updateBreTreatyPropInfo")
    public ResultInfoDto updateBreTreatyPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            int state = treatyService.updateBreTreatyPropInfo(breTreatAllInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("updateBreTreatyPropInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据修改异常");
        }
    }


    @RequestMapping("/updateBreTreatyNonPropInfo")
    public ResultInfoDto updateBreTreatyNonPropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            int state = treatyService.updateBreTreatyNonPropInfo(breTreatAllInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("updateBreTreatyNonPropInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据修改异常");
        }
    }

    @RequestMapping("/updateBreTreatyReinsureInfo")
    public ResultInfoDto updateBreTreatyReinsureInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            int state = treatyService.updateBreTreatyReinsureInfo(breTreatAllInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("updateBreTreatyReinsureInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据修改异常");
        }
    }

    @RequestMapping("/updateBreTreatyArrangePropInfo")
    public ResultInfoDto updateBreTreatyArrangePropInfo(BreTreatAllInfoDto breTreatAllInfoDto) {
        try {
            int state = treatyService.updateBreTreatyArrangePropInfo(breTreatAllInfoDto);
            return ResultUtils.success(state);
        } catch (Exception e) {
            log.error("updateBreTreatyArrangePropInfo 接口异常：" + e.toString(), e);
            return ResultUtils.error("数据修改异常");
        }
    }

}
