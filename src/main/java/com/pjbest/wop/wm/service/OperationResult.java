package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 操作返回结果
 */
public class OperationResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 操作结果 Y:成功 N:失败
     */
    @Required("操作结果 Y:成功 N:失败 ")
    private String status;

    /**
     * 备注（失败必填）
     */
    
    private String remark;

    /**
     * 操作结果子编码 200：成功，201：PO已取消过，500：失败，501：PO不存在
     */
    @Required("操作结果子编码 200：成功，201：PO已取消过，500：失败，501：PO不存在 ")
    private Integer statusSubCode;

    // 构造函数
    public OperationResult() {super();}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatusSubCode() {
        return statusSubCode;
    }

    public void setStatusSubCode(Integer statusSubCode) {
        this.statusSubCode = statusSubCode;
    }

}
