package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 品牌同步返回结果
 */
public class BrandSyncRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果子编码 200：成功,500：失败
     */
    @Required("结果子编码 200：成功,500：失败 ")
    private Integer resultSubCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    /**
     * 品牌同步结果
     */
    
    private com.pjbest.pdc.service.BrandSyncResult syncResult;

    // 构造函数
    public BrandSyncRespone() {super();}

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

    public com.pjbest.pdc.service.BrandSyncResult getSyncResult() {
        return syncResult;
    }

    public void setSyncResult(com.pjbest.pdc.service.BrandSyncResult syncResult) {
        this.syncResult = syncResult;
    }

}
