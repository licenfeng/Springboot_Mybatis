package com.example.entity;

public class UserAndRoleAndOperationDto {

    private Integer roleId;
    private String operId;
    private String userName;
    private String operLink;

    public String getOperLink() {
        return operLink;
    }

    public void setOperLink(String operLink) {
        this.operLink = operLink;
    }

    public String getOperDesc() {
        return operDesc;
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc;
    }

    private String operDesc;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
