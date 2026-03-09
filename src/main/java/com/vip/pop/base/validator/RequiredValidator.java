package com.vip.pop.base.validator;

import com.vip.pop.base.annotation.Required;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 必填字段验证器
 * 
 * 使用 @Required 注解验证对象中的必填字段
 * 
 * @author POP SDK
 * @version 1.0.0
 */
public class RequiredValidator {
    
    /**
     * 验证对象中的所有必填字段
     * 
     * @param obj 待验证的对象
     * @throws IllegalArgumentException 如果有必填字段为空
     */
    public static void validate(Object obj) throws IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException("验证对象不能为空");
        }
        
        List<String> missingFields = new ArrayList<>();
        
        // 获取对象的所有字段(包括父类的字段)
        Class<?> clazz = obj.getClass();
        while (clazz != null && clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            
            for (Field field : fields) {
                // 检查字段是否有 @Required 注解
                if (field.isAnnotationPresent(Required.class)) {
                    Required required = field.getAnnotation(Required.class);
                    
                    // 设置可访问,即使是私有字段
                    field.setAccessible(true);
                    
                    try {
                        Object value = field.get(obj);
                        
                        // 验证字段值
                        if (!isFieldValid(value, required)) {
                            String fieldName = field.getName();
                            String description = required.value().isEmpty() ? fieldName : required.value();
                            String message = required.message().isEmpty() 
                                ? fieldName + "不能为空" 
                                : required.message();
                            missingFields.add(message);
                        }
                    } catch (IllegalAccessException e) {
                        throw new IllegalArgumentException("访问字段失败: " + field.getName(), e);
                    }
                }
            }
            
            // 检查父类
            clazz = clazz.getSuperclass();
        }
        
        // 如果有缺失的必填字段,抛出异常
        if (!missingFields.isEmpty()) {
            throw new IllegalArgumentException(String.join("; ", missingFields));
        }
    }
    
    /**
     * 验证字段值是否有效
     * 
     * @param value 字段值
     * @param required @Required 注解
     * @return true-有效, false-无效
     */
    private static boolean isFieldValid(Object value, Required required) {
        // 值为null,无效
        if (value == null) {
            return false;
        }
        
        // 如果是字符串类型,检查是否允许空字符串
        if (value instanceof String) {
            String strValue = (String) value;
            if (!required.allowEmpty()) {
                return !strValue.trim().isEmpty();
            }
        }
        
        // 如果是集合类型,检查是否为空集合
        if (value instanceof java.util.Collection) {
            return !((java.util.Collection<?>) value).isEmpty();
        }
        
        return true;
    }
    
    /**
     * 验证对象中的所有必填字段(静默模式)
     * 
     * @param obj 待验证的对象
     * @return 验证结果对象
     */
    public static ValidationResult validateSilently(Object obj) {
        try {
            validate(obj);
            return ValidationResult.success();
        } catch (IllegalArgumentException e) {
            return ValidationResult.failure(e.getMessage());
        }
    }
    
    /**
     * 验证结果类
     */
    public static class ValidationResult {
        private final boolean valid;
        private final String message;
        
        private ValidationResult(boolean valid, String message) {
            this.valid = valid;
            this.message = message;
        }
        
        public static ValidationResult success() {
            return new ValidationResult(true, "");
        }
        
        public static ValidationResult failure(String message) {
            return new ValidationResult(false, message);
        }
        
        public boolean isValid() {
            return valid;
        }
        
        public String getMessage() {
            return message;
        }
        
        @Override
        public String toString() {
            return "ValidationResult{" +
                    "valid=" + valid +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
