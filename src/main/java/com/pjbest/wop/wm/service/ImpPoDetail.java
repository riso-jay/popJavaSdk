package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 导入PO明细对象
 */
public class ImpPoDetail implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品条形码
     */
    @Required("商品条形码 ")
    private String itemCode;

    /**
     * 流水号ID
     */
    
    private String transactionId;

    /**
     * 计划入库件数
     */
    @Required("计划入库件数 ")
    private Integer qty;

    /**
     * 吊牌价
     */
    
    private Double tagPrice;

    /**
     * 采购单价
     */
    
    private Double purchaseUnitPrice;

    /**
     * 备注
     */
    
    private String remark;

    /**
     * 箱号
     */
    
    private String boxNo;

    /**
     * 序列号段
     */
    
    private String serialNos;

    /**
     * 代贴条码(1申请贴码、2商家自贴、3仓库补贴)
     */
    
    private String barCodeType;

    /**
     * 原客户PO
     */
    
    private String orgClientPoNo;

    // 构造函数
    public ImpPoDetail() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getTagPrice() {
        return tagPrice;
    }

    public void setTagPrice(Double tagPrice) {
        this.tagPrice = tagPrice;
    }

    public Double getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    public void setPurchaseUnitPrice(Double purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getSerialNos() {
        return serialNos;
    }

    public void setSerialNos(String serialNos) {
        this.serialNos = serialNos;
    }

    public String getBarCodeType() {
        return barCodeType;
    }

    public void setBarCodeType(String barCodeType) {
        this.barCodeType = barCodeType;
    }

    public String getOrgClientPoNo() {
        return orgClientPoNo;
    }

    public void setOrgClientPoNo(String orgClientPoNo) {
        this.orgClientPoNo = orgClientPoNo;
    }

}
