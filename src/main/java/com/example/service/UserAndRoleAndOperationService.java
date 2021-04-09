package com.example.service;

import com.example.entity.UserAndRoleAndOperationDto;
import com.example.mapper.UserAndRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class UserAndRoleAndOperationService {
    @Autowired
    UserAndRoleMapper userMapper;


    public  String countOpenByLinkAndUser(String operId,String userName){

        UserAndRoleAndOperationDto userAndRoleInfoAndOperationInfo=new UserAndRoleAndOperationDto();
        userAndRoleInfoAndOperationInfo.setOperId(operId);
        userAndRoleInfoAndOperationInfo.setUserName(userName);
        return userMapper.getOpenIdByLink(userAndRoleInfoAndOperationInfo);

    }

    public String getOpenIdByLink(String operLink){

        UserAndRoleAndOperationDto userAndRole =new UserAndRoleAndOperationDto();
        userAndRole.setOperLink(operLink);
        return userMapper.getOpenIdByLink(userAndRole);
    }
}
