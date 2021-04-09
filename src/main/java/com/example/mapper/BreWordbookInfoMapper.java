package com.example.mapper;
import com.example.entity.BreWordbookInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface BreWordbookInfoMapper {
   List<BreWordbookInfoDto> getBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto);

   int addBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto);

   int updateBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto);

   int deleteBreWordbookInfo(BreWordbookInfoDto breWordbookInfoDto);

   List<BreWordbookInfoDto> getBreWordbookInfoGroupByType();

   List<BreWordbookInfoDto> getBreWordbookInfoGroupByKeyType(BreWordbookInfoDto breWordbookInfoDto);

   String getBreSlipNumber();

   String getReinsurerId();

}
