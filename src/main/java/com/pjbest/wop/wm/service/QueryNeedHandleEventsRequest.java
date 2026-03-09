package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询待处理订单事件列表请求
 */
public class QueryNeedHandleEventsRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 查询批次条数大小
     */
    @Required("查询批次条数大小 ")
    private Integer batchSize;

    // 构造函数
    public QueryNeedHandleEventsRequest() {super();}

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

}
