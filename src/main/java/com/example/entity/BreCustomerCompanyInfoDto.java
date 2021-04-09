package com.example.entity;

public class BreCustomerCompanyInfoDto {

    private  Integer  numberId;

    public Integer getNumberId() {
        return numberId;
    }

    public void setNumberId(Integer numberId) {
        this.numberId = numberId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getChineseAbbreviation() {
        return chineseAbbreviation;
    }

    public void setChineseAbbreviation(String chineseAbbreviation) {
        this.chineseAbbreviation = chineseAbbreviation;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEnglishAbbreviation() {
        return englishAbbreviation;
    }

    public void setEnglishAbbreviation(String englishAbbreviation) {
        this.englishAbbreviation = englishAbbreviation;
    }

    public String getCountriesAndRegions() {
        return countriesAndRegions;
    }

    public void setCountriesAndRegions(String countriesAndRegions) {
        this.countriesAndRegions = countriesAndRegions;
    }

    public String getDomesticAndForeign() {
        return domesticAndForeign;
    }

    public void setDomesticAndForeign(String domesticAndForeign) {
        this.domesticAndForeign = domesticAndForeign;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getContractBillingRequirements() {
        return contractBillingRequirements;
    }

    public void setContractBillingRequirements(String contractBillingRequirements) {
        this.contractBillingRequirements = contractBillingRequirements;
    }

    public String getBillingPrinciple() {
        return billingPrinciple;
    }

    public void setBillingPrinciple(String billingPrinciple) {
        this.billingPrinciple = billingPrinciple;
    }

    public String getFaultToleranceOfBilling() {
        return faultToleranceOfBilling;
    }

    public void setFaultToleranceOfBilling(String faultToleranceOfBilling) {
        this.faultToleranceOfBilling = faultToleranceOfBilling;
    }

    public String getSettlementPrinciple() {
        return settlementPrinciple;
    }

    public void setSettlementPrinciple(String settlementPrinciple) {
        this.settlementPrinciple = settlementPrinciple;
    }

    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private  String  chineseName;
    private  String  chineseAbbreviation;
    private  String  englishName;
    private  String  englishAbbreviation;
    private  String  countriesAndRegions;
    private  String  domesticAndForeign;
    private  String  organizationType;
    private  String  contractBillingRequirements;
    private  String  billingPrinciple;
    private  String  faultToleranceOfBilling;
    private  String  settlementPrinciple;
    private  String  settlementCurrency;
    private  String  id;
    private String emailSuffix;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailSuffix() {
        return emailSuffix;
    }

    public void setEmailSuffix(String emailSuffix) {
        this.emailSuffix = emailSuffix;
    }
}
