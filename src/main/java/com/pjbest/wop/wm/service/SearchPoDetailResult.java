package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取PO单明细结果
 */
public class SearchPoDetailResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总的记录数
     */
    @Required("总的记录数 ")
    private Integer totalNum;

    /**
     * 当前页面PO明细记录
     */
    
    private java.util.List<com.pjbest.wop.wm.service.PoDetail> poDetailList;

    // 构造函数
    public SearchPoDetailResult() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.pjbest.wop.wm.service.PoDetail> getPoDetailList() {
        return poDetailList;
    }

    public void setPoDetailList(java.util.List<com.pjbest.wop.wm.service.PoDetail> poDetailList) {
        this.poDetailList = poDetailList;
    }

}
