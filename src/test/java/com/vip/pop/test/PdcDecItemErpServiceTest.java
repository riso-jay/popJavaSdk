package com.vip.pop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pjbest.pdc.service.ErpDecPdcItem;
import com.pjbest.pdc.service.ErpDecPdcItemResult;
import com.pjbest.pdc.service.PdcDecItemErpService;
import com.vip.pop.base.validator.RequiredValidator;

/**
 * PdcDecItemErpService 测试类
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
public class PdcDecItemErpServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(PdcDecItemErpServiceTest.class);
    
    private PdcDecItemErpService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CRM_CUST_CODE = "17002437";
    
    // 商品信息
    private static final String TEST_ITEM_CODE = "TEST_ITEM_001";
    private static final String TEST_TRANSACTION_ID = "TXN_001";
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new PdcDecItemErpService();
        logger.info("PdcDecItemErpServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 货主编码: {}", CRM_CUST_CODE);
        logger.info("  - 商品编码: {}", TEST_ITEM_CODE);
    }
    
    // ==================== ERP商品同步 ====================
    
    /**
     * 测试: 同步ERP商品
     * 
     * ErpDecPdcItem @Required 字段 (14个):
     * - transactionId (唯一标识)
     * - size (商品规格)
     * - color (商品颜色)
     * - stockUnit (商品单位)
     * - isShelfLifeMgmt (是否质保)
     * - insurancePeriod (保险期时长)
     * - actionType (操作类型)
     * - provenance (是否国产)
     * - isFragile (是否易碎品)
     * - isAirForbit (是否航空禁运)
     * - isLuxury (是否贵重品)
     * - itemCode (商品编码)
     * - dataSource (数据源)
     * - itemName (商品名称)
     * - goodsCode (商品货号)
     */
    @Test
    public void testSyncErpDecPdcItem() throws Exception {
        logger.info("========== 测试开始: 同步ERP商品 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        ErpDecPdcItem erpDecPdcItem = new ErpDecPdcItem();
        erpDecPdcItem.setTransactionId(TEST_TRANSACTION_ID);  // @Required: 唯一标识
        erpDecPdcItem.setSize("L");                            // @Required: 商品规格
        erpDecPdcItem.setColor("红色");                          // @Required: 商品颜色
        erpDecPdcItem.setStockUnit("件");                        // @Required: 商品单位
        erpDecPdcItem.setIsShelfLifeMgmt("N");                   // @Required: 是否质保(Y/N)
        erpDecPdcItem.setInsurancePeriod(30);                   // @Required: 保险期时长
        erpDecPdcItem.setActionType("add");                        // @Required: 操作类型(add|update)
        erpDecPdcItem.setProvenance((byte) 1);                   // @Required: 是否国产(0未知|1中国|2进口)
        erpDecPdcItem.setIsFragile("N");                          // @Required: 是否易碎品(Y/N)
        erpDecPdcItem.setIsAirForbit((byte) 0);                   // @Required: 是否航空禁运(0否|1是)
        erpDecPdcItem.setIsLuxury((byte) 0);                      // @Required: 是否贵重品(0否|1是)
        erpDecPdcItem.setItemCode(TEST_ITEM_CODE);                // @Required: 商品编码
        erpDecPdcItem.setDataSource("ERP");                       // @Required: 数据源
        erpDecPdcItem.setItemName("测试商品名称");                 // @Required: 商品名称
        erpDecPdcItem.setGoodsCode("GOODS_001");                  // @Required: 商品货号
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(erpDecPdcItem);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        ErpDecPdcItemResult result = service.syncPdcItem(CRM_CUST_CODE, erpDecPdcItem);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("同步ERP商品测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 同步ERP商品 ==========");
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
     * mvn test -Dtest=PdcDecItemErpServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // ErpDecPdcItem
        logger.info("\n【1】ErpDecPdcItem 必填字段 (14个):");
        listRequiredFields(ErpDecPdcItem.class);
        
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
