package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询退供单请求
 */
public class QueryInvReturnOrderReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * 客户退供单号，clientReturnSn和returnSn必须有一个不为空
     */
    
    private String clientReturnSn;

    /**
     * 系统退供单号，clientReturnSn和returnSn必须有一个不为空
     */
    
    private String returnSn;

    // 构造函数
    public QueryInvReturnOrderReq() {super();}

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

    public String getReturnSn() {
        return returnSn;
    }

    public void setReturnSn(String returnSn) {
        this.returnSn = returnSn;
    }

}
