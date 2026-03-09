package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 调拨单明细信息
 */
public class TransferDetail implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品条形码
     */
    @Required("商品条形码 ")
    private String itemCode;

    /**
     * 商品名称
     */
    @Required("商品名称 ")
    private String itemName;

    /**
     * 货品等级 枚举(100:正常 101:正常，已过可上线日期 102:正常，已过保险期 103:正常，已过失效期 210:一级残次 211:一级残次，已过可上线日期 212:一级残次，已过保险期 213:一级残次，已过失效期 220:二级残次 221:二级残次，已过可上线日期 222:二级残次，已过保险期 223:二级残次，已过失效期 230:三级残次 231:三级残次，已过可上线日期 232:三级残次，已过保险期 233:三级残次，已过失效期)
     */
    
    private String grade;

    /**
     * 售卖状态 枚举(0:可用 1:不可用)
     */
    
    private Byte saleStatus;

    /**
     * 申请调拨数量
     */
    @Required("申请调拨数量 ")
    private Integer qty;

    /**
     * 实际调出数量
     */
    @Required("实际调出数量 ")
    private Integer actuallyOutQty;

    /**
     * 实际调入数量
     */
    @Required("实际调入数量 ")
    private Integer actuallyInQty;

    /**
     * 入库凭证
     */
    
    private String poNo;

    // 构造函数
    public TransferDetail() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Byte getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Byte saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getActuallyOutQty() {
        return actuallyOutQty;
    }

    public void setActuallyOutQty(Integer actuallyOutQty) {
        this.actuallyOutQty = actuallyOutQty;
    }

    public Integer getActuallyInQty() {
        return actuallyInQty;
    }

    public void setActuallyInQty(Integer actuallyInQty) {
        this.actuallyInQty = actuallyInQty;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

}
