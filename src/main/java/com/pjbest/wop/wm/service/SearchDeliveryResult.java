package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取PO单收货明细结果
 */
public class SearchDeliveryResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总的记录数
     */
    @Required("总的记录数 ")
    private Integer totalNum;

    /**
     * 当前页面收货明细记录
     */
    
    private java.util.List<com.pjbest.wop.wm.service.PoDeliveryResult> resultList;

    // 构造函数
    public SearchDeliveryResult() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.pjbest.wop.wm.service.PoDeliveryResult> getResultList() {
        return resultList;
    }

    public void setResultList(java.util.List<com.pjbest.wop.wm.service.PoDeliveryResult> resultList) {
        this.resultList = resultList;
    }

}
