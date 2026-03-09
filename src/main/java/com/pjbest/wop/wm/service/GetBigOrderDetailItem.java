package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取大订单明细记录
 */
public class GetBigOrderDetailItem implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 行号
     */
    
    private Long lineId;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 商品名称
     */
    
    private String itemName;

    /**
     * 申请商品数量
     */
    
    private Integer qty;

    /**
     * 出仓商品数量
     */
    
    private Integer outQty;

    /**
     * 序列号
     */
    
    private String serialNo;

    /**
     * 客户PO号
     */
    
    private String clientPoNo;

    /**
     * 系统PO号
     */
    
    private String systemPoNo;

    // 构造函数
    public GetBigOrderDetailItem() {super();}

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
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

    public Integer getOutQty() {
        return outQty;
    }

    public void setOutQty(Integer outQty) {
        this.outQty = outQty;
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

    public String getSystemPoNo() {
        return systemPoNo;
    }

    public void setSystemPoNo(String systemPoNo) {
        this.systemPoNo = systemPoNo;
    }

}
