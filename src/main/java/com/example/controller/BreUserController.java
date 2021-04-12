package com.example.controller;


import com.example.entity.ResultInfoDto;
import com.example.entity.UserInfoDto;
import com.example.service.UserService;
import com.example.utils.ResultUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@ResponseBody
@RequestMapping("/breUser")
public class BreUserController {
    @Autowired
    UserService userService;
    private Logger logger =  LogManager.getLogger(BreUserController.class);
    @PostMapping("/login")
    public ResultInfoDto login(UserInfoDto userInfo){
        try{
            UserInfoDto userData=userService.loginInfo(userInfo.getUsername());
            String username="";
            if(userData.getPassword().equals(userInfo.getPassword())){
                username=userData.getUsername();
            }else{
                return ResultUtils.error("账号或者密码错误！");
            }
            return ResultUtils.success(username);
        }catch (Exception e){
            logger.error("getBreFieldExportInfoList"+e.toString(),e);
            return ResultUtils.error("登录失败！");
        }

    }

    @PostMapping("/logout")
    public ResultInfoDto logout(HttpSession session){
        try {
            session.invalidate();
            return ResultUtils.success();
        }catch (Exception e){
            logger.error("getBreFieldExportInfoList"+e.toString(),e);
            return ResultUtils.error(e.toString());
        }
    }


}
