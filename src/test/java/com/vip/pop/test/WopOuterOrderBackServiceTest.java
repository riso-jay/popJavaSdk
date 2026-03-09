package com.vip.pop.test;

import java.util.ArrayList;
import java.util.List;

import com.pjbest.wop.wm.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vip.pop.base.validator.RequiredValidator;

/**
 * WopOuterOrderBackService 测试类
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
public class WopOuterOrderBackServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(WopOuterOrderBackServiceTest.class);
    
    private WopOuterOrderBackService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CUSTOMER_CODE = "17002437";
    
    // 客退单信息
    private static final String TEST_ORDER_BACK_SN = "TEST_ORDER_BACK_001";
    private static final String TEST_ERP_ORDER_BACK_SN = "ERP_OB_001";
    private static final String TEST_ERP_ORDER_SN = "ERP_ORDER_001";
    
    // 仓库信息
    private static final String REV_WAREHOUSE = "WH001";
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new WopOuterOrderBackService();
        logger.info("WopOuterOrderBackServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 客户编码: {}", CUSTOMER_CODE);
        logger.info("  - 客退单号: {}", TEST_ORDER_BACK_SN);
        logger.info("  - ERP客退单号: {}", TEST_ERP_ORDER_BACK_SN);
        logger.info("  - ERP订单号: {}", TEST_ERP_ORDER_SN);
        logger.info("  - 收货仓: {}", REV_WAREHOUSE);
    }
    
    // ==================== 客退单操作 ====================
    
    /**
     * 测试: 创建客退单
     * 
     * OrderBackInfo @Required 字段 (3个):
     * - erpOrderBackSn (ERP客退单号)
     * - orderBackType (客退单类型 0-拒收 1-退货)
     * - erpOrderSn (erp订单号)
     * - revcWarehouse (收货仓)
     */
    @Test
    public void testCreateOrder() throws Exception {
        logger.info("========== 测试开始: 创建客退单 ==========");
        
        // 1. 准备客退单信息 (根据 @Required 注解设置必填字段)
        OrderBackInfo orderBackInfo = new OrderBackInfo();
        orderBackInfo.setErpOrderBackSn(TEST_ERP_ORDER_BACK_SN);  // @Required: ERP客退单号
        orderBackInfo.setOrderBackType((byte) 1);                // @Required: 客退单类型 (0-拒收 1-退货)
        orderBackInfo.setErpOrderSn(TEST_ERP_ORDER_SN);            // @Required: erp订单号
        orderBackInfo.setRevcWarehouse(REV_WAREHOUSE);             // @Required: 收货仓
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(orderBackInfo);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        ObCreateResult result = service.createOrder(CUSTOMER_CODE, orderBackInfo);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("创建客退单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 创建客退单 ==========");
    }
    
    /**
     * 测试: 取消客退单
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - orderBackSn (客退单号)
     */
    @Test
    public void testCancelOrder() throws Exception {
        logger.info("========== 测试开始: 取消客退单 ==========");
        
        // 1. 调用API (只设置服务方法验证的必填参数)
        ObCancelResult result = service.cancelOrder(
            CUSTOMER_CODE,        // 必填: 客户编码 (统一使用 17002437)
            TEST_ORDER_BACK_SN     // 必填: 客退单号
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("取消客退单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 取消客退单 ==========");
    }
    
    /**
     * 测试: 修改客退单承运商信息
     * 
     * ModifyCarrierRequest @Required 字段 (4个):
     * - customerCode (货主(客户)编码)
     * - erpOrderBackSn (ERP(客户)客退单号)
     * - transportNo (运单号)
     * - carrierCode (承运商)
     */
    @Test
    public void testModifyCarrier() throws Exception {
        logger.info("========== 测试开始: 修改客退单承运商信息 ==========");
        
        // 1. 准备修改请求 (根据 @Required 注解设置必填字段)
        ModifyCarrierRequest req = new ModifyCarrierRequest();
        req.setCustomerCode(CUSTOMER_CODE);            // @Required: 货主(客户)编码 (统一使用 17002437)
        req.setErpOrderBackSn(TEST_ERP_ORDER_BACK_SN);  // @Required: ERP(客户)客退单号
        req.setTransportNo("SF1234567890");            // @Required: 运单号
        req.setCarrierCode("SF");                       // @Required: 承运商
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(req);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        ModifyCarrierRespone result = service.modifyCarrier(req);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("修改客退单承运商信息测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 修改客退单承运商信息 ==========");
    }
    
    /**
     * 测试: 查询客退单详情
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - orderBackSn (客退单号)
     */
    @Test
    public void testQueryOrderDetail() throws Exception {
        logger.info("========== 测试开始: 查询客退单详情 ==========");
        
        // 1. 调用API (只设置服务方法验证的必填参数)
        WopOrderBackInfo result = service.queryOrderDetail(
            CUSTOMER_CODE,        // 必填: 客户编码 (统一使用 17002437)
            TEST_ORDER_BACK_SN    // 必填: 客退单号
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("查询客退单详情测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 查询客退单详情 ==========");
    }
    
    /**
     * 测试: 通过erp订单号查询客退单列表
     * 
     * 必填参数:
     * - customerCode (客户编码) - 服务方法验证
     * 
     * QueryByErpOrderSnReq @Required 字段 (1个):
     * - erpOrderSn (erp订单号)
     */
    @Test
    public void testQueryOrderBackByErpOrderSn() throws Exception {
        logger.info("========== 测试开始: 通过erp订单号查询客退单列表 ==========");
        
        // 1. 准备查询条件 (根据 @Required 注解设置必填字段)
        QueryByErpOrderSnReq req = new QueryByErpOrderSnReq();
        req.setErpOrderSn(TEST_ERP_ORDER_SN);  // @Required: erp订单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(req);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        List<WopOrderBackInfo> result = service.queryOrderBackByErpOrderSn(CUSTOMER_CODE, req);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("通过erp订单号查询客退单列表测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 通过erp订单号查询客退单列表 ==========");
    }
    
    /**
     * 测试: 查询客退单
     * 
     * 必填参数同上
     */
    @Test
    public void testSearchOrderList() throws Exception {
        logger.info("========== 测试开始: 查询客退单 ==========");
        
        // 1. 准备查询条件
        QueryByErpOrderSnReq req = new QueryByErpOrderSnReq();
        req.setErpOrderSn(TEST_ERP_ORDER_SN);  // @Required: erp订单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(req);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        List<WopOrderBackInfo> result = service.searchOrderList(CUSTOMER_CODE, req);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("查询客退单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 查询客退单 ==========");
    }
    
    /**
     * 测试: 批量查询客退单状态
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - orderBackSns (客退单号列表,不能为空)
     */
    @Test
    public void testQueryOrderStatusBatch() throws Exception {
        logger.info("========== 测试开始: 批量查询客退单状态 ==========");
        
        // 1. 准备客退单号列表
        List<String> orderBackSns = new ArrayList<>();
        orderBackSns.add(TEST_ORDER_BACK_SN);
        orderBackSns.add(TEST_ORDER_BACK_SN + "_002");
        
        // 2. 调用API (没有异常即通过测试)
        List<ObStatusResult> result = service.queryOrderStatusBatch(
            CUSTOMER_CODE,  // 必填: 客户编码 (统一使用 17002437)
            orderBackSns    // 必填: 客退单号列表
        );
        
        // 3. 测试通过 (无断言,无异常即通过)
        logger.info("批量查询客退单状态测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 批量查询客退单状态 ==========");
    }
    
    // ==================== 健康检查 ====================
    
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
     * mvn test -Dtest=WopOuterOrderBackServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // OrderBackInfo
        logger.info("\n【1】OrderBackInfo 必填字段 (4个):");
        listRequiredFields(OrderBackInfo.class);
        
        // ModifyCarrierRequest
        logger.info("\n【2】ModifyCarrierRequest 必填字段 (4个):");
        listRequiredFields(ModifyCarrierRequest.class);
        
        // QueryByErpOrderSnReq
        logger.info("\n【3】QueryByErpOrderSnReq 必填字段 (1个):");
        listRequiredFields(QueryByErpOrderSnReq.class);
        
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
