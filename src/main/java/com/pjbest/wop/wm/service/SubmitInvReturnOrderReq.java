package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 提交退供单请求
 */
public class SubmitInvReturnOrderReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * 客户退供单号
     */
    @Required("客户退供单号 ")
    private String clientReturnSn;

    // 构造函数
    public SubmitInvReturnOrderReq() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getClientReturnSn() {
        return clientReturnSn;
    }

    public void setClientReturnSn(String clientReturnSn) {
        this.clientReturnSn = clientReturnSn;
    }

}
