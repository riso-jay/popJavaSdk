package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询订单出仓数量（带PO）响应
 */
public class QueryOutQtyRespone implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品条码
     */
    
    private String itemCode;

    /**
     * 出仓数量
     */
    
    private Integer outQty;

    /**
     * 客户PO号
     */
    
    private String clientPoNo;

    // 构造函数
    public QueryOutQtyRespone() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getOutQty() {
        return outQty;
    }

    public void setOutQty(Integer outQty) {
        this.outQty = outQty;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

}
