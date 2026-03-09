# WopJitxOrderPopService API 文档

> 云仓JITX订单服务 - 提供JITX订单查询和明细查询功能
>
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=5161&serviceName=WopJitxOrderPopService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.vip.wop.app.jit.service.WopJitxOrderPopService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();
```

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `healthCheck` | 健康检查 | 无 | String |
| `queryJitxOrder` | 云仓JITX订单查询 | JitxOrderQueryRequest, Integer, Integer | JitxOrderQueryResponse |
| `queryJitxOrderDetail` | 云仓JITX订单明细查询 | String, String | JitxOrderDetailQueryResponse |

---

## 方法详情

### queryJitxOrder

> 云仓JITX订单查询接口

**方法签名:**
```java
public JitxOrderQueryResponse queryJitxOrder(JitxOrderQueryRequest request, Integer pageNum, Integer pageSize) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| request | JitxOrderQueryRequest | 是 | 查询条件对象 |
| pageNum | Integer | 否 | 页码，默认为1 |
| pageSize | Integer | 否 | 页大小，默认为10，最大50 |

**示例代码:**
```java
WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();

JitxOrderQueryRequest request = new JitxOrderQueryRequest();
request.setCrmCustCode("17002437");
request.setWarehouseCode("WH001");

JitxOrderQueryResponse response = service.queryJitxOrder(request, 1, 10);
System.out.println("查询到 " + response.getTotalCount() + " 条订单");
```

---

### queryJitxOrderDetail

> 云仓JITX订单明细查询接口

**方法签名:**
```java
public JitxOrderDetailQueryResponse queryJitxOrderDetail(String crmCustCode, String platformOrderSn) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| crmCustCode | String | 是 | 供应商编码 |
| platformOrderSn | String | 是 | 唯品订单号 |

**示例代码:**
```java
WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();

JitxOrderDetailQueryResponse response = service.queryJitxOrderDetail(
    "17002437",        // 供应商编码
    "JITX202603010001" // 唯品订单号
);
System.out.println("订单明细: " + response);
```

---

### healthCheck

> 健康检查接口

**方法签名:**
```java
public String healthCheck() throws Exception
```

**示例代码:**
```java
WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();
String result = service.healthCheck();
System.out.println("健康检查结果: " + result);
```

---

## 模型类

### JitxOrderQueryRequest

> JITX订单查询请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| crmCustCode | String | 供应商编码 |
| warehouseCode | String | 仓库编码 |
| platformOrderSn | String | 唯品订单号 |
| orderStatus | String | 订单状态 |

### JitxOrderQueryResponse

> JITX订单查询响应

| 字段名 | 类型 | 描述 |
|--------|------|------|
| orderList | List\<JitxOrderInfo\> | 订单列表 |
| totalCount | Integer | 总数 |

### JitxOrderDetailQueryResponse

> JITX订单明细查询响应

| 字段名 | 类型 | 描述 |
|--------|------|------|
| detailList | List\<JitxOrderDetailInfo\> | 明细列表 |
| totalCount | Integer | 总数 |

---

## 错误处理

```java
try {
    WopJitxOrderPopService service = PopServiceFactory.getWopJitxOrderPopService();
    JitxOrderQueryResponse response = service.queryJitxOrder(request, 1, 10);
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
