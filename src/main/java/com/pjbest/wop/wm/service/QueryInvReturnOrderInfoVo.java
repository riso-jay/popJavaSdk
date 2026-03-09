package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询退供单信息返回结果实体
 */
public class QueryInvReturnOrderInfoVo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 货主编码
     */
    @Required("货主编码 ")
    private String customerCode;

    /**
     * 退供收货邮政编码
     */
    
    private String postcode;

    /**
     * 退供收货省/州
     */
    
    private String state;

    /**
     * 退供收货城市
     */
    
    private String city;

    /**
     * 退供收货区/县
     */
    
    private String region;

    /**
     * 退供收货乡镇/街道
     */
    
    private String town;

    /**
     * 退供收货详细地址
     */
    
    private String address;

    /**
     * 通知邮箱
     */
    
    private String toEmail;

    /**
     * 抄送邮箱
     */
    
    private String ccEmail;

    /**
     * 退供单状态
     */
    
    private Integer status;

    /**
     * WOP退供单号
     */
    
    private String erpReturnSn;

    /**
     * 客户退供单号
     */
    @Required("客户退供单号 ")
    private String clientReturnSn;

    /**
     * 出仓时间
     */
    
    private Long outTime;

    /**
     * 总箱数
     */
    
    private Integer totalBoxNum;

    /**
     * 箱号
     */
    
    private String boxId;

    /**
     * 退供收货仓码
     */
    
    private String refundToWarehouse;

    /**
     * 运单号
     */
    
    private String transportNo;

    /**
     * 创建时间
     */
    
    private Long createdDtmLoc;

    /**
     * 退供类型：110正常退供，111残次退供，112过期退供，113入库凭证退供
     */
    
    private com.pjbest.wop.wm.service.InventroyReturnReturnType returnType;

    /**
     * 退供发货仓
     */
    
    private String warehouse;

    /**
     * 退供方式：1、自提；2、退供应商；3、增值服务；4、报废；5、暂存转上线
     */
    
    private com.pjbest.wop.wm.service.InventroyReturnReturnMode returnMode;

    /**
     * 支付方式:0-到付，1-月结
     */
    
    private com.pjbest.wop.wm.service.InventroyReturnPayType payType;

    /**
     * 退供收货人
     */
    
    private String consignee;

    /**
     * 退供收货人电话
     */
    
    private String telephone;

    /**
     * 退供收货人手机
     */
    
    private String mobile;

    // 构造函数
    public QueryInvReturnOrderInfoVo() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErpReturnSn() {
        return erpReturnSn;
    }

    public void setErpReturnSn(String erpReturnSn) {
        this.erpReturnSn = erpReturnSn;
    }

    public String getClientReturnSn() {
        return clientReturnSn;
    }

    public void setClientReturnSn(String clientReturnSn) {
        this.clientReturnSn = clientReturnSn;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    public Integer getTotalBoxNum() {
        return totalBoxNum;
    }

    public void setTotalBoxNum(Integer totalBoxNum) {
        this.totalBoxNum = totalBoxNum;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getRefundToWarehouse() {
        return refundToWarehouse;
    }

    public void setRefundToWarehouse(String refundToWarehouse) {
        this.refundToWarehouse = refundToWarehouse;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

    public Long getCreatedDtmLoc() {
        return createdDtmLoc;
    }

    public void setCreatedDtmLoc(Long createdDtmLoc) {
        this.createdDtmLoc = createdDtmLoc;
    }

    public com.pjbest.wop.wm.service.InventroyReturnReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(com.pjbest.wop.wm.service.InventroyReturnReturnType returnType) {
        this.returnType = returnType;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public com.pjbest.wop.wm.service.InventroyReturnReturnMode getReturnMode() {
        return returnMode;
    }

    public void setReturnMode(com.pjbest.wop.wm.service.InventroyReturnReturnMode returnMode) {
        this.returnMode = returnMode;
    }

    public com.pjbest.wop.wm.service.InventroyReturnPayType getPayType() {
        return payType;
    }

    public void setPayType(com.pjbest.wop.wm.service.InventroyReturnPayType payType) {
        this.payType = payType;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
