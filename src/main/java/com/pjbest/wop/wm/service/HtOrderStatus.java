package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 导入海淘订单明细记录
 */
public class HtOrderStatus implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ERP订单号
     */
    
    private String erpOrderSn;

    /**
     * 状态类型[0:订单状态,1:清关状态]
     */
    
    private Byte statusType;

    /**
     * 订单状态[10:新增,20:预占失败,30:待清关中,40:清关中,41:清关完成,42:清关失败,100:仓库新增,110:待审核,111:审核通过,112:审核不通过,113:待确定地址,101:仓库下单中,200:仓库已下单,102:下单失败,300:拣货中,301:已打包,400:已出仓,420:核放中,421:核放完成,422:核放失败,500:配送中,501:已签收,502:已拒收,600:已取消,900:关闭]。清关状态[11:已报国检,12国检放行,13:国检审核不通过,14:国检抽查,21:已报关,22:海关查验,23:海关放行,24:海关退单]
     */
    
    private Integer status;

    /**
     * 状态备注
     */
    
    private String statusRemark;

    /**
     * 状态发生时间
     */
    
    private String actionTime;

    // 构造函数
    public HtOrderStatus() {super();}

    public String getErpOrderSn() {
        return erpOrderSn;
    }

    public void setErpOrderSn(String erpOrderSn) {
        this.erpOrderSn = erpOrderSn;
    }

    public Byte getStatusType() {
        return statusType;
    }

    public void setStatusType(Byte statusType) {
        this.statusType = statusType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusRemark() {
        return statusRemark;
    }

    public void setStatusRemark(String statusRemark) {
        this.statusRemark = statusRemark;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

}
