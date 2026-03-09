package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取订单缺货请求
 */
public class GetOrderLackByMaxIdRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 货主编码
     */
    @Required("货主编码 ")
    private String customerCode;

    /**
     * maxId
     */
    @Required("maxId ")
    private Long maxId;

    /**
     * 请求返回数据条数限制
     */
    @Required("请求返回数据条数限制 ")
    private Integer rowLimit;

    // 构造函数
    public GetOrderLackByMaxIdRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Integer getRowLimit() {
        return rowLimit;
    }

    public void setRowLimit(Integer rowLimit) {
        this.rowLimit = rowLimit;
    }

}
