# EPAY Java SDK

本项目为彩虹易支付提供了完整的 Java SDK 支持，基于 PHP-SDK v1.2 进行迁移。

## 项目特点

- ✨ **多模块结构**：分离核心SDK和Spring Boot自动装配
- 🚀 **灵活使用**：支持Spring Boot项目自动装配，也支持纯Java应用
- 📦 **完整功能**：页面支付、API支付、订单查询、退款等功能
- 🔐 **安全可靠**：MD5签名验证，支持异步通知验签
- 📝 **文档完善**：提供详细的使用示例

## 项目结构

```
epay-java-sdk/
├── epay-core/              # 核心SDK模块（无框架依赖）
│   ├── client/            # HTTP客户端接口
│   ├── core/              # 核心功能（签名、加密等）
│   ├── enums/             # 枚举定义
│   ├── pojo/              # 数据对象
│   ├── request/           # 请求对象
│   ├── response/          # 响应对象
│   └── util/              # 工具类
│
└── epay-spring-boot-starter/  # Spring Boot自动装配模块
    └── config/            # 自动配置和属性配置
```

## 快速开始

### Maven导入Jar包

Windows
```powershell
mvnw.cmd install:install-file ^
  -Dfile=yourdir ^
  -DgroupId=com.knownniu ^
  -DartifactId=epay-java-sdk ^
  -Dversion=1.0.0 ^
  -Dpackaging=jar
```

Linux/MacOS
```bash
./mvnw install:install-file \
  -Dfile=yourdir \
  -DgroupId=com.knownniu \
  -DartifactId=epay-spring-boot-starter \
  -Dversion=1.0.0 \
  -Dpackaging=jar
```

### 方式一：Spring Boot 项目

#### 1. 添加依赖

```xml
<dependency>
    <groupId>com.knownniu</groupId>
    <artifactId>epay-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### 2. 配置参数

在 `application.properties` 中添加配置：

```properties
epay.pid=1000
epay.key=wix3NN284w4z4A78BXiqLyqb443ZCD7l
epay.apiUrl=http://192.168.102.149/
```

或在 `application.yml` 中：

```yaml
epay:
  pid: 1000
  key: wix3NN284w4z4A78BXiqLyqb443ZCD7l
  apiUrl: http://192.168.102.149/
```

#### 3. 注入服务使用

```java
@Service
public class PaymentService {
    
    @Autowired
    private EpayService epayService;
    
    public String createPaymentForm(pagePayRequest request) {
        return epayService.pagePay(request, "Pay Now");
    }
}
```

### 方式二：纯 Java 项目

#### 1. 添加依赖

```xml
<dependency>
    <groupId>com.knownniu</groupId>
    <artifactId>epay-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### 2. 手动配置使用

```java
public class PaymentDemo {
    
    public static void main(String[] args) {
        // 配置参数
        EpayProperties config = new EpayProperties();
        config.setPid("1000");
        config.setKey("wix3NN284w4z4A78BXiqLyqb443ZCD7l");
        config.setApiUrl("http://192.168.102.149/");
        
        // 创建核心对象
        EpayCore core = new EpayCore(config);
        
        // 创建HTTP客户端
        EpayClient client = Feign.builder()
            .options(new Request.Options(10, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true))
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(EpayClient.class, config.getApiUrl());
        
        // 创建服务
        EpayService service = new EpayService(core, client);
    }
}
```

## 使用示例

### 1. 页面跳转支付

```java
@Test
public void testPagePay() {
    pagePayRequest request = new pagePayRequest();
    request.setPid(epayProperties.getPid());
    request.setType(PayTypeEnum.ALIPAY.getType());
    request.setOut_trade_no("test1");
    request.setNotify_url("http://www.example.com/notify");
    request.setReturn_url("http://www.example.com/return");
    request.setName("Test Product");
    request.setMoney("10.00");
    request.setParam("test_param");

    String htmlForm = epayService.pagePay(request, "Pay Now");
    log.info("生成的HTML表单:\n{}", htmlForm);
}
```

### 2. 获取支付链接

```java
@Test
public void testGetPayLink() {
    pagePayRequest request = new pagePayRequest();
    request.setPid(epayProperties.getPid());
    request.setType(PayTypeEnum.WXPAY.getType());
    request.setOut_trade_no("test2");
    request.setNotify_url("http://www.example.com/notify");
    request.setReturn_url("http://www.example.com/return");
    request.setName("Test Product");
    request.setMoney("10.00");
    request.setParam("test_param");

    String url = epayService.getPayLink(request);
    log.info(url);
}
```

### 3. API 支付（小程序/APP调用）

```java
@Test
public void testApiPay() {
    apiPayRequest request = new apiPayRequest();
    request.setPid(epayProperties.getPid());
    request.setType(PayTypeEnum.WXPAY.getType());
    request.setOut_trade_no("test3");
    request.setNotify_url("http://www.example.com/notify");
    request.setReturn_url("http://www.example.com/return");
    request.setName("Test Product");
    request.setMoney("10.00");
    request.setParam("test_param");
    request.setClientip("127.0.0.1");
    request.setDevice(DeviceTypeEnum.PC.getType());

    apiPayResponse response = epayService.apiPay(request);
    log.info(response.toString());
}
```

### 4. 查询订单

```java
@Test
public void testQueryOrder() {
    queryOrderRequest request = new queryOrderRequest();
    request.setAct("order");
    request.setPid(epayProperties.getPid());
    request.setKey(epayProperties.getKey());
    request.setOut_trade_no("test3");

    queryOrderResponse response = epayService.queryOrder(request);
    log.info(response.toString());
}
```

### 5. 查询商户信息

```java
@Test
public void testQueryPidInfo() {
    queryPidInfoRequest request = new queryPidInfoRequest();
    request.setAct("query");
    request.setPid(epayProperties.getPid());
    request.setKey(epayProperties.getKey());

    queryPidInfoResponse response = epayService.queryPidInfo(request);
    log.info(response.toString());
}
```

### 6. 订单退款

```java
@Test
public void testRefund() {
    refundRequest request = new refundRequest();
    request.setAct("refund");
    request.setPid(epayProperties.getPid());
    request.setKey(epayProperties.getKey());
    request.setOut_trade_no("test3");
    request.setMoney("10");

    refundResponse response = epayService.refund(request);
    log.info(response.toString());
}
```

## API接口列表

| 功能 | 方法 | 说明 |
|-----|------|------|
| 页面支付 | `pagePay(pagePayRequest, buttonText)` | 生成HTML表单自动跳转 |
| 获取支付链接 | `getPayLink(pagePayRequest)` | 返回支付链接 |
| API支付 | `apiPay(apiPayRequest)` | 返回JSON格式的支付信息 |
| 查询订单 | `queryOrder(queryOrderRequest)` | 查询单个订单状态 |
| 批量查询订单 | `queryOrders(queryOrdersRequest)` | 分页查询订单 |
| 查询商户信息 | `queryPidInfo(queryPidInfoRequest)` | 获取商户账户信息 |
| 查询结算 | `querySettle(querySettleRequest)` | 查询结算记录 |
| 退款 | `refund(refundRequest)` | 订单退款操作 |
| 验证通知 | `verifyNotify(notifyRequest)` | 验证支付回调签名 |