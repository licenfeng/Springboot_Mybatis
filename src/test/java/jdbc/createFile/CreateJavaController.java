package jdbc.createFile;

import jdbc.common.CommonText;
import jdbc.common.CreateFileCommon;
import jdbc.name.NameClass;

public class CreateJavaController extends NameClass {
    public static String fileHold="package "+controllerJavaUrl+";\n"
            +"import com.example.util.ResultUtil;"+RN
            +"import org.springframework.beans.factory.annotation.Autowired;"+RN
            +"import org.springframework.web.bind.annotation.RequestMapping;"+RN
            +"import org.springframework.web.bind.annotation.ResponseBody;"+RN
            +"import org.springframework.web.bind.annotation.RestController;"+RN
            +"import org.apache.logging.log4j.LogManager;"+RN
            +"import org.apache.logging.log4j.Logger;"+RN
            +"import com.example.entity.ResultInfoDto;"+RN
            +"import javax.servlet.http.HttpSession;"+RN
            +"import java.util.*;"+RN;

    public static void createJavaServiceFile(){
        String url=projectUrl+ST+javaUrl+ST+ CommonText.getSpotToSlash(controllerJavaUrl)+ST+getNameController()+".java";
        System.out.println(url);
        String text=getText();
        CreateFileCommon.getFile(url,text);
    }

    static String getImport(){
        StringBuffer sbf=new StringBuffer();
        sbf.append("import "+getJavaDtoAllUrl()+";"+RN);
        sbf.append("import "+getNameServiceAllUrl()+";"+RN);
        return sbf.toString();
    }

    static String getText(){
        StringBuffer sbf=new StringBuffer();
        sbf.append(fileHold);
        sbf.append(getImport());
        sbf.append("@RestController"+RN);
        sbf.append("@ResponseBody"+RN);
        sbf.append(" @RequestMapping("+CommonText.getTextAddMarks("/"+getTableNameAa())+")"+RN);
        sbf.append("public class "+getNameController()+"{"+RN);
        sbf.append(getAutowired());
        sbf.append(getJavaMethod());
        sbf.append(RN+"}");
        return  sbf.toString();
    }

    static String getAutowired(){
        StringBuffer sbf=new StringBuffer();
        sbf.append(RT+"@Autowired"+RN);
        sbf.append(RT+getNameService()+" "+CommonText.getAToa(getNameService())+";"+RN);
        sbf.append("private Logger logger =  LogManager.getLogger("+getNameController()+".class);");
        return  sbf.toString();
    }


    static String getJavaMethod(){
        StringBuffer sbf=new StringBuffer();
        String nameService=CommonText.getAToa(getNameService());
        String daoName=getNameDto();
        String dtpNameToL=CommonText.getAToa(daoName);

        sbf.append("@RequestMapping("+CommonText.getTextAddMarks("/"+getSelectId())+")"+RN);
        sbf.append("public ResultInfoDto "+getSelectId()+"("+daoName+"  "+ dtpNameToL +"){"+RN);
        sbf.append("try{"+RN);
        sbf.append(RT+"List<"+getNameDto()+"> list="+nameService+"."+getSelectId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return ResultUtil.success(list);"+RN);
        sbf.append("}catch (Exception e){" +RN);
        sbf.append(RT+"return ResultUtil.error(-1,\"数据查询异常\");" +RN);
        sbf.append("   }"+RN);
        sbf.append("}"+RN);

        sbf.append("@RequestMapping("+CommonText.getTextAddMarks("/"+getUpdateId())+")"+RN);
        sbf.append("public ResultInfoDto "+getUpdateId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +"){"+RN);
        sbf.append("try{"+RN);
        sbf.append(RT+"int size="+nameService+"."+getUpdateId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return ResultUtil.success(size);"+RN);
        sbf.append("}catch (Exception e){" +RN);
        sbf.append(RT+"return ResultUtil.error(-1,\"数据查询异常\");" +RN);
        sbf.append("   }"+RN);
        sbf.append("}"+RN);

        sbf.append("@RequestMapping("+CommonText.getTextAddMarks("/"+getDeleteId())+")"+RN);
        sbf.append("public ResultInfoDto "+getDeleteId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +"){"+RN);
        sbf.append("try{"+RN);
        sbf.append(RT+"int size="+nameService+"."+getDeleteId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return ResultUtil.success(size);"+RN);
        sbf.append("}catch (Exception e){" +RN);
        sbf.append(RT+"return ResultUtil.error(-1,\"数据查询异常\");" +RN);
        sbf.append("   }"+RN);
        sbf.append("}"+RN);

        sbf.append("@RequestMapping("+CommonText.getTextAddMarks("/"+getInsertId())+")"+RN);
        sbf.append("public ResultInfoDto "+getInsertId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +"){"+RN);
        sbf.append("try{"+RN);
        sbf.append(RT+"int size="+nameService+"."+getInsertId()+"( "+dtpNameToL+");"+RN);
        sbf.append(RT+"return ResultUtil.success(size);"+RN);
        sbf.append("}catch (Exception e){" +RN);
        sbf.append(RT+"return ResultUtil.error(-1,\"数据查询异常\");" +RN);
        sbf.append("   }"+RN);
        sbf.append("}"+RN);
        return  sbf.toString();
    }

}
