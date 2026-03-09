package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存盘点结果
 */
public class InvCheckResponse implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    
    private String transactionId;

    /**
     * 售卖状态 0:可用 1:不可用
     */
    
    private String saleStatus;

    /**
     * 商品数量
     */
    @Required("商品数量 ")
    private Integer quantity;

    /**
     * 备注
     */
    
    private String remark;

    /**
     * 单据类型
     */
    
    private String orderType;

    /**
     * 唯品PO号
     */
    
    private String vipPoNo;

    /**
     * 发生时间(YYYY-MM-DD HH:MM:SS)
     */
    
    private String opTime;

    /**
     * 客户代码
     */
    
    private String khCode;

    /**
     * 货主编码
     */
    
    private String crmCustCode;

    /**
     * 唯品物流仓库编码
     */
    
    private String pjWarehouseCode;

    /**
     * 奇门仓库编码
     */
    
    private String qmWarehouseCode;

    /**
     * 单号
     */
    
    private String orderSn;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 业务编码 盘亏:332 盘盈:340
     */
    
    private String actionCode;

    /**
     * 操作类型 0:未定义 1:占用 2:释放 3:取消 4:调整
     */
    
    private String opType;

    /**
     * 货品等级 100:正常
     */
    
    private String grade;

    // 构造函数
    public InvCheckResponse() {super();}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getVipPoNo() {
        return vipPoNo;
    }

    public void setVipPoNo(String vipPoNo) {
        this.vipPoNo = vipPoNo;
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public String getKhCode() {
        return khCode;
    }

    public void setKhCode(String khCode) {
        this.khCode = khCode;
    }

    public String getCrmCustCode() {
        return crmCustCode;
    }

    public void setCrmCustCode(String crmCustCode) {
        this.crmCustCode = crmCustCode;
    }

    public String getPjWarehouseCode() {
        return pjWarehouseCode;
    }

    public void setPjWarehouseCode(String pjWarehouseCode) {
        this.pjWarehouseCode = pjWarehouseCode;
    }

    public String getQmWarehouseCode() {
        return qmWarehouseCode;
    }

    public void setQmWarehouseCode(String qmWarehouseCode) {
        this.qmWarehouseCode = qmWarehouseCode;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
