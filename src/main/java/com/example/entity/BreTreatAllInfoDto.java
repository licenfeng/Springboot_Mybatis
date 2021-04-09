package com.example.entity;

public class BreTreatAllInfoDto extends pageInfoDto {

    public String arrangeSectionAll;

    public String getArrangeCommissionForSurplus() {
        return arrangeCommissionForSurplus;
    }

    public void setArrangeCommissionForSurplus(String arrangeCommissionForSurplus) {
        this.arrangeCommissionForSurplus = arrangeCommissionForSurplus;
    }

    private String arrangeCommissionForSurplus;

    public String getArrangeCommissionForQuotaShare() {
        return arrangeCommissionForQuotaShare;
    }

    public void setArrangeCommissionForQuotaShare(String arrangeCommissionForQuotaShare) {
        this.arrangeCommissionForQuotaShare = arrangeCommissionForQuotaShare;
    }

    public String arrangeCommissionForQuotaShare;

    public String getNonPropLimitNumber() {
        return nonPropLimitNumber;
    }

    public void setNonPropLimitNumber(String nonPropLimitNumber) {
        this.nonPropLimitNumber = nonPropLimitNumber;
    }

    public String getNonPropLimitPercentage() {
        return nonPropLimitPercentage;
    }

    public void setNonPropLimitPercentage(String nonPropLimitPercentage) {
        this.nonPropLimitPercentage = nonPropLimitPercentage;
    }

    public String getNonPropLimit() {
        return nonPropLimit;
    }

    public void setNonPropLimit(String nonPropLimit) {
        this.nonPropLimit = nonPropLimit;
    }

    public String getArrangeSection() {
        return arrangeSection;
    }

    public void setArrangeSection(String arrangeSection) {
        this.arrangeSection = arrangeSection;
    }

    private String arrangeSection;

    public String getArrangeLineOfBusiness() {
        return arrangeLineOfBusiness;
    }

    public void setArrangeLineOfBusiness(String arrangeLineOfBusiness) {
        this.arrangeLineOfBusiness = arrangeLineOfBusiness;
    }

    private String arrangeLineOfBusiness;

    public String getArrangeSectionAll() {
        return arrangeSectionAll;
    }

    public void setArrangeSectionAll(String arrangeSectionAll) {
        this.arrangeSectionAll = arrangeSectionAll;
    }

    public String getIsNonProp() {
        return isNonProp;
    }

    public void setIsNonProp(String isNonProp) {
        this.isNonProp = isNonProp;
    }

