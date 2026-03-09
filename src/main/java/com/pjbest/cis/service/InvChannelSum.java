package com.pjbest.cis.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存汇总查询结果
 */
public class InvChannelSum implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
    
    private String vendorCode;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 货品等级
     */
    
    private String grade;

    /**
     * 当前库存总数
     */
    
    private Long invQty;

    /**
     * 预占库存总数
     */
    
    private Long holdQty;

    /**
     * 在途库存总数
     */
    
    private Long onTheWayQty;

    /**
     * 可用库存总数
     */
    
    private Long usableQty;

    /**
     * 安全库存总数
     */
    
    private Long safeQty;

    // 构造函数
    public InvChannelSum() {super();}

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

}
