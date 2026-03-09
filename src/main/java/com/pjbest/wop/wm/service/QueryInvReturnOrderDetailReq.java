package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 退供单明细查询请求
 */
public class QueryInvReturnOrderDetailReq implements java.io.Serializable{
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
     * 系统退供单号，clientReturnSn和returnSn必须有一个不为空
     */
    
    private String returnSn;

    /**
     * 系统退供单号集合
     */
    
    private java.util.List<String> returnSnList;

    /**
     * 客户退供单号集合
     */
    
    private java.util.List<String> clientReturnSnList;

    // 构造函数
    public QueryInvReturnOrderDetailReq() {super();}

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

    public String getReturnSn() {
        return returnSn;
    }

    public void setReturnSn(String returnSn) {
        this.returnSn = returnSn;
    }

    public java.util.List<String> getReturnSnList() {
        return returnSnList;
    }

    public void setReturnSnList(java.util.List<String> returnSnList) {
        this.returnSnList = returnSnList;
    }

    public java.util.List<String> getClientReturnSnList() {
        return clientReturnSnList;
    }

    public void setClientReturnSnList(java.util.List<String> clientReturnSnList) {
        this.clientReturnSnList = clientReturnSnList;
    }

}
