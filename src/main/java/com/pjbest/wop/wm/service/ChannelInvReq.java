package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 渠道库存查询条件
 */
public class ChannelInvReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 当前页码
     */
    @Required("当前页码 ")
    private Integer pageNo;

    /**
     * 分页数量
     */
    @Required("分页数量 ")
    private Integer pageSize;

    /**
     * 供应商编码
     */
    @Required("供应商编码 ")
    private String vendorCode;

    /**
     * 品牌编码
     */
    
    private String brandCode;

    /**
     * 货号
     */
    
    private String itemSn;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

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

    // 构造函数
    public ChannelInvReq() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
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

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
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

}
