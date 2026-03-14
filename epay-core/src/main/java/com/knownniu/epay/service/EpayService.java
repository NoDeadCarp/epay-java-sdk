package com.knownniu.epay.service;

import java.util.Map;
import java.util.TreeMap;

import com.knownniu.epay.client.EpayClient;
import com.knownniu.epay.core.EpayCore;
import com.knownniu.epay.request.pagePayRequest;
import com.knownniu.epay.request.queryOrderRequest;
import com.knownniu.epay.request.queryOrdersRequest;
import com.knownniu.epay.request.queryPidInfoRequest;
import com.knownniu.epay.request.querySettleRequest;
import com.knownniu.epay.request.refundRequest;
import com.knownniu.epay.response.apiPayResponse;
import com.knownniu.epay.response.queryOrderResponse;
import com.knownniu.epay.response.queryOrdersResponse;
import com.knownniu.epay.response.queryPidInfoResponse;
import com.knownniu.epay.response.querySettleResponse;
import com.knownniu.epay.response.refundResponse;
import com.knownniu.epay.request.apiPayRequest;
import com.knownniu.epay.request.notifyRequest;

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
        String params_url = core.buildRequestURLParam(params);
        apiPayResponse ApiPayResponse = client.pay(params_url);
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

    // 同步/异步通知验签
    public boolean verifyNotify(notifyRequest request) {
        TreeMap<String, String> params = request.toMap();
        params = core.buildRequestParam(params);
        if(request.getSign().equals(params.get("sign"))) return true;
        return false;
    }
}
