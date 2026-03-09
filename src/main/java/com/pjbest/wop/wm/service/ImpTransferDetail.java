package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 导入调拨单明细对象
 */
public class ImpTransferDetail implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品条形码
     */
    @Required("商品条形码 ")
    private String itemCode;

    /**
     * 货品等级(说明：部份供应商非必填，其他必填) 枚举(100:正常 101:正常，已过可上线日期 102:正常，已过保险期 103:正常，已过失效期 210:一级残次 211:一级残次，已过可上线日期 212:一级残次，已过保险期 213:一级残次，已过失效期 220:二级残次 221:二级残次，已过可上线日期 222:二级残次，已过保险期 223:二级残次，已过失效期 230:三级残次 231:三级残次，已过可上线日期 232:三级残次，已过保险期 233:三级残次，已过失效期)
     */
    
    private String grade;

    /**
     * 售卖状态(说明：部份供应商非必填，其他必填) 枚举(0:可用 1:不可用)
     */
    
    private Byte saleStatus;

    /**
     * 调拨申请数量
     */
    @Required("调拨申请数量 ")
    private Integer qty;

    /**
     * 入库凭证
     */
    
    private String poNo;

    /**
     * 库存类型;只支持3PL
     */
    @Required("库存类型;只支持3PL ")
    private String type;

    // 构造函数
    public ImpTransferDetail() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
