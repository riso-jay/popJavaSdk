package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单缺货拉取确认请求
 */
public class OrderLackConfirmRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 货主编码
     */
    @Required("货主编码 ")
    private String customerCode;

    /**
     * 订单缺货唯一标记ID
     */
    @Required("订单缺货唯一标记ID ")
    private Long id;

    /**
     * 推送是否成功
     */
    
    private Boolean success;

    /**
     * 备注
     */
    
    private String remark;

    // 构造函数
    public OrderLackConfirmRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
