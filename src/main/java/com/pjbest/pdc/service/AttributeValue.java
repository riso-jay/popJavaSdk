package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 特有属性值
 */
public class AttributeValue implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 特有属性值
     */
    
    private String literal;

    /**
     * 属性选项值
     */
    
    private java.util.List<com.pjbest.pdc.service.Option> options;

    // 构造函数
    public AttributeValue() {super();}

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public java.util.List<com.pjbest.pdc.service.Option> getOptions() {
        return options;
    }

    public void setOptions(java.util.List<com.pjbest.pdc.service.Option> options) {
        this.options = options;
    }

}
