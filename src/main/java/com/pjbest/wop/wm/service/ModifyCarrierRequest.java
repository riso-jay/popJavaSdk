package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 修改客退单承运商请求
 */
public class ModifyCarrierRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 货主(客户)编码
     */
    @Required("货主(客户)编码 ")
    private String customerCode;

    /**
     * ERP(客户)客退单号
     */
    @Required("ERP(客户)客退单号 ")
    private String erpOrderBackSn;

    /**
     * 运单号
     */
    @Required("运单号 ")
    private String transportNo;

    /**
     * 承运商
     */
    @Required("承运商 ")
    private String carrierCode;

    // 构造函数
    public ModifyCarrierRequest() {super();}

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getErpOrderBackSn() {
        return erpOrderBackSn;
    }

    public void setErpOrderBackSn(String erpOrderBackSn) {
        this.erpOrderBackSn = erpOrderBackSn;
    }

    public String getTransportNo() {
        return transportNo;
    }

    public void setTransportNo(String transportNo) {
        this.transportNo = transportNo;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

}
