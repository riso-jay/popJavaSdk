# PdcDecItemErpService API 文档

> ERP商品同步服务 - 提供ERP商品信息同步功能
> 
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=5688&serviceName=PdcDecItemErpService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.pdc.service.PdcDecItemErpService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
PdcDecItemErpService service = PopServiceFactory.getPdcDecItemErpService();
```

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `healthCheck` | 健康检查 | - | String |
| `syncPdcItem` | 同步商品信息 | String, ErpDecPdcItem | ErpDecPdcItemResult |

---

## 方法详情

### syncPdcItem

> 同步ERP商品信息接口

**方法签名:**
```java
public ErpDecPdcItemResult syncPdcItem(String crmCustCode, ErpDecPdcItem item) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| crmCustCode | String | 是 | 货主编码 |
| item | ErpDecPdcItem | 是 | 商品信息 |

**示例代码:**
```java
PdcDecItemErpService service = PopServiceFactory.getPdcDecItemErpService();

ErpDecPdcItem item = new ErpDecPdcItem();
item.setTransactionId("TXN001");
item.setItemCode("SKU001");
item.setItemName("测试商品");
item.setGoodsCode("GOODS001");
item.setSize("M");
item.setColor("红色");
item.setStockUnit("件");
item.setActionType("add");

ErpDecPdcItemResult result = service.syncPdcItem("17002437", item);
```

---

## 模型类

### ErpDecPdcItem

> ERP商品信息

| 字段名 | 类型 | 描述 |
|--------|------|------|
| transactionId | String | 交易ID |
| itemCode | String | 商品编码 |
| itemName | String | 商品名称 |
| goodsCode | String | 货品编码 |
| size | String | 尺码 |
| color | String | 颜色 |
| stockUnit | String | 库存单位 |
| actionType | String | 操作类型(add/update) |
| isShelfLifeMgmt | String | 是否保质期管理(Y/N) |
| shelfLife | Integer | 保质期天数 |

### ErpDecPdcItemResult

> 商品同步结果

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |
| pdcItemCode | String | 系统商品编码 |
