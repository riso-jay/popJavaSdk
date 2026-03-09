package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 父分类信息
 */
public class Parents implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 父分类ID
     */
    
    private Integer categoryId;

    /**
     * 父分类名称
     */
    
    private String name;

    /**
     * 父分类类型
     */
    
    private com.pjbest.pdc.service.CategoryType type;

    // 构造函数
    public Parents() {super();}

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.pjbest.pdc.service.CategoryType getType() {
        return type;
    }

    public void setType(com.pjbest.pdc.service.CategoryType type) {
        this.type = type;
    }

}
