package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * PO收货明细
 */
public class PoDeliveryResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    @Required("商品编码 ")
    private String itemCode;

    /**
     * 装箱数量
     */
    @Required("装箱数量 ")
    private Integer packingQty;

    /**
     * IQC数量
     */
    @Required("IQC数量 ")
    private Integer iqcQty;

    /**
     * 上架数量
     */
    @Required("上架数量 ")
    private Integer shelvesQty;

    /**
     * 原始数量
     */
    
    private Integer orgQty;

    /**
     * 差异数量
     */
    
    private Integer difQty;

    /**
     * 申请数量
     */
    
    private Integer qty;

    // 构造函数
    public PoDeliveryResult() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getPackingQty() {
        return packingQty;
    }

    public void setPackingQty(Integer packingQty) {
        this.packingQty = packingQty;
    }

    public Integer getIqcQty() {
        return iqcQty;
    }

    public void setIqcQty(Integer iqcQty) {
        this.iqcQty = iqcQty;
    }

    public Integer getShelvesQty() {
        return shelvesQty;
    }

    public void setShelvesQty(Integer shelvesQty) {
        this.shelvesQty = shelvesQty;
    }

    public Integer getOrgQty() {
        return orgQty;
    }

    public void setOrgQty(Integer orgQty) {
        this.orgQty = orgQty;
    }

    public Integer getDifQty() {
        return difQty;
    }

    public void setDifQty(Integer difQty) {
        this.difQty = difQty;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

}
