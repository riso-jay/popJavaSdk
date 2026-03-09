package com.vip.pop.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 必填字段注解
 * 
 * 用于标记模型类中的必填字段,便于代码生成器和测试框架识别必填字段
 * 
 * @author POP SDK
 * @version 1.0.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    
    /**
     * 字段描述
     * @return 字段说明
     */
    String value() default "";
    
    /**
     * 是否允许空字符串
     * @return true-允许空字符串, false-不允许空字符串
     */
    boolean allowEmpty() default false;
    
    /**
     * 错误提示信息
     * @return 自定义错误提示
     */
    String message() default "";
}
