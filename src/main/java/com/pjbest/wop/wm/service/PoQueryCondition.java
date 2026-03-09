package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * PO查询条件
 */
public class PoQueryCondition implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * PO编号
     */
    
    private String poNo;

    /**
     * 客户入库凭证
     */
    
    private String clientPoNo;

    /**
     * 收货仓
     */
    
    private String warehouseCode;

    /**
     * PO状态
     */
    
    private com.pjbest.wop.wm.service.PoStatus status;

    /**
     * 创建日期开始日期 (例：2017-08-08 08:08:08)；poNo和clientPoNo为空时，创建日期范围和更新日期范围必填一个；
     */
    
    private String createdDtmLocFrom;

    /**
     * 创建日期结束日期 (例：2017-08-09 09:09:09)；poNo和clientPoNo为空时，创建日期范围和更新日期范围必填一个；
     */
    
    private String createdDtmLocTo;

    /**
     * 唯品会退供单号
     */
    
    private String vipReturnSn;

    /**
     * 更新日期开始时间 (例：2017-08-08 08:08:08)；poNo和clientPoNo为空时，创建日期范围和更新日期范围必填一个；
     */
    
    private String updatedDtmLocFrom;

    /**
     * 更新日期结束时间 (例：2017-08-09 09:09:09)；poNo和clientPoNo为空时，创建日期范围和更新日期范围必填一个；
     */
    
    private String updatedDtmLocTo;

    // 构造函数
    public PoQueryCondition() {super();}

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getClientPoNo() {
        return clientPoNo;
    }

    public void setClientPoNo(String clientPoNo) {
        this.clientPoNo = clientPoNo;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public com.pjbest.wop.wm.service.PoStatus getStatus() {
        return status;
    }

    public void setStatus(com.pjbest.wop.wm.service.PoStatus status) {
        this.status = status;
    }

    public String getCreatedDtmLocFrom() {
        return createdDtmLocFrom;
    }

    public void setCreatedDtmLocFrom(String createdDtmLocFrom) {
        this.createdDtmLocFrom = createdDtmLocFrom;
    }

    public String getCreatedDtmLocTo() {
        return createdDtmLocTo;
    }

    public void setCreatedDtmLocTo(String createdDtmLocTo) {
        this.createdDtmLocTo = createdDtmLocTo;
    }

    public String getVipReturnSn() {
        return vipReturnSn;
    }

    public void setVipReturnSn(String vipReturnSn) {
        this.vipReturnSn = vipReturnSn;
    }

    public String getUpdatedDtmLocFrom() {
        return updatedDtmLocFrom;
    }

    public void setUpdatedDtmLocFrom(String updatedDtmLocFrom) {
        this.updatedDtmLocFrom = updatedDtmLocFrom;
    }

    public String getUpdatedDtmLocTo() {
        return updatedDtmLocTo;
    }

    public void setUpdatedDtmLocTo(String updatedDtmLocTo) {
        this.updatedDtmLocTo = updatedDtmLocTo;
    }

}
