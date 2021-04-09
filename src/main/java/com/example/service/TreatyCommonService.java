package com.example.service;

import com.example.entity.BreFieldInfoDto;
import com.example.mapper.BreFieIdInfoMapper;
import com.example.utils.CommonUtils;
import com.example.entity.BreFieldExportInfoDto;
import com.example.entity.BreTreatAllInfoDto;
import com.example.entity.BreWordbookInfoDto;
import com.example.mapper.BreFieIdExportInfoMapper;
import com.example.mapper.BreTreatyBasisMapper;
import com.example.mapper.BreWordbookInfoMapper;
import com.example.utils.ExcelExportUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TreatyCommonService {

    @Autowired
    BreFieIdExportInfoMapper  breFieIdExportInfoMapper;

    @Autowired
    BreWordbookInfoMapper breWordbookInfoMapper;

    @Autowired
    BreTreatyBasisMapper breTreatyBasisMapper;
    @Autowired
    BreFieIdInfoMapper breFieIdInfoMapper;


    private Logger logger =  LogManager.getLogger(TreatyCommonService.class);

  public List<BreFieldExportInfoDto> getBreFieldExportInfoList(BreFieldExportInfoDto breFieldExportInfoDto){
      return breFieIdExportInfoMapper.getBreFieldExportInfoList(breFieldExportInfoDto);
  }

  public int updateBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto){
      return breFieIdExportInfoMapper.updateBreFieldExportInfo(breFieldExportInfoDto);
  }

  public int addBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto){

      return breFieIdExportInfoMapper.addBreFieldExportInfo(breFieldExportInfoDto);
  }

  public int deleteBreFieldExportInfo(BreFieldExportInfoDto breFieldExportInfoDto){

      return breFieIdExportInfoMapper.deleteBreFieldExportInfo(breFieldExportInfoDto);
  }

    public List<BreFieldExportInfoDto> getFiledWorkIdList(){
        return breFieIdExportInfoMapper.getFiledWorkIdList();
    }


    public  PageInfo getBreWordbookInfoPage(BreWordbookInfoDto breWordbookInfoDto){
        PageHelper.startPage(breWordbookInfoDto.getPageNo(),breWordbookInfoDto.getPageSize());
        List<BreWordbookInfoDto> list=breWordbookInfoMapper.getBreWordbookInfo(breWordbookInfoDto);
        PageInfo pageInfo =new PageInfo(list);
        return pageInfo;
    }
    public  List<BreWordbookInfoDto> getBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto){
        return  breWordbookInfoMapper.getBreWordbookInfo(breWordbookInfoDto);
    }


    public synchronized String  getReinsurerId(){

      return breWordbookInfoMapper.getReinsurerId();
    }

    public synchronized   String  getBreSlipNumber(){

        String breSlipNumberStr="";
        String breSlipNumber= breWordbookInfoMapper.getBreSlipNumber();
        if(breSlipNumber!=null){
            int length=breSlipNumber.length();
            if(length<7){
                breSlipNumberStr= CommonUtils.leftSupplement("0",6-length,breSlipNumber);
            }else{
                breSlipNumberStr=breSlipNumberStr;
            }
        }
       String start= CommonUtils.getBreSlipNumber();
        return start+breSlipNumberStr ;
    }



    public int addBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto){
        return breWordbookInfoMapper.addBreWordbookInfo(breWordbookInfoDto);
    }

    public int updateBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto){
      return breWordbookInfoMapper.updateBreWordbookInfo(breWordbookInfoDto);

    }

    public int deleteBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto){
        return breWordbookInfoMapper.deleteBreWordbookInfo(breWordbookInfoDto);
    }


    public List<BreFieldInfoDto> getBreFieldInfoList(BreFieldInfoDto breFieldInfoDto){
        return breFieIdInfoMapper.getBreFieldInfoList(breFieldInfoDto);
    }


    public List<BreWordbookInfoDto> getBreWordbookInfoGroupByType(){
      return breWordbookInfoMapper.getBreWordbookInfoGroupByType();
    }

    public  List<BreWordbookInfoDto> getBreWordbookInfoGroupByKeyType(BreWordbookInfoDto breWordbookInfoDto){
        return breWordbookInfoMapper.getBreWordbookInfoGroupByKeyType(breWordbookInfoDto);
    }

    public String exportBreTreatAllCsv(BreFieldExportInfoDto breFieldExportInfoDto, BreTreatAllInfoDto breTreatAllInfoDto){
        List<BreFieldExportInfoDto> list= breFieIdExportInfoMapper.getBreFieldExportInfoList(breFieldExportInfoDto);
        List treatyPropList= breTreatyBasisMapper.selectBreTreatyPropAllInfo(breTreatAllInfoDto);
        String fileNext="";
        try{
            fileNext= CommonUtils.getFileTextCSV(list, treatyPropList, BreTreatAllInfoDto.class);
        }catch (Exception e){
            logger.error("格式转换异常downloadsExcelDown.CommonUtil.getFileTextCSV:"+e.toString(),e);
        }

      return fileNext;
    }

    public HSSFWorkbook exportBreTreatAllExcl(BreFieldExportInfoDto breFieldExportInfoDto, BreTreatAllInfoDto breTreatAllInfoDto){
        List<BreFieldExportInfoDto> list= breFieIdExportInfoMapper.getBreFieldExportInfoList(breFieldExportInfoDto);

        List treatyPropList= breTreatyBasisMapper.selectBreTreatyPropAllInfo(breTreatAllInfoDto);
        HSSFWorkbook workbook=null;
        try{
            ExcelExportUtils exportUtils=new ExcelExportUtils("Treat Info",list,treatyPropList,BreTreatAllInfoDto.class);
            workbook=exportUtils.exclExport();
        }catch (Exception e){
            logger.error("格式转换异常downloadsExcelDown.CommonUtil.getFileTextCSV:"+e.toString(),e);
        }
        return workbook;
    }
}
