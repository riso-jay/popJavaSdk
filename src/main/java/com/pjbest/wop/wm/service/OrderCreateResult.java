package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单创建结果
 */
public class OrderCreateResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ERP订单号
     */
    
    private String erpOrderSn;

    /**
     * 客户编码
     */
    
    private String customerCode;

    /**
     * 状态码
     */
    
    private Integer resultCode;

    /**
     * 错误提示
     */
    
    private String message;

    /**
     * 唯品物流ERP订单号
     */
    
    private String wopErpOrderSn;

    // 构造函数
    public OrderCreateResult() {super();}

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWopErpOrderSn() {
        return wopErpOrderSn;
    }

    public void setWopErpOrderSn(String wopErpOrderSn) {
        this.wopErpOrderSn = wopErpOrderSn;
    }

}
