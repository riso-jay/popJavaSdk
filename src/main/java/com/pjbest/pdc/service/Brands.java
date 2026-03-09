package com.pjbest.pdc.service;

import com.vip.pop.base.annotation.Required;

/**
 * 分类关联的品牌
 */
public class Brands implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 分类关联的品牌信息
     */
    
    private java.util.List<String> brand;

    // 构造函数
    public Brands() {super();}

    public java.util.List<String> getBrand() {
        return brand;
    }

    public void setBrand(java.util.List<String> brand) {
        this.brand = brand;
    }

}
