package jdbc.createFile;

import jdbc.common.CommonText;
import jdbc.common.CreateFileCommon;
import jdbc.createSql.CreateSqlText;
import jdbc.ent.TableInfo;
import jdbc.name.NameClass;
import jdbc.tableNumber.GetTableInfo;
import java.util.List;

public class CreateMapperXmlFile extends NameClass {
    static String fileHold="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n";
   

  public   static  void createMapperXmlFile(){
      String fileName= getMapperXmlName();
        String fileUrl=projectUrl+ ST +resourcesUrl+ ST +mapperUrl+ ST +fileName+".xml";
        String fileText=getMappingFileText();
        CreateFileCommon.getFile(fileUrl,fileText);
    }
    static  String  getMappingFileText(){
      StringBuffer sbf=new StringBuffer();
        sbf.append(fileHold);
        sbf.append(getMapper(getSqlText()));
        return  sbf.toString();
    }

    static String getMapper(String text){
        StringBuffer sbf=new StringBuffer();
        sbf.append("<mapper namespace="+CommonText.getTextAddMarks(getJavaMapperNameAllUrl()));
        sbf.append(">");
        sbf.append(text);
        sbf.append("</mapper>");
        return sbf.toString();
    }

    static   String getSqlText(){
        StringBuffer sbf=new StringBuffer();
        List<TableInfo> list= GetTableInfo.getList();
        sbf.append(strUpdateSql(CreateSqlText.getUpdate(list)));
        sbf.append(strSelectSql(CreateSqlText.getSelectSql(list)));
        sbf.append(strInsertSql(CreateSqlText.getInsertSql(list)));
        sbf.append(strDeleteSql(CreateSqlText.getDeleteSql(list)));
        return sbf.toString();
    }


    public static String strSelectSql(String strSelectSql){
        StringBuffer sbf=new StringBuffer();
        sbf.append(" <select ");
        sbf.append(" id="+CommonText.getTextAddMarks(getSelectId()));
        sbf.append(" parameterType="+CommonText.getTextAddMarks(getParameterTypeSql()));
        sbf.append(" resultType="+CommonText.getTextAddMarks(getResultTypeSql()));
        sbf.append(">"+RN);
        sbf.append(strSelectSql);
        sbf.append(RN+"</select>");
        return sbf.toString();

    }

    public static String strUpdateSql(String strUpdateSql){
        StringBuffer sbf=new StringBuffer();
        sbf.append(" <update ");
        sbf.append(" id="+CommonText.getTextAddMarks(getUpdateId()));
        sbf.append(" parameterType="+CommonText.getTextAddMarks(getParameterTypeSql()));
        sbf.append(">"+RN);
        sbf.append(strUpdateSql);
        sbf.append(RN+"</update>");
        return sbf.toString();
    }

    public static String strInsertSql(String strInsertSql){
        StringBuffer sbf=new StringBuffer();
        sbf.append(" <insert ");
        sbf.append(" id="+CommonText.getTextAddMarks(getInsertId()));
        sbf.append(" parameterType="+CommonText.getTextAddMarks(getParameterTypeSql()));
        sbf.append(">"+RN);
        sbf.append(strInsertSql);
        sbf.append(RN+"</insert>");
        return sbf.toString();
    }

    public static String strDeleteSql(String strDeleteSql){
        StringBuffer sbf=new StringBuffer();
        sbf.append(" <delete ");
        sbf.append(" id="+CommonText.getTextAddMarks(getDeleteId()));
        sbf.append(" parameterType="+CommonText.getTextAddMarks(getParameterTypeSql()));
        sbf.append(">"+RN);
        sbf.append(strDeleteSql);
        sbf.append(RN+"</delete>");
        return sbf.toString();
    }


}
