package com.pjbest.wop.wm.service;

import com.vip.pop.base.annotation.Required;

/**
 * 调拨单明细导入响应
 */
public class TransferImportItemResult implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 商品条形码
     */
    @Required("商品条形码 ")
    private String itemCode;

    /**
     * 结果编码 200：成功,500：失败,501：本批次存在重新的商品，502：本商品已经存在于本调拨单
     */
    @Required("结果编码 200：成功,500：失败,501：本批次存在重新的商品，502：本商品已经存在于本调拨单 ")
    private Integer resultCode;

    /**
     * 结果备注
     */
    
    private String resultMsg;

    // 构造函数
    public TransferImportItemResult() {super();}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

}
