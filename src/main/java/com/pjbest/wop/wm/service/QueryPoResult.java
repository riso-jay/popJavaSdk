package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 按PO查询结果
 */
public class QueryPoResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 开放平台采购入库单号
     */
    
    private String poNo;

    /**
     * 入库商品明细列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.QueryPoItemResult> poItemlist;

    /**
     * 入库箱明细列表
     */
    
    private java.util.List<com.pjbest.wop.wm.service.QueryPoBoxItemResult> poBoxItemlist;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

    /**
     * 入库状态(2：已确认 3：待确认 4：有差异已确认)
     */
    
    private String storageStatus;

    /**
     * 采购入库单状态(20：等待入库 91：取消入库 70：确认入库)
     */
    
    private String poOrderStatus;

    /**
     * 采购入库单创建人
     */
    
    private String createdByUser;

    /**
     * 采购入库单生成时间
     */
    
    private String createdDtmLoc;

    /**
     * 入库确认时间
     */
    
    private String operTime;

    /**
     * 处理结果(1正常，其它为异常 默认为1)
     */
    
    private String resultCode;

    /**
     * 失败消息
     */
    
    private String msg;

    // 构造函数
    public QueryPoResult() {super();}

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public java.util.List<com.pjbest.wop.wm.service.QueryPoItemResult> getPoItemlist() {
        return poItemlist;
    }

    public void setPoItemlist(java.util.List<com.pjbest.wop.wm.service.QueryPoItemResult> poItemlist) {
        this.poItemlist = poItemlist;
    }

    public java.util.List<com.pjbest.wop.wm.service.QueryPoBoxItemResult> getPoBoxItemlist() {
        return poBoxItemlist;
    }

    public void setPoBoxItemlist(java.util.List<com.pjbest.wop.wm.service.QueryPoBoxItemResult> poBoxItemlist) {
        this.poBoxItemlist = poBoxItemlist;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    public String getPoOrderStatus() {
        return poOrderStatus;
    }

    public void setPoOrderStatus(String poOrderStatus) {
        this.poOrderStatus = poOrderStatus;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getCreatedDtmLoc() {
        return createdDtmLoc;
    }

    public void setCreatedDtmLoc(String createdDtmLoc) {
        this.createdDtmLoc = createdDtmLoc;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
