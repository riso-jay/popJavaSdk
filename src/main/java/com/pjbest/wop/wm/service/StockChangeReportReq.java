package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存异动查询对象
 */
public class StockChangeReportReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * WOP货主编码
     */
    
    private String customerCode;

    /**
     * 分页数
     */
    @Required("分页数 ")
    private Integer pageNum;

    /**
     * 分页数量
     */
    @Required("分页数量 ")
    private Integer pageSize;

    /**
     * 处理类型
     */
    
    private String bizType;

    /**
     * 虚拟
     */
    
    private String virtualClientCode;

    // 构造函数
    public StockChangeReportReq() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getVirtualClientCode() {
        return virtualClientCode;
    }

    public void setVirtualClientCode(String virtualClientCode) {
        this.virtualClientCode = virtualClientCode;
    }

}
