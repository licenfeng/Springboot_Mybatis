package com.example.service;

import com.example.entity.UserInfoDto;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public UserInfoDto loginInfo(String userName){
     return  userMapper.getUserInfo(userName);
    }
}
