package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取调拨单明细结果
 */
public class SearchTransferDetailResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功,500：失败
     */
    @Required("结果子编码 200：成功,500：失败 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 总的记录数
     */
    @Required("总的记录数 ")
    private Integer totalNum;

    /**
     * 当前页面PO明细记录
     */
    
    private java.util.List<com.pjbest.wop.wm.service.TransferDetail> transferDetailList;

    // 构造函数
    public SearchTransferDetailResult() {super();}

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Integer getResultSubCode() {
        return resultSubCode;
    }

    public void setResultSubCode(Integer resultSubCode) {
        this.resultSubCode = resultSubCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.pjbest.wop.wm.service.TransferDetail> getTransferDetailList() {
        return transferDetailList;
    }

    public void setTransferDetailList(java.util.List<com.pjbest.wop.wm.service.TransferDetail> transferDetailList) {
        this.transferDetailList = transferDetailList;
    }

}
