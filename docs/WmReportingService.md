# WmReportingService API 文档

> 仓储报表服务 - 提供库存变更报表、盘点报表查询、渠道库存查询、进销存报表查询、实时库存查询等功能
>
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4112&serviceName=WmReportingService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WmReportingService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WmReportingService service = PopServiceFactory.getWmReportingService();
```

## 字段枚举说明

### bizType 库存异动业务类型

| 枚举值 | 场景 | 说明 |
|-------|------|------|
| `JIT` | B2BCK | JIT&JITX B2B退货场景 |
| `PO` | 次品退货 | 直通车(智能退供)唯品大仓退唯品云仓场景 |
| `RTV` | PO退货 | 直通车(智能退供)唯品云仓次品退供应商仓场景 |


**说明**:
- `bizType` 为选填字段,用于过滤特定业务类型的库存异动记录
- 默认情况下不传 `bizType`,查询所有业务类型的库存异动
- 在调用库存异动相关接口时,可根据需要传入对应枚举值进行过滤

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `stockChangeReportQuery` | 查询库存异动报表 | String, Integer, Integer, String, String | List\<StockchangeReportRes\> |
| `stockChangeReportQueryByObj` | 查询库存异动报表(对象方式) | StockChangeReportReq | List\<StockchangeReportRes\> |
| `stockChangeReportAck` | 库存异动通知确认 | String, List\<StockchangeReportAck\>, String, String | List\<StockchangeReportAck\> |
| `stockChangeReportAckByObj` | 库存异动通知确认(对象方式) | StockChangeReportReq | List\<StockchangeReportAck\> |
| `invCheckReportQuery` | 查询盘点报表 | String, Integer, Integer | InvCheckResponse |
| `invCheckReportAck` | 库存盘点结果确认 | String, List\<InvCheckReportAckResult\> | InvCheckAckResponse |
| `channelInvQuery` | 渠道库存查询 | ChannelInvReq | ChannelInvResponse |
| `queryPurchaseSalesInventory` | 进销存报表查询 | PurchaseSalesRequest | PurchaseSalesResponse |
| `queryRealtimeInventory` | 实时库存报表查询 | RealtimeInventoryRequest | RealtimeInventoryResponse |
| `queryInvOutQuantitySkuSum` | 出库SKU汇总查询 | String, String, String, String, String | InventorySkuSumResponse |
| `queryWms119Inventory` | WMS119库存报表查询 | Wms119InventoryRequest | String |
| `healthCheck` | 健康检查 | 无 | void |

---

## 方法详情

### stockChangeReportQuery

> 查询库存异动报表(分页查询)

**方法签名:**
```java
public List<StockchangeReportRes> stockChangeReportQuery(
    String customerCode,
    Integer pageNum,
    Integer pageSize,
    String bizType,
    String virtualClientCode
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | WOP货主编码 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页数量 |
| bizType | String | 否 | 库存异动业务类型,见 [字段枚举说明](#字段枚举说明) |
| virtualClientCode | String | 否 | 虚拟货主客户编码 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

// 不支持查询所有业务类型的库存异动(错误示例)
List<StockchangeReportRes> result1 = service.stockChangeReportQuery(
    "17002437", 1, 20, null, null
);

// 查询次品退货场景的库存异动
List<StockchangeReportRes> result2 = service.stockChangeReportQuery(
    "17002437", 1, 20, "RTV", null
);
```

---

### stockChangeReportQueryByObj

> 查询库存异动报表(对象方式)

**方法签名:**
```java
public List<StockchangeReportRes> stockChangeReportQueryByObj(
    StockChangeReportReq request
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| request | StockChangeReportReq | 是 | 库存异动查询请求对象 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

StockChangeReportReq request = new StockChangeReportReq();
request.setCustomerCode("17002437");
request.setPageNum(1);
request.setPageSize(20);
request.setBizType("RTV");  // 次品退货场景

List<StockchangeReportRes> result = service.stockChangeReportQueryByObj(request);
```

---

### stockChangeReportAck

> 库存异动通知确认

**方法签名:**
```java
public List<StockchangeReportAck> stockChangeReportAck(
    String customerCode,
    List<StockchangeReportAck> ackResultList,
    String bizType,
    String virtualClientCode
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| ackResultList | List\<StockchangeReportAck\> | 是 | 流水确认结果列表 |
| bizType | String | 否 | 库存异动业务类型 |
| virtualClientCode | String | 否 | 虚拟货主客户编码 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

List<StockchangeReportAck> ackResultList = new ArrayList<>();
StockchangeReportAck ack = new StockchangeReportAck();
ack.setTransactionId("123456");
ack.setAckStatus("SUCCESS");
ackResultList.add(ack);

List<StockchangeReportAck> result = service.stockChangeReportAck(
    "17002437", ackResultList, "RTV", null
);
```

---

### invCheckReportQuery

> 查询盘点报表

**方法签名:**
```java
public InvCheckResponse invCheckReportQuery(
    String customerCode,
    Integer pageNum,
    Integer pageSize
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页数量 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

InvCheckResponse result = service.invCheckReportQuery("17002437", 1, 20);
```

---

### invCheckReportAck

> 库存盘点结果确认

**方法签名:**
```java
public InvCheckAckResponse invCheckReportAck(
    String customerCode,
    List<InvCheckReportAckResult> ackResultList
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| ackResultList | List\<InvCheckReportAckResult\> | 是 | 流水确认结果列表 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

List<InvCheckReportAckResult> ackResultList = new ArrayList<>();
InvCheckReportAckResult ack = new InvCheckReportAckResult();
ack.setTransactionId("123456");
ack.setAckStatus("SUCCESS");
ackResultList.add(ack);

InvCheckAckResponse result = service.invCheckReportAck("17002437", ackResultList);
```

---

### channelInvQuery

> 渠道库存查询

**方法签名:**
```java
public ChannelInvResponse channelInvQuery(
    ChannelInvReq queryChannelReq
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| queryChannelReq | ChannelInvReq | 是 | 渠道库存查询请求对象 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

ChannelInvReq request = new ChannelInvReq();
request.setVendorCode("17002437");
request.setPageNo(1);
request.setPageSize(10);
request.setWarehouseCode("WH001");
request.setDateFrom("2026-01-01");
request.setDateTo("2026-02-25");
request.setQueryType("1");

ChannelInvResponse result = service.channelInvQuery(request);
```

---

### queryPurchaseSalesInventory

> 进销存报表查询

**方法签名:**
```java
public PurchaseSalesResponse queryPurchaseSalesInventory(
    PurchaseSalesRequest query
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| query | PurchaseSalesRequest | 是 | 进销存查询条件对象 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

PurchaseSalesRequest query = new PurchaseSalesRequest();
query.setVendorCode("17002437");
query.setPageNo(1);
query.setPageSize(10);
query.setWarehouseCode("WH001");
query.setDateFrom("2026-01-01");
query.setDateTo("2026-02-25");
query.setQueryType("1");

PurchaseSalesResponse result = service.queryPurchaseSalesInventory(query);
```

---

### queryRealtimeInventory

> 实时库存报表查询

**方法签名:**
```java
public RealtimeInventoryResponse queryRealtimeInventory(
    RealtimeInventoryRequest query
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| query | RealtimeInventoryRequest | 是 | 实时库存查询条件对象 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

RealtimeInventoryRequest query = new RealtimeInventoryRequest();
query.setVendorCode("17002437");
query.setPageNo(1);
query.setPageSize(10);
query.setWarehouseCode("WH001");

RealtimeInventoryResponse result = service.queryRealtimeInventory(query);
```

---

### queryInvOutQuantitySkuSum

> 出库SKU汇总查询

**方法签名:**
```java
public InventorySkuSumResponse queryInvOutQuantitySkuSum(
    String vendorCode,
    String startDate,
    String endDate,
    String warehouseCode,
    String itemCode
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| vendorCode | String | 是 | 供应商编码 |
| startDate | String | 是 | 开始时间,格式为：yyyy-mm-dd |
| endDate | String | 是 | 结束时间,格式为：yyyy-mm-dd |
| warehouseCode | String | 否 | 仓库编码 |
| itemCode | String | 否 | 商品编码 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

InventorySkuSumResponse result = service.queryInvOutQuantitySkuSum(
    "17002437", "2026-01-01", "2026-02-25", "WH001", null
);
```

---

### queryWms119Inventory

> WMS119库存报表查询

**方法签名:**
```java
public String queryWms119Inventory(
    Wms119InventoryRequest query
) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| query | Wms119InventoryRequest | 是 | WMS119库存查询条件对象 |

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();

Wms119InventoryRequest query = new Wms119InventoryRequest();
query.setVendorCode("17002437");

String result = service.queryWms119Inventory(query);
```

---

### healthCheck

> 健康检查

**方法签名:**
```java
public void healthCheck() throws Exception
```

**参数说明:** 无参数

**示例代码:**
```java
WmReportingService service = PopServiceFactory.getWmReportingService();
service.healthCheck();
```

---

## 模型类

### StockChangeReportReq

> 库存异动查询请求对象

| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 否 | WOP货主编码 |
| pageNum | Integer | 是 | 分页数 |
| pageSize | Integer | 是 | 分页数量 |
| bizType | String | 否 | 处理类型,见 [字段枚举说明](#字段枚举说明) |
| virtualClientCode | String | 否 | 虚拟货主客户编码 |

### StockchangeReportRes

> 库存异动查询结果对象

| 字段名 | 类型 | 描述 |
|--------|------|------|
| transactionId | String | 流水号ID |
| itemCode | String | 商品编码 |
| warehouseCode | String | 仓库编码 |
| qty | Integer | 数量 |
| bizType | String | 业务类型 |
| createTime | String | 创建时间 |

### InvCheckResponse

> 盘点报表查询响应对象

| 字段名 | 类型 | 描述 |
|--------|------|------|
| transactionId | String | 流水号ID |
| itemCode | String | 商品编码 |
| warehouseCode | String | 仓库编码 |
| checkQty | Integer | 盘点数量 |
| status | String | 状态 |
| createTime | String | 创建时间 |

### ChannelInvReq

> 渠道库存查询请求对象

| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| vendorCode | String | 是 | 供应商编码 |
| pageNo | Integer | 是 | 当前页码 |
| pageSize | Integer | 是 | 分页数量 |
| warehouseCode | String | 否 | 仓库编码 |
| dateFrom | String | 否 | 库存开始日期(格式:yyyy-MM-dd) |
| dateTo | String | 否 | 库存结束日期(格式:yyyy-MM-dd) |
| queryType | String | 否 | 查询维度(1:商品+PO、2:商品、3:PO、4:供应商) |

### PurchaseSalesRequest

> 进销存报表查询请求对象

| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| vendorCode | String | 是 | 供应商编码 |
| pageNo | Integer | 是 | 当前页码 |
| pageSize | Integer | 是 | 分页数量 |
| warehouseCode | String | 否 | 仓库编码 |
| dateFrom | String | 否 | 库存开始日期(格式:yyyy-MM-dd) |
| dateTo | String | 否 | 库存结束日期(格式:yyyy-MM-dd) |
| queryType | String | 否 | 查询维度(1:商品+PO、2:商品、3:PO、4:供应商) |

### RealtimeInventoryRequest

> 实时库存查询请求对象

| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| vendorCode | String | 是 | 供应商编码 |
| pageNo | Integer | 是 | 当前页码 |
| pageSize | Integer | 是 | 分页数量 |
| warehouseCode | String | 否 | 仓库编码 |
