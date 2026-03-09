package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 进销存记录
 */
public class PurchaseSalesRecord implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 经销模式
     */
    
    private String distributionModel;

    /**
     * 库存日期
     */
    
    private String inventoryDate;

    /**
     * 期初库存数量
     */
    
    private Long beginningInventoryQuantity;

    /**
     * 入库数量
     */
    
    private Long inventoryInQuantity;

    /**
     * 销售出库数量
     */
    
    private Long inventoryOutQuantity;

    /**
     * 退供数量
     */
    
    private Long returnToVenderQunatity;

    /**
     * 调拨入库数量
     */
    
    private Long allocatedInventoryInQunatity;

    /**
     * 调拨出库数量
     */
    
    private Long allocatedInventoryOutQunatity;

    /**
     * 盘点盘盈数量
     */
    
    private Long inventoryProfitQuantity;

    /**
     * 盘点盘亏数量
     */
    
    private Long inventoryLossesQuantity;

    /**
     * 客退收货数量
     */
    
    private Long returnFromCustomerReceivedQuantity;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

    /**
     * 认购数量
     */
    
    private Long subscribedQuantity;

    /**
     * 正品库存数量
     */
    
    private Long qualityInventoryQuantity;

    /**
     * 残次品库存数量
     */
    
    private Long defectiveInventoryQuantity;

    /**
     * 期末库存数量
     */
    
    private Long endingInventoryQuantity;

    /**
     * 收费品类
     */
    
    private String payCategory;

    /**
     * 仓库名称
     */
    
    private String warehouseName;

    /**
     * 查询类型
     */
    
    private String queryType;

    /**
     * 入库凭证
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

    // 构造函数
    public PurchaseSalesRecord() {super();}

    public String getDistributionModel() {
        return distributionModel;
    }

    public void setDistributionModel(String distributionModel) {
        this.distributionModel = distributionModel;
    }

    public String getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(String inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public Long getBeginningInventoryQuantity() {
        return beginningInventoryQuantity;
    }

    public void setBeginningInventoryQuantity(Long beginningInventoryQuantity) {
        this.beginningInventoryQuantity = beginningInventoryQuantity;
    }

    public Long getInventoryInQuantity() {
        return inventoryInQuantity;
    }

    public void setInventoryInQuantity(Long inventoryInQuantity) {
        this.inventoryInQuantity = inventoryInQuantity;
    }

    public Long getInventoryOutQuantity() {
        return inventoryOutQuantity;
    }

    public void setInventoryOutQuantity(Long inventoryOutQuantity) {
        this.inventoryOutQuantity = inventoryOutQuantity;
    }

    public Long getReturnToVenderQunatity() {
        return returnToVenderQunatity;
    }

    public void setReturnToVenderQunatity(Long returnToVenderQunatity) {
        this.returnToVenderQunatity = returnToVenderQunatity;
    }

    public Long getAllocatedInventoryInQunatity() {
        return allocatedInventoryInQunatity;
    }

    public void setAllocatedInventoryInQunatity(Long allocatedInventoryInQunatity) {
        this.allocatedInventoryInQunatity = allocatedInventoryInQunatity;
    }

    public Long getAllocatedInventoryOutQunatity() {
        return allocatedInventoryOutQunatity;
    }

    public void setAllocatedInventoryOutQunatity(Long allocatedInventoryOutQunatity) {
        this.allocatedInventoryOutQunatity = allocatedInventoryOutQunatity;
    }

    public Long getInventoryProfitQuantity() {
        return inventoryProfitQuantity;
    }

    public void setInventoryProfitQuantity(Long inventoryProfitQuantity) {
        this.inventoryProfitQuantity = inventoryProfitQuantity;
    }

    public Long getInventoryLossesQuantity() {
        return inventoryLossesQuantity;
    }

    public void setInventoryLossesQuantity(Long inventoryLossesQuantity) {
        this.inventoryLossesQuantity = inventoryLossesQuantity;
    }

    public Long getReturnFromCustomerReceivedQuantity() {
        return returnFromCustomerReceivedQuantity;
    }

    public void setReturnFromCustomerReceivedQuantity(Long returnFromCustomerReceivedQuantity) {
        this.returnFromCustomerReceivedQuantity = returnFromCustomerReceivedQuantity;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Long getSubscribedQuantity() {
        return subscribedQuantity;
    }

    public void setSubscribedQuantity(Long subscribedQuantity) {
        this.subscribedQuantity = subscribedQuantity;
    }

    public Long getQualityInventoryQuantity() {
        return qualityInventoryQuantity;
    }

    public void setQualityInventoryQuantity(Long qualityInventoryQuantity) {
        this.qualityInventoryQuantity = qualityInventoryQuantity;
    }

    public Long getDefectiveInventoryQuantity() {
        return defectiveInventoryQuantity;
    }

    public void setDefectiveInventoryQuantity(Long defectiveInventoryQuantity) {
        this.defectiveInventoryQuantity = defectiveInventoryQuantity;
    }

    public Long getEndingInventoryQuantity() {
        return endingInventoryQuantity;
    }

    public void setEndingInventoryQuantity(Long endingInventoryQuantity) {
        this.endingInventoryQuantity = endingInventoryQuantity;
    }

    public String getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(String payCategory) {
        this.payCategory = payCategory;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
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

}
