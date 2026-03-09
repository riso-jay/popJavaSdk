package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询在库序列号（追踪ID）请求
 */
public class QueryTrackingIdsRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 单据号
     */
    @Required("单据号 ")
    private String orderSn;

    /**
     * 商品编码
     */
    
    private String sizeSn;

    /**
     * 页码
     */
    @Required("页码 ")
    private Integer pageNo;

    /**
     * 每页记录数
     */
    @Required("每页记录数 ")
    private Integer pageSize;

    // 构造函数
    public QueryTrackingIdsRequest() {super();}

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getSizeSn() {
        return sizeSn;
    }

    public void setSizeSn(String sizeSn) {
        this.sizeSn = sizeSn;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
