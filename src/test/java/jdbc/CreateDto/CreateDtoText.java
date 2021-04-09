package jdbc.CreateDto;

import jdbc.common.CommonText;
import jdbc.ent.TableInfo;
import jdbc.name.NameClass;

import java.util.List;

public class CreateDtoText extends NameClass {

    public static String getDtoText(List<TableInfo> list){

        return getDtoPrivateText(list,true);
    }


    static String getType(String dataType){

        if(dataType.equals("int")){
            return "Integer";
        }else if(dataType.equals("varchar")||dataType.equals("string")){
            return "String";
        }else if(dataType.equals("date")){
            return "Date";
        }else{
            return CommonText.aaToAa(dataType);
        }
    }

    public static String getDtoPrivateText(List<TableInfo> list,Boolean isString){
        StringBuffer sbf=new StringBuffer();
        String dataType="";
        for(int j=0;j<list.size();j++){
            TableInfo tableInfo=list.get(j);
            String types=tableInfo.getDataType();
            String columnName=tableInfo.getColumnName();
            String end= CommonText.get_ToAa(columnName);
            if(isString){
                 dataType="String";
            }else{
                dataType=getType(types);
            }
            sbf.append("private  "+dataType+"  "+end+";"+RN);
            sbf.append(getFileGet(columnName,dataType)+RN);
            sbf.append(getFileSet(columnName,dataType)+RN);
        }
       return sbf.toString();
    }


    static String getFileGet(String columnName,String dataType){
        String endColumnName=CommonText.aaToAa(columnName);
        String startColumnName=CommonText.getAToa(endColumnName);
        StringBuffer str=new StringBuffer();
        str.append("public "+dataType+" get"+endColumnName+"(){"+RN);
        str.append(RT+"return this."+startColumnName+";"+RN);
        str.append("}"+RN);
        return str.toString();
    }

    static String getFileSet(String columnName,String dataType){
        String endColumnName=CommonText.aaToAa(columnName);
        String startColumnName=CommonText.getAToa(endColumnName);
        StringBuffer str=new StringBuffer();
        str.append("public void set"+endColumnName+"(");
        str.append(dataType+" "+startColumnName+"){"+RN);
        str.append(RT+" this."+startColumnName+"="+startColumnName+";"+RN);
        str.append("}"+RN);
        return str.toString();
    }
}
