package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 实时库存信息
 */
public class RealtimeInventoryInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
    
    private String vendorCode;

    /**
     * 售卖状态
     */
    
    private String locationClassCode;

    /**
     * null
     */
    
    private String receivedDate;

    /**
     * 库存数量
     */
    
    private Integer onHandQty;

    /**
     * 订单占用数
     */
    
    private Integer allocatedQty;

    /**
     * 冻结库存数
     */
    
    private Integer frozenQty;

    /**
     * 可用数量
     */
    
    private Integer availableQuantity;

    /**
     * 上架时间
     */
    
    private String startOnRacksTime;

    /**
     * 库龄
     */
    
    private Long poNoAge;

    /**
     * 货号
     */
    
    private String vendorItem;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

    /**
     * 入库凭证号
     */
    
    private String poNo;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 商品名称
     */
    
    private String itemName;

    /**
     * 品牌编码
     */
    
    private String brandCode;

    /**
     * 品牌名称
     */
    
    private String brandName;

    /**
     * 库存类型
     */
    
    private String inventorytype;

    /**
     * 货品等级
     */
    
    private String inventoryQuality;

    // 构造函数
    public RealtimeInventoryInfo() {super();}

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getLocationClassCode() {
        return locationClassCode;
    }

    public void setLocationClassCode(String locationClassCode) {
        this.locationClassCode = locationClassCode;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Integer getOnHandQty() {
        return onHandQty;
    }

    public void setOnHandQty(Integer onHandQty) {
        this.onHandQty = onHandQty;
    }

    public Integer getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(Integer allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public Integer getFrozenQty() {
        return frozenQty;
    }

    public void setFrozenQty(Integer frozenQty) {
        this.frozenQty = frozenQty;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getStartOnRacksTime() {
        return startOnRacksTime;
    }

    public void setStartOnRacksTime(String startOnRacksTime) {
        this.startOnRacksTime = startOnRacksTime;
    }

    public Long getPoNoAge() {
        return poNoAge;
    }

    public void setPoNoAge(Long poNoAge) {
        this.poNoAge = poNoAge;
    }

    public String getVendorItem() {
        return vendorItem;
    }

    public void setVendorItem(String vendorItem) {
        this.vendorItem = vendorItem;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getInventorytype() {
        return inventorytype;
    }

    public void setInventorytype(String inventorytype) {
        this.inventorytype = inventorytype;
    }

    public String getInventoryQuality() {
        return inventoryQuality;
    }

    public void setInventoryQuality(String inventoryQuality) {
        this.inventoryQuality = inventoryQuality;
    }

}
