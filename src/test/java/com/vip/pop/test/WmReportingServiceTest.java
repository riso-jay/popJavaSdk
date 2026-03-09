package com.vip.pop.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pjbest.wop.wm.service.ChannelInvReq;
import com.pjbest.wop.wm.service.ChannelInvResponse;
import com.pjbest.wop.wm.service.InvCheckAckResponse;
import com.pjbest.wop.wm.service.InvCheckReportAckResult;
import com.pjbest.wop.wm.service.InvCheckResponse;
import com.pjbest.wop.wm.service.InventorySkuSumResponse;
import com.pjbest.wop.wm.service.PurchaseSalesRequest;
import com.pjbest.wop.wm.service.PurchaseSalesResponse;
import com.pjbest.wop.wm.service.RealtimeInventoryRequest;
import com.pjbest.wop.wm.service.RealtimeInventoryResponse;
import com.pjbest.wop.wm.service.StockchangeReportAck;
import com.pjbest.wop.wm.service.StockchangeReportRes;
import com.pjbest.wop.wm.service.WmReportingService;
import com.pjbest.wop.wm.service.Wms119InventoryRequest;
import com.vip.pop.base.validator.RequiredValidator;

/**
 * WmReportingService 测试类
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
public class WmReportingServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(WmReportingServiceTest.class);
    
    private WmReportingService service;
    
    // ==================== 统一测试数据 ====================
    
    // 客户信息
    private static final String CUSTOMER_CODE = "17002437";
    private static final String VENDOR_CODE = "17002437";  // 统一供应商编码
    
    // 仓库信息
    private static final String WAREHOUSE_CODE = "WH001";
    
    // 商品信息
    private static final String ITEM_CODE = "ITEM_001";
    
    // 时间信息
    private static final String START_DATE = "2025-03-01";
    private static final String END_DATE = "2025-03-31";
    
    // 分页参数
    private static final Integer DEFAULT_PAGE_NUM = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;
    
    // ==================== 测试初始化 ====================
    
    @BeforeClass
    public void setUp() {
        service = new WmReportingService();
        logger.info("WmReportingServiceTest 初始化完成");
        logger.info("测试数据配置:");
        logger.info("  - 客户编码: {}", CUSTOMER_CODE);
        logger.info("  - 供应商编码: {}", VENDOR_CODE);
        logger.info("  - 仓库编码: {}", WAREHOUSE_CODE);
        logger.info("  - 开始日期: {}", START_DATE);
        logger.info("  - 结束日期: {}", END_DATE);
    }
    
    // ==================== 渠道库存查询 ====================
    
    /**
     * 测试: 渠道库存查询
     * 
     * ChannelInvReq @Required 字段 (3个):
     * - vendorCode (供应商编码)
     * - pageNo (当前页码)
     * - pageSize (分页数量)
     */
    @Test
    public void testChannelInvQuery() throws Exception {
        logger.info("========== 测试开始: 渠道库存查询 ==========");
        
        // 1. 准备查询条件 (根据 @Required 注解设置必填字段)
        ChannelInvReq queryChannelReq = new ChannelInvReq();
        queryChannelReq.setVendorCode(VENDOR_CODE);  // @Required: 供应商编码 (统一使用 17002437)
        queryChannelReq.setPageNo(DEFAULT_PAGE_NUM);  // @Required: 当前页码
        queryChannelReq.setPageSize(DEFAULT_PAGE_SIZE); // @Required: 分页数量
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(queryChannelReq);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        ChannelInvResponse result = service.channelInvQuery(queryChannelReq);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("渠道库存查询测试通过");
        logger.info("========== 测试通过: 渠道库存查询 ==========");
    }
    
    // ==================== 库存盘点 ====================
    
    /**
     * 测试: 库存盘点结果确认
     * 
     * 必填参数:
     * - customerCode (客户编码) - 服务方法验证
     * 
     * InvCheckReportAckResult @Required 字段 (2个):
     * - transactionId (唯一标识)
     * - resultCode (结果编码 200:成功,500:失败)
     */
    @Test
    public void testInvCheckReportAck() throws Exception {
        logger.info("========== 测试开始: 库存盘点结果确认 ==========");
        
        // 1. 准备确认结果 (根据 @Required 注解设置必填字段)
        List<InvCheckReportAckResult> ackResultList = new ArrayList<>();
        InvCheckReportAckResult ackResult = new InvCheckReportAckResult();
        ackResult.setTransactionId("1");  // @Required: 唯一标识
        ackResult.setResultCode(200);     // @Required: 结果编码
        ackResultList.add(ackResult);
        
        // 2. 验证测试数据
        for (InvCheckReportAckResult item : ackResultList) {
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
        InvCheckAckResponse result = service.invCheckReportAck(CUSTOMER_CODE, ackResultList);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("库存盘点结果确认测试通过");
        logger.info("========== 测试通过: 库存盘点结果确认 ==========");
    }
    
    /**
     * 测试: 库存盘点结果查询
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - pageNum (页码)
     * - pageSize (每页数量)
     */
    @Test
    public void testInvCheckReportQuery() throws Exception {
        logger.info("========== 测试开始: 库存盘点结果查询 ==========");
        
        // 1. 调用API (只设置服务方法验证的必填参数)
        InvCheckResponse result = service.invCheckReportQuery(
            CUSTOMER_CODE,     // 必填: 客户编码 (统一使用 17002437)
            DEFAULT_PAGE_NUM,  // 必填: 页码
            DEFAULT_PAGE_SIZE // 必填: 每页数量
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("库存盘点结果查询测试通过");
        logger.info("========== 测试通过: 库存盘点结果查询 ==========");
    }
    
    // ==================== 出库SKU汇总查询 ====================
    
    /**
     * 测试: 出库SKU汇总查询
     * 
     * 必填参数 (服务方法验证):
     * - vendorCode (供应商编码)
     * - startDate (开始时间,格式: yyyy-mm-dd)
     * - endDate (结束时间,格式: yyyy-mm-dd)
     */
    @Test
    public void testQueryInvOutQuantitySkuSum() throws Exception {
        logger.info("========== 测试开始: 出库SKU汇总查询 ==========");
        
        // 1. 调用API (只设置服务方法验证的必填参数)
        InventorySkuSumResponse result = service.queryInvOutQuantitySkuSum(
            VENDOR_CODE,  // 必填: 供应商编码 (统一使用 17002437)
            START_DATE,   // 必填: 开始时间 (格式: yyyy-MM-dd)
            END_DATE,     // 必填: 结束时间 (格式: yyyy-MM-dd)
            null,         // 选填: 仓库编码
            null          // 选填: 商品编码
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("出库SKU汇总查询测试通过");
        logger.info("========== 测试通过: 出库SKU汇总查询 ==========");
    }
    
    // ==================== 进销存报表查询 ====================
    
    /**
     * 测试: 进销存报表查询
     * 
     * PurchaseSalesRequest @Required 字段 (7个):
     * - vendorCode (供应商编码)
     * - pageNo (当前页码)
     * - pageSize (分页数量)
     * - warehouseCode (仓库编码)
     * - dateFrom (库存开始日期)
     * - dateTo (库存结束日期)
     * - queryType (查询维度)
     */
    @Test
    public void testQueryPurchaseSalesInventory() throws Exception {
        logger.info("========== 测试开始: 进销存报表查询 ==========");
        
        // 1. 准备查询条件 (根据 @Required 注解设置必填字段)
        PurchaseSalesRequest query = new PurchaseSalesRequest();
        query.setVendorCode(VENDOR_CODE);       // @Required: 供应商编码 (统一使用 17002437)
        query.setPageNo(DEFAULT_PAGE_NUM);      // @Required: 当前页码
        query.setPageSize(DEFAULT_PAGE_SIZE);   // @Required: 分页数量
        query.setWarehouseCode(WAREHOUSE_CODE); // @Required: 仓库编码
        query.setDateFrom(START_DATE);         // @Required: 库存开始日期 (格式: yyyy-MM-dd)
        query.setDateTo(END_DATE);             // @Required: 库存结束日期 (格式: yyyy-MM-dd)
        query.setQueryType("1");               // @Required: 查询维度 (1:商品+PO, 2:商品, 3:PO, 4:供应商)
        
        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(query);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            logger.error("常见问题:");
            logger.error("  1. 是否设置了所有 @Required 字段?");
            logger.error("  2. 选填字段是否错误地设置为 null?");
            logger.error("  3. 日期格式是否正确 (yyyy-MM-dd)?");
            logger.error("  4. 供应商编码是否统一使用 17002437?");
            throw e;  // 重新抛出异常,让测试失败
        }
        
        // 3. 调用API (没有异常即通过测试)
        PurchaseSalesResponse result = service.queryPurchaseSalesInventory(query);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("进销存报表查询测试通过");
        logger.info("========== 测试通过: 进销存报表查询 ==========");
    }
    
    // ==================== 实时库存报表查询 ====================
    
    /**
     * 测试: 实时库存报表查询
     * 
     * RealtimeInventoryRequest @Required 字段 (4个):
     * - warehouseCode (仓库编码)
     * - pageSize (分页数量)
     * - vendorCode (供应商编码)
     * - queryType (查询维度)
     */
    @Test
    public void testQueryRealtimeInventory() throws Exception {
        logger.info("========== 测试开始: 实时库存报表查询 ==========");
        
        // 1. 准备查询条件 (根据 @Required 注解设置必填字段)
        RealtimeInventoryRequest query = new RealtimeInventoryRequest();
        query.setWarehouseCode(WAREHOUSE_CODE); // @Required: 仓库编码
        query.setPageSize(DEFAULT_PAGE_SIZE);    // @Required: 分页数量
        query.setVendorCode(VENDOR_CODE);        // @Required: 供应商编码 (统一使用 17002437)
        query.setQueryType("2");                 // @Required: 查询维度 (1:商品+PO, 2:商品, 3:PO)
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(query);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        RealtimeInventoryResponse result = service.queryRealtimeInventory(query);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("实时库存报表查询测试通过");
        logger.info("========== 测试通过: 实时库存报表查询 ==========");
    }
    
    // ==================== WMS119库存报表查询 ====================
    
    /**
     * 测试: WMS119库存报表查询
     * 
     * Wms119InventoryRequest @Required 字段 (1个):
     * - vendorCode (供应商编码)
     * 
     * 注意: 虽然只有 vendorCode 标记为 @Required,但根据业务逻辑可能需要设置其他字段
     */
    @Test
    public void testQueryWms119Inventory() throws Exception {
        logger.info("========== 测试开始: WMS119库存报表查询 ==========");
        
        // 1. 准备查询条件 (根据 @Required 注解设置必填字段)
        Wms119InventoryRequest query = new Wms119InventoryRequest();
        query.setVendorCode(VENDOR_CODE);  // @Required: 供应商编码 (统一使用 17002437)
        
        // 2. 验证测试数据
        try {
            RequiredValidator.validate(query);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;
        }
        
        // 3. 调用API (没有异常即通过测试)
        String result = service.queryWms119Inventory(query);
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("WMS119库存报表查询测试通过");
        logger.info("========== 测试通过: WMS119库存报表查询 ==========");
    }
    
    // ==================== 库存异动通知确认 ====================
    
    /**
     * 测试: 库存异动通知确认
     * 
     * 必填参数:
     * - customerCode (客户编码) - 服务方法验证
     * 
     * StockchangeReportAck @Required 字段 (1个):
     * - resultCode (结果编码 200:成功,500:失败)
     */
    @Test
    public void testStockChangeReportAck() throws Exception {
        logger.info("========== 测试开始: 库存异动通知确认 ==========");
        
        // 1. 准备确认结果 (根据 @Required 注解设置必填字段)
        List<StockchangeReportAck> ackResultList = new ArrayList<>();
        StockchangeReportAck ack = new StockchangeReportAck();
        ack.setResultCode(200);  // @Required: 结果编码
        ackResultList.add(ack);
        
        // 2. 验证测试数据
        for (StockchangeReportAck item : ackResultList) {
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
        List<StockchangeReportAck> result = service.stockChangeReportAck(
            CUSTOMER_CODE,  // 必填: 客户编码 (统一使用 17002437)
            ackResultList,   // 必填: 流水确认结果列表
            null,            // 选填: 库存异动业务类型
            null             // 选填: 虚拟货主客户编码
        );
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("库存异动通知确认测试通过");
        logger.info("========== 测试通过: 库存异动通知确认 ==========");
    }
    
    /**
     * 测试: 库存异动通知确认 (ByObj版本)
     * 
     * 必填字段同上
     */
    @Test
    public void testStockChangeReportAckByObj() throws Exception {
        logger.info("========== 测试开始: 库存异动通知确认(ByObj) ==========");
        
        // 1. 准备确认结果
        List<StockchangeReportAck> ackResultList = new ArrayList<>();
        StockchangeReportAck ack = new StockchangeReportAck();
        ack.setResultCode(200);  // @Required: 结果编码
        ackResultList.add(ack);
        
        // 2. 验证测试数据
        for (StockchangeReportAck item : ackResultList) {
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
        List<StockchangeReportAck> result = service.stockChangeReportAckByObj(
            CUSTOMER_CODE,
            ackResultList,
            null,
            null
        );
        
        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("库存异动通知确认(ByObj)测试通过");
        logger.info("========== 测试通过: 库存异动通知确认(ByObj) ==========");
    }
    
    // ==================== 库存异动查询 ====================
    
    /**
     * 测试: 库存异动查询
     * 
     * 必填参数 (服务方法验证):
     * - customerCode (客户编码)
     * - pageNum (页码)
     * - pageSize (每页数量)
     */
    @Test
    public void testStockChangeReportQuery() throws Exception {
        logger.info("========== 测试开始: 库存异动查询 ==========");
        
        // 1. 调用API (没有异常即通过测试)
        List<StockchangeReportRes> result = service.stockChangeReportQuery(
            CUSTOMER_CODE,     // 必填: 客户编码 (统一使用 17002437)
            DEFAULT_PAGE_NUM,  // 必填: 页码
            DEFAULT_PAGE_SIZE, // 必填: 每页数量
            null,              // 选填: 库存异动业务类型
            null               // 选填: 虚拟货主客户编码
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("库存异动查询测试通过");
        logger.info("========== 测试通过: 库存异动查询 ==========");
    }
    
    /**
     * 测试: 库存异动查询 (ByObj版本)
     * 
     * 必填字段同上
     */
    @Test
    public void testStockChangeReportQueryByObj() throws Exception {
        logger.info("========== 测试开始: 库存异动查询(ByObj) ==========");
        
        // 1. 调用API (没有异常即通过测试)
        List<StockchangeReportRes> result = service.stockChangeReportQueryByObj(
            CUSTOMER_CODE,
            DEFAULT_PAGE_NUM,
            DEFAULT_PAGE_SIZE,
            null,
            null
        );
        
        // 2. 测试通过 (无断言,无异常即通过)
        logger.info("库存异动查询(ByObj)测试通过");
        logger.info("========== 测试通过: 库存异动查询(ByObj) ==========");
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
     * mvn test -Dtest=WmReportingServiceTest#testListRequiredFields
     */
    @Test
    public void testListRequiredFields() throws Exception {
        logger.info("========================================");
        logger.info("核实模型类的 @Required 字段");
        logger.info("========================================");
        
        // ChannelInvReq
        logger.info("\n【1】ChannelInvReq 必填字段 (3个):");
        listRequiredFields(ChannelInvReq.class);
        
        // InvCheckReportAckResult
        logger.info("\n【2】InvCheckReportAckResult 必填字段 (2个):");
        listRequiredFields(InvCheckReportAckResult.class);
        
        // StockchangeReportAck
        logger.info("\n【3】StockchangeReportAck 必填字段 (1个):");
        listRequiredFields(StockchangeReportAck.class);
        
        // PurchaseSalesRequest
        logger.info("\n【4】PurchaseSalesRequest 必填字段 (7个):");
        listRequiredFields(PurchaseSalesRequest.class);
        
        // RealtimeInventoryRequest
        logger.info("\n【5】RealtimeInventoryRequest 必填字段 (4个):");
        listRequiredFields(RealtimeInventoryRequest.class);
        
        // Wms119InventoryRequest
        logger.info("\n【6】Wms119InventoryRequest 必填字段 (1个):");
        listRequiredFields(Wms119InventoryRequest.class);
        
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
