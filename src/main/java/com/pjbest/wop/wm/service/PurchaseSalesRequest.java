package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 进销存报表查询请求
 */
public class PurchaseSalesRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
    @Required("供应商编码 ")
    private String vendorCode;

    /**
     * 当前页码
     */
    @Required("当前页码 ")
    private Integer pageNo;

    /**
     * 分页数量
     */
    @Required("分页数量 ")
    private Integer pageSize;

    /**
     * 仓库编码
     */
    @Required("仓库编码 ")
    private String warehouseCode;

    /**
     * 入库凭证
     */
    
    private String poNo;

    /**
     * 商品编码
     */
    
    private String itemCode;

    /**
     * 品牌编码
     */
    
    private String brandCode;

    /**
     * 收费品类
     */
    
    private String payCategory;

    /**
     * 库存开始日期（格式：yyyy-MM-dd）
     */
    @Required("库存开始日期（格式：yyyy-MM-dd） ")
    private String dateFrom;

    /**
     * 库存结束日期（格式：yyyy-MM-dd）
     */
    @Required("库存结束日期（格式：yyyy-MM-dd） ")
    private String dateTo;

    /**
     * 查询维度（1:商品+PO、 2:商品、3:PO、4:供应商）
     */
    @Required("查询维度（1:商品+PO、 2:商品、3:PO、4:供应商） ")
    private String queryType;

    // 构造函数
    public PurchaseSalesRequest() {super();}

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(String payCategory) {
        this.payCategory = payCategory;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

}
