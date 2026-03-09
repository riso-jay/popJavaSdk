package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 品牌同步请求对象
 */
public class BrandSyncReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户品牌编码(必填)
     */
    @Required("客户品牌编码(必填) ")
    private String custBrandCode;

    /**
     * 客户品牌名称(必填 长度不能超过128)
     */
    @Required("客户品牌名称(必填 长度不能超过128) ")
    private String custbrandName;

    // 构造函数
    public BrandSyncReq() {super();}

    public String getCustBrandCode() {
        return custBrandCode;
    }

    public void setCustBrandCode(String custBrandCode) {
        this.custBrandCode = custBrandCode;
    }

    public String getCustbrandName() {
        return custbrandName;
    }

    public void setCustbrandName(String custbrandName) {
        this.custbrandName = custbrandName;
    }

}
