# WopOuterOrderService API 文档

> 外部订单服务 - 提供订单状态查询功能
> 
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4101&serviceName=WopOuterOrderService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopOuterOrderService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopOuterOrderService service = PopServiceFactory.getWopOuterOrderService();
```

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `getOrderStatus` | 获取订单状态 | OrderStatusQueryRequest | String |
| `getOrderStatusByWopErpOrderSn` | 通过WOP ERP订单号获取状态 | String, String | String |
| `getOrderStatusByOrderNo` | 通过订单号获取状态 | String, String | String |
| `getOrderStatusByOuterOrderNo` | 通过外部订单号获取状态 | String, String | String |
| `getOrderStatusWithResponse` | 带响应的订单状态查询 | OrderStatusQueryRequest | ApiResponse\<String\> |
| `batchGetOrderStatus` | 批量获取订单状态 | OrderStatusQueryRequest[] | String[] |

---

## 方法详情

### getOrderStatus

> 获取订单状态

**方法签名:**
```java
public String getOrderStatus(OrderStatusQueryRequest request) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| request | OrderStatusQueryRequest | 是 | 查询请求参数 |

**示例代码:**
```java
WopOuterOrderService service = PopServiceFactory.getWopOuterOrderService();

OrderStatusQueryRequest request = new OrderStatusQueryRequest()
        .setCustomerCode("17002437")
        .setWopErpOrderSn("ERP202303210001");

String result = service.getOrderStatus(request);
```

---

### getOrderStatusByWopErpOrderSn

> 通过WOP ERP订单号获取订单状态

**方法签名:**
```java
public String getOrderStatusByWopErpOrderSn(String customerCode, String wopErpOrderSn) throws Exception
```

**示例代码:**
```java
WopOuterOrderService service = PopServiceFactory.getWopOuterOrderService();

String result = service.getOrderStatusByWopErpOrderSn("17002437", "ERP202303210001");
```

---

### batchGetOrderStatus

> 批量获取订单状态

**方法签名:**
```java
public String[] batchGetOrderStatus(OrderStatusQueryRequest[] requests) throws Exception
```

**示例代码:**
```java
WopOuterOrderService service = PopServiceFactory.getWopOuterOrderService();

OrderStatusQueryRequest[] requests = new OrderStatusQueryRequest[2];
requests[0] = new OrderStatusQueryRequest("17002437", "ERP001");
requests[1] = new OrderStatusQueryRequest("17002437", "ERP002");

String[] results = service.batchGetOrderStatus(requests);
```

---

## 模型类

### OrderStatusQueryRequest

> 订单状态查询请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| customerCode | String | 客户编码（必填） |
| wopErpOrderSn | String | WOP ERP订单号 |
| orderNo | String | 订单号 |
| outerOrderNo | String | 外部订单号 |

> 注：wopErpOrderSn、orderNo、outerOrderNo 三者必须提供其一
