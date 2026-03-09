# WopOuterOrderBackService API 文档

> 客退单接口服务 - 提供客退单的创建、取消、查询、状态批量查询、修改承运商等功能
>
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4108&serviceName=WopOuterOrderBackService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.wop.wm.service.WopOuterOrderBackService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
```

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `createOrder` | 创建客退单 | String, OrderBackInfo | ObCreateResult |
| `cancelOrder` | 取消客退单 | String, String | ObCancelResult |
| `queryOrderDetail` | 查询客退单详情 | String, String | WopOrderBackInfo |
| `queryOrderStatusBatch` | 批量查询客退单状态 | String, List\<String\> | List\<ObStatusResult\> |
| `queryOrderBackByErpOrderSn` | 通过ERP订单号查询客退单列表 | String, QueryByErpOrderSnReq | List\<WopOrderBackInfo\> |
| `searchOrderList` | 查询客退单列表 | SearchOrderBackRequest | SearchOrderBackResponse |
| `modifyCarrier` | 修改客退单承运商信息 | ModifyCarrierRequest | ModifyCarrierResponse |

---

## 方法详情

### createOrder

> 创建客退单接口

**方法签名:**
```java
public ObCreateResult createOrder(String customerCode, OrderBackInfo orderBackInfo) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackInfo | OrderBackInfo | 是 | 客退单信息对象 |

**示例代码:**
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

List<OrderDetailInfo> details = new ArrayList<>();
OrderDetailInfo detail = new OrderDetailInfo();
detail.setItemCode("SKU001");
detail.setItemName("测试商品A");
detail.setReqQty(1);
detail.setReturnReasonName("质量问题");
details.add(detail);

OrderBackInfo orderBackInfo = new OrderBackInfo();
orderBackInfo.setErpOrderBackSn("OB" + System.currentTimeMillis());
orderBackInfo.setErpOrderSn("ORDER001");
orderBackInfo.setRevcWarehouse("WH001");
orderBackInfo.setReturnReason("质量问题");
orderBackInfo.setOrderBackType((byte) 1);
orderBackInfo.setOrderDetailInfos(details);

ObCreateResult result = service.createOrder("17002437", orderBackInfo);
```

---

### cancelOrder

> 取消客退单接口

**方法签名:**
```java
public ObCancelResult cancelOrder(String customerCode, String orderBackSn) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackSn | String | 是 | 客退单号 |

**示例代码:**
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
ObCancelResult result = service.cancelOrder("17002437", "OB202303210001");
```

---

### queryOrderDetail

> 查询客退单详情接口

**方法签名:**
```java
public WopOrderBackInfo queryOrderDetail(String customerCode, String orderBackSn) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackSn | String | 是 | 客退单号 |

**示例代码:**
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
WopOrderBackInfo detail = service.queryOrderDetail("17002437", "OB202303210001");
```

---

### queryOrderStatusBatch

> 批量查询客退单状态接口

**方法签名:**
```java
public List<ObStatusResult> queryOrderStatusBatch(String customerCode, List<String> orderBackSns) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| orderBackSns | List\<String\> | 是 | 客退单号列表 |

**示例代码:**
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

List<String> orderBackSns = Arrays.asList(
    "OB202303210001", 
    "OB202303210002", 
    "OB202303210003"
);

List<ObStatusResult> results = service.queryOrderStatusBatch("17002437", orderBackSns);
```

---

### queryOrderBackByErpOrderSn

> 通过ERP订单号查询客退单列表接口

**方法签名:**
```java
public List<WopOrderBackInfo> queryOrderBackByErpOrderSn(String customerCode, QueryByErpOrderSnReq req) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| customerCode | String | 是 | 客户编码 |
| req | QueryByErpOrderSnReq | 是 | 查询请求 |

**示例代码:**
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

QueryByErpOrderSnReq req = new QueryByErpOrderSnReq();
req.setErpOrderSn("ORDER001");
req.setOrderBackType((byte) 1);

List<WopOrderBackInfo> results = service.queryOrderBackByErpOrderSn("17002437", req);
```

---

### searchOrderList

> 查询客退单列表接口（分页）

**方法签名:**
```java
public SearchOrderBackResponse searchOrderList(SearchOrderBackRequest req) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| req | SearchOrderBackRequest | 是 | 查询请求 |

**示例代码:**
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

SearchOrderBackRequest req = new SearchOrderBackRequest();
req.setCustomerCode("17002437");
req.setPageNum(1);
req.setPageSize(20);
req.setSystemSource("WOP");

SearchOrderBackResponse response = service.searchOrderList(req);
System.out.println("查询到 " + response.getTotalCount() + " 条客退单");
```

---

### modifyCarrier

> 修改客退单承运商信息接口

**方法签名:**
```java
public ModifyCarrierResponse modifyCarrier(ModifyCarrierRequest req) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| req | ModifyCarrierRequest | 是 | 修改请求 |

**示例代码:**
```java
WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

ModifyCarrierRequest req = new ModifyCarrierRequest();
req.setCustomerCode("17002437");
req.setErpOrderBackSn("OB202303210001");
req.setTransportNo("SF123456789");
req.setCarrierCode("SF");

ModifyCarrierResponse response = service.modifyCarrier(req);
```

---

## 模型类

### 请求模型

#### OrderBackInfo

> 客退单信息

| 字段名 | 类型 | 描述 |
|--------|------|------|
| erpOrderBackSn | String | 客退单号 |
| erpOrderSn | String | 原订单号 |
| revcWarehouse | String | 退货仓库 |
| returnReason | String | 退货原因 |
| orderBackType | Byte | 退货类型: 1=普通退货 |
| orderDetailInfos | List\<OrderDetailInfo\> | 退货明细 |

#### OrderDetailInfo

> 客退单明细

| 字段名 | 类型 | 描述 |
|--------|------|------|
| itemCode | String | 商品编码 |
| itemName | String | 商品名称 |
| reqQty | Integer | 退货数量 |
| returnReasonName | String | 退货原因名称 |

#### QueryByErpOrderSnReq

> 通过ERP订单查询客退单请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| erpOrderSn | String | ERP订单号 |
| orderBackType | Byte | 退货类型 |

#### SearchOrderBackRequest

> 客退单列表查询请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| customerCode | String | 客户编码 |
| pageNum | Integer | 页码 |
| pageSize | Integer | 每页大小 |
| systemSource | String | 来源系统 |

#### ModifyCarrierRequest

> 修改承运商请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| customerCode | String | 客户编码 |
| erpOrderBackSn | String | 客退单号 |
| transportNo | String | 运单号 |
| carrierCode | String | 承运商编码 |

### 响应模型

#### ObCreateResult

> 创建客退单结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |
| erpOrderBackSn | String | 客退单号 |

#### ObCancelResult

> 取消客退单结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |

#### ObStatusResult

> 客退单状态结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| erpOrderBackSn | String | 客退单号 |
| status | String | 状态 |
| statusName | String | 状态名称 |

#### SearchOrderBackResponse

> 客退单列表查询响应

| 字段名 | 类型 | 描述 |
|--------|------|------|
| orderList | List\<WopOrderBackInfo\> | 客退单列表 |
| totalCount | Integer | 总数 |

#### ModifyCarrierResponse

> 修改承运商响应

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |

---

## 错误处理

```java
try {
    WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();
    ObCreateResult result = service.createOrder("17002437", orderBackInfo);
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
