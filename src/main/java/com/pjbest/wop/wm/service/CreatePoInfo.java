package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建PO信息
 */
public class CreatePoInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户PO
     */
    @Required("客户PO ")
    private String clientPoNo;

    /**
     * 退货市名称
     */
    @Required("退货市名称 ")
    private String returnCityName;

    /**
     * 退货地区编码
     */
    @Required("退货地区编码 ")
    private String returnDistrictName;

    /**
     * 退货详细地址
     */
    @Required("退货详细地址 ")
    private String returnDetailAddress;

    /**
     * 邮箱
     */
    @Required("邮箱 ")
    private String email;

    /**
     * 销售渠道 0:待定 1:唯品会 2:非唯品会 默认（0:待定）
     */
    
    private Byte channel;

    /**
     * 是否当面清点， 0:不需要 1:需要
     */
    
    private Byte isNeedFaceCount;

    /**
     * 重量
     */
    
    private Double weight;

    /**
     * 体积
     */
    
    private Double volume;

    /**
     * 备注
     */
    
    private String remark;

    /**
     * 创建人
     */
    @Required("创建人 ")
    private String createdByUser;

    /**
     * 供应商编码
     */
    @Required("供应商编码 ")
    private String vendorCode;

    /**
     * 是否按箱收货（0：否；1：是；默认为0）
     */
    
    private Byte boxFlag;

    /**
     * 是否允许分批入库（0：否，1：是，默认为1）
     */
    
    private Byte isBatchStorage;

    /**
     * 是否鲸仓[0:VIPSHOP 1:VIPMAXX]
     */
    
    private Byte isWhaleWarehouse;

    /**
     * po类型:3PL：3PL采购入库;TRANS_MDFC：店返仓入库
     */
    
    private String type;

    /**
     * 发货时间 (例：2017-08-08 08:08:08)
     */
    
    private String deliveryTime;

    /**
     * 预计到货时间 (例：2017-08-08 08:08:08)
     */
    
    private String expectArriveTime;

    /**
     * 发货联系人
     */
    
    private String deliveryContacter;

    /**
     * 发货联系人电话
     */
    
    private String deliveryContacterTel;

    /**
     * 发货联系人手机
     */
    
    private String deliveryContacterMobile;

    /**
     * 发货门店编码
     */
    
    private String deliveryStoreCode;

    /**
     * 仓库编码
     */
    @Required("仓库编码 ")
    private String warehouseCode;

    /**
     * 发货门店名称
     */
    
    private String deliveryStoreName;

    /**
     * 发货国家
     */
    
    private String deliveryCountry;

    /**
     * 发货省份名称
     */
    
    private String deliveryStateName;

    /**
     * 发货城市名称
     */
    
    private String deliveryCityName;

    /**
     * 发货区域
     */
    
    private String deliveryDistrictName;

    /**
     * 发货地址
     */
    
    private String deliveryDetailAddress;

    /**
     * 业务来源
     */
    
    private String transactionSource;

    /**
     * 采购员
     */
    
    private String buyer;

    /**
     * 退货联系人
     */
    @Required("退货联系人 ")
    private String returnContacter;

    /**
     * 退货联系人电话
     */
    @Required("退货联系人电话 ")
    private String returnContacterTel;

    /**
     * 退货联系人手机
     */
    @Required("退货联系人手机 ")
    private String returnContacterMobile;

    /**
     * 退货国家
     */
    @Required("退货国家 ")
    private String returnCountry;

    /**
     * 退货省名称
     */
    @Required("退货省名称 ")
    private String returnStateName;

    // 构造函数
    public CreatePoInfo() {super();}

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

    public String getReturnCityName() {
        return returnCityName;
    }

    public void setReturnCityName(String returnCityName) {
        this.returnCityName = returnCityName;
    }

    public String getReturnDistrictName() {
        return returnDistrictName;
    }

    public void setReturnDistrictName(String returnDistrictName) {
        this.returnDistrictName = returnDistrictName;
    }

    public String getReturnDetailAddress() {
        return returnDetailAddress;
    }

    public void setReturnDetailAddress(String returnDetailAddress) {
        this.returnDetailAddress = returnDetailAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getChannel() {
        return channel;
    }

    public void setChannel(Byte channel) {
        this.channel = channel;
    }

    public Byte getIsNeedFaceCount() {
        return isNeedFaceCount;
    }

    public void setIsNeedFaceCount(Byte isNeedFaceCount) {
        this.isNeedFaceCount = isNeedFaceCount;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Byte getBoxFlag() {
        return boxFlag;
    }

    public void setBoxFlag(Byte boxFlag) {
        this.boxFlag = boxFlag;
    }

    public Byte getIsBatchStorage() {
        return isBatchStorage;
    }

    public void setIsBatchStorage(Byte isBatchStorage) {
        this.isBatchStorage = isBatchStorage;
    }

    public Byte getIsWhaleWarehouse() {
        return isWhaleWarehouse;
    }

    public void setIsWhaleWarehouse(Byte isWhaleWarehouse) {
        this.isWhaleWarehouse = isWhaleWarehouse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getExpectArriveTime() {
        return expectArriveTime;
    }

    public void setExpectArriveTime(String expectArriveTime) {
        this.expectArriveTime = expectArriveTime;
    }

    public String getDeliveryContacter() {
        return deliveryContacter;
    }

    public void setDeliveryContacter(String deliveryContacter) {
        this.deliveryContacter = deliveryContacter;
    }

    public String getDeliveryContacterTel() {
        return deliveryContacterTel;
    }

    public void setDeliveryContacterTel(String deliveryContacterTel) {
        this.deliveryContacterTel = deliveryContacterTel;
    }

    public String getDeliveryContacterMobile() {
        return deliveryContacterMobile;
    }

    public void setDeliveryContacterMobile(String deliveryContacterMobile) {
        this.deliveryContacterMobile = deliveryContacterMobile;
    }

    public String getDeliveryStoreCode() {
        return deliveryStoreCode;
    }

    public void setDeliveryStoreCode(String deliveryStoreCode) {
        this.deliveryStoreCode = deliveryStoreCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getDeliveryStoreName() {
        return deliveryStoreName;
    }

    public void setDeliveryStoreName(String deliveryStoreName) {
        this.deliveryStoreName = deliveryStoreName;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    public String getDeliveryStateName() {
        return deliveryStateName;
    }

    public void setDeliveryStateName(String deliveryStateName) {
        this.deliveryStateName = deliveryStateName;
    }

    public String getDeliveryCityName() {
        return deliveryCityName;
    }

    public void setDeliveryCityName(String deliveryCityName) {
        this.deliveryCityName = deliveryCityName;
    }

    public String getDeliveryDistrictName() {
        return deliveryDistrictName;
    }

    public void setDeliveryDistrictName(String deliveryDistrictName) {
        this.deliveryDistrictName = deliveryDistrictName;
    }

    public String getDeliveryDetailAddress() {
        return deliveryDetailAddress;
    }

    public void setDeliveryDetailAddress(String deliveryDetailAddress) {
        this.deliveryDetailAddress = deliveryDetailAddress;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(String transactionSource) {
        this.transactionSource = transactionSource;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getReturnContacter() {
        return returnContacter;
    }

    public void setReturnContacter(String returnContacter) {
        this.returnContacter = returnContacter;
    }

    public String getReturnContacterTel() {
        return returnContacterTel;
    }

    public void setReturnContacterTel(String returnContacterTel) {
        this.returnContacterTel = returnContacterTel;
    }

    public String getReturnContacterMobile() {
        return returnContacterMobile;
    }

    public void setReturnContacterMobile(String returnContacterMobile) {
        this.returnContacterMobile = returnContacterMobile;
    }

    public String getReturnCountry() {
        return returnCountry;
    }

    public void setReturnCountry(String returnCountry) {
        this.returnCountry = returnCountry;
    }

    public String getReturnStateName() {
        return returnStateName;
    }

    public void setReturnStateName(String returnStateName) {
        this.returnStateName = returnStateName;
    }

}
