package com.example.utils;

import com.example.entity.ResultInfoDto;


public class ResultUtils {
    /**
     * 成功
     * @param object
     * @return
     */
    public static ResultInfoDto success(Object object) {
        ResultInfoDto result = new ResultInfoDto();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static ResultInfoDto success() {
        return success(null);
    }

    public static ResultInfoDto error(Integer code, String msg) {
        ResultInfoDto result = new ResultInfoDto();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 一般异常
     * @param msg
     * @return
     */
    public static ResultInfoDto error(String msg) {
        return error(-1,msg);
    }

    /**
     * 没有权限
     * @param msg
     * @return
     */
    public static ResultInfoDto noRole(String msg) {
        return error(403,msg);
    }

    /**
     * 登录超时
     * @param msg
     * @return
     */
    public static ResultInfoDto noLogin(String msg) {
        return error(401,msg);
    }
}
