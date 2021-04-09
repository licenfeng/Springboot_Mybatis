package com.example.mapper;
import com.example.entity.UserInfoDto;
import org.springframework.stereotype.Repository;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper {


    UserInfoDto getUserInfo(String userName);

}
