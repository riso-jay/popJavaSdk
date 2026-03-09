package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存异动Item
 */
public class StockchangeReportItem implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * sn
     */
    
    private String sn;

    // 构造函数
    public StockchangeReportItem() {super();}

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

}
