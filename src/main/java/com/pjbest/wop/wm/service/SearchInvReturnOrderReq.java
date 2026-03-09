package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 退供单分页查询请求
 */
public class SearchInvReturnOrderReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * 每页的记录数
     */
    @Required("每页的记录数 ")
    private Integer pageSize;

    /**
     * 更新日期开始时间 (例：2017-08-08 08:08:08)，客户退供单号和系统退供单号都为空时，创建日期范围和更新日期范围必填一个；日期范围不能超过30天
     */
    
    private String updatedDtmLocFrom;

    /**
     * 更新日期结束时间 (例：2017-08-09 09:09:09)
     */
    
    private String updatedDtmLocTo;

    /**
     * 客户退供单号
     */
    
    private String clientReturnSn;

    /**
     * 系统退供单号
     */
    
    private String returnSn;

    /**
     * 退供类型：110正常退供，111残次退供，112过期退供，113入库凭证退供
     */
    
    private com.pjbest.wop.wm.service.InventroyReturnReturnType returnType;

    /**
     * 发货仓码
     */
    
    private String warehouse;

    /**
     * 退供单状态
     */
    
    private com.pjbest.wop.wm.service.InventroyReturnReturnStatus status;

    /**
     * 创建日期开始时间 (例：2017-08-08 08:08:08)，客户退供单号和系统退供单号都为空时，创建日期范围和更新日期范围必填一个；日期范围不能超过30天
     */
    
    private String createdDtmLocFrom;

    /**
     * 创建日期结束时间 (例：2017-08-09 09:09:09)
     */
    
    private String createdDtmLocTo;

    /**
     * 页码
     */
    @Required("页码 ")
    private Integer pageNum;

    // 构造函数
    public SearchInvReturnOrderReq() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUpdatedDtmLocFrom() {
        return updatedDtmLocFrom;
    }

    public void setUpdatedDtmLocFrom(String updatedDtmLocFrom) {
        this.updatedDtmLocFrom = updatedDtmLocFrom;
    }

    public String getUpdatedDtmLocTo() {
        return updatedDtmLocTo;
    }

    public void setUpdatedDtmLocTo(String updatedDtmLocTo) {
        this.updatedDtmLocTo = updatedDtmLocTo;
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

    public com.pjbest.wop.wm.service.InventroyReturnReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(com.pjbest.wop.wm.service.InventroyReturnReturnType returnType) {
        this.returnType = returnType;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public com.pjbest.wop.wm.service.InventroyReturnReturnStatus getStatus() {
        return status;
    }

    public void setStatus(com.pjbest.wop.wm.service.InventroyReturnReturnStatus status) {
        this.status = status;
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
