package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * PO明细信息
 */
public class PoDetail implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 接口主表id
     */
    @Required("接口主表id ")
    private Long transactionId;

    /**
     * 逻辑仓码
     */
    @Required("逻辑仓码 ")
    private String warehouseCode;

    /**
     * 商品条形码
     */
    @Required("商品条形码 ")
    private String itemCode;

    /**
     * 唯品云仓入库单号
     */
    
    private String poNo;

    /**
     * 残次等级，100-良品，210-残次
     */
    
    private String grade;

    /**
     * 上架数量
     */
    
    private Long shelvesQty;

    /**
     * 上架时间
     */
    
    private String shelvesTime;

    // 构造函数
    public PoDetail() {super();}

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getShelvesQty() {
        return shelvesQty;
    }

    public void setShelvesQty(Long shelvesQty) {
        this.shelvesQty = shelvesQty;
    }

    public String getShelvesTime() {
        return shelvesTime;
    }

    public void setShelvesTime(String shelvesTime) {
        this.shelvesTime = shelvesTime;
    }

}
