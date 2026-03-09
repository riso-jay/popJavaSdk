# WopOuterTransferService API 文档

> WOP仓间调拨单服务 - 提供调拨单的创建、修改、查询、提交、取消等完整生命周期管理功能
>
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=5083&serviceName=WopOuterTransferService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopOuterTransferService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
```

## 方法列表

### 调拨单创建与修改

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `createTransfer` | 创建调拨单表头 | String, String, String, String, String, Byte, String | String |
| `editTransfer` | 修改调拨单表头 | String, String, String, Byte, String | OperationResult |
| `cleanTransferDetail` | 清空调拨单明细 | String, String | OperationResult |
| `submitTransfer` | 提交调拨单 | String, String | OperationResult |
| `cancelTransfer` | 取消调拨单 | String, String, String, String, String | OperationResult |

### 调拨单查询

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `searchTransferList` | 调拨单查询 | String, Integer, Integer | String |
| `getTransferDetailList` | 调拨单明细查询 | String, String, Integer, Integer | String |

---

## 方法详情

### createTransfer

> 创建调拨单表头接口

**方法签名:**
```java
public String createTransfer(String customerCode, String erpTransferSn, String transferType,
        String fromWarehouseCode, String toWarehouseCode, Byte payType, String toEmail) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |
| transferType | String | 否 | 调拨类型 |
| fromWarehouseCode | String | 否 | 调出仓库编码 |
| toWarehouseCode | String | 否 | 调入仓库编码 |
| payType | Byte | 否 | 付款方式 |
| toEmail | String | 否 | 收件邮箱 |

**示例代码:**
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();

String result = service.createTransfer(
    "17002437",           // 客户编码
    "TRANSFER-" + System.currentTimeMillis(),  // ERP调拨单号
    "NORMAL",            // 调拨类型
    "WH001",             // 调出仓库
    "WH002",             // 调入仓库
    (byte)1,             // 付款方式
    "notify@company.com" // 收件邮箱
);
System.out.println("调拨单创建: " + result);
```

---

### submitTransfer

> 提交调拨单接口

**方法签名:**
```java
public OperationResult submitTransfer(String customerCode, String erpTransferSn) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |

**示例代码:**
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
OperationResult result = service.submitTransfer("17002437", "TRANSFER-001");
```

---

### searchTransferList

> 调拨单查询接口（分页）

**方法签名:**
```java
public String searchTransferList(String customerCode, Integer pageNum, Integer pageSize) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页记录数 |

**示例代码:**
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
String result = service.searchTransferList("17002437", 1, 20);
```

---

### getTransferDetailList

> 调拨单明细查询接口（分页）

**方法签名:**
```java
public String getTransferDetailList(String customerCode, String erpTransferSn, 
        Integer pageNum, Integer pageSize) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |
| pageNum | Integer | 否 | 页码 |
| pageSize | Integer | 否 | 每页记录数 |

**示例代码:**
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
String result = service.getTransferDetailList("17002437", "TRANSFER-001", 1, 50);
```

---

## 模型类

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
    WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
    OperationResult result = service.submitTransfer("17002437", "TRANSFER-001");
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
