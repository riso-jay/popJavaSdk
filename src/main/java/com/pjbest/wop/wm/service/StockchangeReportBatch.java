package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存异动batch
 */
public class StockchangeReportBatch implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * batchCode
     */
    
    private String batchCode;

    /**
     * expireDate
     */
    
    private String expireDate;

    /**
     * inventoryType
     */
    
    private String inventoryType;

    /**
     * produceCode
     */
    
    private String produceCode;

    /**
     * productDate
     */
    
    private String productDate;

    /**
     * quantity
     */
    
    private Long quantity;

    // 构造函数
    public StockchangeReportBatch() {super();}

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getProduceCode() {
        return produceCode;
    }

    public void setProduceCode(String produceCode) {
        this.produceCode = produceCode;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
