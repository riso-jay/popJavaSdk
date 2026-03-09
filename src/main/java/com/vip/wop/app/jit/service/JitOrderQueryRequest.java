package com.vip.wop.app.jit.service;

import com.vip.pop.base.annotation.Required;

/**
 * 云仓JIT订单查询参数
 */
public class JitOrderQueryRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 客户编码
     */
    @Required("客户编码 ")
    private String crmCustCode;

    /**
     * 订单状态，100：新增，101：下单中，102：下单失败，200：已下单，300：拣货中，301：已打包，400：已出仓，500：配送中，501：已签收，502：已拒收，600：已取消，900：已关闭
     */
    
    private Integer orderStatus;

    /**
     * 出仓时间范围开始，格式：yyyy-MM-dd HH:mm:ss
     */
    
    private String outTimeFrom;

    /**
     * 出仓时间范围结束，格式：yyyy-MM-dd HH:mm:ss
     */
    
    private String outTimeTo;

    /**
     * 创建时间范围开始，格式：yyyy-MM-dd HH:mm:ss
     */
    @Required("创建时间范围开始，格式：yyyy-MM-dd HH:mm:ss ")
    private String createdDtmLocFrom;

    /**
     * 创建时间范围结束，格式：yyyy-MM-dd HH:mm:ss
     */
    @Required("创建时间范围结束，格式：yyyy-MM-dd HH:mm:ss ")
    private String createdDtmLocTo;

    // 构造函数
    public JitOrderQueryRequest() {super();}

    public String getCrmCustCode() {
        return crmCustCode;
    }

    public void setCrmCustCode(String crmCustCode) {
        this.crmCustCode = crmCustCode;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOutTimeFrom() {
        return outTimeFrom;
    }

    public void setOutTimeFrom(String outTimeFrom) {
        this.outTimeFrom = outTimeFrom;
    }

    public String getOutTimeTo() {
        return outTimeTo;
    }

    public void setOutTimeTo(String outTimeTo) {
        this.outTimeTo = outTimeTo;
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

}
