package com.vip.pop.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pjbest.wop.wm.service.CreateOrderTaskResult;
import com.pjbest.wop.wm.service.CreateOrderTaskStatus;
import com.pjbest.wop.wm.service.GetOrderDeliveryTraceRequest;
import com.pjbest.wop.wm.service.GetOrderDeliveryTraceRespone;
import com.pjbest.wop.wm.service.OrderCancelResult;
import com.pjbest.wop.wm.service.OrderDetail;
import com.pjbest.wop.wm.service.OrderInfo;
import com.pjbest.wop.wm.service.OrderLackConfirmRequest;
import com.pjbest.wop.wm.service.OrderLackConfirmRespone;
import com.pjbest.wop.wm.service.OrderStatus;
import com.pjbest.wop.wm.service.OrderTrace;
import com.pjbest.wop.wm.service.QueryOutQtyRequest;
import com.pjbest.wop.wm.service.QueryOutQtyRespone;
import com.pjbest.wop.wm.service.WopOuterOrderService;
import com.vip.pop.base.validator.RequiredValidator;

/**
 * WopOuterOrderService 测试类
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
public class WopOuterOrderServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(WopOuterOrderServiceTest.class);
    
    private WopOuterOrderService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CUSTOMER_CODE = "17002437";
    
    // 订单信息
    private static final String TEST_WOP_ERP_ORDER_SN = "TEST_WOP_ERP_ORDER_001";
    private static final String TEST_ERP_ORDER_SN = "TEST_ERP_ORDER_001";
    
    // 分页参数
    private static final Long DEFAULT_MAX_ID = 0L;
    private static final Integer DEFAULT_LIMIT = 10;
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new WopOuterOrderService();
        logger.info("WopOuterOrderServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 客户编码: {}", CUSTOMER_CODE);
        logger.info("  - ERP订单号: {}", TEST_ERP_ORDER_SN);
        logger.info("  - 唯品ERP订单号: {}", TEST_WOP_ERP_ORDER_SN);
    }
    
    // ==================== 订单操作 ====================
    
    /**
     * 测试: 批量取消订单
     * 
     * 无 @Required 字段
     */
    @Test
    public void testBatchCancelOrder() throws Exception {
        logger.info("========== 测试开始: 批量取消订单 ==========");
        
        // 1. 准备测试数据
        List<String> wopErpOrderSnList = new ArrayList<>();
        wopErpOrderSnList.add(TEST_WOP_ERP_ORDER_SN);
        
        // 2. 调用API (没有异常即通过测试)
        List<OrderCancelResult> result = service.batchCancelOrder(CUSTOMER_CODE, wopErpOrderSnList);
        
        // 3. 测试通过 (无断言,无异常即通过)
        logger.info("批量取消订单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 批量取消订单 ==========");
    }
    
    /**
     * 测试: 获取订单物流轨迹
     * 
     * 无 @Required 字段
     */
    @Test
    public void testGetDeliveryTrace() throws Exception {
        logger.info("========== 测试开始: 获取订单物流轨迹 ==========");
        
        // 1. 准备测试数据
        GetOrderDeliveryTraceRequest req = new GetOrderDeliveryTraceRequest();
        req.setCustomerCode(CUSTOMER_CODE);
        req.setErpOrderSn(TEST_WOP_ERP_ORDER_SN);
        
        // 2. 调用API (没有异常即通过测试)
        GetOrderDeliveryTraceRespone result = service.getDeliveryTrace(req);
        
        // 3. 测试通过 (无断言,无异常即通过)
        logger.info("获取订单物流轨迹测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 获取订单物流轨迹 ==========");
    }
    
    /**
     * 测试: 查询订单明细
     * 
     * 无 @Required 字段
     */
    @Test
    public void testGetOrderDetails() throws Exception {
        logger.info("========== 测试开始: 查询订单明细 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        List<OrderDetail> result = service.getOrderDetails(CUSTOMER_CODE, TEST_WOP_ERP_ORDER_SN);
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("查询订单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 查询订单明细 ==========");
    }
    
    /**
     * 测试: 获取订单缺货
     * 
     * 无 @Required 字段
     */
    @Test
    public void testGetOrderLackByMaxId() throws Exception {
        logger.info("========== 测试开始: 获取订单缺货 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        service.getOrderLackByMaxId();
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("获取订单缺货测试通过");
        logger.info("========== 测试通过: 获取订单缺货 ==========");
    }
    
    /**
     * 测试: 查询订单状态
     * 
     * 无 @Required 字段
     */
    @Test
    public void testGetOrderStatus() throws Exception {
        logger.info("========== 测试开始: 查询订单状态 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        OrderStatus result = service.getOrderStatus(CUSTOMER_CODE, TEST_WOP_ERP_ORDER_SN);
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("查询订单状态测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 查询订单状态 ==========");
    }
    
    /**
     * 测试: 批量查询订单状态
     * 
     * 无 @Required 字段
     */
    @Test
    public void testGetOrderStatusBatch() throws Exception {
        logger.info("========== 测试开始: 批量查询订单状态 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        List<OrderStatus> result = service.getOrderStatusBatch(CUSTOMER_CODE, DEFAULT_MAX_ID, DEFAULT_LIMIT);
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("批量查询订单状态测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 批量查询订单状态 ==========");
    }
    
    /**
     * 测试: 查询订单轨迹
     * 
     * 无 @Required 字段
     */
    @Test
    public void testGetOrderTrace() throws Exception {
        logger.info("========== 测试开始: 查询订单轨迹 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        List<OrderTrace> result = service.getOrderTrace(CUSTOMER_CODE, TEST_WOP_ERP_ORDER_SN);
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("查询订单轨迹测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 查询订单轨迹 ==========");
    }
    
    /**
     * 测试: 根据客户ERP订单号查询唯品物流ERP订单号
     * 
     * 无 @Required 字段
     */
    @Test
    public void testGetWopErpOrderSnByCustomerErpOrderSn() throws Exception {
        logger.info("========== 测试开始: 根据客户ERP订单号查询唯品物流ERP订单号 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        String result = service.getWopErpOrderSnByCustomerErpOrderSn(CUSTOMER_CODE, TEST_ERP_ORDER_SN);
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("根据客户ERP订单号查询唯品物流ERP订单号测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 根据客户ERP订单号查询唯品物流ERP订单号 ==========");
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
     * 测试: 订单缺货拉取确认
     * 
     * OrderLackConfirmRequest @Required 字段 (2个):
     * - customerCode (货主编码)
     * - id (订单缺货唯一标记ID)
     */
    @Test
    public void testOrderLackConfirm() throws Exception {
        logger.info("========== 测试开始: 订单缺货拉取确认 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        OrderLackConfirmRequest req = new OrderLackConfirmRequest();
        req.setCustomerCode(CUSTOMER_CODE);  // @Required: 货主编码
        req.setId(1L);                        // @Required: 订单缺货唯一标记ID
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(req);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        OrderLackConfirmRespone result = service.orderLackConfirm(req);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("订单缺货拉取确认测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 订单缺货拉取确认 ==========");
    }
    
    /**
     * 测试: 批量查询创建订单任务状态
     * 
     * 无 @Required 字段
     */
    @Test
    public void testQueryCreateOrderTaskStatus() throws Exception {
        logger.info("========== 测试开始: 批量查询创建订单任务状态 ==========");
        
        // 1. 准备测试数据
        List<String> createOrderTaskCodeList = new ArrayList<>();
        createOrderTaskCodeList.add("TASK_001");
        
        // 2. 调用API (没有异常即通过测试)
        List<CreateOrderTaskStatus> result = service.queryCreateOrderTaskStatus(CUSTOMER_CODE, createOrderTaskCodeList);
        
        // 3. 测试通过 (无断言,无异常即通过)
        logger.info("批量查询创建订单任务状态测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 批量查询创建订单任务状态 ==========");
    }
    
    /**
     * 测试: 查询订单出仓数量（带PO）
     * 
     * QueryOutQtyRequest @Required 字段 (2个):
     * - customerCode (货主编码)
     * - odsOrderSn (ODS订单号)
     */
    @Test
    public void testQueryOutQty() throws Exception {
        logger.info("========== 测试开始: 查询订单出仓数量（带PO） ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        QueryOutQtyRequest req = new QueryOutQtyRequest();
        req.setCustomerCode(CUSTOMER_CODE);        // @Required: 货主编码
        req.setOdsOrderSn("ODS_ORDER_001");         // @Required: ODS订单号
        
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
        QueryOutQtyRespone result = service.queryOutQty(req);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("查询订单出仓数量（带PO）测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 查询订单出仓数量（带PO） ==========");
    }
    
    /**
     * 测试: 批量提交创建订单任务（异步创建订单）
     * 
     * 无 @Required 字段
     */
    @Test
    public void testSubmitCreateOrderTask() throws Exception {
        logger.info("========== 测试开始: 批量提交创建订单任务（异步创建订单） ==========");
        
        // 1. 准备测试数据
        List<OrderInfo> orderInfoList = new ArrayList<>();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setErpOrderSn(TEST_ERP_ORDER_SN);
        orderInfoList.add(orderInfo);
        
        // 2. 调用API (没有异常即通过测试)
        List<CreateOrderTaskResult> result = service.submitCreateOrderTask(CUSTOMER_CODE, orderInfoList);
        
        // 3. 测试通过 (无断言,无异常即通过)
        logger.info("批量提交创建订单任务测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 批量提交创建订单任务（异步创建订单） ==========");
    }
    
    // ==================== 辅助方法: 核实 @Required 注解 ====================
    
    /**
     * 辅助方法: 核实模型类的所有 @Required 字段
     * 用于开发时快速查看模型的必填字段
     * 
     * 使用方法:
     * mvn test -Dtest=WopOuterOrderServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // OrderLackConfirmRequest
        logger.info("\n【1】OrderLackConfirmRequest 必填字段 (2个):");
        listRequiredFields(OrderLackConfirmRequest.class);
        
        // QueryOutQtyRequest
        logger.info("\n【2】QueryOutQtyRequest 必填字段 (2个):");
        listRequiredFields(QueryOutQtyRequest.class);
        
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
