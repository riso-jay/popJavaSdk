package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 获取订单缺货明细
 */
public class GetOrderLackByMaxIdItem implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 订单缺货明细唯一标记ID
     */
    
    private Long id;

    /**
     * 商品条码
     */
    
    private String itemCode;

    /**
     * 计划应发商品数量
     */
    
    private Integer planQty;

    /**
     * 缺货商品数量
     */
    
    private Integer lackQty;

    /**
     * 缺货原因(系统报缺,实物报缺)
     */
    
    private String reason;

    // 构造函数
    public GetOrderLackByMaxIdItem() {super();}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getPlanQty() {
        return planQty;
    }

    public void setPlanQty(Integer planQty) {
        this.planQty = planQty;
    }

    public Integer getLackQty() {
        return lackQty;
    }

    public void setLackQty(Integer lackQty) {
        this.lackQty = lackQty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
