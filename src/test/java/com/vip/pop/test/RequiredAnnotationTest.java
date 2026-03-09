package com.vip.pop.test;

import com.pjbest.wop.wm.service.ChannelInvReq;
import com.vip.pop.base.annotation.Required;
import com.vip.pop.base.validator.RequiredValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

/**
 * @Required 注解和验证器测试类
 * 
 * 演示如何使用 @Required 注解标记必填字段,
 * 以及如何使用 RequiredValidator 验证必填字段
 */
public class RequiredAnnotationTest {
    
    /**
     * 测试: 验证完整的必填字段
     */
    @Test
    public void testValidateWithAllRequiredFields() {
        // 准备测试数据 (包含所有必填字段)
        ChannelInvReq req = new ChannelInvReq();
        req.setVendorCode("VENDOR_001");  // 必填
        req.setPageNo(1);                   // 必填
        req.setPageSize(10);                // 必填
        
        // 验证对象 (应该通过)
        RequiredValidator.validate(req);
        
        // 静默验证
        RequiredValidator.ValidationResult result = RequiredValidator.validateSilently(req);
        Assert.assertTrue(result.isValid(), "验证应该通过");
        Assert.assertEquals(result.getMessage(), "", "错误信息应该为空");
    }
    
    /**
     * 测试: 缺少必填字段 vendorCode
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValidateWithoutVendorCode() {
        ChannelInvReq req = new ChannelInvReq();
        req.setPageNo(1);
        req.setPageSize(10);
        // 缺少 vendorCode (必填)
        
        RequiredValidator.validate(req);
    }
    
    /**
     * 测试: 缺少必填字段 pageNo
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValidateWithoutPageNo() {
        ChannelInvReq req = new ChannelInvReq();
        req.setVendorCode("VENDOR_001");
        req.setPageSize(10);
        // 缺少 pageNo (必填)
        
        RequiredValidator.validate(req);
    }
    
    /**
     * 测试: 缺少必填字段 pageSize
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValidateWithoutPageSize() {
        ChannelInvReq req = new ChannelInvReq();
        req.setVendorCode("VENDOR_001");
        req.setPageNo(1);
        // 缺少 pageSize (必填)
        
        RequiredValidator.validate(req);
    }
    
    /**
     * 测试: 所有必填字段都为null
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValidateWithAllNullFields() {
        ChannelInvReq req = new ChannelInvReq();
        // 所有字段都为null
        
        RequiredValidator.validate(req);
    }
    
    /**
     * 测试: 静默验证 - 失败情况
     */
    @Test
    public void testValidateSilentlyWithMissingFields() {
        ChannelInvReq req = new ChannelInvReq();
        req.setPageNo(1);
        // 缺少 vendorCode 和 pageSize (必填)
        
        RequiredValidator.ValidationResult result = RequiredValidator.validateSilently(req);
        Assert.assertFalse(result.isValid(), "验证应该失败");
        Assert.assertNotNull(result.getMessage(), "应该有错误信息");
        System.out.println("错误信息: " + result.getMessage());
    }
    
    /**
     * 测试: 验证null对象
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValidateNullObject() {
        RequiredValidator.validate(null);
    }
    
    /**
     * 测试: 通过反射获取 @Required 注解
     */
    @Test
    public void testGetRequiredAnnotation() throws NoSuchFieldException {
        Field vendorCodeField = ChannelInvReq.class.getDeclaredField("vendorCode");
        Required annotation = vendorCodeField.getAnnotation(Required.class);
        
        Assert.assertNotNull(annotation, "vendorCode 字段应该有 @Required 注解");
        Assert.assertEquals(annotation.value(), "供应商编码", "注解描述应该正确");
        Assert.assertFalse(annotation.allowEmpty(), "默认不允许空字符串");
    }
    
    /**
     * 测试: 检查哪些字段有 @Required 注解
     */
    @Test
    public void testListRequiredFields() {
        Field[] fields = ChannelInvReq.class.getDeclaredFields();
        int requiredFieldCount = 0;
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(Required.class)) {
                Required annotation = field.getAnnotation(Required.class);
                System.out.println("必填字段: " + field.getName() + " - " + annotation.value());
                requiredFieldCount++;
            }
        }
        
        Assert.assertEquals(requiredFieldCount, 3, "应该有3个必填字段");
    }
    
    /**
     * 测试: 选填字段不应该有 @Required 注解
     */
    @Test
    public void testOptionalFieldsWithoutRequiredAnnotation() throws NoSuchFieldException {
        // itemCode 是选填字段,不应该有 @Required 注解
        Field itemCodeField = ChannelInvReq.class.getDeclaredField("itemCode");
        Required annotation = itemCodeField.getAnnotation(Required.class);
        
        Assert.assertNull(annotation, "itemCode 字段不应该有 @Required 注解");
    }
    
    /**
     * 测试: 字符串字段不允许空字符串
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testStringFieldWithEmptyValue() {
        ChannelInvReq req = new ChannelInvReq();
        req.setVendorCode("");  // 空字符串
        req.setPageNo(1);
        req.setPageSize(10);
        
        RequiredValidator.validate(req);
    }
    
    /**
     * 测试: 字符串字段允许空字符串(如果设置了 allowEmpty=true)
     */
    @Test
    public void testCustomRequiredAnnotationWithAllowEmpty() throws NoSuchFieldException {
        // 演示如何使用 allowEmpty 属性
        Field vendorCodeField = ChannelInvReq.class.getDeclaredField("vendorCode");
        Required annotation = vendorCodeField.getAnnotation(Required.class);
        
        Assert.assertFalse(annotation.allowEmpty(), "默认不允许空字符串");
        
        // 如果需要允许空字符串,可以这样使用:
        // @Required(value = "字段描述", allowEmpty = true)
        // private String fieldName;
    }
}
