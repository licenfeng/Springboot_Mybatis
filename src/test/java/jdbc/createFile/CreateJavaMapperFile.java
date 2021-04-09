package jdbc.createFile;

import jdbc.common.CommonText;
import jdbc.common.CreateFileCommon;
import jdbc.name.NameClass;

public class CreateJavaMapperFile extends NameClass {
    public static String fileHold="package "+mapperJavaUrl +";\n"
            +"import org.springframework.stereotype.Repository;\n"
            +"import java.util.*;\n";
    public static void createJavaMapperFile(){

        String url=projectUrl+ ST +javaUrl+ ST + CommonText.getSpotToSlash(mapperJavaUrl)+ ST +getMapperName()+".java";
        String text=getText();
        CreateFileCommon.getFile(url,text);
    }

    static String getImport(){
        StringBuffer sbf=new StringBuffer();
        sbf.append("import "+getJavaDtoAllUrl()+";"+RN);
        return sbf.toString();
    }

    static String getText(){
        StringBuffer sbf=new StringBuffer();
        sbf.append(fileHold);
        sbf.append(getImport());
        sbf.append(getJavaMapperText());
        return sbf.toString();
    }
    static String getJavaMapperText(){
        StringBuffer sbf=new StringBuffer();
        sbf.append("@Repository"+RN);
        sbf.append("public interface "+getMapperName()+"{"+RN);
        sbf.append(getMethodText()+RN);
        sbf.append("}"+RN);
        return  sbf.toString();
    }

    static String getMethodText(){
        StringBuffer sbf=new StringBuffer();
        sbf.append(" List<"+getNameDto()+"> "+getSelectId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +");"+RN);
        sbf.append(" int "+getUpdateId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +");"+RN);
        sbf.append(" int "+getDeleteId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +");"+RN);
        sbf.append(" int "+getInsertId()+"("+getNameDto()+"  "+ CommonText.getAToa(getNameDto()) +");"+RN);
        return  sbf.toString();
    }
}
