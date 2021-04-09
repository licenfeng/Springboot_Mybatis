package jdbc.common;

import jdbc.name.NameClass;

import java.io.File;
import java.io.FileOutputStream;

public class CreateFileCommon extends NameClass {
    private static File getFile(String url){
        File file=new File(url);
        try {
            //获取父目录
            File fileParent = file.getParentFile();
            //判断是否存在
            if (!fileParent.exists()) {
                //创建父目录文件
                fileParent.mkdirs();
            }
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
        return file;
    }

    public static void getFile(String url,String text){
         try{
             File file=getFile(url);
             FileOutputStream fileOutputStream=new FileOutputStream(file);
             fileOutputStream.write(text.getBytes());
             fileOutputStream.flush();
             fileOutputStream.close();
         }catch (Exception e){
             e.printStackTrace();
         }


    }
}
