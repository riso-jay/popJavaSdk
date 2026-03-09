package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 取消退供单返回结果
 */
public class CancelInvReturnOrderRsp implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功，500：失败
     */
    @Required("结果编码 200：成功，500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码：200：成功，500：取消失败，501：退供单已取消过，502：退供单不存在
     */
    @Required("结果子编码：200：成功，500：取消失败，501：退供单已取消过，502：退供单不存在 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    // 构造函数
    public CancelInvReturnOrderRsp() {super();}

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

}
