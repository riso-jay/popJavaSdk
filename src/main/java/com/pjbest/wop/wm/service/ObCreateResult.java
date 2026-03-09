package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 客退单创建结果
 */
public class ObCreateResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ERP客退单号
     */
    
    private String erpOrderBackSn;

    /**
     * 客退单号
     */
    
    private String orderBackSn;

    /**
     * 客户编码
     */
    
    private String customerCode;

    /**
     * 状态码[200:成功]
     */
    
    private Integer resultCode;

    /**
     * 错误提示
     */
    
    private String message;

    // 构造函数
    public ObCreateResult() {super();}

    public String getErpOrderBackSn() {
        return erpOrderBackSn;
    }

    public void setErpOrderBackSn(String erpOrderBackSn) {
        this.erpOrderBackSn = erpOrderBackSn;
    }

    public String getOrderBackSn() {
        return orderBackSn;
    }

    public void setOrderBackSn(String orderBackSn) {
        this.orderBackSn = orderBackSn;
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

}
