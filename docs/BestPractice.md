# POP Java SDK 最佳实践指南

> 电商物流业务场景实践 - 帮助第三方供应商快速掌握云仓业务对接

> 📖 本文档是《README》的进阶篇，建议先阅读 [README.md](../README.md) 完成 SDK 基础入门

## 目录

- [业务概览](#业务概览)
- [对接前准备](#对接前准备)
- [一、基础准备](#一基础准备)
- [二、入库管理](#二入库管理)
- [三、出库管理](#三出库管理)
- [四、退货管理](#四退货管理)
- [五、库存管理](#五库存管理)
- [六、事件驱动](#六事件驱动)
- [七、渠道与虚拟仓管理](#七渠道与虚拟仓管理)
- [开发技巧](#开发技巧)
- [疑难排查](#疑难排查)

---

## 业务概览

唯品云仓开放平台为第三方供应商提供完整的电商物流能力，业务流程如下：

```
┌─────────────────────────────────────────────────────────────────┐
│                      电商物流业务全景图                           │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  ┌─────────┐    ┌─────────┐    ┌─────────┐    ┌─────────┐     │
│  │ 基础准备 │ ──▶│ 入库管理 │ ──▶│ 库存管理 │ ──▶│ 出库管理 │     │
│  └─────────┘    └─────────┘    └─────────┘    └─────────┘     │
│       │                             │               │          │
│       │                             │               │          │
│       ▼                             ▼               ▼          │
│  ┌─────────┐                   ┌─────────┐    ┌─────────┐     │
│  │ 商品同步 │                   │ 仓间调拨 │    │ 退货管理 │     │
│  └─────────┘                   └─────────┘    └─────────┘     │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

### 核心业务模块

| 模块 | 描述 | 涉及服务 |
|------|------|----------|
| 基础准备 | 商品信息同步、品牌管理 | PdcDecItemErpService, PdcBrandService |
| 入库管理 | PO入库单创建、收货、上架 | WopOuterPoService, WopBigOrderService |
| 出库管理 | 订单查询、状态跟踪 | WopOuterOrderService, WopJitOrderPopService |
| 退货管理 | 客退单、退供单处理 | WopOuterOrderBackService, WopOuterInvReturnOrderService |
| 库存管理 | 库存查询、仓间调拨 | CisInvChannelQueryAPI, WopOuterTransferService |
| 事件驱动 | 订单事件监听与处理 | WopOrderEventService |

---

## 对接前准备

> 在开始开发前，需要先确认业务信息和配置信息

### 确认事项清单

| 项目 | 说明 | 示例 |
|------|------|------|
| **货主信息** | 货主编码、货主名称、父子货主关系 | 货主编码: `80001001` |
| **仓库信息** | 物理仓库编码、名称、地址 | 仓库编码: `PJ_ZQHX`（华南肆庆仓） |
| **品牌信息** | 品牌编码、品牌名称 | 品牌编码: `10032800` |
| **应用凭证** | AppKey、AppSecret | `pop.app.key`, `pop.app.secret` |
| **客户编码** | 客户ID（customerCode） | `17002437` 或 `80001001V2` |
| **履约场景** | 唯品渠道/非唯品渠道 | 唯品会、快手、拼多多等 |
| **库存对齐方式** | 物理仓/逻辑仓/渠道分离 | 见下方说明 |

### 货主与仓库架构

```
父货主 (80001001)
    │
    ├── 子货主 A (8000100101) ─── 品牌: 示例品牌A
    │
    └── 子货主 B (8000100102) ─── 品牌: 示例品牌B

物理仓库 (PJ_ZQHX 华南肆庆仓)
    │
    ├── 唯品会渠道 ─── 虚拟仓: V1_80001001  (唯品库存)
    │
    └── 非唯品渠道 ─── 虚拟仓: NV1_80001001 (非唯库存)
```

### 虚拟仓配置示例

通过虚拟仓将同一物理仓库拆分为不同渠道，实现库存隔离：

| 物理仓库 | 仓库名称 | 渠道 | 虚拟仓编码 | 虚拟仓名称 |
|----------|----------|------|------------|----------|
| PJ_ZQHX | 华南肆庆仓 | 唯品会 | V1_80001001 | XXX-华南唯品虚拟仓 |
| PJ_ZQHX | 华南肆庆仓 | 非唯品会 | NV1_80001001 | XXX-华南非唯品虚拟仓 |

> 注意：虚拟仓编码长度需在 **16位以内**

### 库存渠道说明

| 渠道类型 | 说明 | 常见场景 |
|----------|------|----------|
| **唯品会渠道** | 库存用于唯品会平台销售 | 唯品会 APP、小程序订单 |
| **非唯品渠道** | 库存用于其他平台销售 | 快手、拼多多、抖音等 |

---

## 一、基础准备

> 在进行入库/出库操作前，需要先完成商品信息的同步

### 1.1 商品信息同步

商品同步是所有业务的基础，确保WMS系统中有正确的商品档案。

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.PdcDecItemErpService;
import com.vip.pop.model.ErpDecPdcItem;
import com.vip.pop.model.ErpDecPdcItemResult;

/**
 * 商品同步示例
 * 
 * 业务场景：新品上架前，将ERP商品信息同步到云仓
 */
public class ProductSyncExample {
    
    private static final String CUSTOMER_CODE = "17002437";
    
    public void syncProduct() {
        PdcDecItemErpService service = PopServiceFactory.getPdcDecItemErpService();
        
        // 1. 构建商品信息
        ErpDecPdcItem item = new ErpDecPdcItem();
        item.setTransactionId("TXN" + System.currentTimeMillis());  // 交易ID，用于幂等
        item.setItemCode("SKU001");                                  // 商品编码（唯一）
        item.setItemName("2026春季新款连衣裙");
        item.setGoodsCode("GOODS001");                               // 货品编码
        item.setSize("M");
        item.setColor("粉色");
        item.setStockUnit("件");
        item.setActionType("add");                                   // add=新增, update=更新
        item.setIsShelfLifeMgmt("N");                              // 是否保质期管理
        
        try {
            // 2. 调用同步接口
            ErpDecPdcItemResult result = service.syncPdcItem(CUSTOMER_CODE, item);
            
            if (result.getSuccess()) {
                System.out.println("商品同步成功，系统编码: " + result.getPdcItemCode());
            } else {
                System.err.println("商品同步失败: " + result.getMessage());
            }
        } catch (Exception e) {
            System.err.println("API调用异常: " + e.getMessage());
        }
    }
}
```

**最佳实践：**
- 使用 `transactionId` 保证接口幂等性，避免重复创建
- 商品编码 `itemCode` 在系统内唯一，建议与ERP保持一致
- 先同步商品，再创建入库单，避免因商品不存在导致入库失败

---

## 二、入库管理

> 入库是电商物流的起点，涉及PO单创建、收货、入库确认等环节

### 2.1 入库流程全景

```
创建PO单 ──▶ 导入明细 ──▶ 提交PO单 ──▶ 仓库收货 ──▶ 入库上架 ──▶ 查询结果
   │                                      │            │
   │                                      ▼            ▼
   │                              收货明细查询    入库结果查询
   │
   └──▶ 取消PO单（异常情况）
```

### 2.2 创建入库单（推荐：一步到位）

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterPoService;
import com.vip.pop.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * PO入库单创建示例
 * 
 * 业务场景：供应商发货前，创建入库预报单通知云仓
 */
public class CreatePoExample {
    
    private static final String CUSTOMER_CODE = "17002437";
    
    /**
     * 推荐方式：创建PO单并自动提交（含明细）
     * 一次调用完成：创建表头 + 导入明细 + 自动提交
     */
    public void createPoWithDetail() {
        WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
        
        // 1. 构建PO表头
        CreatePoInfo poInfo = new CreatePoInfo();
        poInfo.setClientPoNo("CLIENT-PO-" + System.currentTimeMillis());  // 客户PO号（唯一）
        poInfo.setWarehouseCode("WH001");                                  // 目标仓库
        poInfo.setVendorCode("V001");
        poInfo.setVendorName("测试供应商");
        poInfo.setExpectedArrivalTime("2026-03-15");                       // 预计到货时间
        poInfo.setRemark("2026春季新品入库");
        
        // 2. 构建PO明细
        List<ImpPoDetail> details = new ArrayList<>();
        ImpPoDetail detail1 = new ImpPoDetail();
        detail1.setSkuCode("SKU001");
        detail1.setExpectedQty(100);
        detail1.setProductName("2026春季新款连衣裙-M码");
        detail1.setBarcode("6901234567890");
        details.add(detail1);
        ImpPoDetail detail2 = new ImpPoDetail();
        detail2.setSkuCode("SKU002");
        detail2.setExpectedQty(150);
        detail2.setProductName("2026春季新款连衣裙-L码");
        detail2.setBarcode("6901234567891");
        details.add(detail2);
        
        try {
            // 3. 一步创建并提交
            CreatePoResult result = service.createPoWithDetail(CUSTOMER_CODE, poInfo, details);
            
            if (result.getSuccess()) {
                System.out.println("PO单创建成功！");
                System.out.println("系统PO号: " + result.getPoNo());
                // 保存系统PO号，用于后续查询
            } else {
                System.err.println("PO单创建失败: " + result.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("参数错误: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("API调用异常: " + e.getMessage());
        }
    }
}
```

### 2.3 分步创建入库单（灵活控制）

```java
/**
 * 分步创建PO单
 * 
 * 适用场景：需要多次修改明细，或需要人工审核后再提交
 */
public void createPoStepByStep() {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    
    try {
        // 第一步：创建PO表头
        CreatePoInfo poInfo = new CreatePoInfo();
        poInfo.setClientPoNo("CLIENT-PO-001");
        poInfo.setWarehouseCode("WH001");
        CreatePoResult createResult = service.createPo(CUSTOMER_CODE, poInfo, "ERP");
        
        if (!createResult.getSuccess()) {
            System.err.println("创建表头失败: " + createResult.getMessage());
            return;
        }
        String poNo = createResult.getPoNo();
        
        // 第二步：导入明细（可多次调用追加）
        List<ImpPoDetail> details = new ArrayList<>();
        ImpPoDetail detail = new ImpPoDetail();
        detail.setSkuCode("SKU001");
        detail.setExpectedQty(100);
        details.add(detail);
        OperationResult importResult = service.importPoDetail(
                CUSTOMER_CODE, poNo, details, "ERP");
        
        if (!importResult.getSuccess()) {
            System.err.println("导入明细失败: " + importResult.getMessage());
            return;
        }
        
        // 第三步：提交PO单
        OperationResult submitResult = service.submitPo(CUSTOMER_CODE, poNo, "ERP");
        
        if (submitResult.getSuccess()) {
            System.out.println("PO单提交成功: " + poNo);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

### 2.4 查询入库结果

```java
/**
 * 查询PO单收货和入库结果
 * 
 * 业务场景：跟踪入库进度，获取实际入库数量
 */
public void queryPoResult() {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    
    try {
        String poNo = "PO202603010001";
        
        // 1. 查询PO单状态
        QueryPoResult poResult = service.queryPo(CUSTOMER_CODE, poNo);
        System.out.println("PO单状态: " + poResult);
        
        // 2. 查询收货明细（仓库收到了多少）
        SearchDeliveryResult deliveryResult = service.getDeliveryResult(
                CUSTOMER_CODE, poNo, 1, 50);
        System.out.println("收货记录: " + deliveryResult);
        
        // 3. 查询入库结果（实际上架了多少）
        SearchReceiptResult receiptResult = service.getReceiptResult(
                CUSTOMER_CODE, null, poNo, 1, 50, null);
        System.out.println("入库结果: " + receiptResult);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

### 2.5 PO单完整生命周期管理

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterPoService;
import com.vip.pop.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PO单完整生命周期管理示例
 * 涵盖：创建 -> 编辑 -> 提交 -> 查询 -> 取消/关闭
 */
public class PoLifecycleExample {

	private static final String CUSTOMER_CODE = "17002437";
	private WopOuterPoService service;

	public PoLifecycleExample() {
		service = PopServiceFactory.getWopOuterPoService();
	}

	/**
	 * 通过客记PO号获取系统PO号
	 * 业务场景：通过ERP的PO号查询云仓系统的PO号
	 */
	public String getSystemPoNo(String clientPoNo) throws Exception {
		String systemPoNo = service.getPoNoByClientPoNo(CUSTOMER_CODE, clientPoNo);
		System.out.println("客记PO号: " + clientPoNo + " -> 系统PO号: " + systemPoNo);
		return systemPoNo;
	}

	/**
	 * 修改PO单信息
	 * 业务场景：修改供应商信息、备注等
	 */
	public void editPoInfo(String poNo) throws Exception {
		CreatePoInfo updateInfo = new CreatePoInfo();
		updateInfo.setVendorName("修改后的供应商名称");
		updateInfo.setRemark("备注信息更新");

		OperationResult result = service.editPo(CUSTOMER_CODE, poNo, updateInfo);
		System.out.println("修改PO单结果: " + result);
	}

	/**
	 * 追加导入PO明细
	 * 业务场景：分批次导入商品明细
	 */
	public void appendPoDetail(String poNo) throws Exception {
		List<ImpPoDetail> newDetails = new ArrayList<>();
		ImpPoDetail detail1 = new ImpPoDetail();
		detail1.setItemCode("SKU003");
		detail1.setExpectedQty(50);
		newDetails.add(detail1);
		ImpPoDetail detail2 = new ImpPoDetail();
		detail2.setItemCode("SKU004");
		detail2.setExpectedQty(80);
		newDetails.add(detail2);

		OperationResult result = service.importPoDetail(CUSTOMER_CODE, poNo, newDetails, "ERP");
		System.out.println("导入PO明细结果: " + result);
	}

	/**
	 * 清空PO明细
	 * 业务场景：重新导入明细前清空旧数据
	 */
	public void cleanPoDetail(String poNo) throws Exception {
		OperationResult result = service.cleanPoDetail(CUSTOMER_CODE, poNo);
		System.out.println("清空PO明细结果: " + result);
	}

	/**
	 * 提交PO单
	 * 业务场景：明细导入完成后提交给仓库
	 */
	public void submitPo(String poNo) throws Exception {
		OperationResult result = service.submitPo(CUSTOMER_CODE, poNo, "ERP");
		System.out.println("提交PO单结果: " + result);
	}

	/**
	 * 取消PO单
	 * 业务场景：订单变更，取消入库计划
	 */
	public void cancelPo(String poNo) throws Exception {
		OperationResult result = service.cancelPo(CUSTOMER_CODE, poNo, "ERP");
		System.out.println("取消PO单结果: " + result);
	}

	/**
	 * 关闭PO单（支持批量）
	 * 业务场景：批量关闭已完成的PO单
	 */
	public void closePoList() throws Exception {
		ClosePoRequest request = new ClosePoRequest();
		request.setCustomerCode(CUSTOMER_CODE);
		request.setPoNoList(Arrays.asList("PO001", "PO002", "PO003"));

		ClosePoResponse response = service.closePo(request);
		System.out.println("关闭PO单结果: " + response);
	}

	/**
	 * 分页查询PO单列表
	 * 业务场景：报表导出、PO列表展示
	 */
	public void searchPoList() throws Exception {
		PoQueryCondition condition = new PoQueryCondition();
		condition.setPoStatus("SUBMITTED");
		condition.setCreatedDtmLocFrom("2026-01-01");
		condition.setCreatedDtmLocTo("2026-03-01");

		SearchPoResult result = service.searchPoList(CUSTOMER_CODE, condition, 1, 20, "ERP");
		System.out.println("查询到 " + result.getTotalCount() + " 条PO单");
	}

	/**
	 * 查询PO明细列表
	 * 业务场景：获取PO单的商品明细
	 */
	public void getPoDetailList(String poNo) throws Exception {
		SearchPoDetailResult result = service.getPoDetailList(CUSTOMER_CODE, poNo, 1, 50, null);
		System.out.println("PO明细: " + result);
	}

	/**
	 * 批量查询多个PO的明细
	 */
	public void batchGetPoDetail() throws Exception {
		List<String> poNoList = Arrays.asList("PO001", "PO002", "PO003");

		SearchPoDetailResult result = service.getPoDetailList(CUSTOMER_CODE, null, 1, 100, poNoList);
		System.out.println("批量查询PO明细: " + result);
	}

	/**
	 * 根据系统PO号查询
	 */
	public void queryPoBySystemPoNo() throws Exception {
		QueryPoBySystemPoNoRequest request = new QueryPoBySystemPoNoRequest();
		request.setCustomerCode(CUSTOMER_CODE);
		request.setSystemPoNo("PO202603010001");

		QueryPoBySystemPoNoResponse response = service.queryPoBySystemPoNo(request);
		System.out.println("查询结果: " + response);
	}

	/**
	 * 批量查询多个PO单
	 */
	public void queryMultiplePo() throws Exception {
		// 支持逗号分隔批量查询
		QueryPoResult result = service.queryPo(CUSTOMER_CODE, "PO001,PO002,PO003");
		System.out.println("批量查询结果: " + result);
	}

	/**
	 * 查询入库结果（按交易ID）
	 */
	public void getReceiptByTransactionIds() throws Exception {
		List<String> transactionIds = Arrays.asList("TXN001", "TXN002", "TXN003");

		SearchReceiptResult result = service.getReceiptResult(CUSTOMER_CODE, "ERP", null, 1, 100, transactionIds);
		System.out.println("按交易ID查询入库结果: " + result);
	}

	/**
	 * 使用 ApiResponse 获取完整响应
	 * 业务场景：需要获取错误码和详细错误信息
	 */
	public void createPoWithFullResponse() throws Exception {
		CreatePoInfo poInfo = new CreatePoInfo();
		poInfo.setClientPoNo("CLIENT-RESP-" + System.currentTimeMillis());
		poInfo.setWarehouseCode("WH001");

		// 使用 WithResponse 后缀方法获取完整响应
		ApiResponse<CreatePoResult> response = service.createPoWithResponse(CUSTOMER_CODE, poInfo, null);

		if (response.isSuccess()) {
			CreatePoResult data = response.getData();
			System.out.println("创建成功，PO号: " + data.getPoNo());
		} else {
			System.err.println("创建失败，错误码: " + response.getCode());
			System.err.println("错误信息: " + response.getMessage());
		}
	}
}
```
```

---

## 三、出库管理

> 出库是电商物流的核心环节，涉及订单下发、拣货、发货、物流跟踪

### 3.1 出库流程全景

```
电商订单 ──▶ 订单下发WMS ──▶ 拣货作业 ──▶ 包装称重 ──▶ 发货交接 ──▶ 物流跟踪
                 │                                         │
                 ▼                                         ▼
           订单状态查询                              事件回调通知
```

### 3.2 订单状态查询

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterOrderService;
import com.vip.pop.model.OrderStatusQueryRequest;

/**
 * 订单状态查询示例
 * 
 * 业务场景：电商平台跟踪订单履约状态
 */
public class OrderStatusExample {
    
    private static final String CUSTOMER_CODE = "17002437";
    
    /**
     * 单个订单状态查询
     */
    public void queryOrderStatus() {
        WopOuterOrderService service = PopServiceFactory.getWopOuterOrderService();
        
        try {
            // 方式1：通过ERP订单号查询
            String status = service.getOrderStatusByWopErpOrderSn(
                    CUSTOMER_CODE, "ERP202603210001");
            System.out.println("订单状态: " + status);
            
            // 方式2：通过外部订单号查询
            String status2 = service.getOrderStatusByOuterOrderNo(
                    CUSTOMER_CODE, "OUTER202603210001");
            System.out.println("订单状态: " + status2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 批量订单状态查询
     * 
     * 业务场景：批量同步订单状态到电商平台
     */
    public void batchQueryOrderStatus() {
        WopOuterOrderService service = PopServiceFactory.getWopOuterOrderService();
        
        try {
            OrderStatusQueryRequest[] requests = new OrderStatusQueryRequest[3];
            OrderStatusQueryRequest request0 = new OrderStatusQueryRequest();
            request0.setCustomerCode(CUSTOMER_CODE);
            request0.setWopErpOrderSn("ERP001");
            requests[0] = request0;
            OrderStatusQueryRequest request1 = new OrderStatusQueryRequest();
            request1.setCustomerCode(CUSTOMER_CODE);
            request1.setWopErpOrderSn("ERP002");
            requests[1] = request1;
            OrderStatusQueryRequest request2 = new OrderStatusQueryRequest();
            request2.setCustomerCode(CUSTOMER_CODE);
            request2.setWopErpOrderSn("ERP003");
            requests[2] = request2;
            
            String[] results = service.batchGetOrderStatus(requests);
            for (int i = 0; i < results.length; i++) {
                System.out.println("订单" + (i+1) + "状态: " + results[i]);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 3.3 JIT订单查询

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopJitOrderPopService;
import com.vip.pop.model.*;

/**
 * JIT订单查询示例
 * 
 * 业务场景：JIT模式下，供应商查询待送货订单
 */
public class JitOrderExample {
    
    public void queryJitOrders() {
        WopJitOrderPopService service = PopServiceFactory.getWopJitOrderPopService();
        
        try {
            // 1. 查询JIT订单列表
            JitOrderQueryRequest request = new JitOrderQueryRequest();
            // 设置查询条件...
            
            JitOrderQueryResponse response = service.queryJitOrder(request, 1, 20);
            System.out.println("查询到JIT订单: " + response);
            
            // 2. 查询订单明细
            JitOrderDetailQueryResponse detailResponse = service.queryJitOrderDetail(
                    "17002437",           // 供应商编码
                    "JIT202603150001",    // JIT送货单号
                    1, 50);
            System.out.println("订单明细: " + detailResponse);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 四、退货管理

> 退货是电商物流的重要环节，包括客户退货（客退）和退还供应商（退供）

### 4.1 退货流程全景

```
                              ┌─────────────────────────────────┐
                              │           退货管理              │
                              └─────────────────────────────────┘
                                           │
                    ┌──────────────────────┴──────────────────────┐
                    │                                             │
                    ▼                                             ▼
            ┌───────────────┐                            ┌───────────────┐
            │   客退单处理   │                            │   退供单处理   │
            └───────────────┘                            └───────────────┘
                    │                                             │
    ┌───────────────┼───────────────┐         ┌──────────────────┼──────────────────┐
    ▼               ▼               ▼         ▼                  ▼                  ▼
 创建客退单    查询客退单    取消客退单    创建退供单        提交退供单        取消退供单
```

### 4.2 客退单处理

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterOrderBackService;
import com.vip.pop.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 客退单处理示例
 * 
 * 业务场景：客户申请退货后，创建客退单通知云仓收货
 */
public class OrderBackExample {
    
    private static final String CUSTOMER_CODE = "17002437";
    
    /**
     * 创建客退单（带明细）
     * 推荐方式：一次性提交客退单和明细
     */
    public void createOrderBack() {
        WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
        
        try {
            // 1. 构建客退单明细列表
            List<OrderDetailInfo> details = new ArrayList<>();
            OrderDetailInfo detail1 = new OrderDetailInfo();
            detail1.setItemCode("SKU001");
            detail1.setItemName("测试商品A");
            detail1.setReqQty(1);
            detail1.setReturnReasonName("质量问题");
            details.add(detail1);
            OrderDetailInfo detail2 = new OrderDetailInfo();
            detail2.setItemCode("SKU002");
            detail2.setItemName("测试商品B");
            detail2.setReqQty(2);
            detail2.setReturnReasonName("尺码不合适");
            details.add(detail2);
            
            // 2. 构建客退单信息
            OrderBackInfo orderBackInfo = new OrderBackInfo();
            orderBackInfo.setErpOrderBackSn("OB" + System.currentTimeMillis());  // 客退单号（唯一）
            orderBackInfo.setErpOrderSn("ORDER001");                              // 原订单号
            orderBackInfo.setRevcWarehouse("WH001");                              // 退货仓库
            orderBackInfo.setReturnReason("质量问题");                             // 退货原因
            orderBackInfo.setOrderBackType((byte) 1);                             // 退货类型: 1=普通退货
            orderBackInfo.setOrderDetailInfos(details);                          // 退货明细
            
            // 3. 创建客退单
            ObCreateResult result = service.createOrder(CUSTOMER_CODE, orderBackInfo);
            
            if (result != null) {
                System.out.println("客退单创建成功！");
                // 保存返回的客退单号，用于后续查询
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("参数错误: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 批量查询客退单状态
     * 业务场景：定时同步客退单状态到电商平台
     */
    public void batchQueryStatus() {
        WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
        
        try {
            List<String> orderBackSns = Arrays.asList(
                    "OB202303210001", 
                    "OB202303210002", 
                    "OB202303210003");
            
            List<ObStatusResult> results = service.queryOrderStatusBatch(
                    CUSTOMER_CODE, orderBackSns);
            
            for (ObStatusResult result : results) {
                System.out.println("客退单状态: " + result);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 查询客退单详情
     */
    public void queryOrderBackDetail() {
        WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
        
        try {
            WopOrderBackInfo detail = service.queryOrderDetail(
                    CUSTOMER_CODE, "OB202303210001");
            System.out.println("客退单详情: " + detail);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 通过ERP订单号查询客退单
     * 业务场景：查询某订单关联的所有客退单
     */
    public void queryOrderBackByErpOrderSn() {
        WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
        
        try {
            QueryByErpOrderSnReq req = new QueryByErpOrderSnReq();
            req.setErpOrderSn("ORDER001");
            req.setOrderBackType((byte) 1);
            
            List<WopOrderBackInfo> results = service.queryOrderBackByErpOrderSn(
                    CUSTOMER_CODE, req);
            
            for (WopOrderBackInfo info : results) {
                System.out.println("客退单: " + info);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 分页查询客退单列表
     * 业务场景：客退单列表展示、报表导出
     */
    public void searchOrderList() {
        WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
        
        try {
            SearchOrderBackRequest req = new SearchOrderBackRequest();
            req.setCustomerCode(CUSTOMER_CODE);
            req.setPageNum(1);
            req.setPageSize(20);
            req.setSystemSource("WOP");
            
            SearchOrderBackResponse response = service.searchOrderList(req);
            System.out.println("查询到 " + response.getTotalCount() + " 条客退单");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 取消客退单
     * 业务场景：客户取消退货申请
     */
    public void cancelOrderBack() {
        WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
        
        try {
            ObCancelResult result = service.cancelOrder(
                    CUSTOMER_CODE, "OB202303210001");
            System.out.println("客退单取消结果: " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 修改承运商信息
     * 业务场景：客户更换快递公司后更新物流信息
     */
    public void modifyCarrier() {
        WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
        
        try {
            ModifyCarrierRequest req = new ModifyCarrierRequest();
            req.setCustomerCode(CUSTOMER_CODE);
            req.setErpOrderBackSn("OB202303210001");
            req.setTransportNo("SF123456789");   // 新的运单号
            req.setCarrierCode("SF");           // 承运商编码
            
            ModifyCarrierResponse response = service.modifyCarrier(req);
            System.out.println("修改承运商结果: " + response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 4.3 退供单处理

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterInvReturnOrderService;
import com.vip.pop.model.*;

/**
 * 退供单处理示例
 * 
 * 业务场景：将云仓库存退还给供应商
 */
public class InvReturnExample {
    
    private static final String CUSTOMER_CODE = "17002437";
    
    /**
     * 创建并提交退供单
     */
    public void createAndSubmitInvReturn() {
        WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
        
        try {
            // 1. 创建退供单表头
            CreateInvReturnOrderReq request = new CreateInvReturnOrderReq();
            request.setCustomerCode(CUSTOMER_CODE);
            request.setClientReturnSn("RETURN-" + System.currentTimeMillis());
            
            OperationResult createResult = service.createInvReturnOrder(request);
            if (!createResult.getSuccess()) {
                System.err.println("创建失败: " + createResult.getMessage());
                return;
            }
            
            String clientReturnSn = request.getClientReturnSn();
            
            // 2. 导入退供明细（省略，根据实际接口）
            
            // 3. 提交退供单
            OperationResult submitResult = service.submitInvReturnOrder(
                    CUSTOMER_CODE, clientReturnSn);
            
            if (submitResult.getSuccess()) {
                System.out.println("退供单提交成功");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 查询退供单
     */
    public void queryInvReturn() {
        WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
        
        try {
            // 通过客户退供单号查询
            OperationResult result = service.queryInvReturnOrder(
                    CUSTOMER_CODE, "CLIENT-RETURN-001", null);
            System.out.println("退供单信息: " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 五、库存管理

> 库存管理包括库存查询和仓间调拨，是供应链运营的核心

### 5.1 库存查询

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.CisInvChannelQueryAPI;
import com.vip.pop.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存查询示例
 * 
 * 业务场景：查询云仓库存，用于库存同步、补货决策
 */
public class InventoryQueryExample {
    
    private static final String VENDOR_CODE = "17002437";
    
    /**
     * 分页查询渠道库存
     */
    public void queryInventoryByPage() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            // 构建查询条件
            QueryChannelReq queryReq = new QueryChannelReq();
            queryReq.setVendorCode(VENDOR_CODE);
            queryReq.setWarehouseCode("WH001");
            
            // 分页参数
            PaginationModel pagination = new PaginationModel();
            pagination.setPageNumber(1);
            pagination.setPageSize(50);
            
            // 执行查询
            List<QueryChannelResult> results = service.invChannelQueryByPage(queryReq, pagination);
            
            for (QueryChannelResult result : results) {
                System.out.println("商品: " + result.getItemCode() + 
                        ", 库存: " + result.getQty());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 查询总记录数
     * 业务场景：分页前先获取总数
     */
    public void queryInventoryCount() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            QueryChannelReq queryReq = new QueryChannelReq()
                    .setVendorCode(VENDOR_CODE);
            
            Integer count = service.invChannelQueryCount(queryReq);
            System.out.println("库存记录总数: " + count);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 多仓库存汇总查询
     * 
     * 业务场景：查询商品在多个仓库的库存汇总
     */
    public void queryInventorySummary() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            List<InventoryQueryReq> reqList = new ArrayList<>();
            
            // 查询多个仓库
            InventoryQueryReq req1 = new InventoryQueryReq();
            req1.setVendorCode(VENDOR_CODE);
            req1.setWarehouseCode("WH001");
            reqList.add(req1);
            InventoryQueryReq req2 = new InventoryQueryReq();
            req2.setVendorCode(VENDOR_CODE);
            req2.setWarehouseCode("WH002");
            reqList.add(req2);
            InventoryQueryReq req3 = new InventoryQueryReq();
            req3.setVendorCode(VENDOR_CODE);
            req3.setWarehouseCode("WH003");
            reqList.add(req3);
            
            // 汇总查询
            List<InvChannelSum> results = service.selectInvChannelSumByMultiRequests(reqList);
            
            for (InvChannelSum sum : results) {
                System.out.println("仓库: " + sum.getWarehouseCode() + 
                        ", 总库存: " + sum.getTotalQty() + 
                        ", 可用: " + sum.getAvailableQty());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 通过渠道库存编码查询
     * 业务场景：精确查询指定商品的库存信息
     */
    public void selectByInvCode() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            QueryChannelResult result = service.selectByInvCode("INV001");
            System.out.println("库存详情: " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 库存汇总查询
     */
    public void selectInvChannelQuerySum() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            QueryChannelReq queryReq = new QueryChannelReq();
            queryReq.setVendorCode(VENDOR_CODE);
            
            List<QueryChannelResult> results = service.selectInvChannelQuerySum(queryReq);
            System.out.println("汇总查询结果: " + results.size() + " 条");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取供应商业务渠道列表
     * 业务场景：查询供应商在不同渠道的库存分布
     */
    public void getActionChannel() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            ActionChannelList result = service.getActionChannel(
                    VENDOR_CODE, 
                    "ACTION001",   // 动作编码
                    "IN",          // 方向: IN=入库, OUT=出库
                    null, null, null, null, null);
            System.out.println("业务渠道列表: " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取供应商所有渠道（按优先级代码）
     */
    public void getAllChannelByPriorityCode() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            List<Byte> channels = service.getAllChannelByPriorityCode(
                    VENDOR_CODE, "PRIORITY001");
            System.out.println("渠道列表: " + channels);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取供应商所有渠道（按优先级类型）
     */
    public void getAllChannelByVendor() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            List<Byte> channels = service.getAllChannelByVendor(
                    VENDOR_CODE, (byte) 0);  // 0=默认优先级
            System.out.println("渠道列表: " + channels);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取渠道优先级类型
     */
    public void getChannelPriorityType() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            Byte priorityType = service.getChannelPriorityType(
                    "ACTION001", "IN", 100);
            System.out.println("渠道优先级类型: " + priorityType);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取唯品会渠道销售请求参数
     */
    public void getVipChannelSaleBaseReq() {
        CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
        
        try {
            QueryChannelReq req = service.getVipChannelSaleBaseReq(
                    VENDOR_CODE, "WH001", "SKU001");
            System.out.println("渠道销售请求参数: " + req);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 5.2 仓间调拨

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterTransferService;
import com.vip.pop.model.OperationResult;

/**
 * 仓间调拨示例
 * 
 * 业务场景：将库存从A仓调拨到B仓
 */
public class TransferExample {
    
    private static final String CUSTOMER_CODE = "17002437";
    
    /**
     * 创建并提交调拨单
     */
    public void createTransfer() {
        WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
        
        try {
            String erpTransferSn = "TRANSFER-" + System.currentTimeMillis();
            
            // 1. 创建调拨单
            String createResult = service.createTransfer(
                    CUSTOMER_CODE,
                    erpTransferSn,
                    "NORMAL",       // 调拨类型
                    "WH001",        // 调出仓库
                    "WH002",        // 调入仓库
                    (byte) 1,       // 付款方式
                    "notify@company.com"  // 通知邮箱
            );
            System.out.println("调拨单创建: " + createResult);
            
            // 2. 导入调拨明细（根据实际接口）
            
            // 3. 提交调拨单
            OperationResult submitResult = service.submitTransfer(CUSTOMER_CODE, erpTransferSn);
            
            if (submitResult.getSuccess()) {
                System.out.println("调拨单提交成功");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 查询调拨单
     */
    public void queryTransfer() {
        WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
        
        try {
            // 查询调拨单列表
            String result = service.searchTransferList(CUSTOMER_CODE, 1, 20);
            System.out.println("调拨单列表: " + result);
            
            // 查询调拨单明细
            String detail = service.getTransferDetailList(
                    CUSTOMER_CODE, "TRANSFER-001", 1, 50);
            System.out.println("调拨明细: " + detail);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 六、事件驱动

> 通过事件机制，实现订单状态变更的实时感知和处理

### 6.1 事件处理流程

```
┌──────────────┐     ┌──────────────┐     ┌──────────────┐
│  查询待处理   │ ──▶ │  业务处理    │ ──▶ │  标记完成    │
│  事件列表    │     │  (ERP同步)   │     │  (成功/失败) │
└──────────────┘     └──────────────┘     └──────────────┘
                            │
                            │ 处理失败
                            ▼
                     ┌──────────────┐
                     │  累加重试次数 │
                     │  或重置事件  │
                     └──────────────┘
```

### 6.2 事件处理示例

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOrderEventService;

/**
 * 订单事件处理示例
 * 
 * 业务场景：定时轮询待处理事件，同步到ERP系统
 */
public class OrderEventExample {
    
    /**
     * 事件处理主流程
     */
    public void processEvents() {
        WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
        
        try {
            // 1. 查询待处理事件（每次100条）
            String eventsJson = service.queryNeedHandleEvents(100);
            System.out.println("待处理事件: " + eventsJson);
            
            // 2. 解析事件列表并处理（伪代码）
            // List<OrderEvent> events = parseEvents(eventsJson);
            // for (OrderEvent event : events) {
            //     processEvent(event);
            // }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 处理单个事件
     */
    public void processSingleEvent(Long eventId) {
        WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
        
        try {
            // 模拟业务处理
            boolean success = syncToErp(eventId);
            
            if (success) {
                // 处理成功，标记完成
                String result = service.finishEvent(eventId, 1, "同步成功");
                System.out.println("事件处理完成: " + result);
            } else {
                // 处理失败，累加重试次数
                String result = service.markTryEvent(eventId, "同步失败，等待重试");
                System.out.println("事件标记重试: " + result);
            }
            
        } catch (Exception e) {
            // 异常情况，重置事件
            try {
                service.resetEvent(eventId, "异常重置: " + e.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private boolean syncToErp(Long eventId) {
        // 实际的ERP同步逻辑
        return true;
    }
}
```

---

## 七、渠道与虚拟仓管理

> 当供应商需要同时在唯品会和其他平台（快手、拼多多等）销售时，需要进行渠道库存隔离

### 7.1 多渠道业务流程

```
╔═══════════════════════════════════════════════════════════════╗
║                       多渠道库存管理架构                          ║
╠═══════════════════════════════════════════════════════════════╣
║                                                               ║
║                    ┌─────────────────────────┐                    ║
║                    │    物理仓库 (PJ_ZQHX)     │                    ║
║                    │      华南肆庆仓          │                    ║
║                    └───────────┬─────────────┘                    ║
║                              │                                     ║
║            ┌───────────────┴────────────────┐                  ║
║            │                                │                  ║
║            ▼                                ▼                  ║
║   ┌─────────────────┐           ┌──────────────────┐          ║
║   │  唯品会渠道      │           │   非唯品渠道       │          ║
║   │  V1_80001001   │           │  NV1_80001001    │          ║
║   └───────┬─────────┘           └────────┬─────────┘          ║
║           │                              │                   ║
║           ▼                              ▼                   ║
║   ┌─────────────────┐           ┌──────────────────┐          ║
║   │ 唯品会APP/小程序 │           │ 快手/拼多多/抖音  │          ║
║   │ JIT/JITX订单   │           │ 发货单履约       │          ║
║   └─────────────────┘           └──────────────────┘          ║
║                                                               ║
╚═══════════════════════════════════════════════════════════════╝
```

### 7.2 唯品渠道入库

入库时指定唯品会虚拟仓，库存进入唯品会渠道：

```java
/**
 * 唯品渠道入库示例
 * 
 * 业务场景：商品入库到唯品会渠道，用于唯品会平台销售
 * 入库上架成功后，系统会通过VOP自动同步库存到唯品会前端
 */
public void createVipChannelPo() {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    
    try {
        CreatePoInfo poInfo = new CreatePoInfo();
        poInfo.setClientPoNo("PO-VIP-" + System.currentTimeMillis());
        poInfo.setWarehouseCode("V1_80001001");   // 唯品会虚拟仓编码
        poInfo.setVendorCode("8000100101");
        poInfo.setVendorName("示例供应商");
        poInfo.setRemark("唯品渠道采购入库");
        
        List<ImpPoDetail> details = new ArrayList<>();
        ImpPoDetail detail = new ImpPoDetail();
        detail.setItemCode("ITEM20260001");
        detail.setExpectedQty(100);
        details.add(detail);
        
        CreatePoResult result = service.createPoWithDetail(
                "80001001V2", poInfo, details);
        
        System.out.println("唯品渠道PO单创建成功: " + result.getPoNo());
        // 入库上架后，唯品会前端库存会自动增加100件
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

### 7.3 非唯品渠道入库

入库时指定非唯品虚拟仓，库存进入非唯品渠道：

```java
/**
 * 非唯品渠道入库示例
 * 
 * 业务场景：商品入库到非唯品渠道，用于快手、拼多多等平台销售
 */
public void createNonVipChannelPo() {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    
    try {
        CreatePoInfo poInfo = new CreatePoInfo();
        poInfo.setClientPoNo("PO-NV-" + System.currentTimeMillis());
        poInfo.setWarehouseCode("NV1_80001001");  // 非唯品虚拟仓编码
        poInfo.setVendorCode("8000100101");
        poInfo.setVendorName("示例供应商");
        poInfo.setRemark("非唯品渠道采购入库");
        
        List<ImpPoDetail> details = new ArrayList<>();
        ImpPoDetail detail = new ImpPoDetail();
        detail.setItemCode("ITEM20260001");
        detail.setExpectedQty(50);
        details.add(detail);
        
        CreatePoResult result = service.createPoWithDetail(
                "80001001V2", poInfo, details);
        
        System.out.println("非唯渠道PO单创建成功: " + result.getPoNo());
        // 入库后非唯品渠道库存增加50件
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

### 7.4 虚拟调拨（渠道间库存调拨）

当某渠道库存过多或不足时，可通过虚拟调拨在渠道间移动库存：

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterTransferService;
import com.vip.pop.model.OperationResult;

/**
 * 虚拟调拨示例
 * 
 * 业务场景：唯品会渠道库存过多，需要调拨到非唯品渠道用于其他平台销售
 * 
 * 调拨前：唯品渠道 100件，非唯品渠道 50件
 * 调拨后：唯品渠道 90件，非唯品渠道 60件
 */
public class VirtualTransferExample {
    
    private static final String CUSTOMER_CODE = "80001001V2";
    
    /**
     * 唯品渠道 -> 非唯品渠道
     */
    public void transferVipToNonVip() {
        WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
        
        try {
            String erpTransferSn = "VTRANS-" + System.currentTimeMillis();
            
            // 创建虚拟调拨单
            String createResult = service.createTransfer(
                    CUSTOMER_CODE,
                    erpTransferSn,
                    "DBCK",              // 调拨类型: DBCK=渠道拆分/虚拟调拨
                    "V1_80001001",       // 调出仓: 唯品会虚拟仓
                    "NV1_80001001",      // 调入仓: 非唯品虚拟仓
                    (byte) 1,
                    null
            );
            System.out.println("虚拟调拨单创建: " + createResult);
            
            // 导入调拨明细（调拨 10件）
            // ... 调用导入明细接口
            
            // 提交调拨单
            OperationResult submitResult = service.submitTransfer(
                    CUSTOMER_CODE, erpTransferSn);
            
            if (submitResult.getSuccess()) {
                System.out.println("虚拟调拨提交成功");
                // 唯品渠道库存 -10，非唯渠道库存 +10
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 非唯品渠道 -> 唯品渠道
     * 业务场景：唯品会大促刹卖前，将非唯库存调入唯品渠道
     */
    public void transferNonVipToVip() {
        WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
        
        try {
            String erpTransferSn = "VTRANS-" + System.currentTimeMillis();
            
            String createResult = service.createTransfer(
                    CUSTOMER_CODE,
                    erpTransferSn,
                    "DBCK",
                    "NV1_80001001",      // 调出仓: 非唯品虚拟仓
                    "V1_80001001",       // 调入仓: 唯品会虚拟仓
                    (byte) 1,
                    null
            );
            
            System.out.println("虚拟调拨单创建: " + createResult);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 7.5 非唯渠道发货单履约

非唯品渠道订单通过发货单方式履约：

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterOrderService;

/**
 * 非唯品渠道发货单示例
 * 
 * 业务场景：快手/拼多多/抖音等平台订单，通过发货单下发云仓履约
 * 流程：云仓收到发货单 -> 拣货 -> IQC -> 出仓 -> 返回运单号
 */
public class NonVipOrderExample {
    
    private static final String CUSTOMER_CODE = "80001001V2";
    
    public void createShipOrder() {
        WopOuterOrderService service = PopServiceFactory.getWopOuterOrderService();
        
        try {
            // 构建发货单信息
            // 仓库指定非唯品虚拟仓
            // 平台: 快手
            // 承运商: 中通
            
            // TODO: 根据实际接口调用发货单创建方法
            
            System.out.println("非唯渠道发货单创建成功");
            // 云仓履约完成后，会通过发货确认接口返回运单号
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 7.6 库存异动通知（JIT/JITX）

> **什么是库存异动？** 一种「仓库驱动」的履约模式，区别于传统的「ERP驱动」模式

#### 7.6.1 两种履约模式对比

在传统电商物流中，通常由上游ERP系统驱动整个履约流程。但唯品会渠道采用了一种特殊的「库存异动」模式：

```
╔═══════════════════════════════════════════════════════════════════════════════╗
║                        传统模式 vs 库存异动模式 对比                              ║
╠═══════════════════════════════════════════════════════════════════════════════╣
║                                                                               ║
║  【传统ERP驱动模式】                 【库存异动模式（唯品JIT/JITX）】            ║
║  适用：非唯品渠道                    适用：唯品会渠道                           ║
║                                                                               ║
║  ┌────────┐                         ┌────────┐                               ║
║  │ 电商平台 │ ①订单                  │ 唯品会  │ ①订单                        ║
║  └────┬───┘                         └────┬───┘                               ║
║       │                                   │                                   ║
║       ▼                                   │ 直接下发云仓                        ║
║  ┌────────┐                               │ (跳过ERP)                         ║
║  │  ERP   │ ②ERP创建发货单                │                                   ║
║  └────┬───┘                               ▼                                   ║
║       │ ③下发WMS                     ┌────────┐                               ║
║       ▼                              │唯品云仓│ ②独立履约                      ║
║  ┌────────┐                          │(承担ERP角色)│                          ║
║  │  WMS   │ ④拣货发货                 └────┬───┘                               ║
║  └────┬───┘                               │                                   ║
║       │ ⑤发货回传                          │ ③库存异动通知                      ║
║       ▼                                   ▼                                   ║
║  ┌────────┐                          ┌────────┐                               ║
║  │  ERP   │ ⑥库存扣减                 │  ERP   │ ④事后同步                      ║
║  └────────┘                          └────────┘                               ║
║                                                                               ║
║  特点：ERP全程控制                   特点：云仓独立履约，ERP事后感知             ║
║  ERP先知道 → 再发货                 先发货 → ERP后知道                         ║
║                                                                               ║
╚═══════════════════════════════════════════════════════════════════════════════╝
```

#### 7.6.2 为什么采用库存异动模式？

| 对比项 | 传统ERP驱动 | 库存异动模式 |
|--------|-------------|---------------|
| **订单来源** | 电商平台 → ERP → WMS | 唯品会 → 唯品云仓（直达） |
| **履约主体** | ERP驱动，WMS执行 | 云仓独立驱动（承担ERP角色）|
| **ERP角色** | 主导者（先知道再发货） | 接收者（先发货后知道） |
| **时效性** | 中等 | 更快（减少中间环节） |
| **适用场景** | 通用电商 | 唯品会闪购、JIT即时达 |

> 💡 **类比理解**：类似阿里奇门的「库存异动」通知机制。仓库是执行主体，完成履约后通知上游系统「我已经出库了XX商品」，上游系统据此更新自己的库存账。

#### 7.6.3 库存异动业务流程

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                         库存异动完整流程                                      │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ① 唯品会前端                ② 唯品云仓               ③ 供应商ERP           │
│     产生订单                   独立履约                  事后感知             │
│                                                                             │
│  ┌──────────┐            ┌──────────────┐           ┌──────────────┐       │
│  │ 消费者下单 │ ──────▶  │ JIT/JITX订单  │ ──────▶  │  库存异动事件  │       │
│  │ (唯品会APP)│            │ 直接下发云仓  │           │  推送到ERP    │       │
│  └──────────┘            └──────────────┘           └──────────────┘       │
│                                  │                          │              │
│                                  ▼                          ▼              │
│                          ┌──────────────┐           ┌──────────────┐       │
│                          │ 云仓拣货包装  │           │ ERP查询事件   │       │
│                          │ 称重出库交接  │           │ 更新库存账    │       │
│                          └──────────────┘           │ 同步财务      │       │
│                                  │                  └──────────────┘       │
│                                  ▼                                         │
│                          ┌──────────────┐                                  │
│                          │ 产生库存异动  │                                  │
│                          │ (商品A -1件)  │                                  │
│                          └──────────────┘                                  │
│                                                                             │
└─────────────────────────────────────────────────────────────────────────────┘
```

#### 7.6.4 库存异动事件处理

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOrderEventService;

/**
 * 库存异动事件处理示例
 * 
 * 业务背景：
 * - 唯品云仓承担ERP角色，独立完成JIT/JITX订单履约
 * - 无需上游ERP传单据，云仓直接从唯品会接收订单并发货
 * - 发货完成后，通过「库存异动事件」通知ERP系统
 * - ERP系统通过轮询事件，实现库存账的事后同步
 * 
 * 处理流程：
 * 1. 定时查询待处理的库存异动事件
 * 2. 解析事件数据（订单号、商品、数量、品牌等）
 * 3. 根据品牌/虚拟客户编码拆分到对应货主
 * 4. 更新ERP库存账
 * 5. 标记事件处理完成
 */
public class InventoryChangeExample {
    
    /**
     * 库存异动事件处理主流程
     * 建议：每5-10分钟执行一次
     */
    public void processInventoryChangeEvents() {
        WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
        
        try {
            // 1. 查询待处理的库存异动事件（每次最多100条）
            String eventsJson = service.queryNeedHandleEvents(100);
            System.out.println("待处理库存异动事件: " + eventsJson);
            
            // 2. 解析事件列表
            // List<InventoryChangeEvent> events = parseEvents(eventsJson);
            // 
            // 3. 处理每个事件
            // for (InventoryChangeEvent event : events) {
            //     // 3.1 解析事件数据
            //     String orderNo = event.getOrderNo();       // JIT订单号
            //     String itemCode = event.getItemCode();     // 商品编码
            //     Integer qty = event.getQty();              // 出库数量
            //     String brandCode = event.getBrandCode();   // 品牌编码
            //     String virtualClientCode = event.getVirtualClientCode(); // 虚拟客户编码
            //     
            //     // 3.2 根据虚拟客户编码确定货主
            //     String ownerCode = mapToOwner(virtualClientCode);
            //     
            //     // 3.3 更新ERP库存账
            //     erpService.deductInventory(ownerCode, itemCode, qty);
            //     
            //     // 3.4 标记事件处理完成
            //     service.finishEvent(event.getId(), 1, "同步成功");
            // }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 库存异动事件数据示例
     * 
     * 场景：消费者在唯品会下单购买了2件商品（分属不同品牌）
     * 
     * | 字段              | 事件1              | 事件2              |
     * |-------------------|--------------------|--------------------|  
     * | order_no          | 20260301-000001    | 20260301-000001    |
     * | item_code         | ITEM2026A001       | ITEM2026B002       |
     * | qty               | 1                  | 1                  |
     * | brand_code        | 10000001           | 10000002           |
     * | virtual_client_code| 80001001          | 80001001V2         |
     * 
     * 处理逻辑：
     * - 同一订单可能产生多条异动事件（不同品牌/货主）
     * - 根据 virtual_client_code 拆分到对应的ERP货主账户
     * - 80001001 → 货主A的库存账 -1
     * - 80001001V2 → 货主B的库存账 -1
     */
}
```

#### 7.6.5 关键概念说明

| 概念 | 说明 |
|------|------|
| **JIT订单** | Just-In-Time，唯品会即时达订单，消费者下单后快速配送 |
| **JITX订单** | JIT扩展模式，支持更多履约场景 |
| **库存异动** | 仓库出库/入库后产生的库存变动通知 |
| **虚拟客户编码** | 用于区分同一订单中不同品牌归属的货主 |
| **事后同步** | 先发货后通知，ERP通过轮询事件实现数据同步 |

> ⚠️ **重要提示**：库存异动模式下，ERP系统不需要（也不能）主动下发发货单到云仓。唯品云仓会自动完成履约，ERP只需定时查询库存异动事件，更新自己的库存账即可。

### 7.7 渠道库存场景汇总

| 场景 | 操作 | 唯品渠道库存 | 非唯渠道库存 | 备注 |
|------|------|--------------|--------------|------|
| **唯品渠道入库** | 入库单(V1_xxx) | +100 | - | 自动同步到唯品会前端 |
| **非唯渠道入库** | 入库单(NV1_xxx) | - | +50 | 用于其他平台销售 |
| **唯品订单出库** | JIT/JITX履约 | -10 | - | 产生库存异动通知 |
| **非唯订单出库** | 发货单履约 | - | -5 | 返回运单号 |
| **虚拟调拨V→NV** | 调拨单(DBCK) | -10 | +10 | 渠道间移动 |
| **虚拟调拨NV→V** | 调拨单(DBCK) | +10 | -10 | 渠道间移动 |
| **退供出库** | 出库单 | - | -20 | 次品退供应商 |

---

## 开发技巧

> 提升开发效率和代码质量的实用技巧

### 1. 配置管理

```java
// ✅ 推荐：使用环境变量或JVM参数（安全）
// 生产环境启动命令
// java -Dpop.app.key=xxx -Dpop.app.secret=xxx -jar app.jar

// ❌ 避免：将密钥硬编码在代码中
// String appKey = "1a2e1e07"; // 不安全！
```

### 2. 服务实例获取

```java
// ✅ 推荐：使用工厂类获取单例（性能最优）
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

// ⚠️ 可选：每次创建新实例（适用于多租户场景）
WopOuterPoService service = PopServiceFactory.createWopOuterPoService();

// ❌ 避免：频繁实例化（影响性能）
for (int i = 0; i < 1000; i++) {
    WopOuterPoService service = new WopOuterPoService(); // 不推荐
}
```

### 3. 异常处理

```java
// ✅ 推荐：统一的异常处理模式
public <T> T executeWithRetry(ApiCallback<T> callback, int maxRetries) {
    int attempts = 0;
    Exception lastException = null;
    
    while (attempts < maxRetries) {
        try {
            return callback.execute();
        } catch (IllegalArgumentException e) {
            // 参数错误，不需要重试
            throw e;
        } catch (Exception e) {
            lastException = e;
            attempts++;
            if (attempts < maxRetries) {
                try {
                    Thread.sleep(1000 * attempts); // 指数退避
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    throw new RuntimeException("重试" + maxRetries + "次后失败", lastException);
}
```

### 4. 幂等性保障

```java
// ✅ 推荐：使用业务单号作为唯一标识
CreatePoInfo poInfo = new CreatePoInfo();
poInfo.setClientPoNo("CLIENT-PO-" + businessId);  // 业务唯一ID

// 重复调用相同clientPoNo不会创建重复记录
```

### 5. 分页查询

```java
// ✅ 推荐：合理的分页大小
int pageSize = 50;  // 建议50-100

// ❌ 避免：过大的分页（影响性能）
int pageSize = 1000;  // 不推荐

// ✅ 推荐：使用时间范围缩小查询范围
PoQueryCondition condition = new PoQueryCondition();
condition.setStartTime("2026-03-01");
condition.setEndTime("2026-03-15");  // 限制时间范围
```

---

## 疑难排查

> 常见问题及解决方案

### Q1: API调用返回"签名验证失败"

**原因：** AppKey、AppSecret 配置错误或不匹配

**解决：**
```java
// 检查配置
System.out.println("AppKey: " + System.getProperty("pop.app.key"));
System.out.println("AppSecret: " + System.getProperty("pop.app.secret"));
```

### Q2: 创建PO单失败"商品不存在"

**原因：** 商品未同步到云仓系统

**解决：**
```java
// 先同步商品
PdcDecItemErpService pdcService = PopServiceFactory.getPdcDecItemErpService();
ErpDecPdcItemResult result = pdcService.syncPdcItem(customerCode, item);

// 再创建PO单
WopOuterPoService poService = PopServiceFactory.getWopOuterPoService();
poService.createPoWithDetail(customerCode, poInfo, details);
```

### Q3: 查询结果为空

**原因：** 查询条件过于严格或数据不存在

**解决：**
```java
// 1. 放宽查询条件
PoQueryCondition condition = new PoQueryCondition();
condition.setStartTime("2026-01-01");  // 扩大时间范围
condition.setEndTime("2026-12-31");

// 2. 确认客户编码正确
String customerCode = "17002437";  // 确保与申请的一致
```

### Q4: 请求超时

**原因：** 网络问题或大数据量查询

**解决：**
```java
// 1. 减小分页大小
int pageSize = 20;  // 减小批次

// 2. 缩小查询范围
condition.setStartTime("2026-03-01");
condition.setEndTime("2026-03-07");  // 一周数据

// 3. 检查网络连通性
// ping api.example.com
```

---

## 相关文档

- [返回 README.md](../README.md) - SDK 入门指南
- [API 文档目录](./) - 各服务详细 API 文档

---

*文档版本: 1.0.0 | 更新日期: 2026-02-26*
