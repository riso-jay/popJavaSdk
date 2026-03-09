package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建退供单返回结果
 */
public class CreateInvReturnOrderRsp implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功,500：失败，501：退供单头已存在
     */
    @Required("结果子编码 200：成功,500：失败，501：退供单头已存在 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 客户退供单号
     */
    
    private String clientReturnSn;

    /**
     * 退供单号
     */
    
    private String erpReturnSn;

    // 构造函数
    public CreateInvReturnOrderRsp() {super();}

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

    public String getClientReturnSn() {
        return clientReturnSn;
    }

    public void setClientReturnSn(String clientReturnSn) {
        this.clientReturnSn = clientReturnSn;
    }

    public String getErpReturnSn() {
        return erpReturnSn;
    }

    public void setErpReturnSn(String erpReturnSn) {
        this.erpReturnSn = erpReturnSn;
    }

}
