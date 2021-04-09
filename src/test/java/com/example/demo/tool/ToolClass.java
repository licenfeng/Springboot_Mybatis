package com.example.demo.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ToolClass {

    public  static void addBatisIf(){

        String[] strList={
                "number_id",
                "chinese_name",
                "chinese_abbreviation",
                "english_name",
                "english_abbreviation",
                "countries_and_regions",
                "domestic_and_foreign",
                "organization_type",
                "contract_billing_requirements",
                "billing_principle",
                "fault_tolerance_of_billing",
                "settlement_principle",
                "settlement_currency",
                "id"
        };
        StringBuffer sbf=new StringBuffer();
        for (int j=0;j<strList.length;j++){

            String str=strList[j];
            String [] strs=str.split("_");
            String end="";
            for(int i=0;i<strs.length;i++){
                String st=strs[i];

                if(i>0){
                    String ends= st.substring(0,1).toUpperCase()+ st.substring(1,st.length()).toLowerCase();
                    end=end+ends;
                }else {
                    end=end+strs[i].toLowerCase();
                }
            }

            String start=" <if test=\""+end+"!=null\">";
            sbf.append(start+"\n");
            String startTow="  and  "+str+"=#{"+end+"}";
            sbf.append(startTow+"\n");
            String startEnd="</if>";
            sbf.append(startEnd+"\n");
        }
        System.out.println(sbf.toString());

    }

    public static void addMyBatisResultMap(){
        String typeList[]={
                "varchar",
                "int",
                "varchar",
                "int",
                "varchar",
                "int",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "int",
                "varchar",
                "varchar",
                "varchar",
                "date",
                "date",
                "date",
                "varchar",
                "varchar",
                "int",
                "varchar",
                "int",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar"};



        String[] strList={
                "id",
                "treaty_type_key",
                "treaty_type",
                "bre_dept_key",
                "bre_dept",
                "type_of_business_key",
                "type_of_business",
                "bre_slip_number",
                "bre_bound_no",
                "ceding_company_key",
                "ceding_company",
                "country_of_ceding_company",
                "producing_broker_key",
                "producing_broker",
                "country_of_producing_broker",
                "treaty_name",
                "inception_date",
                "expiry_date",
                "underwriting_year",
                "currency_key",
                "currency",
                "leading_reinsurer_key",
                "leading_reinsurer",
                "business_status_key",
                "business_status",
                "tax_percent",
                "tax_surcharge_percent",
                "remarks1",
                "remarks2",
                "remarks3" }                    ;

        for (int j=0;j<strList.length;j++){
            String types=typeList[j];
            String str=strList[j];
            String [] strs=str.split("_");
            String end="";
            for(int i=0;i<strs.length;i++){
                String st=strs[i];

                if(i>0){
                    String ends= st.substring(0,1).toUpperCase()+ st.substring(1,st.length()).toLowerCase();
                    end=end+ends;
                }else {
                    end=end+strs[i].toLowerCase();
                }
            }

            if(types.toLowerCase().equals("int")){
                types="INTEGER";
            }
            System.out.println(" <result column=\""+end+"\" jdbcType=\""+types.toUpperCase()+"\" property=\""+strList[j]+"\" />");
        }
    }


    public  static void   addJavaGetSet(){
        String[] strList={
                "type",
                "type_desc",
                "key_type",
                "value_type",
                "key_desc",
                "key_off",
                "id"
        };

        String typeList[]={
                "int",
                "String",
                "int",
                "String",
                "String",
                "String",
                "int"
        };

        for(int j=0;j<strList.length;j++){

            String types=typeList[j];

            String str=strList[j];
            String [] strs=str.split("_");
            String end="";
            for(int i=0;i<strs.length;i++){
                String st=strs[i];

                if(i>0){
                    String ends= st.substring(0,1).toUpperCase()+ st.substring(1,st.length()).toLowerCase();
                    end=end+ends;
                }else {
                    end=end+strs[i].toLowerCase();
                }


            }

            if(types.equals("int")){
                System.out.println("private  Integer  "+end+";");
            }else if(types.equals("varchar")||types.equals("string")){
                System.out.println("private  String  "+end+";");
            }else if(types.equals("date")){
                System.out.println("private   Date  "+end+";");
            }else{
                System.out.println("private   "+types+"  "+end+";");
            }
        }

    }


    public static void createTable(){

        String  tableName="bre_country_region_info";

        String[] fidE ={
                "number",
                "English_abbreviation",
                "Chinese_abbreviation",
                "English_name",
                "tow_code",
                "three_code",
                "number_code",
                "country_desc",
                "id"
        };


        String[] fidDesc={
                "序号",
                "英文简称",
                "中文简称",
                "英文全称",
                "两字母代码",
                "三字母代码",
                "数字代码",
                "备注",
                "主健"
                };


        String[] fidType={
                "string",
                "string",
                "string",
                "string",
                "string",
                "string",
                "string",
                "string",
                "string"
        };

        String[] fidLength={
                "100",
                "100",
                "500",
                "1000",
                "2",
                "3",
                "4",
                "600",
                "200"
        };


        StringBuffer sbf=new StringBuffer();
        sbf.append("create table "+tableName +"(\n");
        for(int i=0;i<fidE.length;i++){

            if(fidType[i].trim().equals("String")||fidType[i].trim().equals("string")){
                fidType[i]="varchar";
            }
            sbf.append(fidE[i].toLowerCase()+" "+fidType[i]);
            if(!fidType[i].trim().equals("date")){
                sbf.append("("+fidLength[i]+")");
            }
            sbf.append(" COMMENT "+"'"+fidDesc[i]+"'");
            if(i<fidE.length-1){
                sbf.append(",");
            }
            sbf.append("\n");
        }
        sbf.append(");");
        getText(sbf.toString());
    }
    static  void getText(String text){
        try {

            File file=new File("C:\\Users\\Lenovo\\Desktop\\sql.txt");
            if(!file.exists()){
                file.createNewFile();
            }

            FileOutputStream of=new FileOutputStream(file);
            of.write(text.getBytes());
            of.flush();
            of.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addMySqlAs(){
        String[] strList={
                "number_id",
                "chinese_name",
                "chinese_abbreviation",
                "english_name",
                "english_abbreviation",
                "countries_and_regions",
                "domestic_and_foreign",
                "organization_type",
                "contract_billing_requirements",
                "billing_principle",
                "fault_tolerance_of_billing",
                "settlement_principle",
                "settlement_currency",
                "id"
        };

        StringBuffer sbf=new StringBuffer();
        for(int j=0;j<strList.length;j++) {

            String str = strList[j];
            String[] strs = str.split("_");
            String end = "";
            for (int i = 0; i < strs.length; i++) {
                String st = strs[i];

                if (i > 0) {
                    String ends = st.substring(0, 1).toUpperCase() + st.substring(1, st.length()).toLowerCase();
                    end = end + ends;
                } else {
                    end = end + strs[i].toLowerCase();
                }


            }
           // sbf.append(" as \"" + end + "\"");
            sbf.append(str + " as \"" + end + "\"");
            if(j<strList.length-1){
                sbf.append(",");
            }
            sbf.append("\n");
        }
        System.out.println(sbf);
    }

    public  static  void addTowMerge(){
        String[] a={
                "basis.bre_slip_number",
                "basis.treaty_type_key",
                "basis.treaty_type",
                "basis.bre_dept_key",
                "basis.bre_dept",
                "basis.type_of_business_key",
                "basis.type_of_business",
                "basis.bre_bound_no",
                "basis.ceding_company_key",
                "basis.ceding_company",
                "basis.country_of_ceding_company",
                "basis.producing_broker_key",
                "basis.producing_broker",
                "basis.country_of_producing_broker",
                "basis.treaty_name",
                "basis.inception_date",
                "basis.expiry_date",
                "basis.underwriting_year",
                "basis.currency_key",
                "basis.currency",
                "basis.leading_reinsurer_key",
                "basis.leading_reinsurer",
                "basis.business_status_key",
                "basis.business_status",
                "basis.tax_percent",
                "basis.tax_surcharge_percent",
                "basis.remarks1",
                "basis.remarks2",
                "basis.remarks3",
                "nonProp.id",
                "nonProp.bre_slip_number",
                "nonProp.layer",
                "nonProp.gnpi",
                "nonProp.adjustable_rate",
                "nonProp.deposit_premium",
                "nonProp.dp_percent",
                "nonProp.minimum_premium",
                "nonProp.mp_percent",
                "nonProp.rate_on_line",
                "nonProp.reinstatement",
                "nonProp.coverage",
                "reinsurer.id",
                "reinsurer.bre_slip_number",
                "reinsurer.prop_id",
                "reinsurer.reinsurer",
                "reinsurer.country_of_reinsurer",
                "reinsurer.settlement_currency",
                "reinsurer.placement_broker",
                "reinsurer.country_of_placement_broker",
                "reinsurer.bre_brokerage",
                "reinsurer.bre_brokerage_percent",
                "reinsurer.other_fee_or_charge",
                "reinsurer.including_excluding_brokerage_vat",
                "reinsurer.written_line",
                "reinsurer.signed_line",
                "reinsurer.status_reinsurer",
                "reinsurer.signing_date",
                "reinsurer.condition_reinsurer",
                "reinsurer.remarks",
                "arrange.id",
                "arrange.bre_slip_number",
                "arrange.prop_id",
                "arrange.reinsurer_id",
                "arrange.layer",
                "arrange.gnpi",
                "arrange.adjustable_rate",
                "arrange.deposit_premium",
                "arrange.dp_percent",
                "arrange.minimum_premium",
                "arrange.mp_percent",
                "arrange.rate_on_line",
                "arrange.reinstatement",
                "arrange.coverage"
        };
        String[] b={
                " as \"breSlipNumber\",",
                " as \"treatyTypeKey\",",
                " as \"treatyType\",",
                " as \"breDeptKey\",",
                " as \"breDept\",",
                " as \"typeOfBusinessKey\",",
                " as \"typeOfBusiness\",",
                " as \"breBoundNo\",",
                " as \"cedingCompanyKey\",",
                " as \"cedingCompany\",",
                " as \"countryOfCedingCompany\",",
                " as \"producingBrokerKey\",",
                " as \"producingBroker\",",
                " as \"countryOfProducingBroker\",",
                " as \"treatyName\",",
                " as \"inception\",",
                " as \"expiry\",",
                " as \"underwritingYear\",",
                " as \"currencyKey\",",
                " as \"currency\",",
                " as \"leadingReinsurerKey\",",
                " as \"leadingReinsurer\",",
                " as \"businessStatusKey\",",
                " as \"businessStatus\",",
                " as \"taxPercent\",",
                " as \"taxSurchargePercent\",",
                " as \"remarks1\",",
                " as \"remarks2\",",
                " as \"remarks3\",",
                " as \"nonPropId\",",
                " as \"nonPropBreSlipNumber\",",
                " as \"nonPropLayer\",",
                " as \"nonPropGnpi\",",
                " as \"nonPropAdjustableRate\",",
                " as \"nonPropDepositPremium\",",
                " as \"nonPropDpPercent\",",
                " as \"nonPropMinimumPremium\",",
                " as \"nonPropMpPercent\",",
                " as \"nonPropRateOnLine\",",
                " as \"nonPropReinstatement\",",
                " as \"nonPropCoverage\",",
                " as \"reinsurerId\",",
                " as \"reinsurerBreSlipNumber\",",
                " as \"reinsurerPropId\",",
                " as \"reinsurer\",",
                " as \"countryOfReinsurer\",",
                " as \"settlementCurrency\",",
                " as \"placementBroker\",",
                " as \"countryOfPlacementBroker\",",
                " as \"breBrokerage\",",
                " as \"breBrokeragePercent\",",
                " as \"otherFeeOrCharge\",",
                " as \"includingExcludingBrokerageVat\",",
                " as \"writtenLine\",",
                " as \"signedLine\",",
                " as \"statusReinsurer\",",
                " as \"signing\",",
                " as \"conditionReinsurer\",",
                " as \"reinsurerRemarks\",",
                " as \"arrangeId\",",
                " as \"arrangeBreSlipNumber\",",
                " as \"arrangePropId\",",
                " as \"arrangeReinsurerId\",",
                " as \"arrangeLayer\",",
                " as \"arrangeGnpi\",",
                " as \"arrangeAdjustableRate\",",
                " as \"arrangeDepositPremium\",",
                " as \"arrangeDpPercentDpPercent\",",
                " as \"arrangeMinimumPremium\",",
                " as \"arrangeMpPercent\",",
                " as \"arrangeRateOnLine\",",
                " as \"arrangeReinstatement\",",
                " as \"arrangeCoverage\""
        };
        for(int j=0;j<a.length;j++){
            System.out.println(a[j]+" "+b[j]);

        }
    }

    public  static void addInsertSql(){

        String tableName="bre_treaty_non_prop_info";

        String[] strList={
                "id",
                "bre_slip_number",
                "layer",
                "gnpi",
                "adjustable_rate",
                "deposit_premium",
                "dp_percent",
                "minimum_premium",
                "mp_percent",
                "rate_on_line",
                "reinstatement",
                "coverage"
        };

        String [] types={
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "decimal",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "varchar",
                "date",
                "varchar",
                "varchar"
        };

            StringBuffer sbf=new StringBuffer();
            sbf.append("insert into "+tableName+"(\n");
            String strValue=" )values(";

            StringBuffer sbfKey=new StringBuffer();

            StringBuffer sbfValue=new StringBuffer();

            for (int j=0;j<strList.length;j++) {
                String str = strList[j];
                String[] strs = str.split("_");
                String end = "";
                for (int i = 0; i < strs.length; i++) {
                    String st = strs[i];
                    if (i > 0) {
                        String ends = st.substring(0, 1).toUpperCase() + st.substring(1, st.length()).toLowerCase();
                        end = end + ends;
                    } else {
                        end = end + strs[i].toLowerCase();
                    }
                }
                String  strToDate="";
                String strToDateEnd="";
                if(types[j].toLowerCase().equals("date")){
                    strToDate="str_to_date(";
                    strToDateEnd=",'%Y-%m-%d %H:%i:%s')";
                }

                String start=" <if test=\""+end+"!=null\">";
                sbfKey.append(start+"\n");
                String startTow=str+",";
                sbfKey.append(startTow+"\n");
                String startEnd="</if>";
                sbfKey.append(startEnd+"\n");


                String startValue=" <if test=\""+end+"!=null\">";
                sbfValue.append(startValue+"\n");
                String startValueTow=strToDate+"#{"+end+"}"+strToDateEnd+",";
                sbfValue.append(startValueTow+"\n");
                String startValueEnd="</if>";
                sbfValue.append(startValueEnd+"\n");

            }
            sbf.append(sbfKey);
            sbf.append(strValue) ;
            sbf.append(sbfValue) ;
            sbf.append(")");

            System.out.println(sbf.toString());
        }


    public  static void addUpdateSql(){

        String tableName="bre_treaty_prop_info";

        String[] strList={
                "id",
                "bre_slip_number",
                "section",
                "gross_retention",
                "cession_for_quota_share",
                "line_surplus",
                "commission_for_quota_share",
                "commission_for_surplus",
                "fixed_or_provisional_commission",
                "epi_for_quota_share",
                "epi_for_surplus",
                "event_limit",
                "expiry_date_of_extension",
                "underwriting_period"
        };
        StringBuffer sbf=new StringBuffer();
        sbf.append("update  "+tableName+" set \n");
        String strValue=" where 1=1 ";

        StringBuffer sbfKey=new StringBuffer();

        StringBuffer sbfValue=new StringBuffer();

        for (int j=0;j<strList.length;j++) {
            String str = strList[j];
            String[] strs = str.split("_");
            String end = "";
            for (int i = 0; i < strs.length; i++) {
                String st = strs[i];
                if (i > 0) {
                    String ends = st.substring(0, 1).toUpperCase() + st.substring(1, st.length()).toLowerCase();
                    end = end + ends;
                } else {
                    end = end + strs[i].toLowerCase();
                }
            }

            String start=" <if test=\""+end+"!=null\">";
            sbfKey.append(start+"\n");
            String startTow="  "+str+"=#{"+end+"} ,";
            sbfKey.append(startTow+"\n");
            String startEnd="</if>";
            sbfKey.append(startEnd+"\n");


            String startValue=" <if test=\""+end+"!=null\">";
            sbfValue.append(startValue+"\n");
            String startValueTow="  and  "+str+"=#{"+end+"}";
            sbfValue.append(startValueTow+"\n");
            String startValueEnd="</if>";
            sbfValue.append(startValueEnd+"\n");


        }
        sbf.append(sbfKey);
        sbf.append(strValue) ;
        sbf.append(sbfValue) ;
        System.out.println(sbf.toString());
    }

    public  static void addSelectSql(){

        String tableName="bre_treaty_prop_info";

        String briName="i.";


        String[] strList={
                "id",
                "bre_slip_number",
                "section",
                "gross_retention",
                "cession_for_quota_share",
                "line_surplus",
                "commission_for_quota_share",
                "commission_for_surplus",
                "fixed_or_provisional_commission",
                "epi_for_quota_share",
                "epi_for_surplus",
                "event_limit",
                "expiry_date_of_extension",
                "underwriting_period"
        };



        StringBuffer sbf=new StringBuffer();
        sbf.append("select ");
        String strValue=" from  "+ tableName+" where 1=1 ";

        StringBuffer sbfKey=new StringBuffer();

        StringBuffer sbfValue=new StringBuffer();

        for (int j=0;j<strList.length;j++) {
            String str = strList[j];
            String[] strs = str.split("_");
            String end = "";
            for (int i = 0; i < strs.length; i++) {
                String st = strs[i];
                if (i > 0) {
                    String ends = st.substring(0, 1).toUpperCase() + st.substring(1, st.length()).toLowerCase();
                    end = end + ends;
                } else {
                    end = end + strs[i].toLowerCase();
                }
            }

            sbfKey.append(str + " as \"" + end + "\", \n");

            String startValue="\n <if test=\""+end+" != '' and "+end+"!= null\">";
            sbfValue.append(startValue+"\n");
            String startValueTow="  and  "+briName+str+"=#{"+end+"}";
            sbfValue.append(startValueTow+"\n");
            String startValueEnd="</if>";
            sbfValue.append(startValueEnd+"\n");


        }
        sbf.append(sbfKey);
        sbf.append(strValue) ;
        sbf.append(sbfValue) ;

        System.out.println(sbf.toString());

    }

}
