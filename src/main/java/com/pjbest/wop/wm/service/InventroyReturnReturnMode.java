package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum InventroyReturnReturnMode {

    /** 自提 */
    BY_SELF(1),
    /** 退供应商 */
    RETURN_TO_VENDOR(2),
    /** 增值服务 */
    VALUE_ADDED(3),
    /** 报废 */
    SCRAPPED(4),
    /** 暂存转上线 */
    TEMPORARY_TRANSFER_ONLINE(5);

    /** 枚举值 */
    private final int value;

    InventroyReturnReturnMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
