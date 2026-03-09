package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 客退单查询请求
 */
public class SearchOrderBackRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * 更新日期结束时间 (例：2017-08-09 09:09:09)
     */
    
    private String updatedDtmLocTo;

    /**
     * 客退单号
     */
    
    private String orderBackSn;

    /**
     * 来源系统
     */
    @Required("来源系统 ")
    private String systemSource;

    /**
     * 状态
     */
    
    private String status;

    /**
     * 页码
     */
    @Required("页码 ")
    private Integer pageNum;

    /**
     * 每页的记录数
     */
    @Required("每页的记录数 ")
    private Integer pageSize;

    /**
     * 创建日期开始时间 (例：2017-08-08 08:08:08)，客退单号为空时，需要提供创建日期范围或更新日期范围；日期范围不能超过30天
     */
    
    private String createdDtmLocFrom;

    /**
     * 创建日期结束时间 (例：2017-08-09 09:09:09)
     */
    
    private String createdDtmLocTo;

    /**
     * 更新日期开始时间 (例：2017-08-08 08:08:08)，客退单号为空时，需要提供创建日期范围或更新日期范围；日期范围不能超过30天
     */
    
    private String updatedDtmLocFrom;

    // 构造函数
    public SearchOrderBackRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getUpdatedDtmLocTo() {
        return updatedDtmLocTo;
    }

    public void setUpdatedDtmLocTo(String updatedDtmLocTo) {
        this.updatedDtmLocTo = updatedDtmLocTo;
    }

    public String getOrderBackSn() {
        return orderBackSn;
    }

    public void setOrderBackSn(String orderBackSn) {
        this.orderBackSn = orderBackSn;
    }

    public String getSystemSource() {
        return systemSource;
    }

    public void setSystemSource(String systemSource) {
        this.systemSource = systemSource;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCreatedDtmLocFrom() {
        return createdDtmLocFrom;
    }

    public void setCreatedDtmLocFrom(String createdDtmLocFrom) {
        this.createdDtmLocFrom = createdDtmLocFrom;
    }

    public String getCreatedDtmLocTo() {
        return createdDtmLocTo;
    }

    public void setCreatedDtmLocTo(String createdDtmLocTo) {
        this.createdDtmLocTo = createdDtmLocTo;
    }

    public String getUpdatedDtmLocFrom() {
        return updatedDtmLocFrom;
    }

    public void setUpdatedDtmLocFrom(String updatedDtmLocFrom) {
        this.updatedDtmLocFrom = updatedDtmLocFrom;
    }

}
