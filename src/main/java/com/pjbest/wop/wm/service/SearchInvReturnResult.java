package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 退供单查询返回结果
 */
public class SearchInvReturnResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

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
     * 当前页面退供单记录
     */
    
    private java.util.List<com.pjbest.wop.wm.service.QueryInvReturnOrderInfoVo> returnOrderInfoVoList;

    // 构造函数
    public SearchInvReturnResult() {super();}

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

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public java.util.List<com.pjbest.wop.wm.service.QueryInvReturnOrderInfoVo> getReturnOrderInfoVoList() {
        return returnOrderInfoVoList;
    }

    public void setReturnOrderInfoVoList(java.util.List<com.pjbest.wop.wm.service.QueryInvReturnOrderInfoVo> returnOrderInfoVoList) {
        this.returnOrderInfoVoList = returnOrderInfoVoList;
    }

}
