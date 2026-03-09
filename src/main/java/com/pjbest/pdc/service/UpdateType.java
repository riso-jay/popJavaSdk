package com.pjbest.pdc.service;

/**
 * 
 */
public enum UpdateType {

    /** 添加 */
    Insert(0),
    /** 更新 */
    Update(1),
    /** 删除 */
    Delete(2);

    /** 枚举值 */
    private final int value;

    UpdateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
