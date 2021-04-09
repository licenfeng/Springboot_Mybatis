package com.example.entity;

public class pageInfoDto {

    //Y 表示分页，N表示不分页
    private String isPaging;

    //当前页
    private int  pageNo=0;

    public String getIsPaging() {
        return isPaging;
    }

    public void setIsPaging(String isPaging) {
        this.isPaging = isPaging;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    //每页多少
    private int  pageSize=10;

    //总页数
    private int pageCount=0;

    //总条目数
    private int total=0;

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = this.pageNo*this.pageSize;
    }

    private int startValue;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
