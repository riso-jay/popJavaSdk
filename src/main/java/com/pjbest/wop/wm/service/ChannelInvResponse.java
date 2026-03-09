package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 进销存报表查询结果
 */
public class ChannelInvResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 记录数
     */
    
    private Integer totalSize;

    /**
     * 数据列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.ChannelInvItem> resultList;

    // 构造函数
    public ChannelInvResponse() {super();}

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public java.util.List<com.pjbest.wop.wm.service.ChannelInvItem> getResultList() {
        return resultList;
    }

    public void setResultList(java.util.List<com.pjbest.wop.wm.service.ChannelInvItem> resultList) {
        this.resultList = resultList;
    }

}
