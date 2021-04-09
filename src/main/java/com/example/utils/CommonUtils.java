package com.example.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.BreFieldExportInfoDto;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {
    public static JSONArray listToJSONArray(List list){
        String actual = JSON.toJSONString(list);
        JSONArray jsonArray=JSONArray.parseArray(actual);
        return jsonArray;
    }

    public static JSONObject strToJSONObject(String  str){
        JSONObject  jsonObject= JSONObject.parseObject(str);
        return jsonObject;

    }

    public static String aaToAa(String str){
        return str.substring(0,1).toUpperCase()+ str.substring(1);
    }

    public static String getCurrentDate(String dateStr){
        Date date=new Date();
        SimpleDateFormat strDate = new SimpleDateFormat(dateStr);
        return strDate.format(date);
    }

    public static String getBreSlipNumber(){
        String slipNumber=getCurrentDate("yyyy");
        return  "BRE"+slipNumber+"T";
    }

    public static String leftSupplement(String str,int size,String value){
        String startStr="";
        if(size<2){
            return str+value;
        }else{
           for(int i=0;i<size;i++){
               startStr=str+""+startStr;
           }
            return startStr+value;
        }

    }

    public static JSONObject intToJSONObjectReturnState(int state){
        String str="{\"state\":"+state+"}";
        JSONObject  jsonObject= strToJSONObject(str);
        return jsonObject;
    }

    public synchronized static String getId(){
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Long log=calendar.getTimeInMillis();
     return "";
    }

    public static String getFileTextCSV(List<BreFieldExportInfoDto> headList, List<Object> list, Class clazz)throws Exception{
        StringBuffer fileHead=new StringBuffer();
        int line=0;
        List<String> strHead=new ArrayList<>();
        for(BreFieldExportInfoDto breFieldExportInfoDto : headList){
            fileHead.append(breFieldExportInfoDto.getFieldDesc());
            if(breFieldExportInfoDto ==null || null== breFieldExportInfoDto.getFieldId()){
                continue;
            }
            strHead.add(breFieldExportInfoDto.getFieldId());
            if(line<headList.size()-1){
                fileHead.append(",");
            }
            line++;
        }
        StringBuffer fileNext=new StringBuffer();
        fileNext.append("\n\r");
        if(StringUtils.isEmpty(list)){
            return fileHead.toString();
        }
        Field[] fields = clazz.getDeclaredFields();
        for(Object Obj : list){
            for(int i=0;i<strHead.size();i++){
                String strName=strHead.get(i);
                for (Field field : fields) {
                    String end =get_ToAa(strName);
                    if(end.equals(field.getName())){
                        field.setAccessible(true);
                        Object value = field.get(Obj);
                        fileNext.append(value);
                        if(i<strHead.size()-1){
                            fileNext.append(",");
                        }
                    }
                }
            }
            fileNext.append("\n\r");
        }
        return fileHead.toString()+fileNext.toString();
    }

    public static String get_ToAa(String str){
        String[] strList = str.split("_");
        String end = "";
        for (int i = 0; i < strList.length; i++) {
            String st = strList[i];
            if (i > 0) {
                String ends = st.substring(0, 1).toUpperCase() + st.substring(1).toLowerCase();
                end = end + ends;
            } else {
                end = end + strList[i].toLowerCase();
            }
        }
        return end;
    }

    public static int compareStringDate(String stringDate,String datePattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(datePattern);//设置日期格式
        Date date = df.parse(stringDate);
        Date date1 = new Date();
        return date.compareTo(date1);
    }

}
