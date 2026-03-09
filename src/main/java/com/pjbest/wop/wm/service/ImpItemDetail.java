package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 导入退供单明细实体
 */
public class ImpItemDetail implements java.io.Serializable{
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
     * 售卖状态
     */
    @Required("售卖状态 ")
    private com.pjbest.wop.wm.service.InventroyReturnSaleStatus saleStatus;

    /**
     * 货品等级
     */
    @Required("货品等级 ")
    private com.pjbest.wop.wm.service.InventroyReturnGrade grade;

    /**
     * 申请退供数量
     */
    @Required("申请退供数量 ")
    private Long qty;

    /**
     * 客户PO号
     */
    
    private String clientPoNo;

    // 构造函数
    public ImpItemDetail() {super();}

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

    public com.pjbest.wop.wm.service.InventroyReturnSaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(com.pjbest.wop.wm.service.InventroyReturnSaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public com.pjbest.wop.wm.service.InventroyReturnGrade getGrade() {
        return grade;
    }

    public void setGrade(com.pjbest.wop.wm.service.InventroyReturnGrade grade) {
        this.grade = grade;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

}
