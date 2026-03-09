# WopOuterPoService API 文档

> WOP入库单PO服务 - 提供PO单的创建、修改、查询、取消、关闭等功能
> 
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4102&serviceName=WopOuterPoService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopOuterPoService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
// 方式1: 通过工厂类获取单例（推荐）
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

// 方式2: 创建新实例
WopOuterPoService service = PopServiceFactory.createWopOuterPoService();

// 方式3: 直接实例化
WopOuterPoService service = new WopOuterPoService();
```

## 方法列表

### PO单创建

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `createPo` | 创建PO单表头 | String, CreatePoInfo, String | CreatePoResult |
| `createPoWithDetail` | 创建PO单并自动提交 | String, CreatePoInfo, List\<ImpPoDetail\> | CreatePoResult |

### PO单修改

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `editPo` | 修改PO单表头 | String, String, CreatePoInfo | OperationResult |
| `importPoDetail` | 导入PO单明细 | String, String, List\<ImpPoDetail\>, String | OperationResult |
| `cleanPoDetail` | 清空PO单明细 | String, String | OperationResult |

### PO单状态操作

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `submitPo` | 提交PO单 | String, String, String | OperationResult |
| `cancelPo` | 取消PO单 | String, String, String | OperationResult |
| `closePo` | 关闭PO单 | ClosePoRequest | ClosePoResponse |

### PO单查询

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `queryPo` | PO查询 | String, String | QueryPoResult |
| `queryPoBySystemPoNo` | 根据系统PO查询 | QueryPoBySystemPoNoRequest | QueryPoBySystemPoNoResponse |
| `searchPoList` | PO单列表查询（分页） | String, PoQueryCondition, Integer, Integer, String | SearchPoResult |
| `getPoDetailList` | PO单明细查询 | String, String, Integer, Integer, List\<String\> | SearchPoDetailResult |
| `getPoNoByClientPoNo` | 通过客记PO获取系统PO号 | String, String | String |

### 收货/入库结果查询

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `getDeliveryResult` | 获取PO单收货明细 | String, String, Integer, Integer | SearchDeliveryResult |
| `getReceiptResult` | 入库结果查询 | String, String, String, Integer, Integer, List\<String\> | SearchReceiptResult |

---

## 方法详情

### createPo

> 创建PO单表头接口

**方法签名:**
```java
public CreatePoResult createPo(String customerCode, CreatePoInfo poInfo, String systemSource) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| poInfo | CreatePoInfo | 是 | PO信息 |
| systemSource | String | 否 | 来源系统 |

**示例代码:**
```java
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

CreatePoInfo poInfo = new CreatePoInfo();
poInfo.setClientPoNo("CLIENT-PO-001");
poInfo.setWarehouseCode("WH001");
poInfo.setVendorCode("V001");
poInfo.setVendorName("测试供应商");
poInfo.setExpectedArrivalTime("2026-03-01");

CreatePoResult result = service.createPo("17002437", poInfo, "ERP");
System.out.println("创建结果: " + result);
```

---

### createPoWithDetail

> 创建PO单并自动提交接口（含明细）

**方法签名:**
```java
public CreatePoResult createPoWithDetail(String customerCode, CreatePoInfo poInfo, List<ImpPoDetail> impPoDetailList) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| poInfo | CreatePoInfo | 是 | PO信息 |
| impPoDetailList | List\<ImpPoDetail\> | 是 | PO明细列表 |

**示例代码:**
```java
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

CreatePoInfo poInfo = new CreatePoInfo();
poInfo.setClientPoNo("CLIENT-PO-002");
poInfo.setWarehouseCode("WH001");

List<ImpPoDetail> details = new ArrayList<>();
ImpPoDetail detail1 = new ImpPoDetail();
detail1.setSkuCode("SKU001");
detail1.setExpectedQty(100);
details.add(detail1);
ImpPoDetail detail2 = new ImpPoDetail();
detail2.setSkuCode("SKU002");
detail2.setExpectedQty(200);
details.add(detail2);

CreatePoResult result = service.createPoWithDetail("17002437", poInfo, details);
```

---

### queryPo

> PO查询接口

**方法签名:**
```java
public QueryPoResult queryPo(String customerCode, String poNos) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| poNos | String | 是 | PO编号（多个用逗号分隔） |

**示例代码:**
```java
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

// 查询单个PO
QueryPoResult result = service.queryPo("17002437", "PO202603010001");

// 查询多个PO
QueryPoResult results = service.queryPo("17002437", "PO001,PO002,PO003");
```

---

### searchPoList

> PO单列表查询接口（分页）

