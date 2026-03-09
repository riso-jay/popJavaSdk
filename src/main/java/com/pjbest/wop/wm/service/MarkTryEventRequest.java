package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 累加事件处理次数请求
 */
public class MarkTryEventRequest implements java.io.Serializable{
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

    // 构造函数
    public MarkTryEventRequest() {super();}

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

}
