package com.example.entity;

public class BreFieldExportInfoDto extends pageInfoDto {
    private  String  fieldId;
    private  Integer  fieldPosition;
    private   String  workId;
    private  String  fieldDesc;
    private  String exportOff;
    private String workDesc;
    private  String  id;


    public String getExportOff() {
        return exportOff;
    }

    public void setExportOff(String exportOff) {
        this.exportOff = exportOff;
    }


    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }



    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(Integer fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
