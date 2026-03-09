package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取订单物流轨迹响应
 */
public class GetOrderDeliveryTraceRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功，500：失败
     */
    @Required("结果编码 200：成功，500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功，500：失败
     */
    @Required("结果子编码 200：成功，500：失败 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 轨迹记录列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.GetOrderDeliveryItem> deliveryItems;

    /**
     * 运单号
     */
    
    private String transportNo;

    /**
     * 物流公司编码
     */
    
    private String carrierCode;

    /**
     * 物流公司名称
     */
    
    private String carrierName;

    // 构造函数
    public GetOrderDeliveryTraceRespone() {super();}

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Integer getResultSubCode() {
        return resultSubCode;
    }

    public void setResultSubCode(Integer resultSubCode) {
        this.resultSubCode = resultSubCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public java.util.List<com.pjbest.wop.wm.service.GetOrderDeliveryItem> getDeliveryItems() {
        return deliveryItems;
    }

    public void setDeliveryItems(java.util.List<com.pjbest.wop.wm.service.GetOrderDeliveryItem> deliveryItems) {
        this.deliveryItems = deliveryItems;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
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

}
