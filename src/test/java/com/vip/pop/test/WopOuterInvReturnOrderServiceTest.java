package com.vip.pop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pjbest.wop.wm.service.CancelInvReturnOrderReq;
import com.pjbest.wop.wm.service.CancelInvReturnOrderRsp;
import com.pjbest.wop.wm.service.CleanInvReturnDetailReq;
import com.pjbest.wop.wm.service.CleanInvReturnDetailRsp;
import com.pjbest.wop.wm.service.CreateInvReturnOrderReq;
import com.pjbest.wop.wm.service.CreateInvReturnOrderRsp;
import com.pjbest.wop.wm.service.EditInvReturnOrderReq;
import com.pjbest.wop.wm.service.EditInvReturnOrderRsp;
import com.pjbest.wop.wm.service.ImportInvReturnDetailReq;
import com.pjbest.wop.wm.service.ImportInvReturnDetailRsp;
import com.pjbest.wop.wm.service.QueryInvReturnOrderDetailReq;
import com.pjbest.wop.wm.service.QueryInvReturnOrderDetailRsp;
import com.pjbest.wop.wm.service.QueryInvReturnOrderReq;
import com.pjbest.wop.wm.service.QueryInvReturnOrderRsp;
import com.pjbest.wop.wm.service.SearchInvReturnOrderReq;
import com.pjbest.wop.wm.service.SearchInvReturnResult;
import com.pjbest.wop.wm.service.SubmitInvReturnOrderReq;
import com.pjbest.wop.wm.service.SubmitInvReturnOrderRsp;
import com.pjbest.wop.wm.service.WopOuterInvReturnOrderService;
import com.vip.pop.base.validator.RequiredValidator;

