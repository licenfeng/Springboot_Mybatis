package com.example.demo;


import java.text.DecimalFormat;

public class Customer {
    private static int totalCount = 0;
    private int customerID;
    public Customer(){
        ++totalCount;
        customerID = totalCount;
        System.out.println("增加一个");
    }
    public String getCustomerID() {
        DecimalFormat decimalFormat = new DecimalFormat("");
        return decimalFormat.format(customerID);
    }


}
