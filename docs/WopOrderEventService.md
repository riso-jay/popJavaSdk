# WopOrderEventService API 文档

> WOP订单事件服务 - 提供订单事件查询、完成处理、累加处理次数、重置等功能
>
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=5664&serviceName=WopOrderEventService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopOrderEventService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
```

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `queryNeedHandleEvents` | 查询待处理订单事件列表 | Integer | String |
| `finishEvent` | 完成事件处理 | Long, Integer, String | String |
| `markTryEvent` | 累加事件处理次数 | Long, String | String |
| `resetEvent` | 重置订单事件为未处理 | Long, String | String |
| `queryTrackingIds` | 查询在库序列号 | String, String, Integer, Integer | String |

---

## 方法详情

### queryNeedHandleEvents

> 查询待处理订单事件列表接口

**方法签名:**
```java
public String queryNeedHandleEvents(Integer batchSize) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| batchSize | Integer | 是 | 查询批次条数大小 |

**示例代码:**
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();

// 查询待处理的库存异动事件（每次最多100条）
String eventsJson = service.queryNeedHandleEvents(100);
System.out.println("待处理事件: " + eventsJson);
```

---

### finishEvent

> 完成事件处理接口

**方法签名:**
```java
public String finishEvent(Long id, Integer eventStatus, String remark) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| id | Long | 是 | 事件ID |
| eventStatus | Integer | 是 | 处理状态：1-成功，2-失败 |
| remark | String | 否 | 处理备注 |

**示例代码:**
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();

// 处理成功，标记完成
String result = service.finishEvent(
    12345L, // 事件ID
    1,      // 处理状态：1-成功
    "同步成功" // 备注
);
```

---

### markTryEvent

> 累加事件处理次数接口

**方法签名:**
```java
public String markTryEvent(Long id, String remark) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| id | Long | 是 | 事件ID |
| remark | String | 否 | 处理备注 |

**示例代码:**
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();

// 处理失败，累加重试次数
String result = service.markTryEvent(
    12345L, 
    "同步失败，等待重试"
);
```

---

### resetEvent

> 重置订单事件为未处理接口

**方法签名:**
```java
public String resetEvent(Long id, String remark) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| id | Long | 是 | 事件ID |
| remark | String | 否 | 处理备注 |

**示例代码:**
```java
WopOrderEventService service = PopServiceFactory.getWopOrderEventService();

// 异常情况，重置事件
String result = service.resetEvent(
    12345L, 
    "异常重置，以便重新处理"
);
```

---

## 错误处理

```java
try {
    WopOrderEventService service = PopServiceFactory.getWopOrderEventService();
    String result = service.finishEvent(12345L, 1, "处理完成");
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
