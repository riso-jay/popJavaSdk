package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 客退单明细
 */
public class OrderDetailInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品条码
     */
    @Required("商品条码 ")
    private String itemCode;

    /**
     * 商品名称
     */
    
    private String itemName;

    /**
     * 请求数
     */
    @Required("请求数 ")
    private Integer reqQty;

    /**
     * 退货原因名称
     */
    
    private String returnReasonName;

    // 构造函数
    public OrderDetailInfo() {super();}

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

    public Integer getReqQty() {
        return reqQty;
    }

    public void setReqQty(Integer reqQty) {
        this.reqQty = reqQty;
    }

    public String getReturnReasonName() {
        return returnReasonName;
    }

    public void setReturnReasonName(String returnReasonName) {
        this.returnReasonName = returnReasonName;
    }

}
