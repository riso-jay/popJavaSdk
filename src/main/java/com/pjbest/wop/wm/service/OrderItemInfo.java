package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 订单明细信息
 */
public class OrderItemInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品代码
     */
    
    private String itemCode;

    /**
     * 扩展属性Map(json字符串) [{'att1':1},{'att1':2}]
     */
    
    private String extendProps;

    /**
     * 商品名称
     */
    
    private String itemName;

    /**
     * 商品数量
     */
    
    private Integer qty;

    /**
     * 单价
     */
    
    private Double price;

    /**
     * 序列号
     */
    
    private String serialNo;

    /**
     * 客户欠货数量
     */
    
    private Integer custOweQty;

    /**
     * 客户PO号
     */
    
    private String clientPoNo;

    /**
     * 生产日期(YYYY-MM-DD) 2016-07-06
     */
    
    private String productDate;

    /**
     * 过期日期(YYYY-MM-DD) 2016-07-06
     */
    
    private String expireDate;

    // 构造函数
    public OrderItemInfo() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getExtendProps() {
        return extendProps;
    }

    public void setExtendProps(String extendProps) {
        this.extendProps = extendProps;
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

    public Integer getCustOweQty() {
        return custOweQty;
    }

    public void setCustOweQty(Integer custOweQty) {
        this.custOweQty = custOweQty;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

}
