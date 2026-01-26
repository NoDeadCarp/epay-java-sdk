package com.knownniu.epay_spring_boot_starter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.knownniu.epay_spring_boot_starter.request.apiPayRequest;
import com.knownniu.epay_spring_boot_starter.request.pagePayRequest;

@SpringBootTest
public class EpayServiceTest {

    private static final Logger log = LoggerFactory.getLogger(EpayServiceTest.class);

    @Autowired
    private EpayService epayService;

    @Test
    public void testPagePay() {
        pagePayRequest request = new pagePayRequest();
        request.setPid("1000");
        request.setType("alipay");
        request.setOut_trade_no("TEST123456");
        request.setNotify_url("http://www.example.com/notify");
        request.setReturn_url("http://www.example.com/return");
        request.setName("Test Product");
        request.setMoney("10.00");
        request.setParam("test_param");
        request.setSign("test_sign");
        request.setSign_type("MD5");

        String htmlForm = epayService.pagePay(request, "Pay Now");
        log.info("生成的HTML表单:\n{}", htmlForm);
    }

    @Test
    public void testGetPayLink() {
        apiPayRequest request = new apiPayRequest();
        request.setPid("1000");
        request.setType("alipay");
        request.setOut_trade_no("TEST123456");
        request.setNotify_url("http://www.example.com/notify");
        request.setReturn_url("http://www.example.com/return");
        request.setName("Test Product");
        request.setMoney("10.00");
        request.setParam("test_param");
        request.setSign("test_sign");
        request.setSign_type("MD5");
        request.setClientip("127.0.0.1");
        request.setDevice("OnePlus");

        String url = epayService.getPayLink(request);
        log.info(url);
    }
}
