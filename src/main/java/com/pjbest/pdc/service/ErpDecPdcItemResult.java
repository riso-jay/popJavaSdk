package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * ERP商品信息同步结
 */
public class ErpDecPdcItemResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 处理结果（true 成功 false 失败）
     */
    @Required("处理结果（true 成功 false 失败） ")
    private Boolean result;

    /**
     * 处理结果描述（ 如果处理失败则是失败原因）
     */
    
    private String message;

    /**
     * 结果编码：000 失败;001 成功 ;002 品牌问题 ;003 品类问题 ;004 其他信息问题;005 商品已存在; 006 唯一标识已存在; 007 更新时商品不存在
     */
    
    private String resultCode;

    // 构造函数
    public ErpDecPdcItemResult() {super();}

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

}
