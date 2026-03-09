# WopBigOrderService API 文档

> WOP大订单服务 - 提供大订单的创建、导入明细、提交、取消、查询等功能
> 
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4883&serviceName=WopBigOrderService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopBigOrderService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopBigOrderService service = PopServiceFactory.getWopBigOrderService();
```

## 方法列表

### 大订单创建

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `createHeader` | 创建大订单单头 | CreateBigOrderHeaderRequest | BigOrderResponse |
| `importDetails` | 导入大订单明细 | ImportBigOrderDetailsRequest | BigOrderResponse |
| `cleanDetails` | 清空大订单明细 | BigOrderRequest | BigOrderResponse |

### 大订单状态操作

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `submit` | 提交大订单 | BigOrderRequest | BigOrderResponse |
| `cancel` | 取消大订单 | BigOrderRequest | BigOrderResponse |

### 大订单查询

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `getHeader` | 获取订单头 | BigOrderRequest | BigOrderResponse |
| `getDetailList` | 获取大订单明细 | String, String, Integer, Integer | BigOrderResponse |
| `getDeliveryTrace` | 获取大订单物流轨迹 | BigOrderRequest | BigOrderResponse |

---

## 方法详情

### createHeader

> 创建大订单单头接口

**方法签名:**
```java
public BigOrderResponse createHeader(CreateBigOrderHeaderRequest request) throws Exception
```

**示例代码:**
```java
WopBigOrderService service = PopServiceFactory.getWopBigOrderService();

CreateBigOrderHeaderRequest request = new CreateBigOrderHeaderRequest()
        .setCustomerCode("17002437")
        .setErpOrderSn("BIGORDER001")
        .setWarehouseCode("WH001")
        .setOrderType((byte) 1);

BigOrderResponse response = service.createHeader(request);
```

---

### importDetails

> 导入大订单明细接口（支持多批次导入）

**方法签名:**
```java
public BigOrderResponse importDetails(ImportBigOrderDetailsRequest request) throws Exception
```

**示例代码:**
```java
WopBigOrderService service = PopServiceFactory.getWopBigOrderService();

List<BigOrderDetailItem> items = new ArrayList<>();
items.add(new BigOrderDetailItem().setItemCode("SKU001").setQty(100));
items.add(new BigOrderDetailItem().setItemCode("SKU002").setQty(200));

ImportBigOrderDetailsRequest request = new ImportBigOrderDetailsRequest()
        .setCustomerCode("17002437")
        .setErpOrderSn("BIGORDER001")
        .setDetailItems(items);

BigOrderResponse response = service.importDetails(request);
```

---

### getDetailList

> 获取大订单明细接口

**方法签名:**
```java
public BigOrderResponse getDetailList(String customerCode, String erpOrderSn, Integer pageNum, Integer pageSize) throws Exception
```

**示例代码:**
```java
WopBigOrderService service = PopServiceFactory.getWopBigOrderService();

BigOrderResponse response = service.getDetailList("17002437", "BIGORDER001", 1, 20);
```

---

## 模型类

### CreateBigOrderHeaderRequest

> 创建大订单请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| customerCode | String | 客户编码 |
| erpOrderSn | String | ERP订单号 |
| warehouseCode | String | 仓库编码 |
| orderType | Byte | 订单类型 |

### BigOrderDetailItem

> 大订单明细项

| 字段名 | 类型 | 描述 |
|--------|------|------|
| itemCode | String | 商品编码 |
| itemName | String | 商品名称 |
| qty | Integer | 数量 |

### BigOrderResponse

> 大订单响应

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |
| data | Object | 响应数据 |
