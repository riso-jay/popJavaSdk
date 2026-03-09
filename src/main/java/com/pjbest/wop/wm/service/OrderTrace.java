package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单轨迹
 */
public class OrderTrace implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 当前记录自增ID
     */
    
    private Long id;

    /**
     * 唯品物流ERP订单号
     */
    
    private String wopErpOrderSn;

    /**
     * ERP订单号
     */
    
    private String erpOrderSn;

    /**
     * 运单号
     */
    
    private String transportNo;

    /**
     * 物流状态编码
     */
    
    private String transportCode;

    /**
     * 物流状态信息
     */
    
    private String transportDetail;

    /**
     * 承运商编码
     */
    
    private String carriersCode;

    /**
     * 承运商名称称
     */
    
    private String carriersName;

    /**
     * 发货仓编码
     */
    
    private String warehouseCode;

    /**
     * 状态发生时间
     */
    
    private String actionTime;

    // 构造函数
    public OrderTrace() {super();}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWopErpOrderSn() {
        return wopErpOrderSn;
    }

    public void setWopErpOrderSn(String wopErpOrderSn) {
        this.wopErpOrderSn = wopErpOrderSn;
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

    public String getTransportCode() {
        return transportCode;
    }

    public void setTransportCode(String transportCode) {
        this.transportCode = transportCode;
    }

    public String getTransportDetail() {
        return transportDetail;
    }

    public void setTransportDetail(String transportDetail) {
        this.transportDetail = transportDetail;
    }

    public String getCarriersCode() {
        return carriersCode;
    }

    public void setCarriersCode(String carriersCode) {
        this.carriersCode = carriersCode;
    }

    public String getCarriersName() {
        return carriersName;
    }

    public void setCarriersName(String carriersName) {
        this.carriersName = carriersName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

}
