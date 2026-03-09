package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 查询创建订单任务编码结果
 */
public class CreateOrderTaskStatus implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 创建订单任务编码
     */
    
    private String createOrderTaskCode;

    /**
     * ERP订单号
     */
    
    private String erpOrderSn;

    /**
     * 客户编码
     */
    
    private String customerCode;

    /**
     * 状态码[0:未处理,1:处理成功,-1:处理失败]
     */
    
    private Integer taskStatus;

    /**
     * 任务执行备注
     */
    
    private String remark;

    /**
     * 唯品物流ERP订单号
     */
    
    private String wopErpOrderSn;

    /**
     * 子状态码[0:未处理,1:处理成功,-1:处理失败,-11:订单已存在]
     */
    @Required("子状态码[0:未处理,1:处理成功,-1:处理失败,-11:订单已存在] ")
    private Integer taskSubStatus;

    // 构造函数
    public CreateOrderTaskStatus() {super();}

    public String getCreateOrderTaskCode() {
        return createOrderTaskCode;
    }

    public void setCreateOrderTaskCode(String createOrderTaskCode) {
        this.createOrderTaskCode = createOrderTaskCode;
    }

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWopErpOrderSn() {
        return wopErpOrderSn;
    }

    public void setWopErpOrderSn(String wopErpOrderSn) {
        this.wopErpOrderSn = wopErpOrderSn;
    }

    public Integer getTaskSubStatus() {
        return taskSubStatus;
    }

    public void setTaskSubStatus(Integer taskSubStatus) {
        this.taskSubStatus = taskSubStatus;
    }

}
