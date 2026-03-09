package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 关闭PO接口响应
 */
public class ClosePoRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功，500：失败
     */
    @Required("结果编码 200：成功，500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功，201：PO已关闭过，500：关闭失败，501：PO不存在
     */
    @Required("结果子编码 200：成功，201：PO已关闭过，500：关闭失败，501：PO不存在 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    // 构造函数
    public ClosePoRespone() {super();}

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
