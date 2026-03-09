package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询PO单结果
 */
public class SearchPoResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总的记录数
     */
    @Required("总的记录数 ")
    private Integer totalNum;

    /**
     * 当前页面PO单记录
     */
    
    private java.util.List<com.pjbest.wop.wm.service.PoInfo> poList;

    // 构造函数
    public SearchPoResult() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.pjbest.wop.wm.service.PoInfo> getPoList() {
        return poList;
    }

    public void setPoList(java.util.List<com.pjbest.wop.wm.service.PoInfo> poList) {
        this.poList = poList;
    }

}
