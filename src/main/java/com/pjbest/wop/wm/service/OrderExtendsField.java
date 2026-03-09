package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单扩展字段(用于非核心业务)
 */
public class OrderExtendsField implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 扩展字段KEY
     */
    
    private String fieldKey;

    /**
     * 扩展字段VAULE
     */
    
    private String fieldValue;

    // 构造函数
    public OrderExtendsField() {super();}

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

}
