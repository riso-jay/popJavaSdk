# POP Java SDK 使用手册

> 唯品云仓开放平台 Java SDK - 为第三方系统提供便捷的 WOP API 调用能力

## 目录

- [快速开始](#快速开始)
- [环境要求](#环境要求)
- [安装配置](#安装配置)
- [对接前准备](#对接前准备)
- [配置说明](#配置说明)
- [使用示例](#使用示例)
- [核心特性](#核心特性)
- [API 服务列表](#api-服务列表)
- [测试指南](#测试指南)
- [错误处理](#错误处理)
- [常见问题](#常见问题)

---

## 快速开始

### 30秒快速体验（单 APPKEY 场景）

```java
// 1. 配置环境变量
// pop.app.key=您的AppKey
// pop.app.secret=您的AppSecret
// pop.app.url=API服务地址

// 2. 调用API
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterPoService;

WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
QueryPoResult result = service.queryPo("17002437", "PO202603010001");
```

### 动态配置 APPKEY（多 APPKEY 场景）

当需要对接多个客户或多个环境时,可以使用 `setPopAppKeyConfig()` 方法动态切换 APPKEY。

#### 场景示例

一个 SaaS 系统需要对接多个客户的唯品云仓,每个客户使用不同的 APPKEY。

#### 方法一：每次调用前动态设置

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterPoService;
import com.vip.pop.BaseService;

// 获取单例服务实例
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

// 场景 1: 调用客户 A 的接口
service.setPopAppKeyConfig("app_key_a", "app_secret_a", "https://api.customerA.com");
QueryPoResult resultA = service.queryPo("17002437", "PO_A_001");

// 场景 2: 调用客户 B 的接口
service.setPopAppKeyConfig("app_key_b", "app_secret_b", "https://api.customerB.com");
QueryPoResult resultB = service.queryPo("17002438", "PO_B_001");

// 场景 3: 调用测试环境的接口
service.setPopAppKeyConfig("test_app_key", "test_app_secret", "https://test.api.com");
QueryPoResult resultTest = service.queryPo("17002439", "PO_TEST_001");
```

#### 方法二：封装配置管理类（推荐）

```java
import com.vip.pop.base.model.PopAppKeyConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多客户配置管理器
 */
public class CustomerConfigManager {

    private static final Map<String, PopAppKeyConfig> CONFIG_CACHE = new ConcurrentHashMap<>();

    /**
     * 注册客户配置
     */
    public static void registerCustomer(String customerId, String appKey, 
                                       String appSecret, String appUrl) {
        PopAppKeyConfig config = new PopAppKeyConfig(appKey, appSecret, appUrl);
        CONFIG_CACHE.put(customerId, config);
    }

    /**
     * 获取客户配置
     */
    public static PopAppKeyConfig getCustomerConfig(String customerId) {
        return CONFIG_CACHE.get(customerId);
    }

    /**
     * 为客户调用 API
     */
    public static <T> T callForCustomer(String customerId, 
                                       String methodName, 
                                       ServiceCaller<T> caller) throws Exception {
        // 获取客户配置
        PopAppKeyConfig config = getCustomerConfig(customerId);
        if (config == null) {
            throw new IllegalArgumentException("未找到客户配置: " + customerId);
        }

        // 创建服务实例并设置配置
        WopOuterPoService service = PopServiceFactory.createWopOuterPoService();
        service.setPopAppKeyConfig(config.getAppKey(), config.getAppSecret(), config.getAppUrl());

        // 执行调用
        return caller.call(service);
    }

    @FunctionalInterface
    public interface ServiceCaller<T> {
        T call(WopOuterPoService service) throws Exception;
    }
}
```

**使用示例**:

```java
// 1. 初始化时注册所有客户配置
CustomerConfigManager.registerCustomer("customerA", "app_key_a", "app_secret_a", 
                                       "https://api.customerA.com");
CustomerConfigManager.registerCustomer("customerB", "app_key_b", "app_secret_b", 
                                       "https://api.customerB.com");

// 2. 调用客户 A 的接口
QueryPoResult resultA = CustomerConfigManager.callForCustomer("customerA", 
    "queryPo", service -> {
        return service.queryPo("17002437", "PO_A_001");
    });

// 3. 调用客户 B 的接口
QueryPoResult resultB = CustomerConfigManager.callForCustomer("customerB", 
    "queryPo", service -> {
        return service.queryPo("17002438", "PO_B_001");
    });
```

#### 配置说明

| 参数 | 类型 | 必填 | 说明 |
|-----|------|-----|------|
| appKey | String | ✅ | 应用密钥 Key |
| appSecret | String | ✅ | 应用密钥 Secret |
| appUrl | String | ✅ | API 服务地址（完整 URL，如 `https://api.example.com/pop-apis`） |

#### 配置优先级

当调用 `setPopAppKeyConfig()` 方法后,后续的 API 调用将使用新设置的配置,**覆盖**全局配置文件和环境变量中的配置。

**配置读取优先级**:
1. **最高优先级**: `setPopAppKeyConfig()` 动态设置（当前线程有效）
2. 次高优先级: JVM 系统属性 (`-Dpop.app.key=xxx`)
3. 次高优先级: 环境变量
4. 最低优先级: 配置文件 (`config.properties`)

#### 多线程场景

`setPopAppKeyConfig()` 方法使用 `ThreadLocal` 存储配置,因此:

- **线程安全**: 每个线程可以独立设置不同的 APPKEY
- **适用场景**: 多线程环境下为不同请求配置不同的 APPKEY

**示例**:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

ExecutorService executor = Executors.newFixedThreadPool(3);

// 线程 1: 使用客户 A 的配置
executor.submit(() -> {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    service.setPopAppKeyConfig("app_key_a", "app_secret_a", "https://api.customerA.com");
    QueryPoResult result = service.queryPo("17002437", "PO_A_001");
});

// 线程 2: 使用客户 B 的配置
executor.submit(() -> {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    service.setPopAppKeyConfig("app_key_b", "app_secret_b", "https://api.customerB.com");
    QueryPoResult result = service.queryPo("17002438", "PO_B_001");
});

// 线程 3: 使用测试环境的配置
executor.submit(() -> {
    WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
    service.setPopAppKeyConfig("test_key", "test_secret", "https://test.api.com");
    QueryPoResult result = service.queryPo("17002439", "PO_TEST_001");
});
```

#### 最佳实践

1. **单客户场景**: 使用环境变量或配置文件配置 APPKEY,无需动态设置
2. **多线程场景**: 每个 Thread 中独立调用 `setPopAppKeyConfig()`,线程间互不影响
3. **配置切换**: 在调用 API 前确保已正确设置配置,避免使用错误的 APPKEY

---

## 环境要求

| 组件 | 最低版本 | 推荐版本 |
|------|---------|---------|
| JDK | 1.8 | 1.8+ |
| Maven | 3.6 | 3.8+ |

---

## 安装配置

### 方式一：Maven 依赖（推荐）

在项目的 `pom.xml` 中添加依赖：

```xml
<dependency>
    <groupId>com.vip.pop</groupId>
    <artifactId>pop-java-sdk</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 方式二：JAR 包引入

1. 下载jar文件 

[pop-java-sdk-1.0-SNAPSHOT.jar](jar/pop-java-sdk-1.0-SNAPSHOT.jar)

[pop-java-sdk-1.0-SNAPSHOT-javadoc.jar](jar/pop-java-sdk-1.0-SNAPSHOT-javadoc.jar)

[pop-java-sdk-1.0-SNAPSHOT-sources.jar](jar/pop-java-sdk-1.0-SNAPSHOT-sources.jar)

2. 将 JAR 包添加到项目 classpath
3. 同时需要引入以下依赖：
    - slf4j-api-1.7.36.jar
    - logback-classic-1.2.12.jar
    - httpclient-4.5.14.jar
    - commons-lang3-3.12.0.jar

---

## 对接前准备

在开始开发前，请确认以下信息：

### 确认事项清单

| 项目 | 说明 | 示例 |
|------|------|------|
| 货主编码 | 供应商在唯品云仓的货主标识 | `80001001` |
| 客户编码 | API调用时的customerCode | `17002437` |
| 仓库编码 | 目标物理仓库或虚拟仓编码 | `PJ_ZQHX`、`V1_80001001` |
| 品牌编码 | 商品关联的品牌标识 | `10032800` |
| AppKey | 应用密钥 Key | 由平台分配 |
| AppSecret | 应用密钥 Secret | 由平台分配 |
| 履约场景 | 唯品渠道、非唯品渠道或两者都有 | 唯品会、快手等 |

### 常见对接场景

| 场景 | 说明 | 涉及接口 |
|------|------|----------|
| 入库单 | 采购入库、退货入库等 | WopOuterPoService |
| 出库单 | 次品退供、移仓出库等 | WopOuterInvReturnOrderService |
| 发货单 | 非唯品渠道订单履约 | WopOuterOrderService |
| 库存异动 | JIT/JITX订单出库通知 | WopOrderEventService |
| 虚拟调拨 | 唯品/非唯品渠道间库存调拨 | WopOuterTransferService |
| 客退单 | 客户退货收货 | WopOuterOrderBackService |


---

## 单客户或多客户默认配置说明

支持三种配置方式，按以下优先级读取：

| 优先级 | 配置方式 | 说明 |
|--------|---------|------|
| 1 | JVM 系统属性 | 启动时通过 `-D` 参数指定 |
| 2 | 环境变量 | 操作系统环境变量 |
| 3 | 配置文件 | `config.properties` 文件 |

### 配置项说明

| 配置项 | 说明 | 必填 | 示例 |
|--------|------|------|------|
| `pop.app.key` | 应用密钥 Key | 是 | `1a2e1e07` |
| `pop.app.secret` | 应用密钥 Secret | 是 | `EBD6C4368019556E...` |
| `pop.app.url` | API 服务地址 | 是 | `http://xxx:19090/pop-apis` |

### 配置方式详解

#### 方式一：JVM 系统属性（推荐生产环境）

启动应用时通过 `-D` 参数指定：

```bash
java -Dpop.app.key=您的AppKey \
     -Dpop.app.secret=您的AppSecret \
     -Dpop.app.url=http://api.example.com/pop-apis \
     -jar your-application.jar
```

#### 方式二：环境变量（推荐容器化部署）

**Linux/Mac:**
```bash
export pop.app.key=您的AppKey
export pop.app.secret=您的AppSecret
export pop.app.url=http://api.example.com/pop-apis
```

**Windows:**
```cmd
set pop.app.key=您的AppKey
set pop.app.secret=您的AppSecret
set pop.app.url=http://api.example.com/pop-apis
```

**Docker:**
```yaml
environment:
  - pop.app.key=您的AppKey
  - pop.app.secret=您的AppSecret
  - pop.app.url=http://api.example.com/pop-apis
```

#### 方式三：配置文件（推荐开发环境）

在 `src/main/resources/config.properties` 中配置：

```properties
pop.app.key=您的AppKey
pop.app.secret=您的AppSecret
pop.app.url=http://api.example.com/pop-apis
```

> **安全提示**: 生产环境不建议将敏感信息写入配置文件，推荐使用环境变量或 JVM 参数。

---

## 使用示例

### 获取服务实例

SDK 提供工厂类统一管理服务实例：

```java
import com.vip.pop.factory.PopServiceFactory;

// 方式1：获取单例实例（推荐）
WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

// 方式2：创建新实例
WopOuterPoService service = PopServiceFactory.createWopOuterPoService();

// 方式3：直接实例化
WopOuterPoService service = new WopOuterPoService();
```

### 示例1：创建 PO 入库单

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterPoService;
import com.vip.pop.model.*;

import java.util.ArrayList;
import java.util.List;

public class CreatePoExample {

    private static final String CUSTOMER_CODE = "17002437";

    public static void main(String[] args) {
        try {
            // 获取服务实例
            WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

            // 1. 构建PO表头
            CreatePoInfo poInfo = new CreatePoInfo();
            poInfo.setClientPoNo("CLIENT-PO-" + System.currentTimeMillis());
            poInfo.setWarehouseCode("WH001");
            poInfo.setVendorCode("V001");
            poInfo.setVendorName("测试供应商");
            poInfo.setExpectedArrivalTime("2026-03-01");

            // 2. 构建PO明细
            List<ImpPoDetail> details = new ArrayList<>();

            ImpPoDetail detail1 = new ImpPoDetail();
            detail1.setItemCode("SKU001");
            detail1.setExpectedQty(100);
            details.add(detail1);

            ImpPoDetail detail2 = new ImpPoDetail();
            detail2.setItemCode("SKU002");
            detail2.setExpectedQty(200);
            details.add(detail2);

            // 3. 一步完成：创建表头 + 导入明细（推荐）
            CreatePoResult result = service.createPoWithDetail(CUSTOMER_CODE, poInfo, details);

            System.out.println("PO单创建成功: " + result.getPoNo());

        } catch (IllegalArgumentException e) {
            System.err.println("参数错误: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("API调用失败: " + e.getMessage());
        }
    }
}
```

### 示例2：查询 PO 单列表

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterPoService;
import com.vip.pop.model.PoQueryCondition;
import com.vip.pop.model.SearchPoResult;

public class QueryPoListExample {
    public static void main(String[] args) {
        try {
            WopOuterPoService service = PopServiceFactory.getWopOuterPoService();

            // 构建查询条件
            PoQueryCondition condition = new PoQueryCondition();
            condition.setPoStatus("SUBMITTED");
            condition.setCreatedDtmLocFrom("2026-01-01");
            condition.setCreatedDtmLocTo("2026-03-01");

            // 分页查询
            SearchPoResult result = service.searchPoList("17002437",  // 客户编码
                    condition,   // 查询条件
                    1,           // 页码
                    20,          // 每页大小
                    null         // 来源系统
            );

            System.out.println("查询到 " + result.getTotalCount() + " 条记录");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 示例3：查询库存

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.CisInvChannelQueryAPI;
import com.vip.pop.model.InventoryQueryReq;

public class QueryInventoryExample {
    public static void main(String[] args) {
        try {
            CisInvChannelQueryAPI service = PopServiceFactory.getCisInvChannelQueryAPI();

            InventoryQueryReq request = new InventoryQueryReq();
            request.setCustomerCode("17002437");
            request.setWarehouseCode("WH001");

            String result = service.queryInventory(request);
            System.out.println("库存查询结果: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 示例4：创建客退单

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterOrderBackService;
import com.vip.pop.model.*;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderBackExample {

    private static final String CUSTOMER_CODE = "17002437";

    public static void main(String[] args) {
        try {
            WopOuterOrderBackService service = PopServiceFactory.getWopOuterOrderBackService();

            // 1. 构建客退单明细
            List<OrderDetailInfo> details = new ArrayList<>();

            OrderDetailInfo detail = new OrderDetailInfo();
            detail.setItemCode("SKU001");
            detail.setItemName("测试商品");
            detail.setReqQty(1);
            detail.setReturnReasonName("质量问题");
            details.add(detail);

            // 2. 构建客退单信息
            OrderBackInfo orderBackInfo = new OrderBackInfo();
            orderBackInfo.setErpOrderBackSn("OB" + System.currentTimeMillis());
            orderBackInfo.setErpOrderSn("ORDER001");
            orderBackInfo.setRevcWarehouse("WH001");
            orderBackInfo.setReturnReason("质量问题");
            orderBackInfo.setOrderBackType((byte) 1);
            orderBackInfo.setOrderDetailInfos(details);

            // 3. 创建客退单
            ObCreateResult result = service.createOrder(CUSTOMER_CODE, orderBackInfo);
            System.out.println("客退单创建结果: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 示例5：使用 ApiResponse 获取完整响应

```java
import com.vip.pop.factory.PopServiceFactory;
import com.vip.pop.service.WopOuterPoService;
import com.vip.pop.model.*;

public class ApiResponseExample {
    public static void main(String[] args) {
        try {
            WopOuterPoService service = PopServiceFactory.getWopOuterPoService();
            
            CreatePoInfo poInfo = new CreatePoInfo();
            poInfo.setClientPoNo("CLIENT-RESP-001");
            poInfo.setWarehouseCode("WH001");

            // 使用 WithResponse 后缀方法获取完整响应（包含错误码、消息等）
            ApiResponse<CreatePoResult> response = service.createPoWithResponse(
                    "17002437", poInfo, null);

            if (response.isSuccess()) {
                CreatePoResult data = response.getData();
                System.out.println("创建成功，PO号: " + data.getPoNo());
            } else {
                System.err.println("创建失败: " + response.getMessage());
                System.err.println("错误码: " + response.getCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


## API 服务列表

SDK 提供以下服务，点击查看详细 API 文档：

### 入库管理

| 服务类 | 描述 | API文档 |
|--------|------|---------|
| `WopOuterPoService` | PO入库单服务 | [WopOuterPoService.md](docs/WopOuterPoService.md) |
| `WopBigOrderService` | 大订单服务 | [WopBigOrderService.md](docs/WopBigOrderService.md) |

### 出库管理

| 服务类 | 描述 | API文档 |
|--------|------|---------|
| `WopOuterOrderService` | 外部订单服务 | [WopOuterOrderService.md](docs/WopOuterOrderService.md) |
| `WopJitOrderPopService` | JIT订单服务 | [WopJitOrderPopService.md](docs/WopJitOrderPopService.md) |
| `WopJitxOrderPopService` | JITX订单服务 | [WopJitxOrderPopService.md](docs/WopJitxOrderPopService.md) |
| `WopOutterHtOrderService` | 海淘订单服务 | [WopOutterHtOrderService.md](docs/WopOutterHtOrderService.md) |

### 退货管理

| 服务类 | 描述 | API文档 |
|--------|------|---------|
| `WopOuterOrderBackService` | 客退单服务 | [WopOuterOrderBackService.md](docs/WopOuterOrderBackService.md) |
| `WopOuterInvReturnOrderService` | 退供单服务 | [WopOuterInvReturnOrderService.md](docs/WopOuterInvReturnOrderService.md) |

### 调拨管理

| 服务类 | 描述 | API文档 |
|--------|------|---------|
| `WopOuterTransferService` | 仓间调拨单服务 | [WopOuterTransferService.md](docs/WopOuterTransferService.md) |

### 库存查询

| 服务类 | 描述 | API文档 |
|--------|------|---------|
| `CisInvChannelQueryAPI` | 渠道库存查询 | [CisInvChannelQueryAPI.md](docs/CisInvChannelQueryAPI.md) |
| `WmReportingService` | 仓储报表服务 | [WmReportingService.md](docs/WmReportingService.md) |

### 基础数据

| 服务类 | 描述 | API文档 |
|--------|------|---------|
| `CategoryAPI` | 类目服务 | [CategoryAPI.md](docs/CategoryAPI.md) |
| `PdcBrandService` | 品牌同步服务 | [PdcBrandService.md](docs/PdcBrandService.md) |
| `PdcDecItemErpService` | ERP商品同步服务 | [PdcDecItemErpService.md](docs/PdcDecItemErpService.md) |

### 事件处理

| 服务类 | 描述 | API文档 |
|--------|------|---------|
| `WopOrderEventService` | 订单事件服务 | [WopOrderEventService.md](docs/WopOrderEventService.md) |

---

## 测试指南

### 测试框架

SDK 使用 TestNG 作为测试框架,提供以下特性:
- **注解支持**: `@Test`, `@BeforeClass`, `@AfterClass` 等
- **异常测试**: `expectedExceptions` 属性验证异常抛出
- **断言**: 使用 `Assert` 类进行结果验证

### 测试原则

**每个方法只保留一个完整的测试用例**:
- ✅ 重点验证必填字段
- ✅ 包含完整的模型对象数据
- ✅ 正常流程测试
- ✅ 清晰的注释说明

**统一测试数据**:
- 供应商编码统一使用 `17002437`
- 客户编码统一使用 `17002437`
- 测试断言: 没有异常即通过测试

**必填字段优先级**:
1. 必须设置所有标记为"必填"的字段
2. 选填字段根据业务需要选择性设置
3. 避免冗余的测试场景

### 测试用例示例

```java
@Test
public void testCreatePo() throws Exception {
    logger.info("========== 测试开始: 创建PO单 ==========");

    // 1. 准备测试数据 (根据 @Required 注解设置必填字段)
    CreatePoInfo poInfo = new CreatePoInfo();
    poInfo.setClientPoNo(TEST_CLIENT_PO_NO);  // @Required: 客户PO单号
    poInfo.setVendorCode("17002437");          // 统一供应商编码
    poInfo.setWarehouseCode("WH001");          // @Required: 仓库编码
    poInfo.setType("NORMAL");                  // @Required: PO类型
    // ... 其他必填字段

    // 2. 验证测试数据 (使用 RequiredValidator 验证 @Required 字段)
    try {
        RequiredValidator.validate(poInfo);
        logger.info("测试数据验证通过,所有 @Required 字段已设置");
    } catch (IllegalArgumentException e) {
        logger.error("测试数据验证失败: {}", e.getMessage());
        throw e;
    }

    // 3. 调用API (没有异常即通过测试)
    service.createPo(CUSTOMER_CODE, poInfo, TEST_SYSTEM_SOURCE);

    // 4. 测试通过 (无断言,无异常即通过)
    logger.info("测试通过");
    logger.info("========== 测试通过: 创建PO单 ==========");
}
```

### 运行测试

```bash
# 运行所有测试
mvn test

# 运行指定测试类
mvn test -Dtest=WopOuterPoServiceTest

# 运行指定测试方法
mvn test -Dtest=WopOuterPoServiceTest#testCreatePo

# 生成测试报告
mvn test surefire-report:report
```

### 测试类列表

| 测试类 | 说明 |
|--------|------|
| `WopOuterPoServiceTest` | PO入库单服务测试 |
| `WopBigOrderServiceTest` | 大订单服务测试 |
| `WopOuterOrderServiceTest` | 外部订单服务测试 |
| `WopOrderEventServiceTest` | 订单事件服务测试 |
| `WopOuterInvReturnOrderServiceTest` | 退供单服务测试 |
| `WopOuterOrderBackServiceTest` | 客退单服务测试 |
| `WopOuterTransferServiceTest` | 仓间调拨单服务测试 |
| `WmReportingServiceTest` | 仓储报表服务测试 |
| `CisInvChannelQueryAPITest` | 渠道库存查询测试 |
| `PdcBrandServiceTest` | 品牌同步服务测试 |
| `PdcDecItemErpServiceTest` | ERP商品同步服务测试 |
| `RequiredAnnotationTest` | @Required注解测试 |

> **详细文档**: [WOP API SDK 测试指南](skills/wop-api-sdk-test.md)


## 错误处理

### 异常类型

| 异常类型 | 描述 | 处理建议 |
|----------|------|---------|
| `IllegalArgumentException` | 参数校验失败 | 检查必填参数是否为空 |
| `Exception` | API调用异常 | 检查网络连接、配置是否正确 |

### 推荐的错误处理模式

```java
try {
    // 调用API
    CreatePoResult result = service.createPo(customerCode, poInfo, null);
    
    // 处理业务结果
    if (result != null && result.isSuccess()) {
        System.out.println("操作成功: " + result.getPoNo());
    } else {
        System.out.println("业务处理失败: " + result.getMessage());
    }
    
} catch (IllegalArgumentException e) {
    // 参数错误 - 通常是代码问题
    logger.error("参数校验失败: {}", e.getMessage());
    
} catch (Exception e) {
    // API调用异常 - 可能是网络或配置问题
    logger.error("API调用异常: {}", e.getMessage());
    // 可考虑重试机制
}
```


## 常见问题

### Q1: 如何获取 AppKey 和 AppSecret？

请联系唯品云仓开放平台管理员申请应用凭证。

### Q2: 调用超时如何处理？

SDK 默认超时时间为 30 秒。如遇超时：
1. 检查网络连接是否正常
2. 确认 API 服务地址是否可访问
3. 大数据量请求考虑分页查询

### Q3: 如何查看请求日志？

SDK 使用 SLF4J + Logback 日志框架，配置 `logback.xml` 开启 DEBUG 级别日志：

```xml
<logger name="com.vip.pop" level="DEBUG"/>
```

### Q4: 分页查询建议？

- `pageSize` 建议不超过 100
- 大数据量导出请分批次查询
- 使用时间范围缩小查询范围

### Q5: 如何保证接口幂等？

- 创建类接口使用业务单号（如 `clientPoNo`）作为唯一标识
- 重复提交相同业务单号会返回已存在的记录

---

## 技术支持

如有问题，请联系技术支持团队。

---

## 项目结构

```
popJavaSdk/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/vip/pop/
│   │   │       ├── base/              # 基础框架
│   │   │       │   ├── annotation/     # 注解定义 (@Required)
│   │   │       │   ├── exception/      # 异常类
│   │   │       │   ├── model/          # 基础模型类
│   │   │       │   └── validator/      # 验证器 (RequiredValidator)
│   │   │       ├── beans/              # Bean 类
│   │   │       ├── factory/           # 工厂类 (服务实例管理)
│   │   │       └── utils/             # 工具类
│   │   └── resources/                 # 资源文件
│   └── test/
│       └── java/
│           └── com/vip/pop/test/      # 测试类
├── docs/                              # API 文档
│   ├── WopOuterPoService.md
│   ├── WopBigOrderService.md
│   ├── WopOuterOrderService.md
│   └── ...
├── skills/                            # 技能文档
│   ├── required-annotation.md         # @Required 注解指南
│   └── wop-api-sdk-test.md           # 测试指南
├── jar/                               # 编译后的 JAR 包
│   ├── pop-java-sdk-1.0-SNAPSHOT.jar
│   ├── pop-java-sdk-1.0-SNAPSHOT-javadoc.jar
│   └── pop-java-sdk-1.0-SNAPSHOT-sources.jar
├── pom.xml                            # Maven 配置文件
├── compile.bat                        # Windows 编译脚本
├── build.ps1                          # PowerShell 编译脚本
├── run_build.bat                      # Windows 运行构建脚本
└── README.md                          # 项目说明文档
```

### 核心模块说明

| 模块 | 说明 |
|-----|------|
| `base/annotation` | 注解定义,包括 `@Required` 必填字段注解 |
| `base/validator` | 验证器,提供 `RequiredValidator` 验证必填字段 |
| `base/exception` | SDK 异常类,如 `PopSdkException` |
| `base/model` | 基础模型类,如 `PopBaseRsp`、`PopAppKeyConfig` |
| `factory` | 工厂类,统一管理服务实例 (如 `PopServiceFactory`) |
| `utils` | 工具类,提供 JSON 序列化、日期处理等通用功能 |

---

## 参考文档

- [WOP API SDK 测试指南](skills/wop-api-sdk-test.md) - 测试框架和测试用例编写

---

*文档版本: 1.0.0 | 更新日期: 2026-03-07*
