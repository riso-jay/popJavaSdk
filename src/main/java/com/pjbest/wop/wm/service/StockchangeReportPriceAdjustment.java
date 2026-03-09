package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存异动PriceAdjustment
 */
public class StockchangeReportPriceAdjustment implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * discount
     */
    
    private String discount;

    /**
     * endDate
     */
    
    private String endDate;

    /**
     * standardPrice
     */
    
    private String standardPrice;

    /**
     * startDate
     */
    
    private String startDate;

    /**
     * type
     */
    
    private String type;

    // 构造函数
    public StockchangeReportPriceAdjustment() {super();}

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
