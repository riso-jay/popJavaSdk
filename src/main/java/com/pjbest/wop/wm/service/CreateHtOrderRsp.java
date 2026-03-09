package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建海淘订单响应
 */
public class CreateHtOrderRsp implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功,500：失败,501：订单已存在
     */
    @Required("结果子编码 200：成功,500：失败,501：订单已存在 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    // 构造函数
    public CreateHtOrderRsp() {super();}

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
