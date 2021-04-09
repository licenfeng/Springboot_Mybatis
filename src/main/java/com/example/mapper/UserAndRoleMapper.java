package com.example.mapper;
import com.example.entity.UserAndRoleAndOperationDto;
import org.springframework.stereotype.Repository;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserAndRoleMapper {


    String getOpenIdByLink(UserAndRoleAndOperationDto userAndRole);
}
