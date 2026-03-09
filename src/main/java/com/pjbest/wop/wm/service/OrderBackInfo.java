package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 客退单信息
 */
public class OrderBackInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ERP客退单号
     */
    @Required("ERP客退单号 ")
    private String erpOrderBackSn;

    /**
     * 退货方式
     */
    
    private String returnMethod;

    /**
     * 特殊客退(0非特殊客退 1特殊客退)
     */
    
    private Byte isSpecialReturn;

    /**
     * 客退单类型(0-拒收 1-退货)
     */
    @Required("客退单类型(0-拒收 1-退货) ")
    private Byte orderBackType;

    /**
     * 是否客退黑名单(0否 1是)
     */
    
    private Byte isBlackUser;

    /**
     * 订单类型(0 一般订单)
     */
    
    private Byte orderType;

    /**
     * 运费到付标识(0：现付【向会员收取运费】 1：到付【公司负责运费】(揽退项目))
     */
    
    private Byte returnsPayType;

    /**
     * 预约上门揽件时间(2015-04-09)
     */
    
    private String goGetReturnTime;

    /**
     * 退款方式(1 - 不是(默认值))
     */
    
    private Byte returnFastType;

    /**
     * 客退申请回寄补充
     */
    
    private String transportRemark;

    /**
     * 退货人姓名
     */
    
    private String bkUser;

    /**
     * erp订单号
     */
    @Required("erp订单号 ")
    private String erpOrderSn;

    /**
     * 退货人手机号码
     */
    
    private String bkUserMobie;

    /**
     * 退货人固定电话
     */
    
    private String bkUserTel;

    /**
     * 退货人国家
     */
    
    private String bkUserCountry;

    /**
     * 退货人省名称
     */
    
    private String bkUserStateName;

    /**
     * null
     */
    
    private String bkUserStateCode;

    /**
     * 退货人市
     */
    
    private String bkUserCityName;

    /**
     * null
     */
    
    private String bkCityCode;

    /**
     * 退货人区
     */
    
    private String bkDistrictName;

    /**
     * 退货人区编码
     */
    
    private String bkDistrictCode;

    /**
     * 退货人乡镇/街道
     */
    
    private String bkTownName;

    /**
     * 收货仓
     */
    @Required("收货仓 ")
    private String revcWarehouse;

    /**
     * 退货人乡镇/街道编码
     */
    
    private String bkTownCode;

    /**
     * 退货人详细地址
     */
    
    private String bkDetailAddress;

    /**
     * 邮政编码
     */
    
    private String zipCode;

    /**
     * 客退单明细
     */
    
    private java.util.List<com.pjbest.wop.wm.service.OrderDetailInfo> orderDetailInfos;

    /**
     * 备注
     */
    
    private String remark;

    /**
     * 退货原因
     */
    @Required("退货原因 ")
    private String returnReason;

    /**
     * 运单号
     */
    
    private String transportNo;

    /**
     * 承运商编码
     */
    
    private String carrierCode;

    /**
     * 承运商名称
     */
    
    private String carrierName;

    /**
     * 退款方式
     */
    
    private String returnType;

    // 构造函数
    public OrderBackInfo() {super();}

    public String getErpOrderBackSn() {
        return erpOrderBackSn;
    }

    public void setErpOrderBackSn(String erpOrderBackSn) {
        this.erpOrderBackSn = erpOrderBackSn;
    }

    public String getReturnMethod() {
        return returnMethod;
    }

    public void setReturnMethod(String returnMethod) {
        this.returnMethod = returnMethod;
    }

    public Byte getIsSpecialReturn() {
        return isSpecialReturn;
    }

    public void setIsSpecialReturn(Byte isSpecialReturn) {
        this.isSpecialReturn = isSpecialReturn;
    }

    public Byte getOrderBackType() {
        return orderBackType;
    }

    public void setOrderBackType(Byte orderBackType) {
        this.orderBackType = orderBackType;
    }

    public Byte getIsBlackUser() {
        return isBlackUser;
    }

    public void setIsBlackUser(Byte isBlackUser) {
        this.isBlackUser = isBlackUser;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getReturnsPayType() {
        return returnsPayType;
    }

    public void setReturnsPayType(Byte returnsPayType) {
        this.returnsPayType = returnsPayType;
    }

    public String getGoGetReturnTime() {
        return goGetReturnTime;
    }

    public void setGoGetReturnTime(String goGetReturnTime) {
        this.goGetReturnTime = goGetReturnTime;
    }

    public Byte getReturnFastType() {
        return returnFastType;
    }

    public void setReturnFastType(Byte returnFastType) {
        this.returnFastType = returnFastType;
    }

    public String getTransportRemark() {
        return transportRemark;
    }

    public void setTransportRemark(String transportRemark) {
        this.transportRemark = transportRemark;
    }

    public String getBkUser() {
        return bkUser;
    }

    public void setBkUser(String bkUser) {
        this.bkUser = bkUser;
    }

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public String getBkUserMobie() {
        return bkUserMobie;
    }

    public void setBkUserMobie(String bkUserMobie) {
        this.bkUserMobie = bkUserMobie;
    }

    public String getBkUserTel() {
        return bkUserTel;
    }

    public void setBkUserTel(String bkUserTel) {
        this.bkUserTel = bkUserTel;
    }

    public String getBkUserCountry() {
        return bkUserCountry;
    }

    public void setBkUserCountry(String bkUserCountry) {
        this.bkUserCountry = bkUserCountry;
    }

    public String getBkUserStateName() {
        return bkUserStateName;
    }

    public void setBkUserStateName(String bkUserStateName) {
        this.bkUserStateName = bkUserStateName;
    }

    public String getBkUserStateCode() {
        return bkUserStateCode;
    }

    public void setBkUserStateCode(String bkUserStateCode) {
        this.bkUserStateCode = bkUserStateCode;
    }

    public String getBkUserCityName() {
        return bkUserCityName;
    }

    public void setBkUserCityName(String bkUserCityName) {
        this.bkUserCityName = bkUserCityName;
    }

    public String getBkCityCode() {
        return bkCityCode;
    }

    public void setBkCityCode(String bkCityCode) {
        this.bkCityCode = bkCityCode;
    }

    public String getBkDistrictName() {
        return bkDistrictName;
    }

    public void setBkDistrictName(String bkDistrictName) {
        this.bkDistrictName = bkDistrictName;
    }

    public String getBkDistrictCode() {
        return bkDistrictCode;
    }

    public void setBkDistrictCode(String bkDistrictCode) {
        this.bkDistrictCode = bkDistrictCode;
    }

    public String getBkTownName() {
        return bkTownName;
    }

    public void setBkTownName(String bkTownName) {
        this.bkTownName = bkTownName;
    }

    public String getRevcWarehouse() {
        return revcWarehouse;
    }

    public void setRevcWarehouse(String revcWarehouse) {
        this.revcWarehouse = revcWarehouse;
    }

    public String getBkTownCode() {
        return bkTownCode;
    }

    public void setBkTownCode(String bkTownCode) {
        this.bkTownCode = bkTownCode;
    }

    public String getBkDetailAddress() {
        return bkDetailAddress;
    }

    public void setBkDetailAddress(String bkDetailAddress) {
        this.bkDetailAddress = bkDetailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public java.util.List<com.pjbest.wop.wm.service.OrderDetailInfo> getOrderDetailInfos() {
        return orderDetailInfos;
    }

    public void setOrderDetailInfos(java.util.List<com.pjbest.wop.wm.service.OrderDetailInfo> orderDetailInfos) {
        this.orderDetailInfos = orderDetailInfos;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
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

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

}
