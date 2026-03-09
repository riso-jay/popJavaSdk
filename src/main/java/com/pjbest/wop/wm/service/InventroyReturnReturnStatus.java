package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum InventroyReturnReturnStatus {

    /** 新增 */
    NEW(0),
    /** 已提交 */
    SUBMIT(1),
    /** 作废 */
    CANCEL(2),
    /** 出仓 */
    EX_WAREHOUSE(3),
    /** 草稿 */
    DRAFT(4),
    /** 待审核 */
    IN_AUTHED(5),
    /** 驳回 */
    REJECT_AUTHED(6),
    /** 退回 */
    ROLL_BACK(7),
    /** 关闭 */
    CLOSE(8),
    /** 取消成功 */
    CANCEL_SUCC(9),
    /** 出仓错误 */
    EX_WAREHOUSE_ERROR(10);

    /** 枚举值 */
    private final int value;

    InventroyReturnReturnStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
