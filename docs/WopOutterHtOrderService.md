# WopOutterHtOrderService API 文档

> WOP海淘订单服务 - 提供海淘订单的创建、查询、查询状态、重推、取消等功能
>
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=5258&serviceName=WopOutterHtOrderService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopOutterHtOrderService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();
```

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `healthCheck` | 健康检查 | 无 | String |
| `createHtOrder` | 创建海淘订单 | CreateHtOrderReq | CreateHtOrderRsp |
| `queryHtOrder` | 查询海淘订单 | QueryHtOrderReq | QueryHtOrderRsp |
| `queryStatus` | 查询海淘订单状态 | QueryStatusReq | QueryStatusRsp |
| `reSend` | 重推海淘订单 | ReSendHtOrderReq | ReSendHtOrderRsp |
| `cancel` | 取消海淘订单 | CancelHtOrderReq | CancelHtOrderRsp |

---

## 方法详情

### createHtOrder

> 创建海淘订单接口

**方法签名:**
```java
public CreateHtOrderRsp createHtOrder(CreateHtOrderReq createHtOrderReq) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| createHtOrderReq | CreateHtOrderReq | 是 | 创建海淘订单请求对象 |

**示例代码:**
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

CreateHtOrderReq request = new CreateHtOrderReq();
request.setCustomerCode("17002437");
request.setErpOrderSn("HT" + System.currentTimeMillis());

CreateHtOrderRsp response = service.createHtOrder(request);
```

---

### queryHtOrder

> 查询海淘订单接口

**方法签名:**
```java
public QueryHtOrderRsp queryHtOrder(QueryHtOrderReq queryReq) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| queryReq | QueryHtOrderReq | 是 | 查询请求对象 |

**示例代码:**
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

QueryHtOrderReq queryReq = new QueryHtOrderReq();
queryReq.setCustomerCode("17002437");
queryReq.setErpOrderSn("HT001");

QueryHtOrderRsp response = service.queryHtOrder(queryReq);
```

---

### queryStatus

> 查询海淘订单状态接口

**方法签名:**
```java
public QueryStatusRsp queryStatus(QueryStatusReq queryStatusReq) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| queryStatusReq | QueryStatusReq | 是 | 查询状态请求对象 |

**示例代码:**
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

QueryStatusReq statusReq = new QueryStatusReq();
statusReq.setCustomerCode("17002437");
statusReq.setErpOrderSn("HT001");

QueryStatusRsp response = service.queryStatus(statusReq);
```

---

### cancel

> 取消海淘订单接口

**方法签名:**
```java
public CancelHtOrderRsp cancel(CancelHtOrderReq cancelReq) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| cancelReq | CancelHtOrderReq | 是 | 取消请求对象 |

**示例代码:**
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

CancelHtOrderReq cancelReq = new CancelHtOrderReq();
cancelReq.setCustomerCode("17002437");
cancelReq.setErpOrderSn("HT001");

CancelHtOrderRsp response = service.cancel(cancelReq);
```

---

## 错误处理

```java
try {
    WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();
    CreateHtOrderRsp response = service.createHtOrder(request);
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
