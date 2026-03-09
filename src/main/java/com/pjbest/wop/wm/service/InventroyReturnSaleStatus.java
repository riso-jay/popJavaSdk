package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum InventroyReturnSaleStatus {

    /** 可用 */
    CAN_SALE(0),
    /** 不可用 */
    CAN_NOT_SALE(1);

    /** 枚举值 */
    private final int value;

    InventroyReturnSaleStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
