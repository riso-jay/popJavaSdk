package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 重置订单事件为未处理请求
 */
public class ResetEventRequest implements java.io.Serializable{
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
    public ResetEventRequest() {super();}

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
