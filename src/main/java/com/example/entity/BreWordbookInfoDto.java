package com.example.entity;

public class BreWordbookInfoDto extends pageInfoDto {

    private  String  type;
    private   String  typeDesc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getKeyDesc() {
        return keyDesc;
    }

    public void setKeyDesc(String keyDesc) {
        this.keyDesc = keyDesc;
    }

    public String getKeyOff() {
        return keyOff;
    }

    public void setKeyOff(String keyOff) {
        this.keyOff = keyOff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private  String  keyType;
    private   String  valueType;
    private   String  keyDesc;
    private   String  keyOff;
    private  Integer  id;
}
