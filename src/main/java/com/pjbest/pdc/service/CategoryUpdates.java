package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 变更节点集合
 */
public class CategoryUpdates implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 变更开始时间
     */
    
    private Long sinceUpdateTime;

    /**
     * 变更结束时间
     */
    
    private Long lastUpdateTime;

    /**
     * 按当前入参可返回的结果的总条数
     */
    
    private Integer total;

    /**
     * 变更节点集合
     */
    
    private java.util.List<com.pjbest.pdc.service.CategoryUpdate> categories;

    // 构造函数
    public CategoryUpdates() {super();}

    public Long getSinceUpdateTime() {
        return sinceUpdateTime;
    }

    public void setSinceUpdateTime(Long sinceUpdateTime) {
        this.sinceUpdateTime = sinceUpdateTime;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public java.util.List<com.pjbest.pdc.service.CategoryUpdate> getCategories() {
        return categories;
    }

    public void setCategories(java.util.List<com.pjbest.pdc.service.CategoryUpdate> categories) {
        this.categories = categories;
    }

}
