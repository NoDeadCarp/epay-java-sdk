package com.knownniu.epay_spring_boot_starter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.knownniu.epay_spring_boot_starter.config.EpayProperties;
import com.knownniu.epay_spring_boot_starter.request.apiPayRequest;
import com.knownniu.epay_spring_boot_starter.request.pagePayRequest;
import com.knownniu.epay_spring_boot_starter.request.queryOrderRequest;
import com.knownniu.epay_spring_boot_starter.request.queryOrdersRequest;
import com.knownniu.epay_spring_boot_starter.request.queryPidInfoRequest;
import com.knownniu.epay_spring_boot_starter.request.querySettleRequest;
import com.knownniu.epay_spring_boot_starter.response.apiPayResponse;
import com.knownniu.epay_spring_boot_starter.response.queryOrderResponse;
import com.knownniu.epay_spring_boot_starter.response.queryOrdersResponse;
import com.knownniu.epay_spring_boot_starter.response.queryPidInfoResponse;
import com.knownniu.epay_spring_boot_starter.response.querySettleResponse;

@SpringBootTest
public class EpayServiceTest {

    private static final Logger log = LoggerFactory.getLogger(EpayServiceTest.class);

    @Autowired
    private EpayService epayService;
    @Autowired
    private EpayProperties epayProperties;

    @Test
    public void testPagePay() {
        pagePayRequest request = new pagePayRequest();
        request.setPid(epayProperties.getPid());
        request.setType("alipay");
        request.setOut_trade_no("test1");
        request.setNotify_url("http://www.example.com/notify");
        request.setReturn_url("http://www.example.com/return");
        request.setName("Test Product");
        request.setMoney("10.00");
        request.setParam("test_param");

        String htmlForm = epayService.pagePay(request, "Pay Now");
        log.info("生成的HTML表单:\n{}", htmlForm);
    }

    @Test
    public void testGetPayLink() {
        pagePayRequest request = new pagePayRequest();
        request.setPid(epayProperties.getPid());
        request.setType("wxpay");
        request.setOut_trade_no("test2");
        request.setNotify_url("http://www.example.com/notify");
        request.setReturn_url("http://www.example.com/return");
        request.setName("Test Product");
        request.setMoney("10.00");
        request.setParam("test_param");

        String url = epayService.getPayLink(request);
        log.info(url);
    }

    @Test
    public void testApiPay() {
        apiPayRequest request = new apiPayRequest();
        request.setPid(epayProperties.getPid());
        request.setType("wxpay");
        request.setOut_trade_no("test3");
        request.setNotify_url("http://www.example.com/notify");
        request.setReturn_url("http://www.example.com/return");
        request.setName("Test Product");
        request.setMoney("10.00");
        request.setParam("test_param");
        request.setClientip("127.0.0.1");
        request.setDevice("pc");

        apiPayResponse ApiPayResponse = epayService.apiPay(request);
        log.info(ApiPayResponse.toString());
    }

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

    @Test
    public void testQueryPidInfo() {
        queryPidInfoRequest request = new queryPidInfoRequest();
        request.setAct("query");
        request.setPid(epayProperties.getPid());
        request.setKey(epayProperties.getKey());

        queryPidInfoResponse QueryPidInfoResponse = epayService.queryPidInfo(request);
        log.info(QueryPidInfoResponse.toString());
    }

    @Test
    public void testQuerySettle() {
        querySettleRequest request = new querySettleRequest();
        request.setAct("settle");
        request.setPid(epayProperties.getPid());
        request.setKey(epayProperties.getKey());

        querySettleResponse QuerySettleResponse = epayService.querySettle(request);
        log.info(QuerySettleResponse.toString());
    }

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
}
