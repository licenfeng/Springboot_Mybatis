package jdbc.common;

public class CommonText {

    public static String aaToAa(String str){
        String strEnd=get_ToAa(str);
        return strEnd.substring(0,1).toUpperCase()+ strEnd.substring(1,strEnd.length());
    }
    public static String getAToa(String strEnd){
        return strEnd.substring(0,1).toLowerCase()+ strEnd.substring(1,strEnd.length());
    }


    public static String get_ToAa(String str){

        if(str.indexOf("_")<0){
            return str;
        }
        String[] strList = str.split("_");
        String end = "";
        for (int i = 0; i < strList.length; i++) {
            String st = strList[i];
            if (i > 0) {
                String ends = st.substring(0, 1).toUpperCase() + st.substring(1).toLowerCase();
                end = end + ends;
            } else {
                end = end + strList[i].toLowerCase();
            }
        }
        return end;
    }



    public static  String getSlashToSpot(String url){
        String urlNew=url.replaceAll("\\\\","\\.").replaceAll("/","\\.");
        return urlNew;
    }

    public static String getSpotToSlash(String url){
        String urlNew=url.replaceAll("\\.","\\\\");
        return urlNew;
    }

    public static String getTextAddMarks(String text){

        return "\""+text+"\"";
    }

}
