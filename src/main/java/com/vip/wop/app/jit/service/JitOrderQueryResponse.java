package com.vip.wop.app.jit.service;

import com.vip.pop.base.annotation.Required;

/**
 * 云仓JIT订单查询响应
 */
public class JitOrderQueryResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    
    private Integer totalNum;

    /**
     * 云仓JIT订单列表
     */
    
    private java.util.List<com.vip.wop.app.jit.service.JitOrder> jitOrders;

    // 构造函数
    public JitOrderQueryResponse() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.vip.wop.app.jit.service.JitOrder> getJitOrders() {
        return jitOrders;
    }

    public void setJitOrders(java.util.List<com.vip.wop.app.jit.service.JitOrder> jitOrders) {
        this.jitOrders = jitOrders;
    }

}
