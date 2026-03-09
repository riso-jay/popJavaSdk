package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 退供单明细查询返回结果实体
 */
public class QueryInvReturnOrderInfoDetailVo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户退供单号
     */
    @Required("客户退供单号 ")
    private String clientReturnSn;

    /**
     * 唯品Po单号
     */
    
    private String vipPoNo;

    /**
     * 唯品退供箱号
     */
    
    private String vipBoxNo;

    /**
     * 云仓Po单号
     */
    
    private String poNo;

    /**
     * 云仓退供单号
     */
    
    private String returnSn;

    /**
     * 云仓退供箱号
     */
    
    private String boxId;

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
    
    private com.pjbest.wop.wm.service.InventroyReturnSaleStatus saleStatus;

    /**
     * 货品等级
     */
    
    private com.pjbest.wop.wm.service.InventroyReturnGrade grade;

    /**
     * 申请退供数量
     */
    
    private Long qty;

    /**
     * 实际退供数量
     */
    
    private Long actuallyQty;

    /**
     * 客户PO号
     */
    
    private String clientPoNo;

    /**
     * 唯品退供单号
     */
    
    private String vipReturnSn;

    // 构造函数
    public QueryInvReturnOrderInfoDetailVo() {super();}

    public String getClientReturnSn() {
        return clientReturnSn;
    }

    public void setClientReturnSn(String clientReturnSn) {
        this.clientReturnSn = clientReturnSn;
    }

    public String getVipPoNo() {
        return vipPoNo;
    }

    public void setVipPoNo(String vipPoNo) {
        this.vipPoNo = vipPoNo;
    }

    public String getVipBoxNo() {
        return vipBoxNo;
    }

    public void setVipBoxNo(String vipBoxNo) {
        this.vipBoxNo = vipBoxNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getReturnSn() {
        return returnSn;
    }

    public void setReturnSn(String returnSn) {
        this.returnSn = returnSn;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
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

    public Long getActuallyQty() {
        return actuallyQty;
    }

    public void setActuallyQty(Long actuallyQty) {
        this.actuallyQty = actuallyQty;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

    public String getVipReturnSn() {
        return vipReturnSn;
    }

    public void setVipReturnSn(String vipReturnSn) {
        this.vipReturnSn = vipReturnSn;
    }

}
