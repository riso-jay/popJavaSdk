package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 调拨单信息
 */
public class TransferInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ERP调拨单号 长度小于等于50个字符
     */
    
    private String erpTransferSn;

    /**
     * 创建人
     */
    
    private String createUser;

    /**
     * 创建时间 格式(例:2019-05-29 11:11:10)
     */
    
    private String createDateTime;

    /**
     * ERP创建人
     */
    
    private String erpCreater;

    /**
     * ERP创建时间 例(2019-04-03 19:15:56)
     */
    
    private String erpCreateTime;

    /**
     * 系统调拨单号 长度小于等于50个字符
     */
    
    private String transferSn;

    /**
     * 调拨单状态 枚举(50:草稿 100:新增 101:下发中 200:已提交 300:已出仓 400:已入仓 500:已关闭 600:已取消 201:提交失败)
     */
    
    private String transferStatus;

    /**
     * 调拨类型 枚举(110:普通调拨 111:残次调拨 QDCF:调拨渠道拆分)
     */
    
    private String transferType;

    /**
     * 调拨发货仓库 长度小于等于50个字符
     */
    
    private String fromWarehouseCode;

    /**
     * 调拨收货仓库 长度小于等于50个字符
     */
    
    private String toWarehouseCode;

    /**
     * 支付方式 枚举(0:到付 1:月结)
     */
    
    private Byte payType;

    /**
     * 通知邮箱 长度小于等于100个字符
     */
    
    private String toEmail;

    /**
     * 抄送邮箱 长度小于等于100个字符
     */
    
    private String ccEmail;

    // 构造函数
    public TransferInfo() {super();}

    public String getErpTransferSn() {
        return erpTransferSn;
    }

    public void setErpTransferSn(String erpTransferSn) {
        this.erpTransferSn = erpTransferSn;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getErpCreater() {
        return erpCreater;
    }

    public void setErpCreater(String erpCreater) {
        this.erpCreater = erpCreater;
    }

    public String getErpCreateTime() {
        return erpCreateTime;
    }

    public void setErpCreateTime(String erpCreateTime) {
        this.erpCreateTime = erpCreateTime;
    }

    public String getTransferSn() {
        return transferSn;
    }

    public void setTransferSn(String transferSn) {
        this.transferSn = transferSn;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getFromWarehouseCode() {
        return fromWarehouseCode;
    }

    public void setFromWarehouseCode(String fromWarehouseCode) {
        this.fromWarehouseCode = fromWarehouseCode;
    }

    public String getToWarehouseCode() {
        return toWarehouseCode;
    }

    public void setToWarehouseCode(String toWarehouseCode) {
        this.toWarehouseCode = toWarehouseCode;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
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

}
