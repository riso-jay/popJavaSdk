# WopOuterTransferService API 文档

## 概述

WOP仓间调拨单服务，提供调拨单的创建、修改、查询、提交、取消等完整生命周期管理功能。

- **服务名称**: `com.pjbest.wop.wm.service.WopOuterTransferService`
- **服务类**: `com.vip.pop.service.WopOuterTransferService`
- **API文档**: https://56.pjbest.com/app/wx/doc/openService?defCode=5083&serviceName=WopOuterTransferService

## 方法列表

| 方法名 | 描述 | 必填参数 |
|--------|------|----------|
| `createTransfer` | 创建调拨单表头 | customerCode, erpTransferSn |
| `editTransfer` | 修改调拨单表头 | customerCode, erpTransferSn |
| `cleanTransferDetail` | 清空调拨单明细 | customerCode, erpTransferSn |
| `submitTransfer` | 提交调拨单 | customerCode, erpTransferSn |
| `cancelTransfer` | 取消调拨单 | customerCode, erpTransferSn |
| `searchTransferList` | 调拨单查询 | customerCode, pageNum, pageSize |
| `getTransferDetailList` | 调拨单明细查询 | customerCode, erpTransferSn |

---

## 方法详情

### 1. createTransfer - 创建调拨单表头

**方法签名**:
```java
public String createTransfer(String customerCode, String erpTransferSn, String transferType,
        String fromWarehouseCode, String toWarehouseCode, Byte payType, String toEmail) throws Exception
```

**功能描述**: 创建调拨单表头信息

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |
| transferType | String | 否 | 调拨类型 |
| fromWarehouseCode | String | 否 | 调出仓库编码 |
| toWarehouseCode | String | 否 | 调入仓库编码 |
| payType | Byte | 否 | 付款方式 |
| toEmail | String | 否 | 收件邮箱 |

**返回值**: `String` - 创建结果JSON

**异常情况**:
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - ERP调拨单号不能为空

**示例代码**:
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();

String result = service.createTransfer(
    "CUST001",           // 客户编码
    "ERP_TRANSFER_001",  // ERP调拨单号
    "NORMAL",            // 调拨类型
    "WH001",             // 调出仓库
    "WH002",             // 调入仓库
    (byte)1,             // 付款方式
    "notify@company.com" // 收件邮箱
);
```

---

### 2. editTransfer - 修改调拨单表头

**方法签名**:
```java
public OperationResult editTransfer(String customerCode, String erpTransferSn, 
        String toWarehouseCode, Byte payType, String toEmail) throws Exception
```

**功能描述**: 修改调拨单表头信息

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |
| toWarehouseCode | String | 否 | 调入仓库编码 |
| payType | Byte | 否 | 付款方式 |
| toEmail | String | 否 | 收件邮箱 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();

OperationResult result = service.editTransfer(
    "CUST001",           // 客户编码
    "ERP_TRANSFER_001",  // ERP调拨单号
    "WH003",             // 新的调入仓库
    (byte)2,             // 新的付款方式
    "new@company.com"    // 新的收件邮箱
);
```

---

### 3. cleanTransferDetail - 清空调拨单明细

**方法签名**:
```java
public OperationResult cleanTransferDetail(String customerCode, String erpTransferSn) throws Exception
```

**功能描述**: 清空指定调拨单的所有明细

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
OperationResult result = service.cleanTransferDetail("CUST001", "ERP_TRANSFER_001");
```

---

### 4. submitTransfer - 提交调拨单

**方法签名**:
```java
public OperationResult submitTransfer(String customerCode, String erpTransferSn) throws Exception
```

**功能描述**: 提交调拨单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
OperationResult result = service.submitTransfer("CUST001", "ERP_TRANSFER_001");
```

---

### 5. cancelTransfer - 取消调拨单

**方法签名**:
```java
public OperationResult cancelTransfer(String customerCode, String erpTransferSn, 
        String remark, String actionTime, String userName) throws Exception
```

**功能描述**: 取消调拨单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |
| remark | String | 否 | 取消备注 |
| actionTime | String | 否 | 操作时间 |
| userName | String | 否 | 操作用户名 |

**返回值**: `OperationResult` - 操作结果

**示例代码**:
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
OperationResult result = service.cancelTransfer(
    "CUST001",            // 客户编码
    "ERP_TRANSFER_001",   // ERP调拨单号
    "订单作废",            // 备注
    "2026-02-25 10:00:00", // 操作时间
    "admin"               // 操作用户
);
```

---

### 6. searchTransferList - 调拨单查询

**方法签名**:
```java
public String searchTransferList(String customerCode, Integer pageNum, Integer pageSize) throws Exception
```

**功能描述**: 分页查询调拨单列表

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| pageNum | Integer | 是 | 页码 |
| pageSize | Integer | 是 | 每页记录数 |

**返回值**: `String` - 查询结果JSON

**异常情况**:
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - 页码不能为空
- `IllegalArgumentException` - 页面大小不能为空

**示例代码**:
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
String result = service.searchTransferList("CUST001", 1, 10);
```

---

### 7. getTransferDetailList - 调拨单明细查询

**方法签名**:
```java
public String getTransferDetailList(String customerCode, String erpTransferSn, 
        Integer pageNum, Integer pageSize) throws Exception
```

**功能描述**: 分页查询调拨单明细

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| erpTransferSn | String | 是 | ERP调拨单号 |
| pageNum | Integer | 否 | 页码 |
| pageSize | Integer | 否 | 每页记录数 |

**返回值**: `String` - 查询结果JSON

**示例代码**:
```java
WopOuterTransferService service = PopServiceFactory.getWopOuterTransferService();
String result = service.getTransferDetailList("CUST001", "ERP_TRANSFER_001", 1, 10);
```

---

## 模型类

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
    String result = service.createTransfer("CUST001", "ERP_TRANSFER_001", 
        "NORMAL", "WH001", "WH002", (byte)1, "notify@company.com");
} catch (IllegalArgumentException e) {
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    System.err.println("API调用失败: " + e.getMessage());
}
```
