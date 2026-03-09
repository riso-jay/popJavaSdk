package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 根据系统PO查PO单接口响应
 */
public class QueryPoBySystemPoNoRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功，500：异常
     */
    @Required("结果编码 200：成功，500：异常 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功，500：异常
     */
    @Required("结果子编码 200：成功，500：异常 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * PO
     */
    
    private com.pjbest.wop.wm.service.PoInfo poInfo;

    // 构造函数
    public QueryPoBySystemPoNoRespone() {super();}

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

    public com.pjbest.wop.wm.service.PoInfo getPoInfo() {
        return poInfo;
    }

    public void setPoInfo(com.pjbest.wop.wm.service.PoInfo poInfo) {
        this.poInfo = poInfo;
    }

}
