package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 客退单查询响应结果
 */
public class SearchOrderBackResponse implements java.io.Serializable{
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
     * 总记录数
     */
    @Required("总记录数 ")
    private Integer totalNum;

    /**
     * 客退单信息列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.WopOrderBackInfo> orderBackInfoList;

    // 构造函数
    public SearchOrderBackResponse() {super();}

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

    public java.util.List<com.pjbest.wop.wm.service.WopOrderBackInfo> getOrderBackInfoList() {
        return orderBackInfoList;
    }

    public void setOrderBackInfoList(java.util.List<com.pjbest.wop.wm.service.WopOrderBackInfo> orderBackInfoList) {
        this.orderBackInfoList = orderBackInfoList;
    }

}