    //Y 表示非比例合约的信息 ，其他的表示比例合约的信息
    private String isNonProp;
    private String breSlipNumber;
    private Integer treatyTypeKey;
    private String treatyType;
    private Integer breDeptKey;
    private String breDept;
    private Integer typeOfBusinessKey;
    private String typeOfBusiness;
    private String breBoundNo;
    private String cedingCompanyKey;
    private String cedingCompany;
    private String countryOfCedingCompany;
    private Integer producingBrokerKey;
    private String producingBroker;
    private String countryOfProducingBroker;
    private String treatyName;
    private String inceptionDate;
    private String expiryDate;
    private String underwritingYear;
    private String currencyKey;
    private String currency;
    private Integer leadingReinsurerKey;
    private String leadingReinsurer;
    private Integer businessStatusKey;
    private String businessStatus;
    private String taxPercent;
    private String taxSurchargePercent;
    private String remarks1;
    private String remarks2;
    private String remarks3;
    private String propId;
    private String propBreSlipNumber;
    private String sectionName;
    private String grossRetention;
    private String cessionForQuotaShare;
    private Integer lineSurplus;
    private String commissionForQuotaShare;
    private String commissionForSurplus;
    private String fixedOrProvisionalCommission;
    private String epiForQuotaShare;
    private String epiForSurplus;
    private String eventLimit;
    private String expiryDateOfExtension;
    private String underwritingPeriod;
    private String nonPropId;
    private String nonPropBreSlipNumber;
    private String nonPropLayer;
    private String nonPropGnpi;
    private String nonPropAdjustableRate;
    private String nonPropDepositPremium;
    private String nonPropDpPercent;
    private String nonPropMinimumPremium;
    private String nonPropMpPercent;
    private String nonPropRateOnLine;
    private String nonPropReinstatement;
    private String nonPropCoverage;
    private String nonPropLimitNumber;
    private String nonPropLimitPercentage;
    private String nonPropLimit;
    private String reinsurerId;
    private String reinsurerBreSlipNumber;
    private String reinsurerPropId;
    private String reinsurer;
    private String countryOfReinsurer;
    private String settlementCurrency;
    private String placementBroker;
    private String countryOfPlacementBroker;
    private String breBrokerage;
    private String breBrokeragePercent;
    private String otherFeeOrCharge;
    private String includingExcludingBrokerageVat;
    private String writtenLine;
    private String signedLine;
    private String statusReinsurer;
    private String signingDate;
    private String conditionReinsurer;
    private String reinsurerRemarks;
    private String arrangeId;
    private String arrangeBreSlipNumber;
    private String arrangePropId;
    private String arrangeReinsurerId;
    private String arrangeLayer;
    private String arrangeGnpi;
    private String arrangeAdjustableRate;
    private String arrangeDepositPremium;
    private String arrangeDpPercentDpPercent;
    private String arrangeMinimumPremium;
    private String arrangeMpPercent;

    private String arrangeLimitNumber;
    private String arrangeLimitPercentage;

    private String breCreate;
    private String breUpdate;
    private String breApproval;
    private String breQuoSum;
    private String breSplSum;
    private String valueType;

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getBreCreate() {
        return breCreate;
    }

    public void setBreCreate(String breCreate) {
        this.breCreate = breCreate;
    }

    public String getBreUpdate() {
        return breUpdate;
    }

    public void setBreUpdate(String breUpdate) {
        this.breUpdate = breUpdate;
    }

    public String getBreApproval() {
        return breApproval;
    }

    public void setBreApproval(String breApproval) {
        this.breApproval = breApproval;
    }

    public String getBreQuoSum() {
        return breQuoSum;
    }

    public void setBreQuoSum(String breQuoSum) {
        this.breQuoSum = breQuoSum;
    }

    public String getBreSplSum() {
        return breSplSum;
    }

    public void setBreSplSum(String breSplSum) {
        this.breSplSum = breSplSum;
    }

    public String getArrangeLimitNumber() {
        return arrangeLimitNumber;
    }

    public void setArrangeLimitNumber(String arrangeLimitNumber) {
        this.arrangeLimitNumber = arrangeLimitNumber;
    }

    public String getArrangeLimitPercentage() {
        return arrangeLimitPercentage;
    }

    public void setArrangeLimitPercentage(String arrangeLimitPercentage) {
        this.arrangeLimitPercentage = arrangeLimitPercentage;
    }

    public String getArrangeLimit() {
        return arrangeLimit;
    }

    public void setArrangeLimit(String arrangeLimit) {
        this.arrangeLimit = arrangeLimit;
    }

    private String arrangeLimit;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String remarks;

    public String getOriginalCedant() {
        return originalCedant;
    }

    public void setOriginalCedant(String originalCedant) {
        this.originalCedant = originalCedant;
    }

    public String getCountryOfOriginalCedant() {
        return countryOfOriginalCedant;
    }

    public void setCountryOfOriginalCedant(String countryOfOriginalCedant) {
        this.countryOfOriginalCedant = countryOfOriginalCedant;
    }

    private String originalCedant;
    private String countryOfOriginalCedant;

    public String getBreSlipNumber() {
        return breSlipNumber;
    }

    public void setBreSlipNumber(String breSlipNumber) {
        this.breSlipNumber = breSlipNumber;
    }

