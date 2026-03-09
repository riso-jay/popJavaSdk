package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单状态
 */
public class OrderStatus implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 当前记录自增ID
     */
    
    private Long id;

    /**
     * 唯品物流订单号
     */
    
    private String odsOrderSn;

    /**
     * 处理时间
     */
    
    private String actionTime;

    /**
     * 原始供应商承运商编码
     */
    
    private String wpCode;

    /**
     * 原始供应商承运商名称
     */
    
    private String wpCodeName;

    /**
     * ERP订单号
     */
    
    private String erpOrderSn;

    /**
     * 运单号
     */
    
    private String transportNo;

    /**
     * 承运商编码
     */
    
    private String carriersCode;

    /**
     * 订单状态编码
     */
    
    private Integer orderStatusCode;

    /**
     * 订单状态名称
     */
    
    private String orderStatusName;

    /**
     * 发货仓编码
     */
    
    private String warehouseCode;

    /**
     * 发货仓名称
     */
    
    private String warehouseName;

    /**
     * 唯品物流ERP订单号
     */
    
    private String wopErpOrderSn;

    // 构造函数
    public OrderStatus() {super();}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOdsOrderSn() {
        return odsOrderSn;
    }

    public void setOdsOrderSn(String odsOrderSn) {
        this.odsOrderSn = odsOrderSn;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getWpCode() {
        return wpCode;
    }

    public void setWpCode(String wpCode) {
        this.wpCode = wpCode;
    }

    public String getWpCodeName() {
        return wpCodeName;
    }

    public void setWpCodeName(String wpCodeName) {
        this.wpCodeName = wpCodeName;
    }

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

    public String getCarriersCode() {
        return carriersCode;
    }

    public void setCarriersCode(String carriersCode) {
        this.carriersCode = carriersCode;
    }

    public Integer getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(Integer orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWopErpOrderSn() {
        return wopErpOrderSn;
    }

    public void setWopErpOrderSn(String wopErpOrderSn) {
        this.wopErpOrderSn = wopErpOrderSn;
    }

}
