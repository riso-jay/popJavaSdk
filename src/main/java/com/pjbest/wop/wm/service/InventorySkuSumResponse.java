package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 出库SKU汇总返回实体
 */
public class InventorySkuSumResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 出库数量汇总
     */
    
    private Integer inventoryOutQuantitySum;

    // 构造函数
    public InventorySkuSumResponse() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getInventoryOutQuantitySum() {
        return inventoryOutQuantitySum;
    }

    public void setInventoryOutQuantitySum(Integer inventoryOutQuantitySum) {
        this.inventoryOutQuantitySum = inventoryOutQuantitySum;
    }

}
