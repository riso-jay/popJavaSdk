# WopJitOrderPopService API 文档

## 概述

云仓JIT订单服务，提供JIT订单查询和明细查询功能。

- **服务名称**: `com.vip.wop.app.jit.service.WopJitOrderPopService`
- **服务类**: `com.vip.pop.service.WopJitOrderPopService`

## 方法列表

| 方法名 | 描述 | 必填参数 |
|--------|------|----------|
| `healthCheck` | 健康检查 | 无 |
| `queryJitOrder` | 云仓JIT订单查询 | request |
| `queryJitOrderDetail` | 云仓JIT订单明细查询 | crmCustCode, platformOrderSn |

---

## 方法详情

### 1. healthCheck - 健康检查

**方法签名**:
```java
public String healthCheck() throws Exception
```

**功能描述**: 检查服务健康状态

**返回值**: `String` - 健康检查结果JSON

**示例代码**:
```java
WopJitOrderPopService service = PopServiceFactory.getWopJitOrderPopService();
String result = service.healthCheck();
```

---

### 2. queryJitOrder - 云仓JIT订单查询

**方法签名**:
```java
public JitOrderQueryResponse queryJitOrder(JitOrderQueryRequest request, Integer pageNum, Integer pageSize) throws Exception
```

**功能描述**: 查询云仓JIT订单列表

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| request | JitOrderQueryRequest | 是 | 查询条件对象 |
| pageNum | Integer | 否 | 页码，默认为1 |
| pageSize | Integer | 否 | 页大小，默认为10，最大50 |

**返回值**: `JitOrderQueryResponse` - 查询响应对象

**异常情况**:
- `IllegalArgumentException` - 查询条件不能为空

**示例代码**:
```java
WopJitOrderPopService service = PopServiceFactory.getWopJitOrderPopService();

JitOrderQueryRequest request = new JitOrderQueryRequest();
// 设置查询条件

JitOrderQueryResponse response = service.queryJitOrder(request, 1, 10);
```

---

### 3. queryJitOrderDetail - 云仓JIT订单明细查询

**方法签名**:
```java
public JitOrderDetailQueryResponse queryJitOrderDetail(String crmCustCode, String platformOrderSn, 
        Integer pageNum, Integer pageSize) throws Exception
```

**功能描述**: 查询云仓JIT订单明细信息

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| crmCustCode | String | 是 | 供应商编码 |
| platformOrderSn | String | 是 | JIT送货单号 |
| pageNum | Integer | 否 | 页码，默认为1 |
| pageSize | Integer | 否 | 页大小，默认为10，最大50 |

**返回值**: `JitOrderDetailQueryResponse` - 明细查询响应对象

**异常情况**:
- `IllegalArgumentException` - 供应商编码不能为空
- `IllegalArgumentException` - JIT送货单号不能为空

**示例代码**:
```java
WopJitOrderPopService service = PopServiceFactory.getWopJitOrderPopService();

JitOrderDetailQueryResponse response = service.queryJitOrderDetail(
    "VENDOR001",      // 供应商编码
    "JIT202602250001", // JIT送货单号
    1,                 // 页码
    10                 // 页大小
);
```

---

## 模型类

### JitOrderQueryRequest - JIT订单查询请求

JIT订单查询条件对象，支持链式调用设置参数。

### JitOrderQueryResponse - JIT订单查询响应

JIT订单查询返回结果对象。

### JitOrderDetailQueryResponse - JIT订单明细查询响应

JIT订单明细查询返回结果对象。

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
    JitOrderQueryResponse response = service.queryJitOrder(request, 1, 10);
} catch (IllegalArgumentException e) {
    // 处理参数校验异常
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // 处理API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