    public Integer getTreatyTypeKey() {
        return treatyTypeKey;
    }

    public void setTreatyTypeKey(Integer treatyTypeKey) {
        this.treatyTypeKey = treatyTypeKey;
    }

    public String getTreatyType() {
        return treatyType;
    }

    public void setTreatyType(String treatyType) {
        this.treatyType = treatyType;
    }

    public Integer getBreDeptKey() {
        return breDeptKey;
    }

    public void setBreDeptKey(Integer breDeptKey) {
        this.breDeptKey = breDeptKey;
    }

    public String getBreDept() {
        return breDept;
    }

    public void setBreDept(String breDept) {
        this.breDept = breDept;
    }

    public Integer getTypeOfBusinessKey() {
        return typeOfBusinessKey;
    }

    public void setTypeOfBusinessKey(Integer typeOfBusinessKey) {
        this.typeOfBusinessKey = typeOfBusinessKey;
    }

    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public String getBreBoundNo() {
        return breBoundNo;
    }

    public void setBreBoundNo(String breBoundNo) {
        this.breBoundNo = breBoundNo;
    }

    public String getCedingCompanyKey() {
        return cedingCompanyKey;
    }

    public void setCedingCompanyKey(String cedingCompanyKey) {
        this.cedingCompanyKey = cedingCompanyKey;
    }

    public String getCedingCompany() {
        return cedingCompany;
    }

    public void setCedingCompany(String cedingCompany) {
        this.cedingCompany = cedingCompany;
    }

    public String getCountryOfCedingCompany() {
        return countryOfCedingCompany;
    }

    public void setCountryOfCedingCompany(String countryOfCedingCompany) {
        this.countryOfCedingCompany = countryOfCedingCompany;
    }

    public Integer getProducingBrokerKey() {
        return producingBrokerKey;
    }

    public void setProducingBrokerKey(Integer producingBrokerKey) {
        this.producingBrokerKey = producingBrokerKey;
    }

    public String getProducingBroker() {
        return producingBroker;
    }

    public void setProducingBroker(String producingBroker) {
        this.producingBroker = producingBroker;
    }

    public String getCountryOfProducingBroker() {
        return countryOfProducingBroker;
    }

    public void setCountryOfProducingBroker(String countryOfProducingBroker) {
        this.countryOfProducingBroker = countryOfProducingBroker;
    }

    public String getTreatyName() {
        return treatyName;
    }

    public void setTreatyName(String treatyName) {
        this.treatyName = treatyName;
    }

    public String getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getUnderwritingYear() {
        return underwritingYear;
    }

    public void setUnderwritingYear(String underwritingYear) {
        this.underwritingYear = underwritingYear;
    }

    public String getCurrencyKey() {
        return currencyKey;
    }

