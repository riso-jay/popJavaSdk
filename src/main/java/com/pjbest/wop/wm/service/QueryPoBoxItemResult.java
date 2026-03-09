package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 按PO商品箱明细结果
 */
public class QueryPoBoxItemResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 箱号
     */
    
    private String boxNo;

    /**
     * 箱内商品实际入库数量
     */
    
    private Integer realInstoreQty;

    /**
     * 申请入库数量
     */
    
    private Integer orgQty;

    // 构造函数
    public QueryPoBoxItemResult() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public Integer getRealInstoreQty() {
        return realInstoreQty;
    }

    public void setRealInstoreQty(Integer realInstoreQty) {
        this.realInstoreQty = realInstoreQty;
    }

    public Integer getOrgQty() {
        return orgQty;
    }

    public void setOrgQty(Integer orgQty) {
        this.orgQty = orgQty;
    }

}
