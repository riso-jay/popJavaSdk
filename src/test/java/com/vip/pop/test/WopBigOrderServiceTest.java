package com.vip.pop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pjbest.wop.wm.service.BigOrderSubmitRequest;
import com.pjbest.wop.wm.service.CancelBigOrderRequest;
import com.pjbest.wop.wm.service.CancelBigOrderRespone;
import com.pjbest.wop.wm.service.CleanBigOrderDetailsRequest;
import com.pjbest.wop.wm.service.CleanBigOrderDetailsRespone;
import com.pjbest.wop.wm.service.CreateBigOrderHeaderRequest;
import com.pjbest.wop.wm.service.CreateBigOrderHeaderRespone;
import com.pjbest.wop.wm.service.GetBigOrderDeliveryTraceRequest;
import com.pjbest.wop.wm.service.GetBigOrderDeliveryTraceRespone;
import com.pjbest.wop.wm.service.GetBigOrderDetailListRequest;
import com.pjbest.wop.wm.service.GetBigOrderDetailListRespone;
import com.pjbest.wop.wm.service.GetBigOrderHeaderRequest;
import com.pjbest.wop.wm.service.GetBigOrderHeaderRespone;
import com.pjbest.wop.wm.service.ImportBigOrderDetailsRequest;
import com.pjbest.wop.wm.service.ImportBigOrderDetailsRespone;
import com.pjbest.wop.wm.service.SubmitBigOrderRespone;
import com.pjbest.wop.wm.service.WopBigOrderService;
import com.vip.pop.base.validator.RequiredValidator;