    public void setCurrencyKey(String currencyKey) {
        this.currencyKey = currencyKey;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getLeadingReinsurerKey() {
        return leadingReinsurerKey;
    }

    public void setLeadingReinsurerKey(Integer leadingReinsurerKey) {
        this.leadingReinsurerKey = leadingReinsurerKey;
    }

    public String getLeadingReinsurer() {
        return leadingReinsurer;
    }

    public void setLeadingReinsurer(String leadingReinsurer) {
        this.leadingReinsurer = leadingReinsurer;
    }

    public Integer getBusinessStatusKey() {
        return businessStatusKey;
    }

    public void setBusinessStatusKey(Integer businessStatusKey) {
        this.businessStatusKey = businessStatusKey;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(String taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getTaxSurchargePercent() {
        return taxSurchargePercent;
    }

    public void setTaxSurchargePercent(String taxSurchargePercent) {
        this.taxSurchargePercent = taxSurchargePercent;
    }

    public String getRemarks1() {
        return remarks1;
    }

    public void setRemarks1(String remarks1) {
        this.remarks1 = remarks1;
    }

    public String getRemarks2() {
        return remarks2;
    }

    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    public String getRemarks3() {
        return remarks3;
    }

    public void setRemarks3(String remarks3) {
        this.remarks3 = remarks3;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public String getPropBreSlipNumber() {
        return propBreSlipNumber;
    }

    public void setPropBreSlipNumber(String propBreSlipNumber) {
        this.propBreSlipNumber = propBreSlipNumber;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getGrossRetention() {
        return grossRetention;
    }

    public void setGrossRetention(String grossRetention) {
        this.grossRetention = grossRetention;
    }

    public String getCessionForQuotaShare() {
        return cessionForQuotaShare;
    }

    public void setCessionForQuotaShare(String cessionForQuotaShare) {
        this.cessionForQuotaShare = cessionForQuotaShare;
    }

    public Integer getLineSurplus() {
        return lineSurplus;
    }

    public void setLineSurplus(Integer lineSurplus) {
        this.lineSurplus = lineSurplus;
    }

    public String getCommissionForQuotaShare() {
        return commissionForQuotaShare;
    }

    public void setCommissionForQuotaShare(String commissionForQuotaShare) {
        this.commissionForQuotaShare = commissionForQuotaShare;
    }

    public String getCommissionForSurplus() {
        return commissionForSurplus;
    }

    public void setCommissionForSurplus(String commissionForSurplus) {
        this.commissionForSurplus = commissionForSurplus;
    }

    public String getFixedOrProvisionalCommission() {
        return fixedOrProvisionalCommission;
    }

    public void setFixedOrProvisionalCommission(String fixedOrProvisionalCommission) {
        this.fixedOrProvisionalCommission = fixedOrProvisionalCommission;
    }

    public String getEpiForQuotaShare() {
        return epiForQuotaShare;
    }

    public void setEpiForQuotaShare(String epiForQuotaShare) {
        this.epiForQuotaShare = epiForQuotaShare;
    }

    public String getEpiForSurplus() {
        return epiForSurplus;
    }

    public void setEpiForSurplus(String epiForSurplus) {
        this.epiForSurplus = epiForSurplus;
    }

    public String getEventLimit() {
        return eventLimit;
    }

    public void setEventLimit(String eventLimit) {
        this.eventLimit = eventLimit;
    }

    public String getExpiryDateOfExtension() {
        return expiryDateOfExtension;
    }

    public void setExpiryDateOfExtension(String expiryDateOfExtension) {
        this.expiryDateOfExtension = expiryDateOfExtension;
    }

    public String getUnderwritingPeriod() {
        return underwritingPeriod;
    }

    public void setUnderwritingPeriod(String underwritingPeriod) {
        this.underwritingPeriod = underwritingPeriod;
    }

    public String getNonPropId() {
        return nonPropId;
    }

    public void setNonPropId(String nonPropId) {
        this.nonPropId = nonPropId;
    }

    public String getNonPropBreSlipNumber() {
        return nonPropBreSlipNumber;
    }

    public void setNonPropBreSlipNumber(String nonPropBreSlipNumber) {
        this.nonPropBreSlipNumber = nonPropBreSlipNumber;
    }

    public String getNonPropLayer() {
        return nonPropLayer;
    }

    public void setNonPropLayer(String nonPropLayer) {
        this.nonPropLayer = nonPropLayer;
    }

    public String getNonPropGnpi() {
        return nonPropGnpi;
    }

    public void setNonPropGnpi(String nonPropGnpi) {
        this.nonPropGnpi = nonPropGnpi;
    }

    public String getNonPropAdjustableRate() {
        return nonPropAdjustableRate;
    }

    public void setNonPropAdjustableRate(String nonPropAdjustableRate) {
        this.nonPropAdjustableRate = nonPropAdjustableRate;
    }

    public String getNonPropDepositPremium() {
        return nonPropDepositPremium;
    }

    public void setNonPropDepositPremium(String nonPropDepositPremium) {
        this.nonPropDepositPremium = nonPropDepositPremium;
    }

    public String getNonPropDpPercent() {
        return nonPropDpPercent;
    }

    public void setNonPropDpPercent(String nonPropDpPercent) {
        this.nonPropDpPercent = nonPropDpPercent;
    }

    public String getNonPropMinimumPremium() {
        return nonPropMinimumPremium;
    }

    public void setNonPropMinimumPremium(String nonPropMinimumPremium) {
        this.nonPropMinimumPremium = nonPropMinimumPremium;
    }

    public String getNonPropMpPercent() {
        return nonPropMpPercent;
    }

    public void setNonPropMpPercent(String nonPropMpPercent) {
        this.nonPropMpPercent = nonPropMpPercent;
    }

    public String getNonPropRateOnLine() {
        return nonPropRateOnLine;
    }

    public void setNonPropRateOnLine(String nonPropRateOnLine) {
        this.nonPropRateOnLine = nonPropRateOnLine;
    }

    public String getNonPropReinstatement() {
        return nonPropReinstatement;
    }

    public void setNonPropReinstatement(String nonPropReinstatement) {
        this.nonPropReinstatement = nonPropReinstatement;
    }

    public String getNonPropCoverage() {
        return nonPropCoverage;
    }

    public void setNonPropCoverage(String nonPropCoverage) {
        this.nonPropCoverage = nonPropCoverage;
    }

    public String getReinsurerId() {
        return reinsurerId;
    }

    public void setReinsurerId(String reinsurerId) {
        this.reinsurerId = reinsurerId;
    }

    public String getReinsurerBreSlipNumber() {
        return reinsurerBreSlipNumber;
    }

    public void setReinsurerBreSlipNumber(String reinsurerBreSlipNumber) {
        this.reinsurerBreSlipNumber = reinsurerBreSlipNumber;
    }

    public String getReinsurerPropId() {
        return reinsurerPropId;
    }

    public void setReinsurerPropId(String reinsurerPropId) {
        this.reinsurerPropId = reinsurerPropId;
    }

    public String getReinsurer() {
        return reinsurer;
    }

    public void setReinsurer(String reinsurer) {
        this.reinsurer = reinsurer;
    }

    public String getCountryOfReinsurer() {
        return countryOfReinsurer;
    }

    public void setCountryOfReinsurer(String countryOfReinsurer) {
        this.countryOfReinsurer = countryOfReinsurer;
    }

    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public String getPlacementBroker() {
        return placementBroker;
    }

    public void setPlacementBroker(String placementBroker) {
        this.placementBroker = placementBroker;
    }

    public String getCountryOfPlacementBroker() {
        return countryOfPlacementBroker;
    }

    public void setCountryOfPlacementBroker(String countryOfPlacementBroker) {
        this.countryOfPlacementBroker = countryOfPlacementBroker;
    }

    public String getBreBrokerage() {
        return breBrokerage;
    }

    public void setBreBrokerage(String breBrokerage) {
        this.breBrokerage = breBrokerage;
    }

    public String getBreBrokeragePercent() {
        return breBrokeragePercent;
    }

    public void setBreBrokeragePercent(String breBrokeragePercent) {
        this.breBrokeragePercent = breBrokeragePercent;
    }

    public String getOtherFeeOrCharge() {
        return otherFeeOrCharge;
    }

    public void setOtherFeeOrCharge(String otherFeeOrCharge) {
        this.otherFeeOrCharge = otherFeeOrCharge;
    }

    public String getIncludingExcludingBrokerageVat() {
        return includingExcludingBrokerageVat;
    }

    public void setIncludingExcludingBrokerageVat(String includingExcludingBrokerageVat) {
        this.includingExcludingBrokerageVat = includingExcludingBrokerageVat;
    }

    public String getWrittenLine() {
        return writtenLine;
    }

    public void setWrittenLine(String writtenLine) {
        this.writtenLine = writtenLine;
    }

    public String getSignedLine() {
        return signedLine;
    }

    public void setSignedLine(String signedLine) {
        this.signedLine = signedLine;
    }

    public String getStatusReinsurer() {
        return statusReinsurer;
    }

    public void setStatusReinsurer(String statusReinsurer) {
        this.statusReinsurer = statusReinsurer;
    }

    public String getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(String signingDate) {
        this.signingDate = signingDate;
    }

    public String getConditionReinsurer() {
        return conditionReinsurer;
    }

    public void setConditionReinsurer(String conditionReinsurer) {
        this.conditionReinsurer = conditionReinsurer;
    }

    public String getReinsurerRemarks() {
        return reinsurerRemarks;
    }

    public void setReinsurerRemarks(String reinsurerRemarks) {
        this.reinsurerRemarks = reinsurerRemarks;
    }

    public String getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(String arrangeId) {
        this.arrangeId = arrangeId;
    }

    public String getArrangeBreSlipNumber() {
        return arrangeBreSlipNumber;
    }

    public void setArrangeBreSlipNumber(String arrangeBreSlipNumber) {
        this.arrangeBreSlipNumber = arrangeBreSlipNumber;
    }

    public String getArrangePropId() {
        return arrangePropId;
    }

    public void setArrangePropId(String arrangePropId) {
        this.arrangePropId = arrangePropId;
    }

    public String getArrangeReinsurerId() {
        return arrangeReinsurerId;
    }

    public void setArrangeReinsurerId(String arrangeReinsurerId) {
        this.arrangeReinsurerId = arrangeReinsurerId;
    }

    public String getArrangeLayer() {
        return arrangeLayer;
    }

    public void setArrangeLayer(String arrangeLayer) {
        this.arrangeLayer = arrangeLayer;
    }

    public String getArrangeGnpi() {
        return arrangeGnpi;
    }

    public void setArrangeGnpi(String arrangeGnpi) {
        this.arrangeGnpi = arrangeGnpi;
    }

    public String getArrangeAdjustableRate() {
        return arrangeAdjustableRate;
    }

    public void setArrangeAdjustableRate(String arrangeAdjustableRate) {
        this.arrangeAdjustableRate = arrangeAdjustableRate;
    }

    public String getArrangeDepositPremium() {
        return arrangeDepositPremium;
    }

    public void setArrangeDepositPremium(String arrangeDepositPremium) {
        this.arrangeDepositPremium = arrangeDepositPremium;
    }

    public String getArrangeDpPercentDpPercent() {
        return arrangeDpPercentDpPercent;
    }

    public void setArrangeDpPercentDpPercent(String arrangeDpPercentDpPercent) {
        this.arrangeDpPercentDpPercent = arrangeDpPercentDpPercent;
    }

    public String getArrangeMinimumPremium() {
        return arrangeMinimumPremium;
    }

    public void setArrangeMinimumPremium(String arrangeMinimumPremium) {
        this.arrangeMinimumPremium = arrangeMinimumPremium;
    }

    public String getArrangeMpPercent() {
        return arrangeMpPercent;
    }

    public void setArrangeMpPercent(String arrangeMpPercent) {
        this.arrangeMpPercent = arrangeMpPercent;
    }

    public String getArrangeRateOnLine() {
        return arrangeRateOnLine;
    }

    public void setArrangeRateOnLine(String arrangeRateOnLine) {
        this.arrangeRateOnLine = arrangeRateOnLine;
    }

    public String getArrangeReinstatement() {
        return arrangeReinstatement;
    }

    public void setArrangeReinstatement(String arrangeReinstatement) {
        this.arrangeReinstatement = arrangeReinstatement;
    }

    public String getArrangeCoverage() {
        return arrangeCoverage;
    }

    public void setArrangeCoverage(String arrangeCoverage) {
        this.arrangeCoverage = arrangeCoverage;
    }

    private String arrangeRateOnLine;
    private String arrangeReinstatement;
    private String arrangeCoverage;

    private String lineOfBusiness;

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }
}
