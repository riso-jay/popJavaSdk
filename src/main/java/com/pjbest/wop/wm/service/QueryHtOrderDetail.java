package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询海淘订单明细记录
 */
public class QueryHtOrderDetail implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品序号
     */
    
    private String itemSeq;

    /**
     * 商品条码
     */
    
    private String itemCode;

    /**
     * 商品名称
     */
    
    private String itemName;

    /**
     * 数量
     */
    
    private Integer qty;

    /**
     * 单价(销售单价)
     */
    
    private Double price;

    /**
     * 总价(商品销售总价)
     */
    
    private Double totalPrice;

    /**
     * 计量单位
     */
    
    private String unit;

    // 构造函数
    public QueryHtOrderDetail() {super();}

    public String getItemSeq() {
        return itemSeq;
    }

    public void setItemSeq(String itemSeq) {
        this.itemSeq = itemSeq;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
