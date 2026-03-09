package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存盘点确认结果
 */
public class InvCheckReportAckResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @Required("唯一标识 ")
    private String transactionId;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    // 构造函数
    public InvCheckReportAckResult() {super();}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}
