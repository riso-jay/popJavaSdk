package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建PO返回结果
 */
public class CreatePoResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 操作结果 Y:成功 N:失败
     */
    @Required("操作结果 Y:成功 N:失败 ")
    private String status;

    /**
     * PO编号 创建成功时不为空，其他情况为空
     */
    
    private String poNo;

    /**
     * 备注（失败必填）
     */
    
    private String remark;

    /**
     * 错误码(501:PO已存在)
     */
    
    private String errorCode;

    // 构造函数
    public CreatePoResult() {super();}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
