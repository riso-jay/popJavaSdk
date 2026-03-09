package com.pjbest.cis.service;

import com.vip.pop.base.annotation.Required;

/**
 * 供应商渠道列表
 */
public class ActionChannelList implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 供应商编码
     */
    
    private String vendorCode;

    /**
     * 业务编码
     */
    
    private String actionCode;

    /**
     * 业务类型
     */
    
    private String opType;

    /**
     * 调整类型 0:调减 1:调增
     */
    
    private Byte priorityType;

    /**
     * 渠道列表
     */
    
    private java.util.List<Byte> channelList;

    // 构造函数
    public ActionChannelList() {super();}

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
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

    public Byte getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(Byte priorityType) {
        this.priorityType = priorityType;
    }

    public java.util.List<Byte> getChannelList() {
        return channelList;
    }

    public void setChannelList(java.util.List<Byte> channelList) {
        this.channelList = channelList;
    }

}
