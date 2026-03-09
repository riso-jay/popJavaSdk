package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 实时库存查询请求
 */
public class RealtimeInventoryRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 仓库编码
     */
    @Required("仓库编码 ")
    private String warehouseCode;

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
     * 入库凭证
     */
    
    private String poNo;

    /**
     * 查询维度（1:商品+PO、 2:商品、3:PO）
     */
    @Required("查询维度（1:商品+PO、 2:商品、3:PO） ")
    private String queryType;

    /**
     * 品牌编码
     */
    
    private String brandCode;

    /**
     * 售卖状态（0:可用、1:不可用）
     */
    
    private String locationClassCode;

    /**
     * 货品等级，对应WOP的商品属性（10:正常、21:一级残次、22:二级残次、23:三级残次）
     */
    
    private String inventoryQuality;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 当前页码
     */
    @Required("当前页码 ")
    private Integer pageNo;

    // 构造函数
    public RealtimeInventoryRequest() {super();}

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
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

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getLocationClassCode() {
        return locationClassCode;
    }

    public void setLocationClassCode(String locationClassCode) {
        this.locationClassCode = locationClassCode;
    }

    public String getInventoryQuality() {
        return inventoryQuality;
    }

    public void setInventoryQuality(String inventoryQuality) {
        this.inventoryQuality = inventoryQuality;
    }

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

}
