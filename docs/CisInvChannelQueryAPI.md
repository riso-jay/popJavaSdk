# CisInvChannelQueryAPI API 文档

> CIS渠道库存查询API - 提供渠道库存查询、汇总查询等功能
> 
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4113&serviceName=CisInvChannelQueryAPI

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.cis.service.CisInvChannelQueryAPI` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
// 方式1: 通过工厂类获取单例（推荐）
CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();

// 方式2: 创建新实例
CisInvChannelQueryAPI service = PopServiceFactory.createCisInvChannelQueryAPI();

// 方式3: 直接实例化
CisInvChannelQueryAPI service = new CisInvChannelQueryAPI();
```

## 方法列表

### 渠道查询接口

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `getActionChannel` | 获取供应商业务渠道列表 | String, String, String, String, Integer, String, String, Byte | ActionChannelList |
| `getAllChannelByPriorityCode` | 获取供应商所有的渠道（按优先级代码） | String, String | List\<Byte\> |
| `getAllChannelByVendor` | 获取供应商所有的渠道（按优先级类型） | String, Byte | List\<Byte\> |
| `getChannelPriorityType` | 获取渠道优先级类型 | String, String, Integer | Byte |
| `getVipChannelSaleBaseReq` | 获取唯品会渠道销售请求参数 | String, String, String | QueryChannelReq |

### 库存查询接口

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `invChannelQueryByPage` | 分页查询渠道库存 | QueryChannelReq, PaginationModel | List\<QueryChannelResult\> |
| `invChannelQueryCount` | 查询总记录数 | QueryChannelReq | Integer |
| `selectByInvCode` | 通过渠道库存编码获取渠道库存 | String | QueryChannelResult |
| `selectInvChannelQuerySum` | 汇总查询结果 | QueryChannelReq | List\<QueryChannelResult\> |
| `selectInvChannelSumByMultiRequests` | 库存汇总查询（多请求） | List\<InventoryQueryReq\> | List\<InvChannelSum\> |

---

## 方法详情

### getActionChannel

> 获取供应商业务渠道列表

**方法签名:**
```java
public ActionChannelList getActionChannel(String vendorCode, String actionCode, String opType, 
        String systemPoNo, Integer qty, String otherPoNo, String grade, Byte saleStatus) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| vendorCode | String | 是 | 供应商编码 |
| actionCode | String | 是 | 业务编码 |
| opType | String | 是 | 业务类型 |
| systemPoNo | String | 否 | 入库单号 |
| qty | Integer | 否 | 操作数 |
| otherPoNo | String | 否 | 其他入库单号 |
| grade | String | 否 | 货品等级 |
| saleStatus | Byte | 否 | 售卖状态 0:可用 1:不可用 |

**示例代码:**
```java
CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();

ActionChannelList result = service.getActionChannel(
    "17002437", "ACTION001", "IN", null, null, null, null, null);
System.out.println("渠道列表: " + result);
```

---

### invChannelQueryByPage

> 分页查询渠道库存

**方法签名:**
```java
public List<QueryChannelResult> invChannelQueryByPage(QueryChannelReq queryChannelReq, PaginationModel paginationModel) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| queryChannelReq | QueryChannelReq | 是 | 查询对象 |
| paginationModel | PaginationModel | 是 | 分页对象，注:排序不起作用 |

**示例代码:**
```java
CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();

QueryChannelReq queryReq = new QueryChannelReq()
        .setVendorCode("17002437")
        .setWarehouseCode("WH001");

PaginationModel pagination = new PaginationModel()
        .setPageNum(1)
        .setPageSize(20);

List<QueryChannelResult> results = service.invChannelQueryByPage(queryReq, pagination);
System.out.println("查询到 " + results.size() + " 条记录");
```

---

### selectByInvCode

> 通过渠道库存编码获取渠道库存

**方法签名:**
```java
public QueryChannelResult selectByInvCode(String invCode) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| invCode | String | 是 | 渠道库存编码 |

**示例代码:**
```java
CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();

QueryChannelResult result = service.selectByInvCode("INV001");
System.out.println("库存信息: " + result);
```

---

### selectInvChannelSumByMultiRequests

> 库存汇总查询（多请求）

**方法签名:**
```java
public List<InvChannelSum> selectInvChannelSumByMultiRequests(List<InventoryQueryReq> inventoryQueryReqList) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| inventoryQueryReqList | List\<InventoryQueryReq\> | 是 | 查询对象集合 |

**示例代码:**
```java
CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();

List<InventoryQueryReq> reqList = new ArrayList<>();
reqList.add(new InventoryQueryReq().setVendorCode("17002437").setWarehouseCode("WH001"));
reqList.add(new InventoryQueryReq().setVendorCode("17002437").setWarehouseCode("WH002"));

List<InvChannelSum> results = service.selectInvChannelSumByMultiRequests(reqList);
```

---

## 模型类

### QueryChannelReq

> 渠道查询请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| vendorCode | String | 供应商编码 |
| warehouseCode | String | 仓库编码 |
| itemCode | String | 商品编码 |
| channel | Byte | 渠道 |

### PaginationModel

> 分页模型

| 字段名 | 类型 | 描述 |
|--------|------|------|
| pageNum | Integer | 页码 |
| pageSize | Integer | 每页大小 |

### QueryChannelResult

> 渠道查询结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| invCode | String | 库存编码 |
| vendorCode | String | 供应商编码 |
| warehouseCode | String | 仓库编码 |
| itemCode | String | 商品编码 |
| qty | Integer | 数量 |
| channel | Byte | 渠道 |

### InventoryQueryReq

> 库存查询请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| vendorCode | String | 供应商编码 |
| warehouseCode | String | 仓库编码 |
| itemCode | String | 商品编码 |

### InvChannelSum

> 库存汇总结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| vendorCode | String | 供应商编码 |
| warehouseCode | String | 仓库编码 |
| totalQty | Integer | 总数量 |
| availableQty | Integer | 可用数量 |

---

## 错误处理

```java
try {
    CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();
    QueryChannelResult result = service.selectByInvCode("INV001");
    System.out.println("库存: " + result);
} catch (IllegalArgumentException e) {
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    System.err.println("API调用失败: " + e.getMessage());
}
```
