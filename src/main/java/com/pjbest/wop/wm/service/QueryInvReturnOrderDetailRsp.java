package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 退供单明细查询返回结果
 */
public class QueryInvReturnOrderDetailRsp implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码：200 成功,500 失败
     */
    @Required("结果编码：200 成功,500 失败 ")
    private Integer resultCode;

    /**
     * 结果子编码：200 成功,500 失败，501：退供单不存在
     */
    @Required("结果子编码：200 成功,500 失败，501：退供单不存在 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 总数量
     */
    @Required("总数量 ")
    private Integer totalCount;

    /**
     * 明细列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.QueryInvReturnOrderInfoDetailVo> detailItems;

    // 构造函数
    public QueryInvReturnOrderDetailRsp() {super();}

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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public java.util.List<com.pjbest.wop.wm.service.QueryInvReturnOrderInfoDetailVo> getDetailItems() {
        return detailItems;
    }

    public void setDetailItems(java.util.List<com.pjbest.wop.wm.service.QueryInvReturnOrderInfoDetailVo> detailItems) {
        this.detailItems = detailItems;
    }

}
