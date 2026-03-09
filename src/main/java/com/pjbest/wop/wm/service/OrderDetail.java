package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单明细
 */
public class OrderDetail implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品代码
     */
    
    private String itemCode;

    /**
     * 申请商品数量
     */
    
    private Integer qty;

    /**
     * 出仓商品数量
     */
    
    private Integer outQty;

    /**
     * 序列号
     */
    
    private String serialNo;

    /**
     * 客户欠货数量
     */
    
    private Integer custOweQty;

    /**
     * 客户PO号
     */
    
    private String clientPoNo;

    /**
     * 系统PO号
     */
    
    private String systemPoNo;

    // 构造函数
    public OrderDetail() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getOutQty() {
        return outQty;
    }

    public void setOutQty(Integer outQty) {
        this.outQty = outQty;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getCustOweQty() {
        return custOweQty;
    }

    public void setCustOweQty(Integer custOweQty) {
        this.custOweQty = custOweQty;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

    public String getSystemPoNo() {
        return systemPoNo;
    }

    public void setSystemPoNo(String systemPoNo) {
        this.systemPoNo = systemPoNo;
    }

}
