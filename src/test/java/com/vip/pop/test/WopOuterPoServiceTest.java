package com.vip.pop.test;

import com.pjbest.wop.wm.service.*;
import com.vip.pop.base.validator.RequiredValidator;
import com.vip.pop.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * WOP PO服务测试类
 * 按照 wop-api-sdk-test.md 指南生成
 */
public class WopOuterPoServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(WopOuterPoServiceTest.class);

    // 客户信息
    private static final String CUSTOMER_CODE = "17002437";
    private static final String VENDOR_CODE = "17002437";  // 统一供应商编码

    // 测试PO单号
    private static final String TEST_PO_NO = "TEST_PO_001";
    private static final String TEST_CLIENT_PO_NO = "CLIENT_PO_001";

    // 系统来源
    private static final String TEST_SYSTEM_SOURCE = "TEST";

    // 分页参数
    private static final Integer DEFAULT_PAGE_NUM = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    private WopOuterPoService service;

    @BeforeClass
    public void setUp() {
        service = new WopOuterPoService();
        logger.info("========== WopOuterPoService 测试初始化完成 ==========");
    }

    // ==================== PO单操作测试 ====================

    /**
     * 测试取消PO单
     */
    @Test
    public void testCancelPo() throws Exception {
        logger.info("========== 测试取消PO单 ==========");

        OperationResult result = service.cancelPo(
            CUSTOMER_CODE,    // 必填: 客户编码
            TEST_PO_NO,       // 必填: PO编号
            TEST_SYSTEM_SOURCE // 选填: 来源系统
        );

        Assert.assertNotNull(result, "取消PO单结果不应为空");
        logger.info("取消PO单结果: {}", result);
        logger.info("取消PO单测试通过");
    }

    /**
     * 测试清空PO单明细
     */
    @Test
    public void testCleanPoDetail() throws Exception {
        logger.info("========== 测试清空PO单明细 ==========");

        OperationResult result = service.cleanPoDetail(
            CUSTOMER_CODE,    // 必填: 客户编码
            TEST_PO_NO         // 必填: PO编号
        );

        Assert.assertNotNull(result, "清空PO单明细结果不应为空");
        logger.info("清空PO单明细结果: {}", result);
        logger.info("清空PO单明细测试通过");
    }

    /**
     * 测试关闭PO单
     */
    @Test
    public void testClosePo() throws Exception {
        logger.info("========== 测试关闭PO单 ==========");

        ClosePoRequest request = new ClosePoRequest();
        request.setCustomerCode(CUSTOMER_CODE);  // 必填: 客户编码
        request.setPoNo(TEST_PO_NO);              // 必填: PO编号
        request.setActualReceiveQty(10);           // 必填: 实际收货数量

        // 调用API
        ClosePoRespone result = service.closePo(request);

        Assert.assertNotNull(result, "关闭PO单结果不应为空");
        logger.info("关闭PO单结果: {}", result);
        logger.info("关闭PO单测试通过");
    }

    /**
     * 测试创建PO单
     */
    @Test
    public void testCreatePo() throws Exception {
        logger.info("========== 测试创建PO单 ==========");

        // 1. 准备PO单信息 (只设置必填字段)
        CreatePoInfo poInfo = new CreatePoInfo();

        // 基本信息 (必填)
        poInfo.setClientPoNo(TEST_CLIENT_PO_NO);  // @Required: 客户PO单号
        poInfo.setVendorCode(VENDOR_CODE);        // @Required: 供应商编码 (统一使用 17002437)
        poInfo.setWarehouseCode("WH001");          // @Required: 仓库编码
        poInfo.setCreatedByUser("TEST_USER");     // @Required: 创建人

        // 邮箱 (必填)
        poInfo.setEmail("test@example.com");      // @Required: 邮箱

        // 退货地址信息 (必填)
        poInfo.setReturnCountry("中国");              // @Required: 退货国家
        poInfo.setReturnStateName("广东省");          // @Required: 退货省名称
        poInfo.setReturnCityName("广州市");           // @Required: 退货市名称
        poInfo.setReturnDistrictName("天河区");        // @Required: 退货地区编码
        poInfo.setReturnDetailAddress("测试地址123号"); // @Required: 退货详细地址
        poInfo.setReturnContacter("张三");             // @Required: 退货联系人
        poInfo.setReturnContacterTel("020-12345678");  // @Required: 退货联系人电话
        poInfo.setReturnContacterMobile("13800138000"); // @Required: 退货联系人手机

        // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
        try {
            RequiredValidator.validate(poInfo);
            logger.info("测试数据验证通过,所有 @Required 字段已设置");
        } catch (IllegalArgumentException e) {
            logger.error("测试数据验证失败: {}", e.getMessage());
            logger.error("请检查是否缺少必填字段或设置了选填字段的默认值");
            throw e;  // 重新抛出异常,让测试失败
        }

        // 3. 调用API (没有异常即通过测试)
        CreatePoResult result = service.createPo(CUSTOMER_CODE, poInfo, TEST_SYSTEM_SOURCE);

        // 4. 测试通过 (无断言,无异常即通过)
        logger.info("创建PO单测试通过, 结果: {}", result);
    }

    /**
     * 测试创建PO单并自动提交
     */
    @Test
    public void testCreatePoWithDetail() throws Exception {
        logger.info("========== 测试创建PO单并自动提交 ==========");

        // 1. 准备PO单信息 (只设置必填字段)
        CreatePoInfo poInfo = new CreatePoInfo();
        poInfo.setClientPoNo(TEST_CLIENT_PO_NO);  // @Required
        poInfo.setVendorCode(VENDOR_CODE);         // @Required: 统一使用 17002437
        poInfo.setWarehouseCode("WH001");          // @Required
        poInfo.setCreatedByUser("TEST_USER");     // @Required
        poInfo.setEmail("test@example.com");      // @Required
        poInfo.setReturnCountry("中国");           // @Required
        poInfo.setReturnStateName("广东省");       // @Required
        poInfo.setReturnCityName("广州市");        // @Required
        poInfo.setReturnDistrictName("天河区");    // @Required
        poInfo.setReturnDetailAddress("测试地址");  // @Required
        poInfo.setReturnContacter("张三");         // @Required
        poInfo.setReturnContacterTel("020-12345678");  // @Required
        poInfo.setReturnContacterMobile("13800138000"); // @Required

        // 2. 准备PO单明细 (只设置必填字段)
        List<ImpPoDetail> impPoDetailList = new ArrayList<>();
        ImpPoDetail detail = new ImpPoDetail();
        detail.setItemCode("ITEM_001");    // 必填: 商品编码
        detail.setQty(10);                  // 必填: 数量
        // 选填字段根据需要设置: tagPrice, purchaseUnitPrice, remark 等
        impPoDetailList.add(detail);

        // 3. 验证测试数据
        try {
            RequiredValidator.validate(poInfo);
            logger.info("PO单信息验证通过");
        } catch (IllegalArgumentException e) {
            logger.error("PO单信息验证失败: {}", e.getMessage());
            throw e;
        }

        // 4. 调用API
        CreatePoResult result = service.createPoWithDetail(CUSTOMER_CODE, poInfo, impPoDetailList);

        // 5. 验证结果
        Assert.assertNotNull(result, "创建PO单并提交结果不应为空");
        Assert.assertNotNull(result.getPoNo(), "PO编号不应为空");
        logger.info("创建PO单并提交成功, PO编号: {}", result.getPoNo());
        logger.info("创建PO单并自动提交测试通过");
    }

    /**
     * 测试修改PO单
     */
    @Test
    public void testEditPo() throws Exception {
        logger.info("========== 测试修改PO单 ==========");

        // 准备PO单信息 (只设置必填字段)
        CreatePoInfo poInfo = new CreatePoInfo();
        poInfo.setClientPoNo(TEST_CLIENT_PO_NO);  // @Required
        poInfo.setVendorCode(VENDOR_CODE);         // @Required: 统一使用 17002437
        poInfo.setWarehouseCode("WH001");          // @Required
        poInfo.setCreatedByUser("TEST_USER");     // @Required
        poInfo.setEmail("test@example.com");      // @Required
        poInfo.setReturnCountry("中国");           // @Required
        poInfo.setReturnStateName("广东省");       // @Required
        poInfo.setReturnCityName("广州市");        // @Required
        poInfo.setReturnDistrictName("天河区");    // @Required
        poInfo.setReturnDetailAddress("测试地址");  // @Required
        poInfo.setReturnContacter("张三");         // @Required
        poInfo.setReturnContacterTel("020-12345678");  // @Required
        poInfo.setReturnContacterMobile("13800138000"); // @Required

        // 验证测试数据
        RequiredValidator.validate(poInfo);

        OperationResult result = service.editPo(CUSTOMER_CODE, TEST_PO_NO, poInfo);

        Assert.assertNotNull(result, "修改PO单结果不应为空");
        logger.info("修改PO单结果: {}", result);
        logger.info("修改PO单测试通过");
    }

    /**
     * 测试导入PO单明细
     */
    @Test
    public void testImportPoDetail() throws Exception {
        logger.info("========== 测试导入PO单明细 ==========");

        // 准备PO单明细 (只设置必填字段)
        List<ImpPoDetail> impPoDetailList = new ArrayList<>();
        ImpPoDetail detail = new ImpPoDetail();
        detail.setItemCode("ITEM_001");    // 必填: 商品编码
        detail.setQty(10);                  // 必填: 数量
        impPoDetailList.add(detail);

        OperationResult result = service.importPoDetail(
            CUSTOMER_CODE,
            TEST_PO_NO,
            impPoDetailList,
            TEST_SYSTEM_SOURCE
        );

        Assert.assertNotNull(result, "导入PO单明细结果不应为空");
        logger.info("导入PO单明细结果: {}", result);
        logger.info("导入PO单明细测试通过");
    }

    /**
     * 测试提交PO单
     */
    @Test
    public void testSubmitPo() throws Exception {
        logger.info("========== 测试提交PO单 ==========");

        OperationResult result = service.submitPo(
            CUSTOMER_CODE,
            TEST_PO_NO,
            TEST_SYSTEM_SOURCE
        );

        Assert.assertNotNull(result, "提交PO单结果不应为空");
        logger.info("提交PO单结果: {}", result);
        logger.info("提交PO单测试通过");
    }

    // ==================== PO单查询测试 ====================

    /**
     * 测试PO单查询
     */
    @Test
    public void testQueryPo() throws Exception {
        logger.info("========== 测试PO单查询 ==========");

        List<QueryPoResult> result = service.queryPo(CUSTOMER_CODE, TEST_PO_NO);

        Assert.assertNotNull(result, "PO查询结果不应为空");
        logger.info("PO查询结果: {}", result);
        logger.info("PO单查询测试通过");
    }

    /**
     * 测试根据系统PO查PO单
     */
    @Test
    public void testQueryPoBySystemPoNo() throws Exception {
        logger.info("========== 测试根据系统PO查PO单 ==========");

        QueryPoBySystemPoNoRequest req = new QueryPoBySystemPoNoRequest();
        req.setSystemPoNo("SYSTEM_PO_001"); // 必填: 系统PO号

        QueryPoBySystemPoNoRespone result = service.queryPoBySystemPoNo(req);

        logger.info("根据系统PO查PO单结果: {}", result);
        logger.info("根据系统PO查PO单测试通过");
    }

    /**
     * 测试PO单查询(带条件)
     */
    @Test
    public void testSearchPoList() throws Exception {
        logger.info("========== 测试PO单查询(带条件) ==========");

        // 准备查询条件 (只设置查询所需的字段)
        PoQueryCondition con = new PoQueryCondition();
        con.setClientPoNo(TEST_CLIENT_PO_NO); // 查询字段

        SearchPoResult result = service.searchPoList(
            CUSTOMER_CODE,
            con,
            DEFAULT_PAGE_NUM,
            DEFAULT_PAGE_SIZE,
            TEST_SYSTEM_SOURCE
        );

        Assert.assertNotNull(result, "PO单查询结果不应为空");
        logger.info("PO单查询结果: {}", JsonUtils.toStr(result));
        logger.info("PO单查询(带条件)测试通过");
    }

    /**
     * 测试PO单明细查询
     */
    @Test
    public void testGetPoDetailList() throws Exception {
        logger.info("========== 测试PO单明细查询 ==========");

        SearchPoDetailResult result = service.getPoDetailList(
            CUSTOMER_CODE,
            TEST_PO_NO,      // 查询单个PO号
            DEFAULT_PAGE_NUM,
            DEFAULT_PAGE_SIZE,
            null              // 不使用poNoList
        );

        Assert.assertNotNull(result, "PO单明细查询结果不应为空");
        logger.info("PO单明细查询结果: {}", result);
        logger.info("PO单明细查询测试通过");
    }

    /**
     * 测试通过客户PO获取系统PO号
     */
    @Test
    public void testGetPoNoByClientPoNo() throws Exception {
        logger.info("========== 测试通过客户PO获取系统PO号 ==========");

        String result = service.getPoNoByClientPoNo(CUSTOMER_CODE, TEST_CLIENT_PO_NO);

        logger.info("系统PO号: {}", result);
        logger.info("通过客户PO获取系统PO号测试通过");
    }

    /**
     * 测试获取PO单收货明细
     */
    @Test
    public void testGetDeliveryResult() throws Exception {
        logger.info("========== 测试获取PO单收货明细 ==========");

        SearchDeliveryResult result = service.getDeliveryResult(
            CUSTOMER_CODE,
            TEST_PO_NO,
            DEFAULT_PAGE_NUM,
            DEFAULT_PAGE_SIZE
        );

        Assert.assertNotNull(result, "获取PO单收货明细结果不应为空");
        logger.info("获取PO单收货明细结果: {}", result);
        logger.info("获取PO单收货明细测试通过");
    }

    /**
     * 测试入库结果查询
     */
    @Test
    public void testGetReceiptResult() throws Exception {
        logger.info("========== 测试入库结果查询 ==========");

        SearchReceiptResult result = service.getReceiptResult(
            CUSTOMER_CODE,
            TEST_SYSTEM_SOURCE,
            TEST_PO_NO,
            DEFAULT_PAGE_NUM,
            DEFAULT_PAGE_SIZE,
            null  // 不使用transactionIdList
        );

        Assert.assertNotNull(result, "入库结果查询结果不应为空");
        logger.info("入库结果查询结果: {}", result);
        logger.info("入库结果查询测试通过");
    }

    /**
     * 测试健康检查
     */
    @Test
    public void testHealthCheck() throws Exception {
        logger.info("========== 测试健康检查 ==========");

        service.healthCheck();
        logger.info("健康检查通过");
    }
}
