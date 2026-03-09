package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 分类映射
 */
public class CategoryMapping implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 更新类型, 获取变更的节点接口使用
     */
    
    private com.pjbest.pdc.service.Category sourcecategory;

    /**
     * 属性条件, 格式：属性ID1:选项ID1,选项ID2|属性ID2:选项ID1,选项ID2
     */
    
    private String filter;

    // 构造函数
    public CategoryMapping() {super();}

    public com.pjbest.pdc.service.Category getSourcecategory() {
        return sourcecategory;
    }

    public void setSourcecategory(com.pjbest.pdc.service.Category sourcecategory) {
        this.sourcecategory = sourcecategory;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

}
