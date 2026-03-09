package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 导入大订单明细请求
 */
public class ImportBigOrderDetailsRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String customerCode;

    /**
     * ERP订单号
     */
    @Required("ERP订单号 ")
    private String erpOrderSn;

    /**
     * 明细列表
     */
    @Required("明细列表 ")
    private java.util.List<com.pjbest.wop.wm.service.ImportBigOrderDetailItem> detailItems;

    // 构造函数
    public ImportBigOrderDetailsRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public java.util.List<com.pjbest.wop.wm.service.ImportBigOrderDetailItem> getDetailItems() {
        return detailItems;
    }

    public void setDetailItems(java.util.List<com.pjbest.wop.wm.service.ImportBigOrderDetailItem> detailItems) {
        this.detailItems = detailItems;
    }

}
