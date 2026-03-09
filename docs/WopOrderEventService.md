# WopOrderEventService API 文档

## 概述

WOP订单事件服务，提供订单事件查询、完成处理、累加处理次数、重置等功能。

- **服务名称**: `com.pjbest.wop.wm.service.WopOrderEventService`
- **服务类**: `com.vip.pop.service.WopOrderEventService`
- **API文档**: https://56.pjbest.com/app/wx/doc/openService?defCode=5664&serviceName=WopOrderEventService

## 方法列表

| 方法名 | 描述 | 必填参数 |
|--------|------|----------|
| `queryNeedHandleEvents` | 查询待处理订单事件列表 | batchSize |
| `queryTrackingIds` | 查询在库序列号 | orderSn, pageNo, pageSize |
| `finishEvent` | 完成事件处理 | id, eventStatus |
| `markTryEvent` | 累加事件处理次数 | id |
| `resetEvent` | 重置订单事件为未处理 | id |

---

## 方法详情

### 1. queryNeedHandleEvents - 查询待处理订单事件列表

**方法签名**:
```java
public String queryNeedHandleEvents(Integer batchSize) throws Exception
```

**功能描述**: 查询待处理的订单事件列表

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| batchSize | Integer | 是 | 查询批次条数大小 |

**返回值**: `String` - 待处理事件列表JSON

**异常情况**:
- `IllegalArgumentException` - 查询批次条数不能为空

**示例代码**:
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
String result = service.queryNeedHandleEvents(100);
```

---

### 2. queryTrackingIds - 查询在库序列号

**方法签名**:
```java
public String queryTrackingIds(String orderSn, String sizeSn, Integer pageNo, Integer pageSize) throws Exception
```

**功能描述**: 根据单据号查询在库序列号（追踪ID）

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| orderSn | String | 是 | 单据号 |
| sizeSn | String | 否 | 商品编码 |
| pageNo | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页记录数 |

**返回值**: `String` - 追踪ID列表JSON

**异常情况**:
- `IllegalArgumentException` - 单据号不能为空
- `IllegalArgumentException` - 页码不能为空
- `IllegalArgumentException` - 每页记录数不能为空

**示例代码**:
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
String result = service.queryTrackingIds(
    "ORDER202602250001", // 单据号
    "SKU001",            // 商品编码（可选）
    1,                   // 页码
    10                   // 每页记录数
);
```

---

### 3. finishEvent - 完成事件处理

**方法签名**:
```java
public String finishEvent(Long id, Integer eventStatus, String remark) throws Exception
```

**功能描述**: 标记订单事件处理完成

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| id | Long | 是 | 事件ID |
| eventStatus | Integer | 是 | 处理状态：1-成功，2-失败 |
| remark | String | 否 | 处理备注 |

**返回值**: `String` - 处理结果JSON

**异常情况**:
- `IllegalArgumentException` - 事件ID不能为空
- `IllegalArgumentException` - 处理状态不能为空

**示例代码**:
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
String result = service.finishEvent(
    12345L, // 事件ID
    1,      // 处理状态：1-成功
    "处理完成" // 备注
);
```

---

### 4. markTryEvent - 累加事件处理次数

**方法签名**:
```java
public String markTryEvent(Long id, String remark) throws Exception
```

**功能描述**: 累加订单事件的处理尝试次数

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| id | Long | 是 | 事件ID |
| remark | String | 否 | 处理备注 |

**返回值**: `String` - 处理结果JSON

**异常情况**:
- `IllegalArgumentException` - 事件ID不能为空

**示例代码**:
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
String result = service.markTryEvent(12345L, "第N次尝试处理");
```

---

### 5. resetEvent - 重置订单事件为未处理

**方法签名**:
```java
public String resetEvent(Long id, String remark) throws Exception
```

**功能描述**: 将订单事件重置为未处理状态

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| id | Long | 是 | 事件ID |
| remark | String | 否 | 处理备注 |

**返回值**: `String` - 处理结果JSON

**异常情况**:
- `IllegalArgumentException` - 事件ID不能为空

**示例代码**:
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
String result = service.resetEvent(12345L, "重置以便重新处理");
```

---

## 事件状态说明

| 状态值 | 描述 |
|--------|------|
| 1 | 成功 |
| 2 | 失败 |

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
    String result = service.finishEvent(12345L, 1, "处理完成");
} catch (IllegalArgumentException e) {
    // 处理参数校验异常
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // 处理API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
