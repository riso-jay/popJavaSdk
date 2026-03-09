package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存异动Res
 */
public class StockchangeReportRes implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * currentPage
     */
    
    private String currentPage;

    /**
     * totalPage
     */
    
    private String totalPage;

    /**
     * warehouseCode
     */
    
    private String warehouseCode;

    /**
     * 虚拟货主客户编码
     */
    
    private String virtualClientCode;

    /**
     * extendProps
     */
    
    private String extendProps;

    /**
     * items
     */
    
    private java.util.List<com.pjbest.wop.wm.service.StockchangeReportItem> items;

    /**
     * orderCode
     */
    
    private String orderCode;

    /**
     * orderType
     */
    
    private String orderType;

    /**
     * ownerCode
     */
    
    private String ownerCode;

    /**
     * pageSize
     */
    
    private String pageSize;

    /**
     * remark
     */
    
    private String remark;

    /**
     * snList
     */
    
    private java.util.List<com.pjbest.wop.wm.service.StockchangeReportSnList> snList;

    // 构造函数
    public StockchangeReportRes() {super();}

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getVirtualClientCode() {
        return virtualClientCode;
    }

    public void setVirtualClientCode(String virtualClientCode) {
        this.virtualClientCode = virtualClientCode;
    }

    public String getExtendProps() {
        return extendProps;
    }

    public void setExtendProps(String extendProps) {
        this.extendProps = extendProps;
    }

    public java.util.List<com.pjbest.wop.wm.service.StockchangeReportItem> getItems() {
        return items;
    }

    public void setItems(java.util.List<com.pjbest.wop.wm.service.StockchangeReportItem> items) {
        this.items = items;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public java.util.List<com.pjbest.wop.wm.service.StockchangeReportSnList> getSnList() {
        return snList;
    }

    public void setSnList(java.util.List<com.pjbest.wop.wm.service.StockchangeReportSnList> snList) {
        this.snList = snList;
    }

}
