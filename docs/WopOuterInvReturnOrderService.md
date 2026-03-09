# WopOuterInvReturnOrderService API 文档

> WOP退供单服务 - 提供退供单的创建、修改、查询、取消、提交等完整生命周期管理功能
>
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4116&serviceName=WopOuterInvReturnOrderService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopOuterInvReturnOrderService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
```

## 方法列表

### 退供单创建与修改

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `createInvReturnOrder` | 创建退供单表头 | CreateInvReturnOrderReq | OperationResult |
| `editInvReturnOrder` | 修改退供单表头 | CreateInvReturnOrderReq | OperationResult |
| `cleanInvReturnDetail` | 清空退供单明细 | String, String | OperationResult |
| `submitInvReturnOrder` | 提交退供单 | String, String | OperationResult |
| `cancelInvReturnOrder` | 取消退供单 | String, String | OperationResult |

### 退供单查询

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `queryInvReturnOrder` | 查询退供单 | String, String, String | OperationResult |
| `queryInvReturnOrderDetail` | 退供单明细查询 | String, String, Integer, Integer | OperationResult |
| `searchInvReturnOrderList` | 退供单分页查询 | String, Integer, Integer | OperationResult |

---

## 方法详情

### createInvReturnOrder

> 创建退供单表头接口

**方法签名:**
```java
public OperationResult createInvReturnOrder(CreateInvReturnOrderReq request) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| request | CreateInvReturnOrderReq | 是 | 创建退供单请求对象 |

**示例代码:**
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();

CreateInvReturnOrderReq request = new CreateInvReturnOrderReq();
request.setCustomerCode("17002437");
request.setClientReturnSn("RETURN-" + System.currentTimeMillis());

OperationResult result = service.createInvReturnOrder(request);
```

---

### submitInvReturnOrder

> 提交退供单接口

**方法签名:**
```java
public OperationResult submitInvReturnOrder(String customerCode, String clientReturnSn) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 是 | 客户退供单号 |

**示例代码:**
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
OperationResult result = service.submitInvReturnOrder("17002437", "RETURN-001");
```

---

### queryInvReturnOrder

> 查询退供单接口

**方法签名:**
```java
public OperationResult queryInvReturnOrder(String customerCode, String clientReturnSn, String returnSn) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 条件必填 | 客户退供单号（与returnSn二选一） |
| returnSn | String | 条件必填 | 系统退供单号（与clientReturnSn二选一） |

**示例代码:**
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();

// 通过客户退供单号查询
OperationResult result = service.queryInvReturnOrder("17002437", "RETURN-001", null);
// 或通过系统退供单号查询
OperationResult result2 = service.queryInvReturnOrder("17002437", null, "SYS_RETURN_001");
```

---

## 模型类

### CreateInvReturnOrderReq

> 创建退供单请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| customerCode | String | 客户编码 |
| clientReturnSn | String | 客户退供单号 |

### OperationResult

> 操作返回结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |
| code | String | 返回码 |

---

## 错误处理

```java
try {
    WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
    OperationResult result = service.createInvReturnOrder(request);
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
