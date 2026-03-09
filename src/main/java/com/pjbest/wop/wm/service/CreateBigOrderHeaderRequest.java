package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建大订单单头请求
 */
public class CreateBigOrderHeaderRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * 区/县
     */
    @Required("区/县 ")
    private String buyerDistrictName;

    /**
     * 乡镇/街道
     */
    
    private String buyerTownName;

    /**
     * 收货地址
     */
    @Required("收货地址 ")
    private String buyerDetailAddress;

    /**
     * 销售平台
     */
    
    private String platformName;

    /**
     * 邮政编码
     */
    @Required("邮政编码 ")
    private String zipCode;

    /**
     * 座机：座机，座机和移动电话二选一必填
     */
    
    private String buyerTel;

    /**
     * 移动电话：座机，座机和移动电话二选一必填
     */
    
    private String buyerMobie;

    /**
     * 支付方式： 银行卡支付 唯品钱包 信用卡支付 支付宝支付 邮政汇款 货到付款 财付通支付 移动手机支付 线上支付
     */
    @Required("支付方式： 银行卡支付 唯品钱包 信用卡支付 支付宝支付 邮政汇款 货到付款 财付通支付 移动手机支付 线上支付 ")
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
     * ERP订单号
     */
    @Required("ERP订单号 ")
    private String erpOrderSn;

    /**
     * 用户备注
     */
    
    private Double totalMoney;

    /**
     * 现金应收，单位：元
     */
    
    private Double money;

    /**
     * 运费，单位：元
     */
    
    private Double carriage;

    /**
     * 货到付款方式： 现金 POS机 支付宝 微信支付
     */
    @Required("货到付款方式： 现金 POS机 支付宝 微信支付 ")
    private String codType;

    /**
     * 平台下单时间
     */
    @Required("平台下单时间 ")
    private String platformAddDtmLoc;

    /**
     * ERP订单创建时间
     */
    @Required("ERP订单创建时间 ")
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
     * 运输要求 1：商家自提 2：服务商匹配 3：商家指定
     */
    @Required("运输要求 1：商家自提 2：服务商匹配 3：商家指定 ")
    private Byte transportReq;

    /**
     * 物流公司编码(transportReq = 3 商家指定是必填) PJ=唯品物流、SF=顺丰、EMS=标准快递、EYB=经济快件、ZJS=宅急送、YTO=圆通 、ZTO=中 通(ZTO)、HTKY=百世汇通、UC=优速、STO=申通、TTKDEX=天天快递、QFKD=全峰、FAST=快捷 、POSTB=邮政小包、 GTO=国通、YUNDA=韵达、JD=京东配送、DD=当当宅配、AMAZON=亚马逊物流、 OTHER=其他)
     */
    
    private String carrierCode;

    /**
     * 原订单号
     */
    
    private String oldErpOrderSn;

    /**
     * 物流公司名称
     */
    
    private String carrierName;

    /**
     * ERP下单人员
     */
    
    private String erpCreateUser;

    /**
     * 配送服务产品 1：标准快递 7：零担快运 8：整车运输 10：快运小包
     */
    
    private Byte productType;

    /**
     * 配送付款方式（结算方式）0：寄方月结1：现付 2：到付 3：到付月结
     */
    
    private Byte carriagePayType;

    /**
     * 配送交货方式 0：客户自取 1：送货上门 2：送货上楼
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
     * 客户店铺名称
     */
    
    private String custStoreName;

    /**
     * 平台订单编号
     */
    @Required("平台订单编号 ")
    private String platformOrderSn;

    /**
     * 货权转移开关1:shop转max
     */
    
    private String inventorySwitch;

    /**
     * 是否越库 0：否 1：是
     */
    
    private String isCrossdock;

    /**
     * 发货仓
     */
    
    private String warehouse;

    /**
     * 收货人
     */
    @Required("收货人 ")
    private String buyer;

    /**
     * 国
     */
    @Required("国 ")
    private String buyerCountry;

    /**
     * 省/州
     */
    @Required("省/州 ")
    private String buyerStateName;

    /**
     * 城市
     */
    
    private String buyerCityName;

    // 构造函数
    public CreateBigOrderHeaderRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
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

    public String getOldErpOrderSn() {
        return oldErpOrderSn;
    }

    public void setOldErpOrderSn(String oldErpOrderSn) {
        this.oldErpOrderSn = oldErpOrderSn;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getErpCreateUser() {
        return erpCreateUser;
    }

    public void setErpCreateUser(String erpCreateUser) {
        this.erpCreateUser = erpCreateUser;
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

    public String getCustStoreName() {
        return custStoreName;
    }

    public void setCustStoreName(String custStoreName) {
        this.custStoreName = custStoreName;
    }

    public String getPlatformOrderSn() {
        return platformOrderSn;
    }

    public void setPlatformOrderSn(String platformOrderSn) {
        this.platformOrderSn = platformOrderSn;
    }

    public String getInventorySwitch() {
        return inventorySwitch;
    }

    public void setInventorySwitch(String inventorySwitch) {
        this.inventorySwitch = inventorySwitch;
    }

    public String getIsCrossdock() {
        return isCrossdock;
    }

    public void setIsCrossdock(String isCrossdock) {
        this.isCrossdock = isCrossdock;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
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

}
