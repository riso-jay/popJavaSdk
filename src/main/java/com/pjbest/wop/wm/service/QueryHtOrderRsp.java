package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取订海淘单响应
 */
public class QueryHtOrderRsp implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功，500：失败
     */
    @Required("结果编码 200：成功，500：失败 ")
    private Integer resultCode;

    /**
     * 收货仓
     */
    
    private String revcWarehouse;

    /**
     * 收货人姓名
     */
    
    private String buyerName;

    /**
     * 收货人身份证号码
     */
    
    private String buyerIdcard;

    /**
     * 收货人电话
     */
    
    private String buyerTel;

    /**
     * 收货人手机
     */
    
    private String buyerMobie;

    /**
     * 收货国家
     */
    
    private String buyerCountry;

    /**
     * 收货省
     */
    
    private String buyerStateName;

    /**
     * 收货省名称
     */
    
    private String buyerStateCode;

    /**
     * 收货市
     */
    
    private String buyerCityName;

    /**
     * 收货市编码
     */
    
    private String buyerCityCode;

    /**
     * 结果子编码 200：成功，500：失败
     */
    @Required("结果子编码 200：成功，500：失败 ")
    private Integer resultSubCode;

    /**
     * 收货区
     */
    
    private String buyerDistrictName;

    /**
     * 收货区编码
     */
    
    private String buyerDistrictCode;

    /**
     * 收货乡镇/街道
     */
    
    private String buyerTownName;

    /**
     * 收货乡镇/街道编码
     */
    
    private String buyerTownCode;

    /**
     * 收货详细地址
     */
    
    private String buyerDetailAddress;

    /**
     * 邮政编码
     */
    
    private String zipCode;

    /**
     * 运输要求
     */
    
    private Byte transportReq;

    /**
     * 运费
     */
    
    private Double carriage;

    /**
     * 支付方式
     */
    
    private String payType;

    /**
     * 应收金额
     */
    
    private Double money;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 货到付款方式
     */
    
    private String codType;

    /**
     * 平台下单时间
     */
    
    private String platformAddDtmLoc;

    /**
     * ERP订单创建时间
     */
    
    private String erpCreatedDtmLoc;

    /**
     * 承运商编码(快递企业代码，不传默认唯品物流)[PJ:唯品物流]
     */
    
    private String carrierCode;

    /**
     * 承运商全称
     */
    
    private String carrierName;

    /**
     * 运单号
     */
    
    private String transportNo;

    /**
     * 发货仓
     */
    
    private String warehouse;

    /**
     * 客户要求
     */
    
    private String customerRequirements;

    /**
     * 服务电话
     */
    
    private String serviceTel;

    /**
     * 清单是否打印价格，0：否，1：是
     */
    
    private Byte isPrintingPrice;

    /**
     * 货主编码
     */
    
    private String crmCustCode;

    /**
     * 备注
     */
    
    private String remark;

    /**
     * 出仓时间
     */
    
    private String outTime;

    /**
     * 货币代码
     */
    
    private String currencyCode;

    /**
     * 清关模式[1:BBC备货]
     */
    
    private String ccMode;

    /**
     * 关口[gzhg广州海关，tjhg天津海关，cqhg重庆海关，nbhg宁波海关]
     */
    
    private String customsCode;

    /**
     * 申报海关类型[1-总署；2-地方关]
     */
    
    private String declareType;

    /**
     * 支付交易号
     */
    
    private String paymentNo;

    /**
     * 订单总价,订单所有商品的总价不包含运费与税金，单位 RMB
     */
    
    private Double totalMoney;

    /**
     * 订单总毛重,整个订单包裹的总重量，单位 KG
     */
    
    private Double pkgGweight;

    /**
     * 订单总净重,订单所有商品不包含快递包装的重量，单位 KG
     */
    
    private Double goodsNweight;

    /**
     * 货主名称
     */
    
    private String crmCustName;

    /**
     * 保费
     */
    
    private Double insuredFee;

    /**
     * 税费
     */
    
    private Double cusTax;

    /**
     * 订购人姓名
     */
    
    private String subscriberName;

    /**
     * 订购人身份证号码
     */
    
    private String subscriberIdcard;

    /**
     * 订购人电话
     */
    
    private String subscriberPhone;

    /**
     * 发货人姓名
     */
    
    private String deliverName;

    /**
     * 发货人身份证号码
     */
    
    private String deliverIdcard;

    /**
     * 发货人电话
     */
    
    private String deliverTel;

    /**
     * 发货人手机
     */
    
    private String deliverMobie;

    /**
     * 发货国家
     */
    
    private String deliverCountry;

    /**
     * erp订单号
     */
    
    private String erpOrderSn;

    /**
     * 发货省
     */
    
    private String deliverStateName;

    /**
     * 发货省名称
     */
    
    private String deliverStateCode;

    /**
     * 发货市
     */
    
    private String deliverCityName;

    /**
     * 发货市编码
     */
    
    private String deliverCityCode;

    /**
     * 发货区
     */
    
    private String deliverDistrictName;

    /**
     * 发货区编码
     */
    
    private String deliverDistrictCode;

    /**
     * 发货乡镇/街道
     */
    
    private String deliverTownName;

    /**
     * 发货乡镇/街道编码
     */
    
    private String deliverTownCode;

    /**
     * 发货详细地址
     */
    
    private String deliverDetailAddress;

    /**
     * 批次号（发货批次）
     */
    
    private String batchNumber;

    /**
     * 原订单号
     */
    
    private String oldErpOrderSn;

    /**
     * 提单号
     */
    
    private String ladingBillNumber;

    /**
     * 子提单号
     */
    
    private String subLadingBillNumber;

    /**
     * 订单状态[10:新增,20:预占失败,30:待清关中,40:清关中,41:清关完成,42:清关失败,100:仓库新增,110:待审核,111:审核通过,112:审核不通过,113:待确定地址,101:仓库下单中,200:仓库已下单,102:下单失败,300:拣货中,301:已打包,400:已出仓,420:核放中,421:核放完成,422:核放失败,500:配送中,501:已签收,502:已拒收,600:已取消,900:关闭]
     */
    
    private Integer orderStatus;

    /**
     * 订单处理备注
     */
    
    private String handleRemark;

    /**
     * 明细列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.QueryHtOrderDetail> details;

    /**
     * 平台(客户)订单号
     */
    
    private String platformOrderSn;

    /**
     * 销售平台名称(订单来源)[TB:淘宝,JD:京东]
     */
    
    private String platformName;

    // 构造函数
    public QueryHtOrderRsp() {super();}

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
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

    public String getBuyerStateCode() {
        return buyerStateCode;
    }

    public void setBuyerStateCode(String buyerStateCode) {
        this.buyerStateCode = buyerStateCode;
    }

    public String getBuyerCityName() {
        return buyerCityName;
    }

    public void setBuyerCityName(String buyerCityName) {
        this.buyerCityName = buyerCityName;
    }

    public String getBuyerCityCode() {
        return buyerCityCode;
    }

    public void setBuyerCityCode(String buyerCityCode) {
        this.buyerCityCode = buyerCityCode;
    }

    public Integer getResultSubCode() {
        return resultSubCode;
    }

    public void setResultSubCode(Integer resultSubCode) {
        this.resultSubCode = resultSubCode;
    }

    public String getBuyerDistrictName() {
        return buyerDistrictName;
    }

    public void setBuyerDistrictName(String buyerDistrictName) {
        this.buyerDistrictName = buyerDistrictName;
    }

    public String getBuyerDistrictCode() {
        return buyerDistrictCode;
    }

    public void setBuyerDistrictCode(String buyerDistrictCode) {
        this.buyerDistrictCode = buyerDistrictCode;
    }

    public String getBuyerTownName() {
        return buyerTownName;
    }

    public void setBuyerTownName(String buyerTownName) {
        this.buyerTownName = buyerTownName;
    }

    public String getBuyerTownCode() {
        return buyerTownCode;
    }

    public void setBuyerTownCode(String buyerTownCode) {
        this.buyerTownCode = buyerTownCode;
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

    public Byte getTransportReq() {
        return transportReq;
    }

    public void setTransportReq(Byte transportReq) {
        this.transportReq = transportReq;
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

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
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

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getCustomerRequirements() {
        return customerRequirements;
    }

    public void setCustomerRequirements(String customerRequirements) {
        this.customerRequirements = customerRequirements;
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

    public String getCrmCustCode() {
        return crmCustCode;
    }

    public void setCrmCustCode(String crmCustCode) {
        this.crmCustCode = crmCustCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
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

    public String getCrmCustName() {
        return crmCustName;
    }

    public void setCrmCustName(String crmCustName) {
        this.crmCustName = crmCustName;
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

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public String getDeliverStateName() {
        return deliverStateName;
    }

    public void setDeliverStateName(String deliverStateName) {
        this.deliverStateName = deliverStateName;
    }

    public String getDeliverStateCode() {
        return deliverStateCode;
    }

    public void setDeliverStateCode(String deliverStateCode) {
        this.deliverStateCode = deliverStateCode;
    }

    public String getDeliverCityName() {
        return deliverCityName;
    }

    public void setDeliverCityName(String deliverCityName) {
        this.deliverCityName = deliverCityName;
    }

    public String getDeliverCityCode() {
        return deliverCityCode;
    }

    public void setDeliverCityCode(String deliverCityCode) {
        this.deliverCityCode = deliverCityCode;
    }

    public String getDeliverDistrictName() {
        return deliverDistrictName;
    }

    public void setDeliverDistrictName(String deliverDistrictName) {
        this.deliverDistrictName = deliverDistrictName;
    }

    public String getDeliverDistrictCode() {
        return deliverDistrictCode;
    }

    public void setDeliverDistrictCode(String deliverDistrictCode) {
        this.deliverDistrictCode = deliverDistrictCode;
    }

    public String getDeliverTownName() {
        return deliverTownName;
    }

    public void setDeliverTownName(String deliverTownName) {
        this.deliverTownName = deliverTownName;
    }

    public String getDeliverTownCode() {
        return deliverTownCode;
    }

    public void setDeliverTownCode(String deliverTownCode) {
        this.deliverTownCode = deliverTownCode;
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

    public String getOldErpOrderSn() {
        return oldErpOrderSn;
    }

    public void setOldErpOrderSn(String oldErpOrderSn) {
        this.oldErpOrderSn = oldErpOrderSn;
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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getHandleRemark() {
        return handleRemark;
    }

    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark;
    }

    public java.util.List<com.pjbest.wop.wm.service.QueryHtOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(java.util.List<com.pjbest.wop.wm.service.QueryHtOrderDetail> details) {
        this.details = details;
    }

    public String getPlatformOrderSn() {
        return platformOrderSn;
    }

    public void setPlatformOrderSn(String platformOrderSn) {
        this.platformOrderSn = platformOrderSn;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

}
