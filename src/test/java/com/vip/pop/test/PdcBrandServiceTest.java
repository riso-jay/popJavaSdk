package com.vip.pop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pjbest.pdc.service.BrandSyncReq;
import com.pjbest.pdc.service.BrandSyncRespone;
import com.pjbest.pdc.service.PdcBrandService;
import com.vip.pop.base.validator.RequiredValidator;

/**
 * PdcBrandService 测试类
 * 
 * 测试原则:
 * - 每个方法一个测试用例
 * - 根据 @Required 注解设置必填字段
 * - 统一供应商编码使用 17002437
 * - 没有异常即通过测试
 * - 验证测试数据时提供详细的错误提示
 * 
 * 测试流程:
 * 1. 运行测试 → 2. 分析结果 → 3. 修正数据 → 4. 重新验证
 */
public class PdcBrandServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(PdcBrandServiceTest.class);
    
    private PdcBrandService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CRM_CUST_CODE = "17002437";
    
    // 品牌信息
    private static final String TEST_BRAND_CODE = "TEST_BRAND_001";
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new PdcBrandService();
        logger.info("PdcBrandServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 货主编码: {}", CRM_CUST_CODE);
        logger.info("  - 品牌编码: {}", TEST_BRAND_CODE);
    }
    
    // ==================== 品牌同步 ====================
    
    /**
     * 测试: 品牌同步
     * 
     * BrandSyncReq @Required 字段 (2个):
     * - custBrandCode (客户品牌编码)
     * - custbrandName (客户品牌名称)
     */
    @Test
    public void testSyncPdcBrand() throws Exception {
        logger.info("========== 测试开始: 品牌同步 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        BrandSyncReq syncBrand = new BrandSyncReq();
        syncBrand.setCustBrandCode(TEST_BRAND_CODE);    // @Required: 客户品牌编码
        syncBrand.setCustbrandName("测试品牌名称");    // @Required: 客户品牌名称
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(syncBrand);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        BrandSyncRespone result = service.syncPdcBrand(CRM_CUST_CODE, syncBrand);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("品牌同步测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 品牌同步 ==========");
    }
    
    /**
     * 测试: 健康检查
     * 
     * 无参数,无 @Required 字段
     */
    @Test
    public void testHealthCheck() throws Exception {
        logger.info("========== 测试开始: 健康检查 ==========");
        
        // 1. 调用健康检查 (没有异常即通过测试)
        service.healthCheck();
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("健康检查测试通过");
        logger.info("========== 测试通过: 健康检查 ==========");
    }
    
    // ==================== 辅助方法: 核实 @Required 注解 ====================
    
    /**
     * 辅助方法: 核实模型类的所有 @Required 字段
     * 用于开发时快速查看模型的必填字段
     * 
     * 使用方法:
     * mvn test -Dtest=PdcBrandServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // BrandSyncReq
        logger.info("\n【1】BrandSyncReq 必填字段 (2个):");
        listRequiredFields(BrandSyncReq.class);
        
        logger.info("\n========================================");
        logger.info("@Required 字段核实完成");
        logger.info("========================================");
    }
    
    /**
     * 辅助方法: 列出类的所有 @Required 字段
     * 
     * @param clazz 要检查的类
     */
    private void listRequiredFields(Class<?> clazz) {
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        int count = 0;
        for (java.lang.reflect.Field field : fields) {
            if (field.isAnnotationPresent(com.vip.pop.base.annotation.Required.class)) {
                com.vip.pop.base.annotation.Required annotation = 
                    field.getAnnotation(com.vip.pop.base.annotation.Required.class);
                logger.info("  {}. {} ({})", ++count, field.getName(), annotation.value());
            }
        }
    }
}
