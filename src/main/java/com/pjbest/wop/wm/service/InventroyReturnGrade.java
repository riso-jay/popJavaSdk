package com.pjbest.wop.wm.service;

/**
 * 
 */
public enum InventroyReturnGrade {

    /** 正常 */
    NORMAL(100),
    /** 正常，已过可上线日期 */
    NORMAL_OVER_ONLINE(101),
    /** 正常，已过保险期 */
    NORAL_OVER_INSURANCE(102),
    /** 正常，已过失效期 */
    NORMAL_OVER_EXP(103),
    /** 一级残次 */
    DEFECTIVE_1(210),
    /** 一级残次，已过可上线日期 */
    DEFECTIVE_1_OVER_ONLINE(211),
    /** 一级残次，已过保险期 */
    DEFECTIVE_1_OVER_INSURANCE(212),
    /** 一级残次，已过失效期 */
    DEFECTIVE_1_OVER_EXP(213),
    /** 二级残次 */
    DEFECTIVE_2(220),
    /** 二级残次，已过可上线日期 */
    DEFECTIVE_2_OVER_ONLINE(221),
    /** 二级残次，已过保险期 */
    DEFECTIVE_2_OVER_INSURANCE(222),
    /** 二级残次，已过失效期 */
    DEFECTIVE_2_OVER_EXP(223),
    /** 三级残次 */
    DEFECTIVE_3(230),
    /** 三级残次，已过可上线日期 */
    DEFECTIVE_3_OVER_ONLINE(231),
    /** 三级残次，已过保险期 */
    DEFECTIVE_3_OVER_INSURANCE(232),
    /** 三级残次，已过失效期 */
    DEFECTIVE_3_OVER_EXP(233);

    /** 枚举值 */
    private final int value;

    InventroyReturnGrade(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
