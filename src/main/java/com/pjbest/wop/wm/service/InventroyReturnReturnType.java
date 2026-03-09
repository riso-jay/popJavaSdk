package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum InventroyReturnReturnType {

    /** 正常退供 */
    COMMON_TYPE(110),
    /** 残次退供 */
    DEFECTIVE_TYPE(111),
    /** 过期退供 */
    OVERDUE_TYPE(112),
    /** 入库凭证退供 */
    BY_PO_TYPE(113),
    /** 智能退供 */
    SMART_RETURN_TYPE(114);

    /** 枚举值 */
    private final int value;

    InventroyReturnReturnType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
