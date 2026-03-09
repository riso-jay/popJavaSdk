package com.pjbest.wop.base.inner.common.service;

import com.vip.pop.base.annotation.Required;

/**
 * 
 */
public class PaginationModel implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 可用库存数
     */
    
    private Long usableQty;

    /**
     * 安全库存数
     */
    
    private Long safeQty;

    /**
     * 品牌编码
     */
    
    private String brandCode;

    /**
     * 货号
     */
    
    private String itemSn;

    /**
     * 商品名称
     */
    
    private String itemName;

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
     * 当前库存数
     */
    
    private Long invQty;

    /**
     * 预占库存数
     */
    
    private Long holdQty;

    /**
     * 在途库存数
     */
    
    private Long onTheWayQty;

    // 构造函数
    public PaginationModel() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getUsableQty() {
        return usableQty;
    }

    public void setUsableQty(Long usableQty) {
        this.usableQty = usableQty;
    }

    public Long getSafeQty() {
        return safeQty;
    }

    public void setSafeQty(Long safeQty) {
        this.safeQty = safeQty;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public Long getInvQty() {
        return invQty;
    }

    public void setInvQty(Long invQty) {
        this.invQty = invQty;
    }

    public Long getHoldQty() {
        return holdQty;
    }

    public void setHoldQty(Long holdQty) {
        this.holdQty = holdQty;
    }

    public Long getOnTheWayQty() {
        return onTheWayQty;
    }

    public void setOnTheWayQty(Long onTheWayQty) {
        this.onTheWayQty = onTheWayQty;
    }

}
