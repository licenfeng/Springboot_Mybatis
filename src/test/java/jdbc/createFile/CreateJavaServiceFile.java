package jdbc.createFile;

import jdbc.common.CommonText;
import jdbc.common.CreateFileCommon;
import jdbc.name.NameClass;

public class CreateJavaServiceFile extends NameClass {
    public static String fileHold="package "+serviceJavaUrl +";"+RN
            +"import org.apache.logging.log4j.LogManager;"+RN
            +"import org.apache.logging.log4j.Logger;"+RN
            +"import org.springframework.beans.factory.annotation.Autowired;"+RN
            +"import org.springframework.stereotype.Service;"+RN
            +"import java.util.*;"+RN;

    public static void createJavaServiceFile(){
        String url=projectUrl + ST + javaUrl+ ST + CommonText.getSpotToSlash(serviceJavaUrl)+ ST +getNameService()+".java";
        String text=getText();
        CreateFileCommon.getFile(url,text);
    }

    static String getImport(){
        StringBuffer sbf=new StringBuffer();
        sbf.append("import "+getJavaDtoAllUrl()+";"+RN);
        sbf.append("import "+getJavaMapperNameAllUrl()+";"+RN);
        return sbf.toString();
    }

    static String getText(){
        StringBuffer sbf=new StringBuffer();
        sbf.append(fileHold);
        sbf.append(getImport());
        sbf.append("@Service"+RN);
        sbf.append("public class "+getNameService()+"{"+RN);
        sbf.append(getAutowired());
        sbf.append(getJavaMethod());
        sbf.append(RN+"}");
        return  sbf.toString();
    }

    static String getAutowired(){
        StringBuffer sbf=new StringBuffer();
        sbf.append(RT+"@Autowired"+RN);
        sbf.append(RT+getMapperName()+" "+CommonText.getAToa(getMapperName())+";"+RN);
        sbf.append("private Logger logger =  LogManager.getLogger("+getNameService()+".class);"+RN);
        return  sbf.toString();
    }


    static String getJavaMethod(){
        StringBuffer sbf=new StringBuffer();
        String mapperName=CommonText.getAToa(getMapperName());
        String daoName=getNameDto();
        String dtpNameToL=CommonText.getAToa(daoName);

        sbf.append("public List<"+getNameDto()+"> "+getSelectId()+"("+daoName+"  "+ dtpNameToL +"){"+RN);
        sbf.append(RT+"List<"+getNameDto()+"> list="+mapperName+"."+getSelectId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return list;"+RN);
        sbf.append("}"+RN);

        sbf.append("public int "+getUpdateId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +"){"+RN);
        sbf.append(RT+"int size="+mapperName+"."+getUpdateId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return size;"+RN);
        sbf.append("}"+RN);

        sbf.append("public int "+getDeleteId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +"){"+RN);
        sbf.append(RT+"int size="+mapperName+"."+getDeleteId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return size;"+RN);
        sbf.append("}"+RN);

        sbf.append("public int "+getInsertId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +"){"+RN);
        sbf.append(RT+"int size="+mapperName+"."+getInsertId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return size;"+RN);
        sbf.append("}"+RN);
        return  sbf.toString();
    }


}
