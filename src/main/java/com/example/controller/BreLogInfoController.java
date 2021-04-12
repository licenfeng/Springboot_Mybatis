package com.example.controller;
import com.example.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.entity.ResultInfoDto;
import javax.servlet.http.HttpSession;
import java.util.*;
import com.example.entity.BreLogInfoDto;
import com.example.service.BreLogInfoService;
@RestController
@ResponseBody
 @RequestMapping("/breLogInfo")
public class BreLogInfoController{
	@Autowired
	BreLogInfoService breLogInfoService;
private Logger logger =  LogManager.getLogger(BreLogInfoController.class);@RequestMapping("/getBreLogInfoList")
public ResultInfoDto getBreLogInfoList(BreLogInfoDto  breLogInfoDto){
try{
	List<BreLogInfoDto> list=breLogInfoService.getBreLogInfoList( breLogInfoDto);
	return ResultUtils.success(list);
}catch (Exception e){
	return ResultUtils.error(-1,"数据查询异常");
   }
}
@RequestMapping("/updateBreLogInfoInfo")
public ResultInfoDto updateBreLogInfoInfo(BreLogInfoDto  breLogInfoDto){
try{
	int size=breLogInfoService.updateBreLogInfoInfo( breLogInfoDto);
	return ResultUtils.success(size);
}catch (Exception e){
	return ResultUtils.error(-1,"数据查询异常");
   }
}
@RequestMapping("/delBreLogInfoInfo")
public ResultInfoDto delBreLogInfoInfo(BreLogInfoDto  breLogInfoDto){
try{
	int size=breLogInfoService.delBreLogInfoInfo( breLogInfoDto);
	return ResultUtils.success(size);
}catch (Exception e){
	return ResultUtils.error(-1,"数据查询异常");
   }
}
@RequestMapping("/addBreLogInfoInfo")
public ResultInfoDto addBreLogInfoInfo(BreLogInfoDto  breLogInfoDto){
try{
	int size=breLogInfoService.addBreLogInfoInfo( breLogInfoDto);
	return ResultUtils.success(size);
}catch (Exception e){
	return ResultUtils.error(-1,"数据查询异常");
   }
}

}