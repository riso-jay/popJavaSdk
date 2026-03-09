# CategoryAPI API 文档

> WOP类目API - 提供类目查询、校验、特有属性查询等功能
> 
> API文档来源: https://56.pjbest.com/app/wx/doc/openService?defCode=4115&serviceName=CategoryAPI

## 概述

| 属性 | 值 |
|------|----|
| 服务名 | `com.pjbest.pdc.service.CategoryAPI` |
| 版本号 | 1.0.0 |
| 生成时间 | 2026-02-25 |

## 快速开始

### 获取服务实例

```java
// 方式1: 通过工厂类获取单例（推荐）
CategoryAPI service = PopServiceFactory.getCategoryAPI();

// 方式2: 创建新实例
CategoryAPI service = PopServiceFactory.createCategoryAPI();

// 方式3: 直接实例化
CategoryAPI service = new CategoryAPI();
```

## 方法列表

### 类目校验

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `checkCategoryByCodeAndName` | 根据品类编码和名称校验品类信息 | String, String | Boolean |

### 类目查询

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `getCategory` | 获取类目节点信息 | Integer | Category |
| `getUpdatedPublishCategories` | 获取给定时间戳以后变更的发布导航分类节点信息 | Long, Integer, Integer, Integer | CategoryUpdates |

### 特有属性查询

| 方法名 | 描述 | 参数类型 | 返回类型 |
|--------|------|---------|--------|
| `getCategorySpecialAttributeList` | 批量获取分类ID和属性IDS特有属性信息 | List\<CategorySpecialParam\> | List\<CategorySpecialAttributes\> |
| `getCategorySpecialAttributes` | 根据分类ID和属性ID获取特有属性信息 | Integer, Integer | List\<AttributeWithValue\> |

---

## 方法详情

### checkCategoryByCodeAndName

> 根据品类编码和名称校验品类信息接口

**方法签名:**
```java
public Boolean checkCategoryByCodeAndName(String categoryCode, String categoryName) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| categoryCode | String | 是 | 品类编码 |
| categoryName | String | 是 | 品类名称 |

**示例代码:**
```java
CategoryAPI service = PopServiceFactory.getCategoryAPI();

Boolean isValid = service.checkCategoryByCodeAndName("CAT001", "服装");
System.out.println("品类校验结果: " + isValid);
```

---

### getCategory

> 获取类目节点信息接口

**方法签名:**
```java
public Category getCategory(Integer categoryId) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| categoryId | Integer | 是 | 分类ID |

**示例代码:**
```java
CategoryAPI service = PopServiceFactory.getCategoryAPI();

Category category = service.getCategory(1001);
System.out.println("类目名称: " + category.getCategoryName());
```

---

### getUpdatedPublishCategories

> 获取给定时间戳以后变更的发布导航分类节点信息接口

**方法签名:**
```java
public CategoryUpdates getUpdatedPublishCategories(Long sinceUpdateTime, Integer hierarchyId, Integer pageNum, Integer pageSize) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| sinceUpdateTime | Long | 是 | 时间戳（示例: 0） |
| hierarchyId | Integer | 是 | 导航ID（默认值: 0） |
| pageNum | Integer | 否 | 当前页码（默认值: 1） |
| pageSize | Integer | 是 | 一页多少条，不能大于1000 |

**示例代码:**
```java
CategoryAPI service = PopServiceFactory.getCategoryAPI();

// 获取所有变更的分类
CategoryUpdates updates = service.getUpdatedPublishCategories(0L, 0, 1, 100);
System.out.println("变更分类数量: " + updates.getCategories().size());
```

---

### getCategorySpecialAttributeList

> 批量获取分类ID和属性IDS特有属性信息

**方法签名:**
```java
public List<CategorySpecialAttributes> getCategorySpecialAttributeList(List<CategorySpecialParam> categorySpecialParams) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| categorySpecialParams | List\<CategorySpecialParam\> | 是 | 分类特有属性参数集合 |

**示例代码:**
```java
CategoryAPI service = PopServiceFactory.getCategoryAPI();

List<CategorySpecialParam> params = new ArrayList<>();
CategorySpecialParam param1 = new CategorySpecialParam();
param1.setCategoryId(1001);
param1.setAttributeId(1);
params.add(param1);
CategorySpecialParam param2 = new CategorySpecialParam();
param2.setCategoryId(1002);
param2.setAttributeId(2);
params.add(param2);

List<CategorySpecialAttributes> result = service.getCategorySpecialAttributeList(params);
```

---

### getCategorySpecialAttributes

> 根据分类ID和属性ID获取特有属性信息

**方法签名:**
```java
public List<AttributeWithValue> getCategorySpecialAttributes(Integer categoryId, Integer attributeId) throws Exception
```

**参数说明:**

| 参数名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| categoryId | Integer | 是 | 分类ID |
| attributeId | Integer | 否 | 分类属性ID（当attributeId=0时返回分类对应所有的特有属性信息） |

**示例代码:**
```java
CategoryAPI service = PopServiceFactory.getCategoryAPI();

// 获取指定分类的所有特有属性
List<AttributeWithValue> attrs = service.getCategorySpecialAttributes(1001, 0);

// 获取指定属性
List<AttributeWithValue> attr = service.getCategorySpecialAttributes(1001, 5);
```

---

## 模型类

### CategorySpecialParam

> 分类特有属性查询参数

| 字段名 | 类型 | 描述 |
|--------|------|------|
| categoryId | Integer | 分类ID |
| attributeId | Integer | 属性ID |

### Category

> 类目信息

| 字段名 | 类型 | 描述 |
|--------|------|------|
| categoryId | Integer | 分类ID |
| categoryName | String | 分类名称 |
| parentId | Integer | 父分类ID |
| level | Integer | 层级 |

### CategoryUpdates

> 变更分类集合

| 字段名 | 类型 | 描述 |
|--------|------|------|
| categories | List\<Category\> | 变更的分类列表 |
| totalCount | Integer | 总数 |

### AttributeWithValue

> 属性及属性值

| 字段名 | 类型 | 描述 |
|--------|------|------|
| attributeId | Integer | 属性ID |
| attributeName | String | 属性名称 |
| attributeValues | List\<String\> | 属性值列表 |

---

## 错误处理

```java
try {
    CategoryAPI service = PopServiceFactory.getCategoryAPI();
    Category category = service.getCategory(1001);
    System.out.println("类目: " + category.getCategoryName());
} catch (IllegalArgumentException e) {
    // 参数验证错误
    System.err.println("参数错误: " + e.getMessage());
} catch (Exception e) {
    // API调用异常
    System.err.println("API调用失败: " + e.getMessage());
}
```
