package jdbc.mian;

import jdbc.common.CommonText;
import jdbc.createFile.*;
import jdbc.createSql.CreateSqlText;
import jdbc.ent.TableInfo;
import jdbc.name.NameClass;
import jdbc.tableNumber.GetTableInfo;

import java.util.List;

public class run {
    public static void main(String[] args) {
        try {
//            CreateJavaController.createJavaServiceFile();
//            CreateJavaServiceFile.createJavaServiceFile();
//            CreateJavaMapperFile.createJavaMapperFile();;
//            CreateDtoFile.createDtoFile();
//            CreateMapperXmlFile.createMapperXmlFile();
//            CreateMapperXmlFile.createMapperXmlFile();

            List<TableInfo> list= GetTableInfo.getList();


            String str=CreateSqlText.getSelectSql(list);
            System.out.println(CreateMapperXmlFile.strSelectSql(str));
         //   System.out.println(CommonText.getSpotToSlash(NameClass.controllerJavaUrl));


         //   List<TableInfo> list=GetTableInfo.getList();

       //     System.out.println( CreateMapperXmlFile.strInsertSql( CreateSqlText.getInsertSql(list)));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
