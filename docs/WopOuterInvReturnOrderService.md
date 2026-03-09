# WopOuterInvReturnOrderService API 文档

## 概述

WOP退供单服务，提供退供单的创建、修改、查询、取消、提交等完整生命周期管理功能。

- **服务名称**: `com.pjbest.wop.wm.service.WopOuterInvReturnOrderService`
- **服务类**: `com.vip.pop.service.WopOuterInvReturnOrderService`
- **API文档**: https://56.pjbest.com/app/wx/doc/openService?defCode=4116&serviceName=WopOuterInvReturnOrderService

## 方法列表

| 方法名 | 描述 | 必填参数 |
|--------|------|----------|
| `createInvReturnOrder` | 创建退供单表头 | request |
| `editInvReturnOrder` | 修改退供单表头 | request |
| `cleanInvReturnDetail` | 清空退供单明细 | customerCode, clientReturnSn |
| `submitInvReturnOrder` | 提交退供单 | customerCode, clientReturnSn |
| `cancelInvReturnOrder` | 取消退供单 | customerCode, clientReturnSn |
| `queryInvReturnOrder` | 查询退供单 | customerCode, clientReturnSn/returnSn |
| `queryInvReturnOrderDetail` | 退供单明细查询 | customerCode, pageNum, pageSize |
| `searchInvReturnOrderList` | 退供单分页查询 | customerCode, pageNum, pageSize |

---

## 方法详情

### 1. createInvReturnOrder - 创建退供单表头

**方法签名**:
```java
public OperationResult createInvReturnOrder(CreateInvReturnOrderReq request) throws Exception
```

**功能描述**: 创建退供单表头信息

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| request | CreateInvReturnOrderReq | 是 | 创建退供单请求对象 |

**CreateInvReturnOrderReq 主要字段**:

| 字段 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 是 | 客户退供单号 |

**返回值**: `OperationResult` - 操作结果

**异常情况**:
- `IllegalArgumentException` - 请求参数不能为空
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - 客户退供单号不能为空

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();

CreateInvReturnOrderReq request = new CreateInvReturnOrderReq()
    .setCustomerCode("CUST001")
    .setClientReturnSn("RETURN202602250001");

OperationResult result = service.createInvReturnOrder(request);
```

---

### 2. editInvReturnOrder - 修改退供单表头

**方法签名**:
```java
public OperationResult editInvReturnOrder(CreateInvReturnOrderReq request) throws Exception
```

**功能描述**: 修改退供单表头信息

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| request | CreateInvReturnOrderReq | 是 | 修改退供单请求对象 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();

CreateInvReturnOrderReq request = new CreateInvReturnOrderReq()
    .setCustomerCode("CUST001")
    .setClientReturnSn("RETURN202602250001");

OperationResult result = service.editInvReturnOrder(request);
```

---

### 3. cleanInvReturnDetail - 清空退供单明细

**方法签名**:
```java
public OperationResult cleanInvReturnDetail(String customerCode, String clientReturnSn) throws Exception
```

**功能描述**: 清空指定退供单的所有明细

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 是 | 客户退供单号 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
OperationResult result = service.cleanInvReturnDetail("CUST001", "RETURN202602250001");
```

---

### 4. submitInvReturnOrder - 提交退供单

**方法签名**:
```java
public OperationResult submitInvReturnOrder(String customerCode, String clientReturnSn) throws Exception
```

**功能描述**: 提交退供单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 是 | 客户退供单号 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
OperationResult result = service.submitInvReturnOrder("CUST001", "RETURN202602250001");
```

---

### 5. cancelInvReturnOrder - 取消退供单

**方法签名**:
```java
public OperationResult cancelInvReturnOrder(String customerCode, String clientReturnSn) throws Exception
```

**功能描述**: 取消退供单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 是 | 客户退供单号 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
OperationResult result = service.cancelInvReturnOrder("CUST001", "RETURN202602250001");
```

---

### 6. queryInvReturnOrder - 查询退供单

**方法签名**:
```java
public OperationResult queryInvReturnOrder(String customerCode, String clientReturnSn, String returnSn) throws Exception
```

**功能描述**: 根据单号查询退供单详情

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 条件必填 | 客户退供单号（与returnSn二选一） |
| returnSn | String | 条件必填 | 系统退供单号（与clientReturnSn二选一） |

**返回值**: `OperationResult` - 查询结果

**异常情况**:
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - 客户退供单号和系统退供单号不能同时为空

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
// 通过客户退供单号查询
OperationResult result = service.queryInvReturnOrder("CUST001", "RETURN202602250001", null);
// 或通过系统退供单号查询
OperationResult result2 = service.queryInvReturnOrder("CUST001", null, "SYS_RETURN001");
```

---

### 7. queryInvReturnOrderDetail - 退供单明细查询

**方法签名**:
```java
public OperationResult queryInvReturnOrderDetail(String customerCode, String clientReturnSn, 
        Integer pageNum, Integer pageSize) throws Exception
```

**功能描述**: 分页查询退供单明细

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| clientReturnSn | String | 否 | 客户退供单号 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页记录数 |

**返回值**: `OperationResult` - 查询结果

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
OperationResult result = service.queryInvReturnOrderDetail("CUST001", "RETURN202602250001", 1, 10);
```

---

### 8. searchInvReturnOrderList - 退供单分页查询

**方法签名**:
```java
public OperationResult searchInvReturnOrderList(String customerCode, Integer pageNum, Integer pageSize) throws Exception
```

**功能描述**: 分页查询退供单列表

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页记录数 |

**返回值**: `OperationResult` - 查询结果

**示例代码**:
```java
WopOuterInvReturnOrderService service = PopServiceFactory.getWopOuterInvReturnOrderService();
OperationResult result = service.searchInvReturnOrderList("CUST001", 1, 10);
```

---

## 便捷方法（带响应包装）

服务提供了带响应包装的便捷方法：

- `createInvReturnOrderWithResponse` - 带响应解析的创建退供单
- `submitInvReturnOrderWithResponse` - 带响应解析的提交退供单
- `cancelInvReturnOrderWithResponse` - 带响应解析的取消退供单

---

## 模型类

### CreateInvReturnOrderReq - 创建退供单请求

| 字段 | 类型 | 描述 |
|------|------|------|
| customerCode | String | 客户编码 |
| clientReturnSn | String | 客户退供单号 |

### OperationResult - 操作结果

通用操作结果对象。

---

## 错误处理

所有方法都可能抛出以下异常：

| 异常类型 | 描述 |
|----------|------|
| `IllegalArgumentException` | 参数校验失败 |
| `Exception` | API调用异常 |

建议使用 try-catch 进行异常处理：

```java
try {
    OperationResult result = service.createInvReturnOrder(request);
} catch (IllegalArgumentException e) {
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    System.err.println("API调用失败: " + e.getMessage());
}
```
