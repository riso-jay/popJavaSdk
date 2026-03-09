package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 库存异动Ack
 */
public class StockchangeReportAck implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 单据类型(JYCK=一般交易出库单;HHCK=换货出库;BFCK=补发出库;PTCK=普通出库单;DBCK=调拨出库;B2BRK=B2B入 库;B2BCK=B2B出库;QTCK=其他出库;SCRK=生产入库;LYRK=领用入库;CCRK=残次品入库;CGRK=采购入库;DBRK= 调拨入库;QTRK= 其他入 库;XTRK= 销退入库;HHRK= 换货入库;CNJG= 仓内加工单)
     */
    
    private String orderType;

    /**
     * 单据ID
     */
    
    private String bizId;

    /**
     * 结果编码 200：成功,500：失败
     */
    @Required("结果编码 200：成功,500：失败 ")
    private Integer resultCode;

    /**
     * 结果信息
     */
    
    private String resultMsg;

    /**
     * 明细outBizCode集合
     */
    
    private java.util.List<String> detailOutBizCodeList;

    /**
     * 虚拟货主客户编码
     */
    
    private String virtualClientCode;

    // 构造函数
    public StockchangeReportAck() {super();}

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public java.util.List<String> getDetailOutBizCodeList() {
        return detailOutBizCodeList;
    }

    public void setDetailOutBizCodeList(java.util.List<String> detailOutBizCodeList) {
        this.detailOutBizCodeList = detailOutBizCodeList;
    }

    public String getVirtualClientCode() {
        return virtualClientCode;
    }

    public void setVirtualClientCode(String virtualClientCode) {
        this.virtualClientCode = virtualClientCode;
    }

}
