# PdcBrandService API 文档

> WOP品牌同步API - 提供品牌信息同步功能
> 
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4129&serviceName=PdcBrandService

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.pdc.service.PdcBrandService` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
// 方式1: 通过工厂类获取单例（推荐）
PdcBrandService service = PopServiceFactory.getPdcBrandService();

// 方式2: 创建新实例
PdcBrandService service = PopServiceFactory.createPdcBrandService();

// 方式3: 直接实例化
PdcBrandService service = new PdcBrandService();
```

## 方法列表

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `healthCheck` | 健康检查 | - | String |
| `syncPdcBrand` | 同步品牌信息 | String, BrandSyncReq | BrandSyncResponse |

---

## 方法详情

### healthCheck

> 健康检查接口

**方法签名:**
```java
public String healthCheck() throws Exception
```

**示例代码:**
```java
PdcBrandService service = PopServiceFactory.getPdcBrandService();
String result = service.healthCheck();
System.out.println("健康检查结果: " + result);
```

---

### syncPdcBrand

> 同步品牌信息接口

**方法签名:**
```java
public BrandSyncResponse syncPdcBrand(String crmCustCode, BrandSyncReq syncBrand) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| crmCustCode | String | 是 | 货主编码 |
| syncBrand | BrandSyncReq | 是 | 品牌同步信息 |

**示例代码:**
```java
PdcBrandService service = PopServiceFactory.getPdcBrandService();

BrandSyncReq syncBrand = new BrandSyncReq()
        .setCustBrandCode("BRAND001")
        .setCustbrandName("测试品牌");

BrandSyncResponse response = service.syncPdcBrand("17002437", syncBrand);
System.out.println("品牌同步结果: " + response);
```

---

## 模型类

### BrandSyncReq

> 品牌同步请求

| 字段名 | 类型 | 描述 |
|--------|------|------|
| custBrandCode | String | 客户品牌编码 |
| custbrandName | String | 客户品牌名称 |

### BrandSyncResponse

> 品牌同步响应

| 字段名 | 类型 | 描述 |
|--------|------|------|
| success | Boolean | 是否成功 |
| message | String | 返回消息 |
| brandCode | String | 系统品牌编码 |

---

## 错误处理

```java
try {
    PdcBrandService service = PopServiceFactory.getPdcBrandService();
    BrandSyncResponse response = service.syncPdcBrand("17002437", syncBrand);
} catch (IllegalArgumentException e) {
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    System.err.println("API调用失败: " + e.getMessage());
}
```
