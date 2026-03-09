package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 创建调拨单单头响应
 */
public class CreateTransferRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功,500：失败,501：调拨单已存在
     */
    @Required("结果子编码 200：成功,500：失败,501：调拨单已存在 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * ERP调拨单号
     */
    
    private String erpTransferSn;

    /**
     * WOP调拨单号
     */
    
    private String transferSn;

    // 构造函数
    public CreateTransferRespone() {super();}

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

    public String getErpTransferSn() {
        return erpTransferSn;
    }

    public void setErpTransferSn(String erpTransferSn) {
        this.erpTransferSn = erpTransferSn;
    }

    public String getTransferSn() {
        return transferSn;
    }

    public void setTransferSn(String transferSn) {
        this.transferSn = transferSn;
    }

}
