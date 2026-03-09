package com.vip.wop.app.jit.service;

import com.vip.pop.base.annotation.Required;

/**
 * 云仓JITX订单查询响应
 */
public class JitxOrderQueryResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    
    private Integer totalNum;

    /**
     * 云仓JITX订单列表
     */
    
    private java.util.List<com.vip.wop.app.jit.service.JitxOrder> jitxOrders;

    // 构造函数
    public JitxOrderQueryResponse() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.vip.wop.app.jit.service.JitxOrder> getJitxOrders() {
        return jitxOrders;
    }

    public void setJitxOrders(java.util.List<com.vip.wop.app.jit.service.JitxOrder> jitxOrders) {
        this.jitxOrders = jitxOrders;
    }

}
