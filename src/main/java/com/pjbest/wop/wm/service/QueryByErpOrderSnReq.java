package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单状态
 */
public class QueryByErpOrderSnReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * erp订单号
     */
    @Required("erp订单号 ")
    private String erpOrderSn;

    /**
     * 客退单类型(0-拒收 1-退货)
     */
    
    private Byte orderBackType;

    // 构造函数
    public QueryByErpOrderSnReq() {super();}

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public Byte getOrderBackType() {
        return orderBackType;
    }

    public void setOrderBackType(Byte orderBackType) {
        this.orderBackType = orderBackType;
    }

}
