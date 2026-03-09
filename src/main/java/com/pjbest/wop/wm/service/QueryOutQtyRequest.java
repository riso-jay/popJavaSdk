package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询订单出仓数量（带PO）请求
 */
public class QueryOutQtyRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 货主编码
     */
    @Required("货主编码 ")
    private String customerCode;

    /**
     * ODS订单号
     */
    @Required("ODS订单号 ")
    private String odsOrderSn;

    // 构造函数
    public QueryOutQtyRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getOdsOrderSn() {
        return odsOrderSn;
    }

    public void setOdsOrderSn(String odsOrderSn) {
        this.odsOrderSn = odsOrderSn;
    }

}
