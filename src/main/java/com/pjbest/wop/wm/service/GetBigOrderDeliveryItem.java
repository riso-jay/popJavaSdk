package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 大订单物流轨迹记录
 */
public class GetBigOrderDeliveryItem implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 物流轨迹状态码
     */
    
    private String statusCode;

    /**
     * 物流轨迹状态名称
     */
    
    private String statusName;

    /**
     * 物流轨迹状态描述
     */
    
    private String transportDetail;

    /**
     * 物流轨迹发生时间
     */
    
    private String actionTime;

    // 构造函数
    public GetBigOrderDeliveryItem() {super();}

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTransportDetail() {
        return transportDetail;
    }

    public void setTransportDetail(String transportDetail) {
        this.transportDetail = transportDetail;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

}
