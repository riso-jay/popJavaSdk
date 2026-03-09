package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建海淘订单请求
 */
public class CreateHtOrderReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 货主编码；必填
     */
    
    private String crmCustCode;

    /**
     * 收货人电话；收货人电话，手机二选一必填
     */
    
    private String buyerTel;

    /**
     * 收货人手机；收货人电话，手机二选一必填
     */
    
    private String buyerMobie;

    /**
     * 收货国家；非必填
     */
    
    private String buyerCountry;

    /**
     * 收货省；必填
     */
    
    private String buyerStateName;

    /**
     * 收货市；必填
     */
    
    private String buyerCityName;

    /**
     * 收货区；必填
     */
    
    private String buyerDistrictName;

    /**
     * 收货乡镇/街道；非必填
     */
    
    private String buyerTownName;

    /**
     * 收货详细地址；必填
     */
    
    private String buyerDetailAddress;

    /**
     * 邮政编码，六位的数字；必填
     */
    
    private String zipCode;

    /**
     * 客户要求；非必填
     */
    
    private String customerRequirements;

    /**
     * 货主名称；非必填
     */
    
    private String crmCustName;

    /**
     * 运费；必填
     */
    
    private Double carriage;

    /**
     * 支付方式；必填
     */
    
    private String payType;

    /**
     * 应收金额；必填
     */
    
    private Double money;

    /**
     * 货到付款方式；非必填
     */
    
    private String codType;

    /**
     * 平台下单时间；非必填
     */
    
    private String platformAddDtmLoc;

    /**
     * ERP订单创建时间；非必填
     */
    
    private String erpCreatedDtmLoc;

    /**
     * 发货仓；必填
     */
    
    private String warehouse;

    /**
     * 服务电话；非必填
     */
    
    private String serviceTel;

    /**
     * 清单是否打印价格，0：否，1：是；非必填
     */
    
    private Byte isPrintingPrice;

    /**
     * 备注；非必填
     */
    
    private String remark;

    /**
     * erp订单号；必填
     */
    
    private String erpOrderSn;

    /**
     * 货币代码；非必填
     */
    
    private String currencyCode;

    /**
     * 清关模式[1:BBC备货]；必填
     */
    
    private String ccMode;

    /**
     * 关口[gzhg广州海关，tjhg天津海关，cqhg重庆海关，nbhg宁波海关]；必填
     */
    
    private String customsCode;

    /**
     * 申报海关类型[1-总署；2-地方关]；必填
     */
    
    private String declareType;

    /**
     * 支付交易号；必填
     */
    
    private String paymentNo;

    /**
     * 订单总价,订单所有商品的总价不包含运费与税金，单位 RMB；必填
     */
    
    private Double totalMoney;

    /**
     * 订单总毛重,整个订单包裹的总重量，单位 KG；必填
     */
    
    private Double pkgGweight;

    /**
     * 订单总净重,订单所有商品不包含快递包装的重量，单位 KG；必填
     */
    
    private Double goodsNweight;

    /**
     * 保费；必填
     */
    
    private Double insuredFee;

    /**
     * 税费；必填
     */
    
    private Double cusTax;

    /**
     * 原订单号；非必填
     */
    
    private String oldErpOrderSn;

    /**
     * 订购人姓名；非必填
     */
    
    private String subscriberName;

    /**
     * 订购人身份证号码；非必填
     */
    
    private String subscriberIdcard;

    /**
     * 订购人电话；非必填
     */
    
    private String subscriberPhone;

    /**
     * 发货人姓名；必填
     */
    
    private String deliverName;

    /**
     * 发货人身份证号码；必填
     */
    
    private String deliverIdcard;

    /**
     * 发货人电话；非必填
     */
    
    private String deliverTel;

    /**
     * 发货人手机；非必填
     */
    
    private String deliverMobie;

    /**
     * 发货国家；必填
     */
    
    private String deliverCountry;

    /**
     * 发货省；必填
     */
    
    private String deliverStateName;

    /**
     * 发货市；必填
     */
    
    private String deliverCityName;

    /**
     * 平台(客户)订单号；必填
     */
    
    private String platformOrderSn;

    /**
     * 发货区；必填
     */
    
    private String deliverDistrictName;

    /**
     * 发货乡镇/街道；非必填
     */
    
    private String deliverTownName;

    /**
     * 发货详细地址；必填
     */
    
    private String deliverDetailAddress;

    /**
     * 批次号（发货批次）；非必填
     */
    
    private String batchNumber;

    /**
     * 提单号；非必填
     */
    
    private String ladingBillNumber;

    /**
     * 子提单号；非必填
     */
    
    private String subLadingBillNumber;

    /**
     * 明细列表；必填
     */
    
    private java.util.List<com.pjbest.wop.wm.service.CreateHtOrderDetail> details;

    /**
     * 承运商编码，例：SF；必填
     */
    
    private String carriersCode;

    /**
     * 销售平台名称(订单来源)[TB:淘宝,JD:京东]；必填
     */
    
    private String platformName;

    /**
     * 收货仓；非必填
     */
    
    private String revcWarehouse;

    /**
     * 收货人姓名；必填
     */
    
    private String buyerName;

    /**
     * 收货人身份证号码；非必填
     */
    
    private String buyerIdcard;

    // 构造函数
    public CreateHtOrderReq() {super();}

    public String getCrmCustCode() {
        return crmCustCode;
    }

    public void setCrmCustCode(String crmCustCode) {
        this.crmCustCode = crmCustCode;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }

    public String getBuyerMobie() {
        return buyerMobie;
    }

    public void setBuyerMobie(String buyerMobie) {
        this.buyerMobie = buyerMobie;
    }

    public String getBuyerCountry() {
        return buyerCountry;
    }

    public void setBuyerCountry(String buyerCountry) {
        this.buyerCountry = buyerCountry;
    }

    public String getBuyerStateName() {
        return buyerStateName;
    }

    public void setBuyerStateName(String buyerStateName) {
        this.buyerStateName = buyerStateName;
    }

    public String getBuyerCityName() {
        return buyerCityName;
    }

    public void setBuyerCityName(String buyerCityName) {
        this.buyerCityName = buyerCityName;
    }

    public String getBuyerDistrictName() {
        return buyerDistrictName;
    }

    public void setBuyerDistrictName(String buyerDistrictName) {
        this.buyerDistrictName = buyerDistrictName;
    }

    public String getBuyerTownName() {
        return buyerTownName;
    }

    public void setBuyerTownName(String buyerTownName) {
        this.buyerTownName = buyerTownName;
    }

    public String getBuyerDetailAddress() {
        return buyerDetailAddress;
    }

    public void setBuyerDetailAddress(String buyerDetailAddress) {
        this.buyerDetailAddress = buyerDetailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCustomerRequirements() {
        return customerRequirements;
    }

    public void setCustomerRequirements(String customerRequirements) {
        this.customerRequirements = customerRequirements;
    }

    public String getCrmCustName() {
        return crmCustName;
    }

    public void setCrmCustName(String crmCustName) {
        this.crmCustName = crmCustName;
    }

    public Double getCarriage() {
        return carriage;
    }

    public void setCarriage(Double carriage) {
        this.carriage = carriage;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getCodType() {
        return codType;
    }

    public void setCodType(String codType) {
        this.codType = codType;
    }

    public String getPlatformAddDtmLoc() {
        return platformAddDtmLoc;
    }

    public void setPlatformAddDtmLoc(String platformAddDtmLoc) {
        this.platformAddDtmLoc = platformAddDtmLoc;
    }

    public String getErpCreatedDtmLoc() {
        return erpCreatedDtmLoc;
    }

    public void setErpCreatedDtmLoc(String erpCreatedDtmLoc) {
        this.erpCreatedDtmLoc = erpCreatedDtmLoc;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public Byte getIsPrintingPrice() {
        return isPrintingPrice;
    }

    public void setIsPrintingPrice(Byte isPrintingPrice) {
        this.isPrintingPrice = isPrintingPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCcMode() {
        return ccMode;
    }

    public void setCcMode(String ccMode) {
        this.ccMode = ccMode;
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode;
    }

    public String getDeclareType() {
        return declareType;
    }

    public void setDeclareType(String declareType) {
        this.declareType = declareType;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getPkgGweight() {
        return pkgGweight;
    }

    public void setPkgGweight(Double pkgGweight) {
        this.pkgGweight = pkgGweight;
    }

    public Double getGoodsNweight() {
        return goodsNweight;
    }

    public void setGoodsNweight(Double goodsNweight) {
        this.goodsNweight = goodsNweight;
    }

    public Double getInsuredFee() {
        return insuredFee;
    }

    public void setInsuredFee(Double insuredFee) {
        this.insuredFee = insuredFee;
    }

    public Double getCusTax() {
        return cusTax;
    }

    public void setCusTax(Double cusTax) {
        this.cusTax = cusTax;
    }

    public String getOldErpOrderSn() {
        return oldErpOrderSn;
    }

    public void setOldErpOrderSn(String oldErpOrderSn) {
        this.oldErpOrderSn = oldErpOrderSn;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberIdcard() {
        return subscriberIdcard;
    }

    public void setSubscriberIdcard(String subscriberIdcard) {
        this.subscriberIdcard = subscriberIdcard;
    }

    public String getSubscriberPhone() {
        return subscriberPhone;
    }

    public void setSubscriberPhone(String subscriberPhone) {
        this.subscriberPhone = subscriberPhone;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getDeliverIdcard() {
        return deliverIdcard;
    }

    public void setDeliverIdcard(String deliverIdcard) {
        this.deliverIdcard = deliverIdcard;
    }

    public String getDeliverTel() {
        return deliverTel;
    }

    public void setDeliverTel(String deliverTel) {
        this.deliverTel = deliverTel;
    }

    public String getDeliverMobie() {
        return deliverMobie;
    }

    public void setDeliverMobie(String deliverMobie) {
        this.deliverMobie = deliverMobie;
    }

    public String getDeliverCountry() {
        return deliverCountry;
    }

    public void setDeliverCountry(String deliverCountry) {
        this.deliverCountry = deliverCountry;
    }

    public String getDeliverStateName() {
        return deliverStateName;
    }

    public void setDeliverStateName(String deliverStateName) {
        this.deliverStateName = deliverStateName;
    }

    public String getDeliverCityName() {
        return deliverCityName;
    }

    public void setDeliverCityName(String deliverCityName) {
        this.deliverCityName = deliverCityName;
    }

    public String getPlatformOrderSn() {
        return platformOrderSn;
    }

    public void setPlatformOrderSn(String platformOrderSn) {
        this.platformOrderSn = platformOrderSn;
    }

    public String getDeliverDistrictName() {
        return deliverDistrictName;
    }

    public void setDeliverDistrictName(String deliverDistrictName) {
        this.deliverDistrictName = deliverDistrictName;
    }

    public String getDeliverTownName() {
        return deliverTownName;
    }

    public void setDeliverTownName(String deliverTownName) {
        this.deliverTownName = deliverTownName;
    }

    public String getDeliverDetailAddress() {
        return deliverDetailAddress;
    }

    public void setDeliverDetailAddress(String deliverDetailAddress) {
        this.deliverDetailAddress = deliverDetailAddress;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getLadingBillNumber() {
        return ladingBillNumber;
    }

    public void setLadingBillNumber(String ladingBillNumber) {
        this.ladingBillNumber = ladingBillNumber;
    }

    public String getSubLadingBillNumber() {
        return subLadingBillNumber;
    }

    public void setSubLadingBillNumber(String subLadingBillNumber) {
        this.subLadingBillNumber = subLadingBillNumber;
    }

    public java.util.List<com.pjbest.wop.wm.service.CreateHtOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(java.util.List<com.pjbest.wop.wm.service.CreateHtOrderDetail> details) {
        this.details = details;
    }

    public String getCarriersCode() {
        return carriersCode;
    }

    public void setCarriersCode(String carriersCode) {
        this.carriersCode = carriersCode;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getRevcWarehouse() {
        return revcWarehouse;
    }

    public void setRevcWarehouse(String revcWarehouse) {
        this.revcWarehouse = revcWarehouse;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerIdcard() {
        return buyerIdcard;
    }

    public void setBuyerIdcard(String buyerIdcard) {
        this.buyerIdcard = buyerIdcard;
    }

}
