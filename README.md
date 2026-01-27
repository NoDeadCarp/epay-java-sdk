# EPAY-JAVA-SDK
本项目为彩虹易支付添加了Java的SDK支持，基于PHP-SDK v1.2进行迁移

## 使用方法
1. 导入本项目
2. 在application.properties中添加配置
```
epay.pid=1000
epay.key=wix3NN284w4z4A78BXiqLyqb443ZCD7l
epay.apiUrl=http://192.168.102.149/
```
3. 参考以下示例进行开发
```java
    // 测试页面跳转支付
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

    // 测试获取支付链接
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

    // 测试API支付
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

        apiPayResponse ApiPayResponse = epayService.apiPay(request);
        log.info(ApiPayResponse.toString());
    }

    // 测试单订单请求
    @Test
    public void testQueryOrder() {
        queryOrderRequest request = new queryOrderRequest();
        request.setAct("order");
        request.setPid(epayProperties.getPid());
        request.setKey(epayProperties.getKey());
        request.setOut_trade_no("test3");

        queryOrderResponse QueryOrderResponse = epayService.queryOrder(request);
        log.info(QueryOrderResponse.toString());
    }

    // 测试商户信息查询
    @Test
    public void testQueryPidInfo() {
        queryPidInfoRequest request = new queryPidInfoRequest();
        request.setAct("query");
        request.setPid(epayProperties.getPid());
        request.setKey(epayProperties.getKey());

        queryPidInfoResponse QueryPidInfoResponse = epayService.queryPidInfo(request);
        log.info(QueryPidInfoResponse.toString());
    }

    // 测试商户结算查询
    @Test
    public void testQuerySettle() {
        querySettleRequest request = new querySettleRequest();
        request.setAct("settle");
        request.setPid(epayProperties.getPid());
        request.setKey(epayProperties.getKey());

        querySettleResponse QuerySettleResponse = epayService.querySettle(request);
        log.info(QuerySettleResponse.toString());
    }

    // 测试多订单查询
    @Test
    public void testQueryOrders() {
        queryOrdersRequest request = new queryOrdersRequest();
        request.setAct("orders");
        request.setPid(epayProperties.getPid());
        request.setKey(epayProperties.getKey());
        request.setLimit("1");
        request.setPage("1");

        queryOrdersResponse QueryOrdersResponse = epayService.queryOrders(request);
        log.info(QueryOrdersResponse.toString());
    }

    // 测试订单退款
    @Test
    public void testRefund() {
        refundRequest request = new refundRequest();
        request.setAct("refund");
        request.setPid(epayProperties.getPid());
        request.setKey(epayProperties.getKey());
        request.setOut_trade_no("test3");
        request.setMoney("10");

        refundResponse RefundResponse = epayService.refund(request);
        log.info(RefundResponse.toString());
    }
```