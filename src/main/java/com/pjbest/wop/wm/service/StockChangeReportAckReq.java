package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存异动确认查询对象
 */
public class StockChangeReportAckReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * WOP货主编码
     */
    
    private String customerCode;

    /**
     * 库存异动确认明细对象
     */
    
    private java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck> stockchangeReportAcks;

    /**
     * 单据类型
     */
    
    private String bizType;

    /**
     * 虚拟货主客户编码
     */
    
    private String virtualClientCode;

    // 构造函数
    public StockChangeReportAckReq() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck> getStockchangeReportAcks() {
        return stockchangeReportAcks;
    }

    public void setStockchangeReportAcks(java.util.List<com.pjbest.wop.wm.service.StockchangeReportAck> stockchangeReportAcks) {
        this.stockchangeReportAcks = stockchangeReportAcks;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getVirtualClientCode() {
        return virtualClientCode;
    }

    public void setVirtualClientCode(String virtualClientCode) {
        this.virtualClientCode = virtualClientCode;
    }

}
