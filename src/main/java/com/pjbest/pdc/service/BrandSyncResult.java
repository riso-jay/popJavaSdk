package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 品牌同步结果
 */
public class BrandSyncResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 货主编码
     */
    
    private String customerCode;

    /**
     * 客户品牌编码 (原值返回)
     */
    
    private String custBrandCode;

    /**
     * 客户品牌名称 (原值返回)
     */
    
    private String custbrandName;

    /**
     * 品骏品牌编码
     */
    
    private String pjBrandCode;

    // 构造函数
    public BrandSyncResult() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

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

    public String getPjBrandCode() {
        return pjBrandCode;
    }

    public void setPjBrandCode(String pjBrandCode) {
        this.pjBrandCode = pjBrandCode;
    }

}
