package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 实时库存查询结果
 */
public class RealtimeInventoryResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 记录总数
     */
    
    private Integer totalSize;

    /**
     * 数据列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.RealtimeInventoryInfo> resultList;

    // 构造函数
    public RealtimeInventoryResponse() {super();}

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public java.util.List<com.pjbest.wop.wm.service.RealtimeInventoryInfo> getResultList() {
        return resultList;
    }

    public void setResultList(java.util.List<com.pjbest.wop.wm.service.RealtimeInventoryInfo> resultList) {
        this.resultList = resultList;
    }

}
