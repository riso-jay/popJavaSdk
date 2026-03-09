package com.vip.wop.app.jit.service;

import com.vip.pop.base.annotation.Required;

/**
 * 云仓JIT订单明细
 */
public class JitOrderDetail implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品条码
     */
    
    private String itemCode;

    /**
     * 创建时间，毫秒
     */
    
    private Long createdDtmLoc;

    /**
     * 商品名称
     */
    
    private String itemName;

    /**
     * 请求数量
     */
    
    private Integer qty;

    /**
     * 出仓数量
     */
    
    private Integer outQty;

    /**
     * 品牌编码
     */
    
    private String brandCode;

    /**
     * 品牌名称
     */
    
    private String brandName;

    /**
     * 拣货单号
     */
    
    private String pickNo;

    /**
     * 云仓PO号
     */
    
    private String poNo;

    /**
     * 箱号
     */
    
    private String boxId;

    // 构造函数
    public JitOrderDetail() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getCreatedDtmLoc() {
        return createdDtmLoc;
    }

    public void setCreatedDtmLoc(Long createdDtmLoc) {
        this.createdDtmLoc = createdDtmLoc;
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

    public Integer getOutQty() {
        return outQty;
    }

    public void setOutQty(Integer outQty) {
        this.outQty = outQty;
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

    public String getPickNo() {
        return pickNo;
    }

    public void setPickNo(String pickNo) {
        this.pickNo = pickNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

}
