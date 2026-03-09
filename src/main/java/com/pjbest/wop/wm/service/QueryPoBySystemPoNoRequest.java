package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 根据系统PO查PO单接口请求
 */
public class QueryPoBySystemPoNoRequest implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * WOP系统PO号
     */
    @Required("WOP系统PO号 ")
    private String systemPoNo;

    // 构造函数
    public QueryPoBySystemPoNoRequest() {super();}

    public String getSystemPoNo() {
        return systemPoNo;
    }

    public void setSystemPoNo(String systemPoNo) {
        this.systemPoNo = systemPoNo;
    }

}
