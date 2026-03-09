package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * wms119库存查询请求
 */
public class Wms119InventoryRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
    @Required("供应商编码 ")
    private String vendorCode;

    /**
     * ds枚举，例:scwms-PJ_GZSC-沙驰WM业务
     */
    
    private String ds;

    /**
     * 商品条码
     */
    
    private String itemCode;

    /**
     * 仓库编码
     */
    
    private String warehouseCode;

    /**
     * 入库凭证号
     */
    
    private String poNo;

    /**
     * 售卖状态
     */
    
    private String status;

    /**
     * 货品等级
     */
    
    private String grade;

    /**
     * 例如：3PL
     */
    
    private String type;

    /**
     * 例如：*
     */
    
    private String companyCode;

    // 构造函数
    public Wms119InventoryRequest() {super();}

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
