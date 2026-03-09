package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 完成事件处理请求
 */
public class FinishEventRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 事件ID（主键）
     */
    @Required("事件ID（主键） ")
    private Long id;

    /**
     * 处理备注
     */
    
    private String remark;

    /**
     * 处理状态
     */
    @Required("处理状态 ")
    private com.pjbest.wop.wm.service.HandleEventStatus eventStatus;

    // 构造函数
    public FinishEventRequest() {super();}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public com.pjbest.wop.wm.service.HandleEventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(com.pjbest.wop.wm.service.HandleEventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

}
