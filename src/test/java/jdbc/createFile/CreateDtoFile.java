package jdbc.createFile;

import jdbc.CreateDto.CreateDtoText;
import jdbc.common.CommonText;
import jdbc.common.CreateFileCommon;
import jdbc.ent.TableInfo;
import jdbc.name.NameClass;
import jdbc.tableNumber.GetTableInfo;

import java.util.List;

public class CreateDtoFile extends NameClass {

    public static String fileHold="package "+ dtoUrl+";";


    public static void createDtoFile(){
        String dtoFileUrl=projectUrl+ST+javaUrl+ST+ CommonText.getSpotToSlash(dtoUrl)+"\\"+getNameDto()+".java";
        List<TableInfo> list=GetTableInfo.getList();
        String str=getDtoText(list);
        CreateFileCommon.getFile(dtoFileUrl,str);
    }

    static String getDtoText(List<TableInfo> list){
        StringBuffer sbf=new StringBuffer();
        sbf.append(fileHold+RN);
        sbf.append("public class "+getNameDto()+"{"+RN);
        sbf.append(CreateDtoText.getDtoText(list)+RN);
        sbf.append("}"+RN);
        return sbf.toString();
    }
}
