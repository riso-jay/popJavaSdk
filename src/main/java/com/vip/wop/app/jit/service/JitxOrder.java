package com.vip.wop.app.jit.service;

import com.vip.pop.base.annotation.Required;

/**
 * 云仓JITX订单头
 */
public class JitxOrder implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
    
    private String crmCustCode;

    /**
     * 发货仓
     */
    
    private String warehouse;

    /**
     * 订单件数
     */
    
    private Long totalQty;

    /**
     * 订单出仓数量
     */
    
    private Long totalOutQty;

    /**
     * 出仓时间，毫秒
     */
    
    private Long outTime;

    /**
     * 创建时间，毫秒
     */
    
    private Long createdDtmLoc;

    /**
     * 更新时间，毫秒
     */
    
    private Long updatedDtmLoc;

    /**
     * 供应商名称
     */
    
    private String crmCustName;

    /**
     * 云仓订单号
     */
    
    private String odsOrderSn;

    /**
     * 唯品订单号
     */
    
    private String platformOrderSn;

    /**
     * 云仓ERP订单号
     */
    
    private String wopErpOrderSn;

    /**
     * 订单状态，100：新增，101：下单中，102：下单失败，200：已下单，300：拣货中，301：已打包，400：已出仓，500：配送中，501：已签收，502：已拒收，600：已取消，900：已关闭
     */
    
    private Integer orderStatus;

    /**
     * 承运商编码
     */
    
    private String carrierCode;

    /**
     * 承运商名称
     */
    
    private String carrierName;

    /**
     * 运单号
     */
    
    private String transportNo;

    // 构造函数
    public JitxOrder() {super();}

    public String getCrmCustCode() {
        return crmCustCode;
    }

    public void setCrmCustCode(String crmCustCode) {
        this.crmCustCode = crmCustCode;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Long getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Long totalQty) {
        this.totalQty = totalQty;
    }

    public Long getTotalOutQty() {
        return totalOutQty;
    }

    public void setTotalOutQty(Long totalOutQty) {
        this.totalOutQty = totalOutQty;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    public Long getCreatedDtmLoc() {
        return createdDtmLoc;
    }

    public void setCreatedDtmLoc(Long createdDtmLoc) {
        this.createdDtmLoc = createdDtmLoc;
    }

    public Long getUpdatedDtmLoc() {
        return updatedDtmLoc;
    }

    public void setUpdatedDtmLoc(Long updatedDtmLoc) {
        this.updatedDtmLoc = updatedDtmLoc;
    }

    public String getCrmCustName() {
        return crmCustName;
    }

    public void setCrmCustName(String crmCustName) {
        this.crmCustName = crmCustName;
    }

    public String getOdsOrderSn() {
        return odsOrderSn;
    }

    public void setOdsOrderSn(String odsOrderSn) {
        this.odsOrderSn = odsOrderSn;
    }

    public String getPlatformOrderSn() {
        return platformOrderSn;
    }

    public void setPlatformOrderSn(String platformOrderSn) {
        this.platformOrderSn = platformOrderSn;
    }

    public String getWopErpOrderSn() {
        return wopErpOrderSn;
    }

    public void setWopErpOrderSn(String wopErpOrderSn) {
        this.wopErpOrderSn = wopErpOrderSn;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

}
