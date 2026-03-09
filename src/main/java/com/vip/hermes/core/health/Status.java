package com.vip.hermes.core.health;

import com.vip.pop.base.annotation.Required;

/**
 * 健康状态，包含状态码和描述
 */
public class Status implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    
    private String code;

    /**
     * 描述
     */
    
    private String description;

    // 构造函数
    public Status() {super();}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
