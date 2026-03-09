package com.vip.wop.app.jit.service;

import com.vip.pop.base.annotation.Required;

/**
 * 云仓JITX订单明细查询结果
 */
public class JitxOrderDetailQueryResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    
    private Integer totalNum;

    /**
     * 云仓JITX订单明细列表
     */
    
    private java.util.List<com.vip.wop.app.jit.service.JitxOrderDetail> jitxOrderDetailList;

    // 构造函数
    public JitxOrderDetailQueryResponse() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.vip.wop.app.jit.service.JitxOrderDetail> getJitxOrderDetailList() {
        return jitxOrderDetailList;
    }

    public void setJitxOrderDetailList(java.util.List<com.vip.wop.app.jit.service.JitxOrderDetail> jitxOrderDetailList) {
        this.jitxOrderDetailList = jitxOrderDetailList;
    }

}
