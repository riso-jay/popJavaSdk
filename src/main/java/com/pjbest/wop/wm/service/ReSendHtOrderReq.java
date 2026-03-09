package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 重推海淘订单请求
 */
public class ReSendHtOrderReq implements java.io.Serializable{
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

    /**
     * 订购人姓名
     */
    
    private String subscriberName;

    /**
     * 订购人身份证号码
     */
    
    private String subscriberIdcard;

    // 构造函数
    public ReSendHtOrderReq() {super();}

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

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberIdcard() {
        return subscriberIdcard;
    }

    public void setSubscriberIdcard(String subscriberIdcard) {
        this.subscriberIdcard = subscriberIdcard;
    }

}
