package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 调拨单查询条件
 */
public class TransferQueryCondition implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 系统调拨单号
     */
    
    private String transferSn;

    /**
     * 更新日期开始日期 (例：2017-08-08 08:08:08)
     */
    
    private String updatedDtmLocFrom;

    /**
     * 更新日期结束日期 (例：2017-08-09 09:09:09)
     */
    
    private String updatedDtmLocTo;

    /**
     * ERP调拨单号
     */
    
    private String erpTransferSn;

    /**
     * 调拨单状态 枚举(50:草稿 100:新增 101:下发中 200:已提交 300:已出仓 400:已入仓 500:已关闭 600:已取消 201:提交失败)
     */
    
    private String transferStatus;

    /**
     * 调拨类型 枚举(110:普通调拨 111:残次调拨)
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
     * 创建日期开始日期 (例：2017-08-08 08:08:08)
     */
    
    private String createdDtmLocFrom;

    /**
     * 创建日期结束日期 (例：2017-08-09 09:09:09)
     */
    
    private String createdDtmLocTo;

    // 构造函数
    public TransferQueryCondition() {super();}

    public String getTransferSn() {
        return transferSn;
    }

    public void setTransferSn(String transferSn) {
        this.transferSn = transferSn;
    }

    public String getUpdatedDtmLocFrom() {
        return updatedDtmLocFrom;
    }

    public void setUpdatedDtmLocFrom(String updatedDtmLocFrom) {
        this.updatedDtmLocFrom = updatedDtmLocFrom;
    }

    public String getUpdatedDtmLocTo() {
        return updatedDtmLocTo;
    }

    public void setUpdatedDtmLocTo(String updatedDtmLocTo) {
        this.updatedDtmLocTo = updatedDtmLocTo;
    }

    public String getErpTransferSn() {
        return erpTransferSn;
    }

    public void setErpTransferSn(String erpTransferSn) {
        this.erpTransferSn = erpTransferSn;
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

    public String getCreatedDtmLocFrom() {
        return createdDtmLocFrom;
    }

    public void setCreatedDtmLocFrom(String createdDtmLocFrom) {
        this.createdDtmLocFrom = createdDtmLocFrom;
    }

    public String getCreatedDtmLocTo() {
        return createdDtmLocTo;
    }

    public void setCreatedDtmLocTo(String createdDtmLocTo) {
        this.createdDtmLocTo = createdDtmLocTo;
    }

}
