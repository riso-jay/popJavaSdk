package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 关闭PO接口请求参数
 */
public class ClosePoRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * PO编号
     */
    @Required("PO编号 ")
    private String poNo;

    /**
     * PO实收数量
     */
    
    private Integer actualReceiveQty;

    // 构造函数
    public ClosePoRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public Integer getActualReceiveQty() {
        return actualReceiveQty;
    }

    public void setActualReceiveQty(Integer actualReceiveQty) {
        this.actualReceiveQty = actualReceiveQty;
    }

}