**方法签名:**
```java
public SearchPoResult searchPoList(String customerCode, PoQueryCondition condition, Integer pageNum, Integer pageSize, String systemSource) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| condition | PoQueryCondition | 是 | 查询条件 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页大小 |
| systemSource | String | 否 | 来源系统 |

**示例代码:**
```java
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

PoQueryCondition condition = new PoQueryCondition();
condition.setPoStatus("SUBMITTED");
condition.setStartTime("2026-01-01");
condition.setEndTime("2026-03-01");

SearchPoResult result = service.searchPoList("17002437", condition, 1, 20, null);
System.out.println("查询到 " + result.getTotalCount() + " 条记录");
```

---

### closePo

> 关闭PO单接口

**方法签名:**
```java
public ClosePoResponse closePo(ClosePoRequest request) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| request | ClosePoRequest | 是 | 关闭PO请求参数 |

**示例代码:**
```java
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

ClosePoRequest request = new ClosePoRequest();
request.setCustomerCode("17002437");
request.setPoNo("PO202603010001");
request.setCloseReason("业务完成");

ClosePoResponse response = service.closePo(request);
```

---

### getDeliveryResult

> 获取PO单收货明细接口

**方法签名:**
```java
public SearchDeliveryResult getDeliveryResult(String customerCode, String poNo, Integer pageNum, Integer pageSize) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| poNo | String | 是 | PO编号 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页大小 |

**示例代码:**
```java
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

SearchDeliveryResult result = service.getDeliveryResult("17002437", "PO202603010001", 1, 50);
```

---

### getReceiptResult

> 入库结果查询接口

**方法签名:**
```java
public SearchReceiptResult getReceiptResult(String customerCode, String systemSource, String poNo, Integer pageNum, Integer pageSize, List<String> transactionIdList) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| systemSource | String | 否 | 来源系统 |
| poNo | String | 否 | PO编号 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页大小 |
| transactionIdList | List\<String\> | 否 | 交易ID列表 |

**示例代码:**
```java
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

// 按PO查询
SearchReceiptResult result = service.getReceiptResult("17002437", null, "PO202603010001", 1, 50, null);

// 按交易ID查询
List<String> transIds = Arrays.asList("TXN001", "TXN002");
SearchReceiptResult result2 = service.getReceiptResult("17002437", null, null, 1, 50, transIds);
```

---

## 模型类

### 请求模型

#### CreatePoInfo

> PO单创建信息

| 字段名 | 类型 | 描述 |
|--------|------|------|
| clientPoNo | String | 客户PO编号 |
| warehouseCode | String | 仓库编码 |
| vendorCode | String | 供应商编码 |
| vendorName | String | 供应商名称 |
| expectedArrivalTime | String | 预计到货时间 |
| remark | String | 备注 |

#### ImpPoDetail

> PO单明细信息

| 字段名 | 类型 | 描述 |
|--------|------|------|
| skuCode | String | SKU编码 |
| expectedQty | Integer | 预期数量 |
| productName | String | 商品名称 |
| barcode | String | 条码 |

#### PoQueryCondition

> PO查询条件

| 字段名 | 类型 | 描述 |
|--------|------|------|
| poStatus | String | PO状态 |
| startTime | String | 开始时间 |
| endTime | String | 结束时间 |
| poNo | String | PO编号 |
| clientPoNo | String | 客户PO编号 |

#### ClosePoRequest

> 关闭PO请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| customerCode | String | 客户编码 |
| poNo | String | PO编号 |
| closeReason | String | 关闭原因 |

### 响应模型

#### CreatePoResult

> 创建PO返回结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| poNo | String | 系统PO编号 |
| message | String | 返回消息 |

#### OperationResult

> 操作返回结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |
| code | String | 返回码 |

#### QueryPoResult

> PO查询结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| poList | List\<PoInfo\> | PO列表 |
| totalCount | Integer | 总数 |

---

## 错误处理

```java
try {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    CreatePoResult result = service.createPo("17002437", poInfo, null);
    
    if (result.getSuccess()) {
        System.out.println("PO创建成功: " + result.getPoNo());
    } else {
        System.out.println("PO创建失败: " + result.getMessage());
    }
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```

## 常见问题

### Q: 如何批量创建PO单？
使用 `createPoWithDetail` 方法可以一次创建PO单并提交明细，比先 `createPo` 再 `importPoDetail` 更高效。

### Q: 如何查询PO单状态变化？
使用 `searchPoList` 配合 `PoQueryCondition` 的状态和时间条件进行查询。

### Q: 分页查询的最大页面大小？
建议 pageSize 不超过 100，以保证接口性能。
