package com.pjbest.pdc.service;

/**
 * 
 */
public enum DataType {

    /** 自由文本，约定不包括英文标点符号 */
    Text(0),
    /** 数值类型 */
    Numeric(1),
    /** 选项类型 */
    Option(2),
    /** 布尔类型 */
    Bumble(3),
    /** 图片类型 */
    Picture(4);

    /** 枚举值 */
    private final int value;

    DataType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
