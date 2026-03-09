package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 特有属性及属性值
 */
public class AttributeWithValue implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    
    private Integer categoryId;

    /**
     * 属性值
     */
    
    private java.util.List<com.pjbest.pdc.service.AttributeWithValue> attributeWithValueList;

    // 构造函数
    public AttributeWithValue() {super();}

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public java.util.List<com.pjbest.pdc.service.AttributeWithValue> getAttributeWithValueList() {
        return attributeWithValueList;
    }

    public void setAttributeWithValueList(java.util.List<com.pjbest.pdc.service.AttributeWithValue> attributeWithValueList) {
        this.attributeWithValueList = attributeWithValueList;
    }

}
