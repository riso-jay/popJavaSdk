# WopOutterHtOrderService API 文档

## 概述

WOP海淘订单服务，提供海淘订单的创建、查询、查询状态、重推、取消等功能。

- **服务名称**: `com.pjbest.wop.wm.service.WopOutterHtOrderService`
- **服务类**: `com.vip.pop.service.WopOutterHtOrderService`

## 方法列表

| 方法名 | 描述 | 必填参数 |
|--------|------|----------|
| `healthCheck` | 健康检查 | 无 |
| `createHtOrder` | 创建海淘订单 | createHtOrderReq |
| `queryHtOrder` | 查询海淘订单 | queryReq |
| `queryStatus` | 查询海淘订单状态 | queryStatusReq |
| `reSend` | 重推海淘订单 | reSendReq |
| `cancel` | 取消海淘订单 | cancelReq |

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
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();
String result = service.healthCheck();
```

---

### 2. createHtOrder - 创建海淘订单

**方法签名**:
```java
public CreateHtOrderRsp createHtOrder(CreateHtOrderReq createHtOrderReq) throws Exception
```

**功能描述**: 创建海淘订单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| createHtOrderReq | CreateHtOrderReq | 是 | 创建海淘订单请求对象 |

**返回值**: `CreateHtOrderRsp` - 创建响应

**异常情况**:
- `IllegalArgumentException` - 创建海淘订单请求不能为空

**示例代码**:
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

CreateHtOrderReq request = new CreateHtOrderReq();
// 设置海淘订单信息

CreateHtOrderRsp response = service.createHtOrder(request);
```

---

### 3. queryHtOrder - 查询海淘订单

**方法签名**:
```java
public QueryHtOrderRsp queryHtOrder(QueryHtOrderReq queryReq) throws Exception
```

**功能描述**: 查询海淘订单详情

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| queryReq | QueryHtOrderReq | 是 | 查询请求对象 |

**返回值**: `QueryHtOrderRsp` - 查询响应

**异常情况**:
- `IllegalArgumentException` - 查询请求不能为空

**示例代码**:
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

QueryHtOrderReq queryReq = new QueryHtOrderReq();
// 设置查询条件

QueryHtOrderRsp response = service.queryHtOrder(queryReq);
```

---

### 4. queryStatus - 查询海淘订单状态

**方法签名**:
```java
public QueryStatusRsp queryStatus(QueryStatusReq queryStatusReq) throws Exception
```

**功能描述**: 查询海淘订单状态

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| queryStatusReq | QueryStatusReq | 是 | 查询状态请求对象 |

**返回值**: `QueryStatusRsp` - 查询状态响应

**异常情况**:
- `IllegalArgumentException` - 查询状态请求不能为空

**示例代码**:
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

QueryStatusReq statusReq = new QueryStatusReq();
// 设置查询条件

QueryStatusRsp response = service.queryStatus(statusReq);
```

---

### 5. reSend - 重推海淘订单

**方法签名**:
```java
public ReSendHtOrderRsp reSend(ReSendHtOrderReq reSendReq) throws Exception
```

**功能描述**: 重推海淘订单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| reSendReq | ReSendHtOrderReq | 是 | 重推请求对象 |

**返回值**: `ReSendHtOrderRsp` - 重推响应

**异常情况**:
- `IllegalArgumentException` - 重推请求不能为空

**示例代码**:
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

ReSendHtOrderReq reSendReq = new ReSendHtOrderReq();
// 设置重推参数

ReSendHtOrderRsp response = service.reSend(reSendReq);
```

---

### 6. cancel - 取消海淘订单

**方法签名**:
```java
public CancelHtOrderRsp cancel(CancelHtOrderReq cancelReq) throws Exception
```

**功能描述**: 取消海淘订单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| cancelReq | CancelHtOrderReq | 是 | 取消请求对象 |

**返回值**: `CancelHtOrderRsp` - 取消响应

**异常情况**:
- `IllegalArgumentException` - 取消请求不能为空

**示例代码**:
```java
WopOutterHtOrderService service = PopServiceFactory.getWopOutterHtOrderService();

CancelHtOrderReq cancelReq = new CancelHtOrderReq();
// 设置取消参数

CancelHtOrderRsp response = service.cancel(cancelReq);
```

---

## 模型类

### CreateHtOrderReq - 创建海淘订单请求

创建海淘订单的请求对象，支持链式调用设置参数。

### CreateHtOrderRsp - 创建海淘订单响应

创建海淘订单的响应对象。

### QueryHtOrderReq - 查询海淘订单请求

查询海淘订单的请求对象。

### QueryHtOrderRsp - 查询海淘订单响应

查询海淘订单的响应对象。

### QueryStatusReq - 查询状态请求

查询海淘订单状态的请求对象。

### QueryStatusRsp - 查询状态响应

查询海淘订单状态的响应对象。

### ReSendHtOrderReq - 重推请求

重推海淘订单的请求对象。

### ReSendHtOrderRsp - 重推响应

重推海淘订单的响应对象。

### CancelHtOrderReq - 取消请求

取消海淘订单的请求对象。

### CancelHtOrderRsp - 取消响应

取消海淘订单的响应对象。

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
    CreateHtOrderRsp response = service.createHtOrder(request);
} catch (IllegalArgumentException e) {
    // 处理参数校验异常
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // 处理API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
