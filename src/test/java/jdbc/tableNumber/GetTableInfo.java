package jdbc.tableNumber;

import jdbc.ent.TableInfo;
import jdbc.name.NameClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetTableInfo {
    public GetTableInfo(){
        getList();
    }

    static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";//for mysql 8.0
    static final String DB_URL="jdbc:mysql://localhost:3306/bres?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
    static final String USER="root";
    static final String PWD="6225110";
    static final String SQL=" select   t.COLUMN_NAME,t.COLUMN_COMMENT,t.table_name,t.DATA_TYPE,t.COLUMN_COMMENT from information_schema.COLUMNS t ";

    static  String sqlWhere="where table_name ='"+ NameClass.tableName +"'";


    public static List<TableInfo> getList(){
        List<TableInfo> list=new ArrayList();
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(DB_DRIVER);
         //   showmsg("加载驱动完毕.");
        } catch (Exception e) {
            // TODO: handle exception
            showmsg(e.getMessage());
            return null;
        }
        try {
            conn= DriverManager.getConnection(DB_URL, USER, PWD);
            stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery(SQL+sqlWhere);
            while(rs.next())
            {
                TableInfo tableInfo=new TableInfo();
                String tableName=rs.getString("TABLE_NAME");
                String columnName=rs.getString("COLUMN_NAME");
                String columnComment=rs.getString("COLUMN_COMMENT");
                String dataType=rs.getString("DATA_TYPE");
                tableInfo.setColumnComment(columnComment);
                tableInfo.setTableName(tableName);
                tableInfo.setColumnName(columnName);
                tableInfo.setDataType(dataType);
                list.add(tableInfo);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            showmsg(e.getMessage());
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    //    showmsg("goodby");

    }

    private static void showmsg(String s)
    {
        System.out.println(s);
    }
}