/**
 * WopOuterInvReturnOrderService 测试类
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
public class WopOuterInvReturnOrderServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(WopOuterInvReturnOrderServiceTest.class);
    
    private WopOuterInvReturnOrderService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CUSTOMER_CODE = "17002437";
    
    // 退供单信息
    private static final String TEST_INV_RETURN_ORDER_NO = "TEST_INV_RETURN_ORDER_001";
    private static final String TEST_CLIENT_RETURN_SN = "CLIENT_RETURN_001";
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new WopOuterInvReturnOrderService();
        logger.info("WopOuterInvReturnOrderServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 客户编码: {}", CUSTOMER_CODE);
        logger.info("  - 客户退供单号: {}", TEST_CLIENT_RETURN_SN);
    }
    
    // ==================== 退供单操作 ====================
    
    /**
     * 测试: 取消退供单
     * 
     * CancelInvReturnOrderReq @Required 字段 (2个):
     * - customerCode (客户编码)
     * - clientReturnSn (客户退供单号)
     */
    @Test
    public void testCancelInvReturnOrder() throws Exception {
        logger.info("========== 测试开始: 取消退供单 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        CancelInvReturnOrderReq cancelInvReq = new CancelInvReturnOrderReq();
        cancelInvReq.setCustomerCode(CUSTOMER_CODE);      // @Required: 客户编码
        cancelInvReq.setClientReturnSn(TEST_CLIENT_RETURN_SN); // @Required: 客户退供单号
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(cancelInvReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        CancelInvReturnOrderRsp result = service.cancelInvReturnOrder(cancelInvReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("取消退供单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 取消退供单 ==========");
    }
    
    /**
     * 测试: 清空退供单明细
     * 
     * CleanInvReturnDetailReq @Required 字段 (2个):
     * - customerCode (客户编码)
     * - clientReturnSn (客户退供单号)
     */
    @Test
    public void testCleanInvReturnDetail() throws Exception {
        logger.info("========== 测试开始: 清空退供单明细 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        CleanInvReturnDetailReq cleanDetailReq = new CleanInvReturnDetailReq();
        cleanDetailReq.setCustomerCode(CUSTOMER_CODE);      // @Required: 客户编码
        cleanDetailReq.setClientReturnSn(TEST_CLIENT_RETURN_SN); // @Required: 客户退供单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(cleanDetailReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        CleanInvReturnDetailRsp result = service.cleanInvReturnDetail(cleanDetailReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("清空退供单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 清空退供单明细 ==========");
    }
    
    /**
     * 测试: 创建退供单表头
     * 
     * CreateInvReturnOrderReq @Required 字段 (12个):
     * - customerCode (客户编码)
     * - postcode (退供收货邮政编码)
     * - state (退供收货省/州)
     * - city (退供收货城市)
     * - region (退供收货区/县)
     * - address (退供收货详细地址)
     * - toEmail (通知邮箱)
     * - clientReturnSn (客户退供单号)
     * - returnType (退供类型)
     * - warehouse (退供发货仓)
     * - returnMode (退供方式)
     * - payType (支付方式)
     * - consignee (退供收货人)
     */
    @Test
    public void testCreateInvReturnOrder() throws Exception {
        logger.info("========== 测试开始: 创建退供单表头 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        CreateInvReturnOrderReq createReq = new CreateInvReturnOrderReq();
        createReq.setCustomerCode(CUSTOMER_CODE);         // @Required: 客户编码
        createReq.setPostcode("100000");                    // @Required: 退供收货邮政编码
        createReq.setState("广东省");                       // @Required: 退供收货省/州
        createReq.setCity("深圳市");                       // @Required: 退供收货城市
        createReq.setRegion("南山区");                      // @Required: 退供收货区/县
        createReq.setAddress("测试地址123号");             // @Required: 退供收货详细地址
        createReq.setToEmail("test@example.com");         // @Required: 通知邮箱
        createReq.setClientReturnSn(TEST_CLIENT_RETURN_SN); // @Required: 客户退供单号
        createReq.setReturnType(com.pjbest.wop.wm.service.InventroyReturnReturnType.COMMON_TYPE);  // @Required: 退供类型 110正常退供，111残次退供
        createReq.setWarehouse("WH001");                    // @Required: 退供发货仓
        createReq.setReturnMode(com.pjbest.wop.wm.service.InventroyReturnReturnMode.BY_SELF);      // @Required: 退供方式 1自提;2退供应商
        createReq.setPayType(com.pjbest.wop.wm.service.InventroyReturnPayType.BY_COD);           // @Required: 支付方式 0到付;1月结
        createReq.setConsignee("测试收货人");                // @Required: 退供收货人
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(createReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        CreateInvReturnOrderRsp result = service.createInvReturnOrder(createReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("创建退供单表头测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 创建退供单表头 ==========");
    }
    
    /**
     * 测试: 修改退供单表头
     * 
     * EditInvReturnOrderReq @Required 字段 (2个):
     * - customerCode (客户编码)
     * - clientReturnSn (客户退供单号)
     */
    @Test
    public void testEditInvReturnOrder() throws Exception {
        logger.info("========== 测试开始: 修改退供单表头 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        EditInvReturnOrderReq editReq = new EditInvReturnOrderReq();
        editReq.setCustomerCode(CUSTOMER_CODE);      // @Required: 客户编码
        editReq.setClientReturnSn(TEST_CLIENT_RETURN_SN); // @Required: 客户退供单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(editReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        EditInvReturnOrderRsp result = service.editInvReturnOrder(editReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("修改退供单表头测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 修改退供单表头 ==========");
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
    
    /**
     * 测试: 导入退供单明细
     * 
     * ImportInvReturnDetailReq @Required 字段 (3个):
     * - customerCode (客户编码)
     * - clientReturnSn (客户退供单号)
     * - detailList (退供单信息)
     */
    @Test
    public void testImportInvReturnDetail() throws Exception {
        logger.info("========== 测试开始: 导入退供单明细 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        ImportInvReturnDetailReq importDetailReq = new ImportInvReturnDetailReq();
        importDetailReq.setCustomerCode(CUSTOMER_CODE);      // @Required: 客户编码
        importDetailReq.setClientReturnSn(TEST_CLIENT_RETURN_SN); // @Required: 客户退供单号
        // detailList 由框架处理
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(importDetailReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        ImportInvReturnDetailRsp result = service.importInvReturnDetail(importDetailReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("导入退供单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 导入退供单明细 ==========");
    }
    
    /**
     * 测试: 查询退供单
     * 
     * QueryInvReturnOrderReq @Required 字段 (1个):
     * - customerCode (客户编码)
     */
    @Test
    public void testQueryInvReturnOrder() throws Exception {
        logger.info("========== 测试开始: 查询退供单 ==========");
        
        // 1. 准备测试数据
        QueryInvReturnOrderReq queryReq = new QueryInvReturnOrderReq();
        queryReq.setCustomerCode(CUSTOMER_CODE); // @Required: 客户编码
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(queryReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        QueryInvReturnOrderRsp result = service.queryInvReturnOrder(queryReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("查询退供单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 查询退供单 ==========");
    }
    
    /**
     * 测试: 退供单明细查询
     * 
     * QueryInvReturnOrderDetailReq @Required 字段 (3个):
     * - customerCode (客户编码)
     * - pageNum (页码)
     * - pageSize (每页的记录数)
     */
    @Test
    public void testQueryInvReturnOrderDetail() throws Exception {
        logger.info("========== 测试开始: 退供单明细查询 ==========");
        
        // 1. 准备测试数据
        QueryInvReturnOrderDetailReq queryReq = new QueryInvReturnOrderDetailReq();
        queryReq.setCustomerCode(CUSTOMER_CODE); // @Required: 客户编码
        queryReq.setPageNum(1);                // @Required: 页码
        queryReq.setPageSize(20);               // @Required: 每页的记录数
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(queryReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        QueryInvReturnOrderDetailRsp result = service.queryInvReturnOrderDetail(queryReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("退供单明细查询测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 退供单明细查询 ==========");
    }
    
    /**
     * 测试: 退供单分页查询
     * 
     * SearchInvReturnOrderReq @Required 字段 (3个):
     * - customerCode (客户编码)
     * - pageSize (每页的记录数)
     * - pageNum (页码)
     */
    @Test
    public void testSearchInvReturnOrderList() throws Exception {
        logger.info("========== 测试开始: 退供单分页查询 ==========");
        
        // 1. 准备测试数据
        SearchInvReturnOrderReq searchReq = new SearchInvReturnOrderReq();
        searchReq.setCustomerCode(CUSTOMER_CODE); // @Required: 客户编码
        searchReq.setPageSize(20);               // @Required: 每页的记录数
        searchReq.setPageNum(1);                // @Required: 页码
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(searchReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        SearchInvReturnResult result = service.searchInvReturnOrderList(searchReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("退供单分页查询测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 退供单分页查询 ==========");
    }
    
    /**
     * 测试: 提交退供单
     * 
     * SubmitInvReturnOrderReq @Required 字段 (2个):
     * - customerCode (客户编码)
     * - clientReturnSn (客户退供单号)
     */
    @Test
    public void testSubmitInvReturnOrder() throws Exception {
        logger.info("========== 测试开始: 提交退供单 ==========");
        
        // 1. 准备测试数据
        SubmitInvReturnOrderReq submitReq = new SubmitInvReturnOrderReq();
        submitReq.setCustomerCode(CUSTOMER_CODE);      // @Required: 客户编码
        submitReq.setClientReturnSn(TEST_CLIENT_RETURN_SN); // @Required: 客户退供单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(submitReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        SubmitInvReturnOrderRsp result = service.submitInvReturnOrder(submitReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("提交退供单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 提交退供单 ==========");
    }
    
    // ==================== 辅助方法: 核实 @Required 注解 ====================
    
    /**
     * 辅助方法: 核实模型类的所有 @Required 字段
     * 用于开发时快速查看模型的必填字段
     * 
     * 使用方法:
     * mvn test -Dtest=WopOuterInvReturnOrderServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // CancelInvReturnOrderReq
        logger.info("\n【1】CancelInvReturnOrderReq 必填字段 (2个):");
        listRequiredFields(CancelInvReturnOrderReq.class);
        
        // CleanInvReturnDetailReq
        logger.info("\n【2】CleanInvReturnDetailReq 必填字段 (2个):");
        listRequiredFields(CleanInvReturnDetailReq.class);
        
        // CreateInvReturnOrderReq
        logger.info("\n【3】CreateInvReturnOrderReq 必填字段 (12个):");
        listRequiredFields(CreateInvReturnOrderReq.class);
        
        // EditInvReturnOrderReq
        logger.info("\n【4】EditInvReturnOrderReq 必填字段 (2个):");
        listRequiredFields(EditInvReturnOrderReq.class);
        
        // ImportInvReturnDetailReq
        logger.info("\n【5】ImportInvReturnDetailReq 必填字段 (3个):");
        listRequiredFields(ImportInvReturnDetailReq.class);
        
        // QueryInvReturnOrderReq
        logger.info("\n【6】QueryInvReturnOrderReq 必填字段 (1个):");
        listRequiredFields(QueryInvReturnOrderReq.class);
        
        // QueryInvReturnOrderDetailReq
        logger.info("\n【7】QueryInvReturnOrderDetailReq 必填字段 (3个):");
        listRequiredFields(QueryInvReturnOrderDetailReq.class);
        
        // SearchInvReturnOrderReq
        logger.info("\n【8】SearchInvReturnOrderReq 必填字段 (3个):");
        listRequiredFields(SearchInvReturnOrderReq.class);
        
        // SubmitInvReturnOrderReq
        logger.info("\n【9】SubmitInvReturnOrderReq 必填字段 (2个):");
        listRequiredFields(SubmitInvReturnOrderReq.class);
        
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