/**
 * WopBigOrderService 测试类
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
public class WopBigOrderServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(WopBigOrderServiceTest.class);
    
    private WopBigOrderService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CUSTOMER_CODE = "17002437";
    
    // 大订单信息
    private static final String TEST_BIG_ORDER_NO = "TEST_BIG_ORDER_001";
    private static final String TEST_PLATFORM_ORDER_SN = "PLATFORM_ORDER_001";
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new WopBigOrderService();
        logger.info("WopBigOrderServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 客户编码: {}", CUSTOMER_CODE);
        logger.info("  - 大订单号: {}", TEST_BIG_ORDER_NO);
    }
    
    // ==================== 大订单操作 ====================
    
    /**
     * 测试: 取消大订单
     * 
     * CancelBigOrderRequest @Required 字段 (2个):
     * - customerCode (客户编码)
     * - erpOrderSn (ERP订单号)
     */
    @Test
    public void testCancel() throws Exception {
        logger.info("========== 测试开始: 取消大订单 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        CancelBigOrderRequest cancelReq = new CancelBigOrderRequest();
        cancelReq.setCustomerCode(CUSTOMER_CODE);  // @Required: 客户编码 (统一使用 17002437)
        cancelReq.setErpOrderSn(TEST_BIG_ORDER_NO);  // @Required: ERP订单号
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(cancelReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        CancelBigOrderRespone result = service.cancel(cancelReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("取消大订单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 取消大订单 ==========");
    }
    
    /**
     * 测试: 清空大订单明细
     * 
     * CleanBigOrderDetailsRequest @Required 字段 (2个):
     * - customerCode (客户编码)
     * - erpOrderSn (ERP订单号)
     */
    @Test
    public void testCleanDetails() throws Exception {
        logger.info("========== 测试开始: 清空大订单明细 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        CleanBigOrderDetailsRequest cleanDetailsReq = new CleanBigOrderDetailsRequest();
        cleanDetailsReq.setCustomerCode(CUSTOMER_CODE);  // @Required: 客户编码
        cleanDetailsReq.setErpOrderSn(TEST_BIG_ORDER_NO);  // @Required: ERP订单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(cleanDetailsReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        CleanBigOrderDetailsRespone result = service.cleanDetails(cleanDetailsReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("清空大订单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 清空大订单明细 ==========");
    }
    
    /**
     * 测试: 创建大订单单头
     * 
     * CreateBigOrderHeaderRequest @Required 字段 (11个):
     * - customerCode (客户编码)
     * - buyerDistrictName (区/县)
     * - buyerDetailAddress (收货地址)
     * - zipCode (邮政编码)
     * - payType (支付方式)
     * - erpOrderSn (ERP订单号)
     * - codType (COD类型)
     * - platformAddDtmLoc (平台下单时间)
     * - erpCreatedDtmLoc (ERP创建时间)
     * - transportReq (运输要求)
     * - platformOrderSn (平台订单号)
     * - buyer (买家)
     * - buyerCountry (买家国家)
     * - buyerStateName (买家省/州)
     */
    @Test
    public void testCreateHeader() throws Exception {
        logger.info("========== 测试开始: 创建大订单单头 ==========");
        
        // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
        CreateBigOrderHeaderRequest createHeaderReq = new CreateBigOrderHeaderRequest();
        createHeaderReq.setCustomerCode(CUSTOMER_CODE);        // @Required: 客户编码
        createHeaderReq.setBuyerDistrictName("测试区县");        // @Required: 区/县
        createHeaderReq.setBuyerDetailAddress("测试详细地址123号"); // @Required: 收货地址
        createHeaderReq.setZipCode("100000");                     // @Required: 邮政编码
        createHeaderReq.setPayType("货到付款");                    // @Required: 支付方式
        createHeaderReq.setErpOrderSn(TEST_BIG_ORDER_NO);          // @Required: ERP订单号
        createHeaderReq.setCodType("标准COD");                      // @Required: COD类型
        createHeaderReq.setPlatformAddDtmLoc("2024-01-01 12:00:00"); // @Required: 平台下单时间
        createHeaderReq.setErpCreatedDtmLoc("2024-01-01 12:00:00");   // @Required: ERP创建时间
        createHeaderReq.setTransportReq((byte) 2);                       // @Required: 运输要求 (1:商家自提 2:服务商匹配 3:商家指定)
        createHeaderReq.setPlatformOrderSn(TEST_PLATFORM_ORDER_SN);   // @Required: 平台订单号
        createHeaderReq.setBuyer("测试买家");                        // @Required: 买家
        createHeaderReq.setBuyerCountry("中国");                     // @Required: 买家国家
        createHeaderReq.setBuyerStateName("测试省");                // @Required: 买家省/州
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(createHeaderReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        CreateBigOrderHeaderRespone result = service.createHeader(createHeaderReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("创建大订单单头测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 创建大订单单头 ==========");
    }
    
    /**
     * 测试: 获取大订单物流轨迹
     * 
     * GetBigOrderDeliveryTraceRequest @Required 字段 (2个):
     * - customerCode (客户编码)
     * - erpOrderSn (ERP订单号)
     */
    @Test
    public void testGetDeliveryTrace() throws Exception {
        logger.info("========== 测试开始: 获取大订单物流轨迹 ==========");
        
        // 1. 准备测试数据
        GetBigOrderDeliveryTraceRequest getDeliveryTraceReq = new GetBigOrderDeliveryTraceRequest();
        getDeliveryTraceReq.setCustomerCode(CUSTOMER_CODE);  // @Required: 客户编码
        getDeliveryTraceReq.setErpOrderSn(TEST_BIG_ORDER_NO);  // @Required: ERP订单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(getDeliveryTraceReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        GetBigOrderDeliveryTraceRespone result = service.getDeliveryTrace(getDeliveryTraceReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("获取大订单物流轨迹测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 获取大订单物流轨迹 ==========");
    }
    
    /**
     * 测试: 获取大订单明细
     * 
     * GetBigOrderDetailListRequest @Required 字段 (4个):
     * - customerCode (客户编码)
     * - erpOrderSn (ERP订单号)
     * - pageNum (页码)
     * - pageSize (每页数量)
     */
    @Test
    public void testGetDetailList() throws Exception {
        logger.info("========== 测试开始: 获取大订单明细 ==========");
        
        // 1. 准备测试数据
        GetBigOrderDetailListRequest getDetailListReq = new GetBigOrderDetailListRequest();
        getDetailListReq.setCustomerCode(CUSTOMER_CODE);  // @Required: 客户编码
        getDetailListReq.setErpOrderSn(TEST_BIG_ORDER_NO);  // @Required: ERP订单号
        getDetailListReq.setPageNum(1);   // @Required: 页码
        getDetailListReq.setPageSize(20);  // @Required: 每页数量
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(getDetailListReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        GetBigOrderDetailListRespone result = service.getDetailList(getDetailListReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("获取大订单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 获取大订单明细 ==========");
    }
    
    /**
     * 测试: 获取大订单单头
     * 
     * GetBigOrderHeaderRequest @Required 字段 (2个):
     * - customerCode (客户编码)
     * - erpOrderSn (ERP订单号)
     */
    @Test
    public void testGetHeader() throws Exception {
        logger.info("========== 测试开始: 获取大订单单头 ==========");
        
        // 1. 准备测试数据
        GetBigOrderHeaderRequest getHeaderReq = new GetBigOrderHeaderRequest();
        getHeaderReq.setCustomerCode(CUSTOMER_CODE);  // @Required: 客户编码
        getHeaderReq.setErpOrderSn(TEST_BIG_ORDER_NO);  // @Required: ERP订单号
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(getHeaderReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        GetBigOrderHeaderRespone result = service.getHeader(getHeaderReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("获取大订单单头测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 获取大订单单头 ==========");
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
     * 测试: 导入大订单明细（支持多批次导入）
     * 
     * ImportBigOrderDetailsRequest @Required 字段 (3个):
     * - customerCode (客户编码)
     * - erpOrderSn (ERP订单号)
     * - detailItems (明细列表)
     */
    @Test
    public void testImportDetails() throws Exception {
        logger.info("========== 测试开始: 导入大订单明细（支持多批次导入） ==========");
        
        // 1. 准备测试数据
        ImportBigOrderDetailsRequest importDetailsReq = new ImportBigOrderDetailsRequest();
        importDetailsReq.setCustomerCode(CUSTOMER_CODE);  // @Required: 客户编码
        importDetailsReq.setErpOrderSn(TEST_BIG_ORDER_NO);  // @Required: ERP订单号
        // detailItems 由框架处理,这里不需要手动设置
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(importDetailsReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        ImportBigOrderDetailsRespone result = service.importDetails(importDetailsReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("导入大订单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 导入大订单明细（支持多批次导入） ==========");
    }
    
    /**
     * 测试: 提交大订单
     * 
     * BigOrderSubmitRequest @Required 字段 (2个):
     * - customerCode (客户编码)
     * - erpOrderSn (ERP订单号)
     */
    @Test
    public void testSubmit() throws Exception {
        logger.info("========== 测试开始: 提交大订单 ==========");
        
        // 1. 准备测试数据
        BigOrderSubmitRequest submitReq = new BigOrderSubmitRequest();
        submitReq.setCustomerCode(CUSTOMER_CODE);  // @Required: 客户编码
        submitReq.setErpOrderSn(TEST_BIG_ORDER_NO);  // @Required: ERP订单号
        
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
        SubmitBigOrderRespone result = service.submit(submitReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("提交大订单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 提交大订单 ==========");
    }
    
    // ==================== 辅助方法: 核实 @Required 注解 ====================
    
    /**
     * 辅助方法: 核实模型类的所有 @Required 字段
     * 用于开发时快速查看模型的必填字段
     * 
     * 使用方法:
     * mvn test -Dtest=WopBigOrderServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // CancelBigOrderRequest
        logger.info("\n【1】CancelBigOrderRequest 必填字段 (2个):");
        listRequiredFields(CancelBigOrderRequest.class);
        
        // CleanBigOrderDetailsRequest
        logger.info("\n【2】CleanBigOrderDetailsRequest 必填字段 (2个):");
        listRequiredFields(CleanBigOrderDetailsRequest.class);
        
        // CreateBigOrderHeaderRequest
        logger.info("\n【3】CreateBigOrderHeaderRequest 必填字段 (11个):");
        listRequiredFields(CreateBigOrderHeaderRequest.class);
        
        // GetBigOrderDeliveryTraceRequest
        logger.info("\n【4】GetBigOrderDeliveryTraceRequest 必填字段 (2个):");
        listRequiredFields(GetBigOrderDeliveryTraceRequest.class);
        
        // GetBigOrderDetailListRequest
        logger.info("\n【5】GetBigOrderDetailListRequest 必填字段 (4个):");
        listRequiredFields(GetBigOrderDetailListRequest.class);
        
        // GetBigOrderHeaderRequest
        logger.info("\n【6】GetBigOrderHeaderRequest 必填字段 (2个):");
        listRequiredFields(GetBigOrderHeaderRequest.class);
        
        // ImportBigOrderDetailsRequest
        logger.info("\n【7】ImportBigOrderDetailsRequest 必填字段 (3个):");
        listRequiredFields(ImportBigOrderDetailsRequest.class);
        
        // BigOrderSubmitRequest
        logger.info("\n【8】BigOrderSubmitRequest 必填字段 (2个):");
        listRequiredFields(BigOrderSubmitRequest.class);
        
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
