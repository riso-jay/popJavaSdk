package com.vip.pop.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pjbest.wop.wm.service.CreateTransferInfo;
import com.pjbest.wop.wm.service.CreateTransferRespone;
import com.pjbest.wop.wm.service.EditTransferInfo;
import com.pjbest.wop.wm.service.ImpTransferDetail;
import com.pjbest.wop.wm.service.TransferImportDetailResult;
import com.pjbest.wop.wm.service.TransferOperationResult;
import com.pjbest.wop.wm.service.WopOuterTransferService;
import com.vip.pop.base.validator.RequiredValidator;

/**
 * WopOuterTransferService 测试类
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
public class WopOuterTransferServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(WopOuterTransferServiceTest.class);
    
    private WopOuterTransferService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CUSTOMER_CODE = "17002437";
    
    // 调拨单信息
    private static final String TEST_ERP_TRANSFER_SN = "TEST_ERP_TRANSFER_001";
    private static final String TEST_TRANSFER_NO = "TEST_TRANSFER_001";
    
    // 仓库信息
    private static final String FROM_WAREHOUSE = "WH001";
    private static final String TO_WAREHOUSE = "WH002";
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new WopOuterTransferService();
        logger.info("WopOuterTransferServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 客户编码: {}", CUSTOMER_CODE);
        logger.info("  - ERP调拨单号: {}", TEST_ERP_TRANSFER_SN);
        logger.info("  - 调拨单号: {}", TEST_TRANSFER_NO);
        logger.info("  - 发货仓库: {}", FROM_WAREHOUSE);
        logger.info("  - 收货仓库: {}", TO_WAREHOUSE);
    }
    
    // ==================== 仓间调拨单操作 ====================
    
    /**
     * 测试: 创建调拨单表头
     * 
     * CreateTransferInfo @Required 字段 (7个):
     * - erpTransferSn (ERP调拨单号)
     * - transferType (调拨类型 110:普通调拨 111:残次调拨 QDCF:调拨渠道拆分)
     * - fromWarehouseCode (调拨发货仓库)
     * - toWarehouseCode (调拨收货仓库)
     * - payType (支付方式 0:到付 1:月结)
     * - toEmail (通知邮箱)
     * - erpCreater (ERP创建人)
     */
    @Test
    public void testCreateTransfer() throws Exception {
        logger.info("========== 测试开始: 创建调拨单表头 ==========");
        
        // 1. 准备调拨单信息 (根据 @Required 注解设置必填字段)
        CreateTransferInfo createTransferInfo = new CreateTransferInfo();
        createTransferInfo.setErpTransferSn(TEST_ERP_TRANSFER_SN);  // @Required: ERP调拨单号
        createTransferInfo.setTransferType("110");                     // @Required: 调拨类型 (110:普通调拨)
        createTransferInfo.setFromWarehouseCode(FROM_WAREHOUSE);       // @Required: 调拨发货仓库
        createTransferInfo.setToWarehouseCode(TO_WAREHOUSE);          // @Required: 调拨收货仓库
        createTransferInfo.setPayType((byte) 0);                       // @Required: 支付方式 (0:到付 1:月结)
        createTransferInfo.setToEmail("test@example.com");            // @Required: 通知邮箱
        createTransferInfo.setErpCreater("TEST_USER");                 // @Required: ERP创建人
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(createTransferInfo);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        CreateTransferRespone result = service.createTransfer(CUSTOMER_CODE, createTransferInfo);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("创建调拨单表头测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 创建调拨单表头 ==========");
    }
    
    /**
     * 测试: 创建调拨单
     * 
     * 必填参数:
     * - customerCode (客户编码)
     * - transferInfo (调拨单信息)
     * - transferDetailList (调拨单明细列表)
     */
    @Test
    public void testCreateTransferOrder() throws Exception {
        logger.info("========== 测试开始: 创建调拨单 ==========");
        
        // 1. 准备调拨单信息
        CreateTransferInfo createTransferInfo = new CreateTransferInfo();
        createTransferInfo.setErpTransferSn(TEST_ERP_TRANSFER_SN);
        createTransferInfo.setTransferType("110");
        createTransferInfo.setFromWarehouseCode(FROM_WAREHOUSE);
        createTransferInfo.setToWarehouseCode(TO_WAREHOUSE);
        createTransferInfo.setPayType((byte) 0);
        createTransferInfo.setToEmail("test@example.com");
        createTransferInfo.setErpCreater("TEST_USER");
        
        // 准备调拨单明细
        List<ImpTransferDetail> detailList = new ArrayList<>();
        ImpTransferDetail detail = new ImpTransferDetail();
        detail.setItemCode("ITEM_001");  // @Required: 商品条形码
        detail.setQty(10);               // @Required: 调拨申请数量
        detail.setType("3PL");            // @Required: 库存类型;只支持3PL
        detailList.add(detail);
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(createTransferInfo);
            logger.info("调拨单信息验证通过");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            throw e;
        }
        
        for (ImpTransferDetail item : detailList) {
            try {
                RequiredValidator.validate(item);
                logger.info("调拨单明细验证通过");
            } catch (IllegalArgumentException e) {
                logger.error("测试数据验证失败: {}", e.getMessage());
                throw e;
            }
        }
        
        // 3. 调用API (没有异常即通过测试)
        CreateTransferRespone result = service.createTransferOrder(CUSTOMER_CODE, createTransferInfo, detailList);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("创建调拨单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 创建调拨单 ==========");
    }
    
    /**
     * 测试: 编辑调拨单
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - erpTransferSn (ERP调拨单号)
     * - transferInfo (调拨单信息)
     */
    @Test
    public void testEditTransfer() throws Exception {
        logger.info("========== 测试开始: 编辑调拨单 ==========");
        
        // 1. 准备调拨单信息 (使用 EditTransferInfo - 空类,只做演示)
        EditTransferInfo editTransferInfo = new EditTransferInfo();
        // EditTransferInfo 没有必填字段
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(editTransferInfo);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        TransferOperationResult result = service.editTransfer(CUSTOMER_CODE, TEST_ERP_TRANSFER_SN, editTransferInfo);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("编辑调拨单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 编辑调拨单 ==========");
    }
    
    /**
     * 测试: 取消调拨单
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - erpTransferSn (ERP调拨单号)
     * - actionTime (操作时间)
     * - userName (操作人)
     */
    @Test
    public void testCancelTransfer() throws Exception {
        logger.info("========== 测试开始: 取消调拨单 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        TransferOperationResult result = service.cancelTransfer(
            CUSTOMER_CODE,           // 必填: 客户编码
            TEST_ERP_TRANSFER_SN,     // 必填: ERP调拨单号
            "测试取消原因",             // 选填: 取消原因
            "2025-03-07 10:00:00",   // 必填: 操作时间
            "TEST_USER"              // 必填: 操作人
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("取消调拨单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 取消调拨单 ==========");
    }
    
    /**
     * 测试: 导入调拨单明细
     * 
     * ImpTransferDetail @Required 字段 (3个):
     * - itemCode (商品条形码)
     * - qty (调拨申请数量)
     * - type (库存类型;只支持3PL)
     */
    @Test
    public void testImportTransferDetail() throws Exception {
        logger.info("========== 测试开始: 导入调拨单明细 ==========");
        
        // 1. 准备调拨单明细 (根据 @Required 注解设置必填字段)
        List<ImpTransferDetail> detailList = new ArrayList<>();
        ImpTransferDetail detail = new ImpTransferDetail();
        detail.setItemCode("ITEM_001");  // @Required: 商品条形码
        detail.setQty(10);               // @Required: 调拨申请数量
        detail.setType("3PL");            // @Required: 库存类型;只支持3PL
        detailList.add(detail);
        
        // 2. 验证测试数据
        for (ImpTransferDetail item : detailList) {
            try {
                RequiredValidator.validate(item);
                logger.info("测试数据验证通过,所有 @Required 字段已设置");
            } catch (IllegalArgumentException e) {
                logger.error("测试数据验证失败: {}", e.getMessage());
                logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
                throw e;
            }
        }
        
        // 3. 调用API (没有异常即通过测试)
        TransferImportDetailResult result = service.importTransferDetail(CUSTOMER_CODE, TEST_ERP_TRANSFER_SN, detailList);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("导入调拨单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 导入调拨单明细 ==========");
    }
    
    /**
     * 测试: 提交调拨单
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - erpTransferSn (ERP调拨单号)
     */
    @Test
    public void testSubmitTransfer() throws Exception {
        logger.info("========== 测试开始: 提交调拨单 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        TransferOperationResult result = service.submitTransfer(CUSTOMER_CODE, TEST_ERP_TRANSFER_SN);
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("提交调拨单测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 提交调拨单 ==========");
    }
    
    /**
     * 测试: 调拨单明细查询
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - erpTransferSn (ERP调拨单号)
     * - pageNum (页码)
     * - pageSize (每页记录数)
     */
    @Test
    public void testGetTransferDetailList() throws Exception {
        logger.info("========== 测试开始: 调拨单明细查询 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        com.pjbest.wop.wm.service.SearchTransferDetailResult result = service.getTransferDetailList(
            CUSTOMER_CODE,        // 必填: 客户编码
            TEST_ERP_TRANSFER_SN,  // 必填: ERP调拨单号
            1,                     // 必填: 页码
            10                     // 必填: 每页记录数
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("调拨单明细查询测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 调拨单明细查询 ==========");
    }
    
    /**
     * 测试: 调拨单查询
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - con (查询条件)
     * - pageNum (页码)
     * - pageSize (每页记录数)
     */
    @Test
    public void testSearchTransferList() throws Exception {
        logger.info("========== 测试开始: 调拨单查询 ==========");
        
        // 1. 准备查询条件
        com.pjbest.wop.wm.service.TransferQueryCondition con = new com.pjbest.wop.wm.service.TransferQueryCondition();
        con.setErpTransferSn(TEST_ERP_TRANSFER_SN);
        
        // 2. 调用API (没有异常即通过测试)
        com.pjbest.wop.wm.service.SearchTransferResult result = service.searchTransferList(
            CUSTOMER_CODE,  // 必填: 客户编码
            con,            // 必填: 查询条件
            1,              // 必填: 页码
            10              // 必填: 每页记录数
        );
        
        // 3. 测试通过 (无断言,无异常即通过)
        logger.info("调拨单查询测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 调拨单查询 ==========");
    }
    
    /**
     * 测试: 清空调拨单明细
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - erpTransferSn (ERP调拨单号)
     */
    @Test
    public void testCleanTransferDetail() throws Exception {
        logger.info("========== 测试开始: 清空调拨单明细 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        TransferOperationResult result = service.cleanTransferDetail(CUSTOMER_CODE, TEST_ERP_TRANSFER_SN);
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("清空调拨单明细测试通过, 结果: {}", result);
        logger.info("========== 测试通过: 清空调拨单明细 ==========");
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
     * mvn test -Dtest=WopOuterTransferServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // CreateTransferInfo
        logger.info("\n【1】CreateTransferInfo 必填字段 (7个):");
        listRequiredFields(CreateTransferInfo.class);
        
        // EditTransferInfo
        logger.info("\n【2】EditTransferInfo 必填字段:");
        listRequiredFields(EditTransferInfo.class);
        
        // ImpTransferDetail
        logger.info("\n【3】ImpTransferDetail 必填字段 (3个):");
        listRequiredFields(ImpTransferDetail.class);
        
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
