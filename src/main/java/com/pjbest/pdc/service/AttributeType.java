package com.pjbest.pdc.service;

/**
 * 
 */
public enum AttributeType {

    /** 商品属性 */
    Normal(0),
    /** 商品标签 */
    Tag(1),
    /** 分类特有属性 */
    Special(2);

    /** 枚举值 */
    private final int value;

    AttributeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
