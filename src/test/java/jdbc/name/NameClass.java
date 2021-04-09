package jdbc.name;

import jdbc.common.CommonText;

public class NameClass {


    public static String ST="\\";
    public static String RN="\n";
    public static String RT="\t";
    public static   String tableName="bre_treaty_non_prop_info";
    public static  String projectUrl="D:\\java\\springBoot_Mybatis-master\\Springboot_Mybatis";
    //  public static  String projectUrl="D:\\new";
    public static  String javaUrl="src\\main\\java";
    public static  String resourcesUrl="src\\main\\resources";
    public static  String mapperUrl="mapping";

    public static String dtoUrl="com.example.entity";
    public static String mapperJavaUrl="com.example.mapper";
    public static String serviceJavaUrl="com.example.service";
    public static String controllerJavaUrl="com.example.controller";


    public static  String getTableNameAa(){
        return CommonText.get_ToAa(tableName);
    }

    public  static String getNameService(){
        return getTableNameAA()+"Service";
    }

    public  static String getNameServiceAllUrl(){
        return serviceJavaUrl+"."+getTableNameAA()+"Service";
    }

    public  static String getNameController(){
        return getTableNameAA()+"Controller";
    }

    static String getTableNameAA(){
        return CommonText.aaToAa(tableName);
    }

    public static  String getJavaMapperNameAllUrl(){
        return  mapperJavaUrl+"."+getTableNameAA()+"Mapper";
    }

    public static  String getMapperName(){
        return  getTableNameAA()+"Mapper";
    }

    public static  String getMapperXmlName(){
        return  getTableNameAA()+"Mapper";
    }

    public  static String getNameDto(){
        return getTableNameAA()+"Dto";
    }
    public static String getSelectId(){
        return  "get"+getTableNameAA()+"List";
    }

    public static String getUpdateId(){
        return  "update"+getTableNameAA()+"Info";
    }

    public static String getInsertId(){
        return  "add"+getTableNameAA()+"Info";
    }

    public static String getDeleteId(){
        return  "del"+getTableNameAA()+"Info";
    }

    public static String getJavaDtoAllUrl(){
        return dtoUrl+"."+getNameDto();
    }

    public static String getParameterTypeSql(){
        return getJavaDtoAllUrl();
    }

    public static String getResultTypeSql(){
        return getJavaDtoAllUrl();
    }


}
