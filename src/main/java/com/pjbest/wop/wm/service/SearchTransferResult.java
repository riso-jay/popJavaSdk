package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询调拨单单结果
 */
public class SearchTransferResult implements java.io.Serializable{
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
     * 当前页面调拨单记录
     */
    
    private java.util.List<com.pjbest.wop.wm.service.TransferInfo> transferList;

    // 构造函数
    public SearchTransferResult() {super();}

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

    public java.util.List<com.pjbest.wop.wm.service.TransferInfo> getTransferList() {
        return transferList;
    }

    public void setTransferList(java.util.List<com.pjbest.wop.wm.service.TransferInfo> transferList) {
        this.transferList = transferList;
    }

}
