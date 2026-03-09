# WopOuterOrderBackService API 文档

## 概述

客退单接口服务，提供客退单的创建、取消、查询、状态批量查询、修改承运商等功能。

- **服务名称**: `com.pjbest.wop.wm.service.WopOuterOrderBackService`
- **服务类**: `com.vip.pop.service.WopOuterOrderBackService`

## 方法列表

| 方法名 | 描述 | 必填参数 |
|--------|------|----------|
| `healthCheck` | 健康检查 | 无 |
| `createOrder` | 创建客退单 | customerCode, orderBackInfo |
| `cancelOrder` | 取消客退单 | customerCode, orderBackSn |
| `queryOrderDetail` | 查询客退单详情 | customerCode, orderBackSn |
| `queryOrderStatusBatch` | 批量查询客退单状态 | customerCode, orderBackSns |
| `queryOrderBackByErpOrderSn` | 通过ERP订单号查询客退单列表 | customerCode, req |
| `searchOrderList` | 查询客退单列表 | req |
| `modifyCarrier` | 修改客退单承运商信息 | req |

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
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
String result = service.healthCheck();
```

---

### 2. createOrder - 创建客退单

**方法签名**:
```java
public ObCreateResult createOrder(String customerCode, OrderBackInfo orderBackInfo) throws Exception
```

**功能描述**: 创建客退单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackInfo | OrderBackInfo | 是 | 客退单信息对象 |

**返回值**: `ObCreateResult` - 创建结果

**异常情况**:
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - 客退单信息不能为空

**示例代码**:
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

OrderBackInfo orderBackInfo = new OrderBackInfo();
// 设置客退单信息

ObCreateResult result = service.createOrder("CUST001", orderBackInfo);
```

---

### 3. cancelOrder - 取消客退单

**方法签名**:
```java
public ObCancelResult cancelOrder(String customerCode, String orderBackSn) throws Exception
```

**功能描述**: 取消客退单

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackSn | String | 是 | 客退单号 |

**返回值**: `ObCancelResult` - 取消结果

**异常情况**:
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - 客退单号不能为空

**示例代码**:
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
ObCancelResult result = service.cancelOrder("CUST001", "OB202602250001");
```

---

### 4. queryOrderDetail - 查询客退单详情

**方法签名**:
```java
public WopOrderBackInfo queryOrderDetail(String customerCode, String orderBackSn) throws Exception
```

**功能描述**: 查询客退单详情

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackSn | String | 是 | 客退单号 |

**返回值**: `WopOrderBackInfo` - 客退单详情

**异常情况**:
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - 客退单号不能为空

**示例代码**:
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
WopOrderBackInfo detail = service.queryOrderDetail("CUST001", "OB202602250001");
```

---

### 5. queryOrderStatusBatch - 批量查询客退单状态

**方法签名**:
```java
public List<ObStatusResult> queryOrderStatusBatch(String customerCode, List<String> orderBackSns) throws Exception
```

**功能描述**: 批量查询客退单状态

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackSns | List<String> | 是 | 客退单号列表 |

**返回值**: `List<ObStatusResult>` - 状态查询结果列表

**异常情况**:
- `IllegalArgumentException` - 客户编码不能为空
- `IllegalArgumentException` - 客退单号列表不能为空

**示例代码**:
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

List<String> orderBackSns = Arrays.asList("OB001", "OB002", "OB003");
List<ObStatusResult> results = service.queryOrderStatusBatch("CUST001", orderBackSns);
```

---

### 6. queryOrderBackByErpOrderSn - 通过ERP订单号查询客退单列表

**方法签名**:
```java
public List<WopOrderBackInfo> queryOrderBackByErpOrderSn(String customerCode, QueryByErpOrderSnReq req) throws Exception
```

**功能描述**: 通过ERP订单号查询关联的客退单列表

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| req | QueryByErpOrderSnReq | 是 | 查询请求 |

**返回值**: `List<WopOrderBackInfo>` - 客退单列表

**示例代码**:
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

QueryByErpOrderSnReq req = new QueryByErpOrderSnReq();
// 设置ERP订单号等查询条件

List<WopOrderBackInfo> results = service.queryOrderBackByErpOrderSn("CUST001", req);
```

---

### 7. searchOrderList - 查询客退单列表

**方法签名**:
```java
public SearchOrderBackResponse searchOrderList(SearchOrderBackRequest req) throws Exception
```

**功能描述**: 分页查询客退单列表

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| req | SearchOrderBackRequest | 是 | 查询请求 |

**返回值**: `SearchOrderBackResponse` - 查询响应

**异常情况**:
- `IllegalArgumentException` - 查询请求不能为空

**示例代码**:
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

SearchOrderBackRequest req = new SearchOrderBackRequest();
// 设置查询条件

SearchOrderBackResponse response = service.searchOrderList(req);
```

---

### 8. modifyCarrier - 修改客退单承运商信息

**方法签名**:
```java
public ModifyCarrierResponse modifyCarrier(ModifyCarrierRequest req) throws Exception
```

**功能描述**: 修改客退单的承运商信息

**参数说明**:

| 参数 | 类型 | 必填 | 描述 |
|------|------|------|------|
| req | ModifyCarrierRequest | 是 | 修改请求 |

**返回值**: `ModifyCarrierResponse` - 修改响应

**异常情况**:
- `IllegalArgumentException` - 修改请求不能为空

**示例代码**:
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

ModifyCarrierRequest req = new ModifyCarrierRequest();
// 设置承运商信息

ModifyCarrierResponse response = service.modifyCarrier(req);
```

---

## 模型类

### OrderBackInfo - 客退单信息

客退单创建时的信息对象，支持链式调用设置参数。

### ObCreateResult - 创建结果

客退单创建返回结果。

### ObCancelResult - 取消结果

客退单取消返回结果。

### WopOrderBackInfo - 客退单详情

客退单详细信息对象。

### ObStatusResult - 状态结果

客退单状态查询结果。

### SearchOrderBackRequest / SearchOrderBackResponse - 查询请求/响应

客退单列表查询的请求和响应对象。

### ModifyCarrierRequest / ModifyCarrierResponse - 修改承运商请求/响应

修改承运商的请求和响应对象。

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
    ObCreateResult result = service.createOrder("CUST001", orderBackInfo);
} catch (IllegalArgumentException e) {
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    System.err.println("API调用失败: " + e.getMessage());
}
```
