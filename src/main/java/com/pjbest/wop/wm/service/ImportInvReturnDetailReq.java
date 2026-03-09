package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 导入退供单明细请求
 */
public class ImportInvReturnDetailReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * 客户退供单号
     */
    @Required("客户退供单号 ")
    private String clientReturnSn;

    /**
     * 退供单信息
     */
    @Required("退供单信息 ")
    private java.util.List<com.pjbest.wop.wm.service.ImpItemDetail> detailList;

    /**
     * 来源标识
     */
    
    private String sourceFlag;

    // 构造函数
    public ImportInvReturnDetailReq() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getClientReturnSn() {
        return clientReturnSn;
    }

    public void setClientReturnSn(String clientReturnSn) {
        this.clientReturnSn = clientReturnSn;
    }

    public java.util.List<com.pjbest.wop.wm.service.ImpItemDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(java.util.List<com.pjbest.wop.wm.service.ImpItemDetail> detailList) {
        this.detailList = detailList;
    }

    public String getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(String sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

}
