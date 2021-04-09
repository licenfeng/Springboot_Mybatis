package jdbc.createSql;

import jdbc.common.CommonText;
import jdbc.ent.TableInfo;

import java.util.List;

public class CreateSqlText {
    static String RN="\n";
    static String RT="\t";


    public static String getInsertSql(List<TableInfo> list){
        String tableName=list.get(0).getTableName();
        StringBuffer sbf=new StringBuffer();
        StringBuffer columnKey=new StringBuffer();
        StringBuffer columnValue=new StringBuffer();
        int i=0;
        for(TableInfo tableInfo :list){
            String columnName=tableInfo.getColumnName();
            columnKey.append(getIfInsertKey(columnName,i));
            String dataType=tableInfo.getDataType();
            columnValue.append(getIfInsertValue(columnName,dataType,tableName,i));
            i++;
        }
        sbf.append("insert into "+tableName+"(" +RN);
        sbf.append(columnKey);
        sbf.append(") values (");
        sbf.append(columnValue);
        sbf.append(")");
        return sbf.toString();
    }

    public static  String getSelectSql(List<TableInfo> list){
        String tableName=list.get(0).getTableName();
        StringBuffer sbf=new StringBuffer();
        String briName="";
        sbf.append("select \n");
        int i=0;
        for(TableInfo tableInfo :list){
            String columnName=tableInfo.getColumnName();
            String dataType=tableInfo.getDataType();
            String endColumnName=CommonText.get_ToAa(tableInfo.getColumnName());
            if(i<list.size()-1){
                sbf.append(getColumnTypeToStr(columnName,dataType) + " as \"" + endColumnName + "\", \n");
            }else{
                sbf.append(getColumnTypeToStr(columnName,dataType) + " as \"" + endColumnName + "\" \n");
            }
            i++;
        }
        sbf.append(" from "+tableName +"\n");
        sbf.append(getWhere(list));
        return sbf.toString();
    }

    public static  String getDeleteSql(List<TableInfo> list){
        String tableName=list.get(0).getTableName();
        StringBuffer sbf=new StringBuffer();
        sbf.append("delete  from  "+tableName+" \n");
        return sbf.toString()+getWhere(list);
    }

    public static  String getUpdate(List<TableInfo> list){
        String tableName=list.get(0).getTableName();
        StringBuffer sbf=new StringBuffer();
        sbf.append("update  "+tableName+" set id=id \n");
        for(TableInfo tableInfo :list){
            String columnName=tableInfo.getColumnName();
            String endColumnName=CommonText.get_ToAa(tableInfo.getColumnName());
            String start=" <if test=\""+endColumnName+"!=null and "+endColumnName+" !=''\">";
            String startTow=" , "+columnName+"="+getColumnStrToType(endColumnName,tableInfo.getDataType());
            String end="</if>";
            sbf.append(start+"\n"+startTow+"\n"+end+"\n");
        }
        return sbf.toString()+"\n"+getWhere(list);
    }

     static  String getWhere(List<TableInfo> list){

        StringBuffer sbf=new StringBuffer();
        String strValue=" where 1=1 ";
        for(TableInfo tableInfo :list){
            String endColumnName=CommonText.get_ToAa(tableInfo.getColumnName());
            String columnName=tableInfo.getColumnName();
            String start=" <if test=\""+endColumnName+"!=null and "+endColumnName+" !=''\">";
            String startTow=" and  "+columnName+"="+getColumnStrToType(endColumnName,tableInfo.getDataType())+" ";
            String end="</if>";
            sbf.append(start+"\n"+startTow+"\n"+end+"\n");
        }
        return strValue+sbf.toString();
    }

    /**
     * insert 语句前半部分 ，key 的拼接
     * @param columnName
     * @return
     */
    static  String getIfInsertKey(String columnName,int i){
        StringBuffer sbf=new StringBuffer();
        String str=getStr(i);
        if("id".equals(columnName)){
            sbf.append(RT+str+columnName +RN);
        }else{
            String columnNameAa=CommonText.get_ToAa(columnName);
            sbf.append(" <if test=\""+columnNameAa+"!=null and "+columnNameAa+" != ''\">"+RN);
            sbf.append(RT+str+columnName +RN);
            sbf.append("</if>"+RN);
        }

        return sbf.toString();
    }

    static  String getStr(int i){
        String str="";
        if(i>0){
            str=" , ";
        }
        return str;
    }

    /**
     *  insert 语句前后部分 ，value 的拼接
     * @param columnName
     * @return
     */
    static  String getIfInsertValue(String columnName,String dataType,String tableName,int i){
        String str=getStr(i);
        StringBuffer sbf=new StringBuffer();
        String columnNameAa=CommonText.get_ToAa(columnName);
        if("id".equals(columnName)){
            sbf.append(RT+str+ "currval('"+tableName+"')");
        }else{
            sbf.append(" <if test=\""+columnNameAa+"!=null and "+columnNameAa+" != ''\">"+RN);
            sbf.append(RT+str+ getColumnStrToType(columnName,dataType)+RN);
            sbf.append("</if>"+RN);
        }
        return sbf.toString();
    }

    /**
     * 添加 #{}
     */
    static String  get(String columnName){
        return "#{"+columnName+"}";

    }

    /**
     *  根据类型判断做转换
     * @param columnName
     * @param dataType
     * @return
     */
    static  String getColumnStrToType(String columnName,String dataType){

        StringBuffer sbf=new StringBuffer();
        if(dataType.toLowerCase().equals("date")){
            sbf.append("str_to_date(");
            sbf.append(get(CommonText.get_ToAa(columnName)));
            sbf.append(",'%Y-%m-%d %H:%i:%s')");
        }else if("int".equals(dataType.toLowerCase())){
            sbf.append("CONVERT(");
            sbf.append(get(CommonText.get_ToAa(columnName)));
            sbf.append(",SIGNED)");
        }else if("bigint".equals(dataType.toLowerCase())){
            sbf.append("CAST(");
            sbf.append(get(CommonText.get_ToAa(columnName)));
            sbf.append(" AS Decimal(26,3))");
        }else{
            sbf.append(get(CommonText.get_ToAa(columnName)));
        }
        return sbf.toString();
    }

    static   String getColumnTypeToStr(String columnName,String dataType){

        StringBuffer sbf=new StringBuffer();
        if(dataType.toLowerCase().equals("date")){
            sbf.append("DATE_FORMAT(");
            sbf.append(columnName);
            sbf.append(",'%Y-%m-%d %H:%i:%s')");
        }else if("int".equals(dataType.toLowerCase())){
            sbf.append("CAST(");
            sbf.append(columnName);
            sbf.append(",char)");
        }else if("bigint".equals(dataType.toLowerCase())){
            sbf.append("CAST(");
            sbf.append(columnName);
            sbf.append(" AS char");
        }else{
            sbf.append(columnName);
        }
        return RT+sbf.toString();
    }

    public static void main(String[] args) {
        String dl="do_op";

        System.out.println(CommonText.get_ToAa(dl));
    }
}
