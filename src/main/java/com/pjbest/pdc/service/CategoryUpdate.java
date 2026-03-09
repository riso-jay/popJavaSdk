package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 变更节点类
 */
public class CategoryUpdate implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 更新类型, 获取变更的节点接口使用
     */
    
    private com.pjbest.pdc.service.UpdateType updateType;

    /**
     * 变更分类节点
     */
    
    private com.pjbest.pdc.service.Category category;

    // 构造函数
    public CategoryUpdate() {super();}

    public com.pjbest.pdc.service.UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(com.pjbest.pdc.service.UpdateType updateType) {
        this.updateType = updateType;
    }

    public com.pjbest.pdc.service.Category getCategory() {
        return category;
    }

    public void setCategory(com.pjbest.pdc.service.Category category) {
        this.category = category;
    }

}
