package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询退供单信息返回结果
 */
public class QueryInvReturnOrderRsp implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功，500：失败
     */
    @Required("结果编码 200：成功，500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功，500：失败，501：退供单不存在
     */
    @Required("结果子编码 200：成功，500：失败，501：退供单不存在 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 退供单信息
     */
    
    private com.pjbest.wop.wm.service.QueryInvReturnOrderInfoVo invReturnOrderInfo;

    // 构造函数
    public QueryInvReturnOrderRsp() {super();}

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

    public com.pjbest.wop.wm.service.QueryInvReturnOrderInfoVo getInvReturnOrderInfo() {
        return invReturnOrderInfo;
    }

    public void setInvReturnOrderInfo(com.pjbest.wop.wm.service.QueryInvReturnOrderInfoVo invReturnOrderInfo) {
        this.invReturnOrderInfo = invReturnOrderInfo;
    }

}
