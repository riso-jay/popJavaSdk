package com.pjbest.cis.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存汇总查询请求
 */
public class InventoryQueryReq implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
    @Required("供应商编码 ")
    private String vendorCode;

    /**
     * 仓库编码
     */
    @Required("仓库编码 ")
    private String warehouseCode;

    /**
     * 商品编码
     */
    @Required("商品编码 ")
    private String itemCode;

    /**
     * 货品等级
     */
    
    private String grade;

    // 构造函数
    public InventoryQueryReq() {super();}

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

}
