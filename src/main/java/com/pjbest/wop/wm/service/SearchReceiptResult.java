package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取入库明细结果
 */
public class SearchReceiptResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 总的记录数
     */
    @Required("总的记录数 ")
    private Integer totalNum;

    /**
     * 当前页面入库明细记录
     */
    
    private java.util.List<com.pjbest.wop.wm.service.ReceiptDetail> receiptDetailList;

    // 构造函数
    public SearchReceiptResult() {super();}

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.pjbest.wop.wm.service.ReceiptDetail> getReceiptDetailList() {
        return receiptDetailList;
    }

    public void setReceiptDetailList(java.util.List<com.pjbest.wop.wm.service.ReceiptDetail> receiptDetailList) {
        this.receiptDetailList = receiptDetailList;
    }

}
