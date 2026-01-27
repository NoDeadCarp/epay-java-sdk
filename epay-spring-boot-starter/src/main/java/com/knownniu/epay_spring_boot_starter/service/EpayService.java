package com.knownniu.epay_spring_boot_starter.service;

import java.util.Map;
import java.util.TreeMap;

import javax.print.DocFlavor.READER;

import com.knownniu.epay_spring_boot_starter.client.EpayClient;
import com.knownniu.epay_spring_boot_starter.core.EpayCore;
import com.knownniu.epay_spring_boot_starter.request.pagePayRequest;
import com.knownniu.epay_spring_boot_starter.request.queryOrderRequest;
import com.knownniu.epay_spring_boot_starter.request.queryOrdersRequest;
import com.knownniu.epay_spring_boot_starter.request.queryPidInfoRequest;
import com.knownniu.epay_spring_boot_starter.request.querySettleRequest;
import com.knownniu.epay_spring_boot_starter.request.refundRequest;
import com.knownniu.epay_spring_boot_starter.response.apiPayResponse;
import com.knownniu.epay_spring_boot_starter.response.queryOrderResponse;
import com.knownniu.epay_spring_boot_starter.response.queryOrdersResponse;
import com.knownniu.epay_spring_boot_starter.response.queryPidInfoResponse;
import com.knownniu.epay_spring_boot_starter.response.querySettleResponse;
import com.knownniu.epay_spring_boot_starter.response.refundResponse;
import com.knownniu.epay_spring_boot_starter.request.apiPayRequest;

public class EpayService {

    private final EpayCore core;
    private final EpayClient client;

    public EpayService(EpayCore core,EpayClient client) {
        this.core = core;
        this.client = client;
    }

    // 页面支付，返回HTML自动跳转页面
    public String pagePay(pagePayRequest request,String buttonText) {
        // 把DTO转成TreeMap 参数
        TreeMap<String, String> params = request.toMap();

        // query 参数签名并加入 sign、sign_type
        params = core.buildRequestParam(params);

        // 拼接HTML表单
        StringBuilder html = new StringBuilder();
        html.append("<form id='dopay' action='")
            .append(core.getSubmitUrl())
            .append("' method='post'>");

        for (Map.Entry<String, String> entry : params.entrySet()) {
            html.append("<input type='hidden' name='")
                .append(entry.getKey())
                .append("' value='")
                .append(entry.getValue())
                .append("'/>");
        }

        html.append("<input type='submit' value='")
            .append(buttonText)
            .append("'>")
            .append("</form>");

        // 自动提交 JS
        html.append("<script>document.getElementById('dopay').submit();</script>");

        return html.toString();

    }

    // 获取支付链接
    public String getPayLink(pagePayRequest request) {
        TreeMap<String, String> params = request.toMap();
        params = core.buildRequestParam(params);

        StringBuffer url = new StringBuffer();
        url.append(core.getSubmitUrl());
        url.append("?");
        url.append(core.buildRequestURLParam(params));
        return url.toString();
    }

    // API支付（小程序APP调用）
    public apiPayResponse apiPay(apiPayRequest request) {
        TreeMap<String, String> params = request.toMap();
        params = core.buildRequestParam(params);
        apiPayResponse ApiPayResponse = client.pay(params);
        return ApiPayResponse;
    }

    // 查询单个订单
    public queryOrderResponse queryOrder(queryOrderRequest request) {
        TreeMap<String, String> params = request.toMap();
        queryOrderResponse QueryOrderResponse = client.queryOrder(params);
        return QueryOrderResponse;
    }

    // 查询商户信息
    public queryPidInfoResponse queryPidInfo(queryPidInfoRequest request) {
        TreeMap<String, String> params = request.toMap();
        queryPidInfoResponse QueryPidInfoResponse = client.queryPidInfo(params);
        return QueryPidInfoResponse;
    }

    // 查询结算记录
    public querySettleResponse querySettle(querySettleRequest request) {
        TreeMap<String, String> params = request.toMap();
        querySettleResponse QuerySettleResponse = client.querySettle(params);
        return QuerySettleResponse;
    }

    // 批量查询订单
    public queryOrdersResponse queryOrders(queryOrdersRequest request) {
        TreeMap<String, String> params = request.toMap();
        queryOrdersResponse QueryOrdersResponse = client.queryOrders(params);
        return QueryOrdersResponse;
    }

    // 订单退款
    public refundResponse refund(refundRequest request) {
        TreeMap<String, String> params = request.toMap();
        refundResponse RefundResponse = client.refund(params);
        return RefundResponse;
    }
}
