package com.pjbest.pdc.service;

/**
 * 
 */
public enum CategoryType {

    /** 顶层类目节点 */
    TopCategory(0),
    /** 中间层类目节点 */
    SubCategory(1),
    /** 最底层类目节点，商品只能挂载在这个节点下 */
    LeafCategory(2);

    /** 枚举值 */
    private final int value;

    CategoryType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
