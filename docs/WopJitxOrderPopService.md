# WopJitxOrderPopService API 文档

## 概述

云仓JITX订单服务，提供JITX订单查询和明细查询功能。

- **服务名称**: `com.vip.wop.app.jit.service.WopJitxOrderPopService`
- **服务类**: `com.vip.pop.service.WopJitxOrderPopService`

## 方法列表

| 方法名 | 描述 | 必填参数 |
|--------|------|----------|
| `healthCheck` | 健康检查 | 无 |
| `queryJitxOrder` | 云仓JITX订单查询 | request |
| `queryJitxOrderDetail` | 云仓JITX订单明细查询 | crmCustCode, platformOrderSn |

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
WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();
String result = service.healthCheck();
```

---

### 2. queryJitxOrder - 云仓JITX订单查询

**方法签名**:
```java
public JitxOrderQueryResponse queryJitxOrder(JitxOrderQueryRequest request, Integer pageNum, Integer pageSize) throws Exception
```

**功能描述**: 查询云仓JITX订单列表

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| request | JitxOrderQueryRequest | 是 | 查询条件对象 |
| pageNum | Integer | 否 | 页码，默认为1 |
| pageSize | Integer | 否 | 页大小，默认为10，最大50 |

**返回值**: `JitxOrderQueryResponse` - 查询响应对象

**异常情况**:
- `IllegalArgumentException` - 查询条件不能为空

**示例代码**:
```java
WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();

JitxOrderQueryRequest request = new JitxOrderQueryRequest();
// 设置查询条件

JitxOrderQueryResponse response = service.queryJitxOrder(request, 1, 10);
```

---

### 3. queryJitxOrderDetail - 云仓JITX订单明细查询

**方法签名**:
```java
public JitxOrderDetailQueryResponse queryJitxOrderDetail(String crmCustCode, String platformOrderSn) throws Exception
```

**功能描述**: 查询云仓JITX订单明细信息

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| crmCustCode | String | 是 | 供应商编码 |
| platformOrderSn | String | 是 | 唯品订单号 |

**返回值**: `JitxOrderDetailQueryResponse` - 明细查询响应对象

**异常情况**:
- `IllegalArgumentException` - 供应商编码不能为空
- `IllegalArgumentException` - 唯品订单号不能为空

**示例代码**:
```java
WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();

JitxOrderDetailQueryResponse response = service.queryJitxOrderDetail(
    "VENDOR001",       // 供应商编码
    "JITX202602250001" // 唯品订单号
);
```

---

## 模型类

### JitxOrderQueryRequest - JITX订单查询请求

JITX订单查询条件对象，支持链式调用设置参数。

### JitxOrderQueryResponse - JITX订单查询响应

JITX订单查询返回结果对象。

### JitxOrderDetailQueryResponse - JITX订单明细查询响应

JITX订单明细查询返回结果对象。

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
    JitxOrderQueryResponse response = service.queryJitxOrder(request, 1, 10);
} catch (IllegalArgumentException e) {
    // 处理参数校验异常
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // 处理API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
