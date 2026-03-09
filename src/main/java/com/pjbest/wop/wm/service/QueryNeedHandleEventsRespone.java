package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询待处理订单事件列表响应
 */
public class QueryNeedHandleEventsRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功,500：失败,batchSize 过大
     */
    @Required("结果子编码 200：成功,500：失败,batchSize 过大 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 订单事件列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.WopOrderEventModel> events;

    // 构造函数
    public QueryNeedHandleEventsRespone() {super();}

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

    public java.util.List<com.pjbest.wop.wm.service.WopOrderEventModel> getEvents() {
        return events;
    }

    public void setEvents(java.util.List<com.pjbest.wop.wm.service.WopOrderEventModel> events) {
        this.events = events;
    }

}
