package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建调拨单信息
 */
public class CreateTransferInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ERP调拨单号 长度小于等于50个字符
     */
    @Required("ERP调拨单号 长度小于等于50个字符 ")
    private String erpTransferSn;

    /**
     * 调拨类型 枚举(110:普通调拨 111:残次调拨 QDCF:调拨渠道拆分)
     */
    @Required("调拨类型 枚举(110:普通调拨 111:残次调拨 QDCF:调拨渠道拆分) ")
    private String transferType;

    /**
     * 调拨发货仓库 长度小于等于50个字符
     */
    @Required("调拨发货仓库 长度小于等于50个字符 ")
    private String fromWarehouseCode;

    /**
     * 调拨收货仓库 长度小于等于50个字符
     */
    @Required("调拨收货仓库 长度小于等于50个字符 ")
    private String toWarehouseCode;

    /**
     * 支付方式 枚举(0:到付 1:月结)
     */
    @Required("支付方式 枚举(0:到付 1:月结) ")
    private Byte payType;

    /**
     * 通知邮箱 长度小于等于100个字符
     */
    @Required("通知邮箱 长度小于等于100个字符 ")
    private String toEmail;

    /**
     * 抄送邮箱 长度小于等于100个字符
     */
    
    private String ccEmail;

    /**
     * ERP创建人
     */
    @Required("ERP创建人 ")
    private String erpCreater;

    /**
     * ERP创建时间 例(2019-04-03 19:15:56)
     */
    
    private String erpCreateTime;

    // 构造函数
    public CreateTransferInfo() {super();}

    public String getErpTransferSn() {
        return erpTransferSn;
    }

    public void setErpTransferSn(String erpTransferSn) {
        this.erpTransferSn = erpTransferSn;
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

}
