package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 取消大订单请求
 */
public class CancelBigOrderRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * ERP订单号
     */
    @Required("ERP订单号 ")
    private String erpOrderSn;

    // 构造函数
    public CancelBigOrderRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

}
