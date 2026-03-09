package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 分类特有属性参数
 */
public class CategorySpecialParam implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    
    private Integer categoryId;

    /**
     * 属性IDS
     */
    
    private java.util.List<Integer> attributeIds;

    // 构造函数
    public CategorySpecialParam() {super();}

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public java.util.List<Integer> getAttributeIds() {
        return attributeIds;
    }

    public void setAttributeIds(java.util.List<Integer> attributeIds) {
        this.attributeIds = attributeIds;
    }

}
