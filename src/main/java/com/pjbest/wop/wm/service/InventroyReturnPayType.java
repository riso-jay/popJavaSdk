package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum InventroyReturnPayType {

    /** 到付 */
    BY_COD(0),
    /** 月结 */
    BY_MONTHLY(1);

    /** 枚举值 */
    private final int value;

    InventroyReturnPayType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
