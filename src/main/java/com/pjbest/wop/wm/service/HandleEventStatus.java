package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum HandleEventStatus {

    /** 处理成功 */
    OK(1),
    /** 处理失败 */
    FAIL(2);

    /** 枚举值 */
    private final int value;

    HandleEventStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
