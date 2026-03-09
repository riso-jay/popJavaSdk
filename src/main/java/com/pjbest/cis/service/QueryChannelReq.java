package com.pjbest.cis.service;

import com.vip.pop.base.annotation.Required;

/**
 * 渠道库存查询请求
 */
public class QueryChannelReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 是否查总库存
     */
    
    private Boolean isGroupByVendor;

    /**
     * 商品编码集合
     */
    
    private java.util.List<String> itemCodeList;

    /**
     * PO号
     */
    
    private String poNo;

    /**
     * 货号集合
     */
    
    private java.util.List<String> itemSnList;

    /**
     * 仓码集合
     */
    
    private java.util.List<String> warehouseCodeList;

    /**
     * 是否只返回小于0的库存
     */
    
    private Boolean isLessThanZero;

    /**
     * 品牌编码集合
     */
    
    private java.util.List<String> brandCodeList;

    /**
     * 是否包括复刻的实物条码
     */
    
    private Boolean isIncludeReplica;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

    /**
     * 供应商编码
     */
    
    private String vendorCode;

    /**
     * 渠道编码
     */
    
    private Byte channel;

    /**
     * 货品等级
     */
    
    private String grade;

    /**
     * 售卖状态 0:可用 1:不可用
     */
    
    private Byte saleStatus;

    /**
     * 是否只返回大于0的库存
     */
    
    private Boolean isMoreThanZero;

    /**
     * 品牌编码
     */
    
    private String brandCode;

    /**
     * 货号
     */
    
    private String itemSn;

    // 构造函数
    public QueryChannelReq() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Boolean getIsGroupByVendor() {
        return isGroupByVendor;
    }

    public void setIsGroupByVendor(Boolean isGroupByVendor) {
        this.isGroupByVendor = isGroupByVendor;
    }

    public java.util.List<String> getItemCodeList() {
        return itemCodeList;
    }

    public void setItemCodeList(java.util.List<String> itemCodeList) {
        this.itemCodeList = itemCodeList;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public java.util.List<String> getItemSnList() {
        return itemSnList;
    }

    public void setItemSnList(java.util.List<String> itemSnList) {
        this.itemSnList = itemSnList;
    }

    public java.util.List<String> getWarehouseCodeList() {
        return warehouseCodeList;
    }

    public void setWarehouseCodeList(java.util.List<String> warehouseCodeList) {
        this.warehouseCodeList = warehouseCodeList;
    }

    public Boolean getIsLessThanZero() {
        return isLessThanZero;
    }

    public void setIsLessThanZero(Boolean isLessThanZero) {
        this.isLessThanZero = isLessThanZero;
    }

    public java.util.List<String> getBrandCodeList() {
        return brandCodeList;
    }

    public void setBrandCodeList(java.util.List<String> brandCodeList) {
        this.brandCodeList = brandCodeList;
    }

    public Boolean getIsIncludeReplica() {
        return isIncludeReplica;
    }

    public void setIsIncludeReplica(Boolean isIncludeReplica) {
        this.isIncludeReplica = isIncludeReplica;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Byte getChannel() {
        return channel;
    }

    public void setChannel(Byte channel) {
        this.channel = channel;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Byte getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Byte saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Boolean getIsMoreThanZero() {
        return isMoreThanZero;
    }

    public void setIsMoreThanZero(Boolean isMoreThanZero) {
        this.isMoreThanZero = isMoreThanZero;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn;
    }

}
