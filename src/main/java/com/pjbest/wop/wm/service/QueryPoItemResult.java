package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 按PO商品明细结果
 */
public class QueryPoItemResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 申请入库数量
     */
    
    private Integer orgQty;

    /**
     * 实际入库数量
     */
    
    private Integer iqcQty;

    /**
     * 上架数量
     */
    
    private Integer shelvesQty;

    // 构造函数
    public QueryPoItemResult() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getOrgQty() {
        return orgQty;
    }

    public void setOrgQty(Integer orgQty) {
        this.orgQty = orgQty;
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

}
