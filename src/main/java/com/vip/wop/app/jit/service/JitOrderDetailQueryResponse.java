package com.vip.wop.app.jit.service;

import com.vip.pop.base.annotation.Required;

/**
 * 云仓JIT订单明细查询结果
 */
public class JitOrderDetailQueryResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    
    private Integer totalNum;

    /**
     * 云仓JIT订单明细列表
     */
    
    private java.util.List<com.vip.wop.app.jit.service.JitOrderDetail> jitOrderDetailList;

    // 构造函数
    public JitOrderDetailQueryResponse() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.vip.wop.app.jit.service.JitOrderDetail> getJitOrderDetailList() {
        return jitOrderDetailList;
    }

    public void setJitOrderDetailList(java.util.List<com.vip.wop.app.jit.service.JitOrderDetail> jitOrderDetailList) {
        this.jitOrderDetailList = jitOrderDetailList;
    }

}
