package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum PoStatus {

    /** 新增 */
    New(0),
    /** 已审批 */
    Pass(1),
    /** 取消 */
    Already_cancel(2),
    /** 审批中 */
    Ready_to_approval(3),
    /** 取消中 */
    Ready_to_cancel(4),
    /** 审核不通过 */
    not_pass(7),
    /** 入库完成 */
    finish(9),
    /** 已关闭入库单 */
    batch_finish(10);

    /** 枚举值 */
    private final int value;

    PoStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
