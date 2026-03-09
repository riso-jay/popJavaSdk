package com.vip.hermes.core.health;

import com.vip.pop.base.annotation.Required;

/**
 * 包含服务状态和详细信息
 */
public class CheckResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 服务状态
     */
    
    private com.vip.hermes.core.health.Status status;

    /**
     * 详细信息
     */
    
    private String details;

    // 构造函数
    public CheckResult() {super();}

    public com.vip.hermes.core.health.Status getStatus() {
        return status;
    }

    public void setStatus(com.vip.hermes.core.health.Status status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
