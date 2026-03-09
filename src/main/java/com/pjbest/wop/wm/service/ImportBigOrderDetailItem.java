package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 导入大订单明细记录
 */
public class ImportBigOrderDetailItem implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    @Required("商品编码 ")
    private String itemCode;

    /**
     * 商品名称
     */
    
    private String itemName;

    /**
     * 商品数量
     */
    @Required("商品数量 ")
    private Integer qty;

    /**
     * 单价
     */
    @Required("单价 ")
    private Double price;

    /**
     * 序列号
     */
    
    private String serialNo;

    /**
     * 客户PO号
     */
    
    private String clientPoNo;

    // 构造函数
    public ImportBigOrderDetailItem() {super();}

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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

}
