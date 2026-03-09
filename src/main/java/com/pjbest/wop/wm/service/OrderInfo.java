package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单信息
 */
public class OrderInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ERP订单号
     */
    
    private String erpOrderSn;

    /**
     * 乡镇/街道
     */
    
    private String buyerTownName;

    /**
     * 收货地址
     */
    
    private String buyerDetailAddress;

    /**
     * 销售平台
     */
    
    private String platformName;

    /**
     * 邮政编码
     */
    
    private String zipCode;

    /**
     * 座机
     */
    
    private String buyerTel;

    /**
     * 移动电话
     */
    
    private String buyerMobie;

    /**
     * 支付方式
     */
    
    private String payType;

    /**
     * 客户要求
     */
    
    private String customerRequirements;

    /**
     * 用户备注
     */
    
    private String remark;

    /**
     * 用户备注
     */
    
    private Double totalMoney;

    /**
     * 原订单号
     */
    
    private String oldErpOrderSn;

    /**
     * 现金应收
     */
    
    private Double money;

    /**
     * 运费
     */
    
    private Double carriage;

    /**
     * 货到付款方式
     */
    
    private String codType;

    /**
     * 下单时间
     */
    
    private String platformAddDtmLoc;

    /**
     * ERP订单创建时间
     */
    
    private String erpCreatedDtmLoc;

    /**
     * 是否打印价格
     */
    
    private Boolean isPrintingPrice;

    /**
     * 服务电话
     */
    
    private String serviceTel;

    /**
     * 运输要求
     */
    
    private Byte transportReq;

    /**
     * 物流公司编码
     */
    
    private String carrierCode;

    /**
     * 物流公司名称
     */
    
    private String carrierName;

    /**
     * 平台订单编号
     */
    
    private String platformOrderSn;

    /**
     * ERP下单人员
     */
    
    private String erpCreateUser;

    /**
     * 订单类型
     */
    
    private Byte orderType;

    /**
     * 订单商品明细
     */
    @Required("订单商品明细 ")
    private java.util.List<com.pjbest.wop.wm.service.OrderItemInfo> detailList;

    /**
     * 服务产品
     */
    
    private Byte productType;

    /**
     * 运费付款方式（结算方式）
     */
    
    private Byte carriagePayType;

    /**
     * 交货方式
     */
    
    private Byte deliveryType;

    /**
     * 订单批次号
     */
    
    private String orderBatchNo;

    /**
     * 订单批次包含订单数
     */
    
    private Integer orderBatchQty;

    /**
     * 交易来源
     */
    
    private String transactionSource;

    /**
     * 客户店铺编码
     */
    
    private String custStoreCode;

    /**
     * 发货仓
     */
    
    private String warehouse;

    /**
     * 客户店铺名称
     */
    
    private String custStoreName;

    /**
     * 是否鲸仓[0:VIPSHOP 1:VIPMAXX]
     */
    
    private Byte isWhaleWarehouse;

    /**
     * 消费税
     */
    
    private Long excise;

    /**
     * 货权转移开关1:shop转max
     */
    
    private String inventorySwitch;

    /**
     * 子订单类型 0:默认订单 2:JITX订单 3: 海淘保税仓订单
     */
    
    private Byte subOrderType;

    /**
     * 申报结果海关状态:7：放行,500：查验
     */
    
    private String cusStatus;

    /**
     * 运单号
     */
    
    private String transportNo;

    /**
     * 三段码（分拣码）
     */
    
    private String positionNo;

    /**
     * 货币代码
     */
    
    private String currencyCode;

    /**
     * 订单扩展字段列表(用于非核心业务)
     */
    
    private java.util.List<com.pjbest.wop.wm.service.OrderExtendsField> extendsFieldList;

    /**
     * 收货人
     */
    
    private String buyer;

    /**
     * 淘宝开平台的收件人ID
     */
    
    private String oaid;

    /**
     * 发货人
     */
    
    private String senderName;

    /**
     * 发货人电话
     */
    
    private String senderTel;

    /**
     * 发货人手机
     */
    
    private String senderMobie;

    /**
     * 发货国家
     */
    
    private String senderCountry;

    /**
     * 发货省
     */
    
    private String senderStateName;

    /**
     * 发货城市
     */
    
    private String senderCityName;

    /**
     * 发货区
     */
    
    private String senderDistrictName;

    /**
     * 发货乡镇/街道
     */
    
    private String senderTownName;

    /**
     * 发货详细地址
     */
    
    private String senderDetailAddress;

    /**
     * 国
     */
    
    private String buyerCountry;

    /**
     * 淘宝开放平台的订单加密、解密、取号唯一标识
     */
    
    private String oaidOrderSourceCode;

    /**
     * 扩展属性Map(json字符串) [{'att1':1},{'att1':2}]
     */
    
    private String extendProps;

    /**
     * (得物)订单履约类型
     */
    
    private String performanceType;

    /**
     * 原始销售平台
     */
    
    private String originalPlatformName;

    /**
     * 省/州
     */
    
    private String buyerStateName;

    /**
     * 城市
     */
    
    private String buyerCityName;

    /**
     * 区/县
     */
    
    private String buyerDistrictName;

    // 构造函数
    public OrderInfo() {super();}

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
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

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getCustomerRequirements() {
        return customerRequirements;
    }

    public void setCustomerRequirements(String customerRequirements) {
        this.customerRequirements = customerRequirements;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOldErpOrderSn() {
        return oldErpOrderSn;
    }

    public void setOldErpOrderSn(String oldErpOrderSn) {
        this.oldErpOrderSn = oldErpOrderSn;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getCarriage() {
        return carriage;
    }

    public void setCarriage(Double carriage) {
        this.carriage = carriage;
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

    public Boolean getIsPrintingPrice() {
        return isPrintingPrice;
    }

    public void setIsPrintingPrice(Boolean isPrintingPrice) {
        this.isPrintingPrice = isPrintingPrice;
    }

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public Byte getTransportReq() {
        return transportReq;
    }

    public void setTransportReq(Byte transportReq) {
        this.transportReq = transportReq;
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

    public String getPlatformOrderSn() {
        return platformOrderSn;
    }

    public void setPlatformOrderSn(String platformOrderSn) {
        this.platformOrderSn = platformOrderSn;
    }

    public String getErpCreateUser() {
        return erpCreateUser;
    }

    public void setErpCreateUser(String erpCreateUser) {
        this.erpCreateUser = erpCreateUser;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public java.util.List<com.pjbest.wop.wm.service.OrderItemInfo> getDetailList() {
        return detailList;
    }

    public void setDetailList(java.util.List<com.pjbest.wop.wm.service.OrderItemInfo> detailList) {
        this.detailList = detailList;
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public Byte getCarriagePayType() {
        return carriagePayType;
    }

    public void setCarriagePayType(Byte carriagePayType) {
        this.carriagePayType = carriagePayType;
    }

    public Byte getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Byte deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getOrderBatchNo() {
        return orderBatchNo;
    }

    public void setOrderBatchNo(String orderBatchNo) {
        this.orderBatchNo = orderBatchNo;
    }

    public Integer getOrderBatchQty() {
        return orderBatchQty;
    }

    public void setOrderBatchQty(Integer orderBatchQty) {
        this.orderBatchQty = orderBatchQty;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public String getCustStoreCode() {
        return custStoreCode;
    }

    public void setCustStoreCode(String custStoreCode) {
        this.custStoreCode = custStoreCode;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getCustStoreName() {
        return custStoreName;
    }

    public void setCustStoreName(String custStoreName) {
        this.custStoreName = custStoreName;
    }

    public Byte getIsWhaleWarehouse() {
        return isWhaleWarehouse;
    }

    public void setIsWhaleWarehouse(Byte isWhaleWarehouse) {
        this.isWhaleWarehouse = isWhaleWarehouse;
    }

    public Long getExcise() {
        return excise;
    }

    public void setExcise(Long excise) {
        this.excise = excise;
    }

    public String getInventorySwitch() {
        return inventorySwitch;
    }

    public void setInventorySwitch(String inventorySwitch) {
        this.inventorySwitch = inventorySwitch;
    }

    public Byte getSubOrderType() {
        return subOrderType;
    }

    public void setSubOrderType(Byte subOrderType) {
        this.subOrderType = subOrderType;
    }

    public String getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(String cusStatus) {
        this.cusStatus = cusStatus;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

    public String getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(String positionNo) {
        this.positionNo = positionNo;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public java.util.List<com.pjbest.wop.wm.service.OrderExtendsField> getExtendsFieldList() {
        return extendsFieldList;
    }

    public void setExtendsFieldList(java.util.List<com.pjbest.wop.wm.service.OrderExtendsField> extendsFieldList) {
        this.extendsFieldList = extendsFieldList;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getOaid() {
        return oaid;
    }

    public void setOaid(String oaid) {
        this.oaid = oaid;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getSenderMobie() {
        return senderMobie;
    }

    public void setSenderMobie(String senderMobie) {
        this.senderMobie = senderMobie;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getSenderStateName() {
        return senderStateName;
    }

    public void setSenderStateName(String senderStateName) {
        this.senderStateName = senderStateName;
    }

    public String getSenderCityName() {
        return senderCityName;
    }

    public void setSenderCityName(String senderCityName) {
        this.senderCityName = senderCityName;
    }

    public String getSenderDistrictName() {
        return senderDistrictName;
    }

    public void setSenderDistrictName(String senderDistrictName) {
        this.senderDistrictName = senderDistrictName;
    }

    public String getSenderTownName() {
        return senderTownName;
    }

    public void setSenderTownName(String senderTownName) {
        this.senderTownName = senderTownName;
    }

    public String getSenderDetailAddress() {
        return senderDetailAddress;
    }

    public void setSenderDetailAddress(String senderDetailAddress) {
        this.senderDetailAddress = senderDetailAddress;
    }

    public String getBuyerCountry() {
        return buyerCountry;
    }

    public void setBuyerCountry(String buyerCountry) {
        this.buyerCountry = buyerCountry;
    }

    public String getOaidOrderSourceCode() {
        return oaidOrderSourceCode;
    }

    public void setOaidOrderSourceCode(String oaidOrderSourceCode) {
        this.oaidOrderSourceCode = oaidOrderSourceCode;
    }

    public String getExtendProps() {
        return extendProps;
    }

    public void setExtendProps(String extendProps) {
        this.extendProps = extendProps;
    }

    public String getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(String performanceType) {
        this.performanceType = performanceType;
    }

    public String getOriginalPlatformName() {
        return originalPlatformName;
    }

    public void setOriginalPlatformName(String originalPlatformName) {
        this.originalPlatformName = originalPlatformName;
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

}
