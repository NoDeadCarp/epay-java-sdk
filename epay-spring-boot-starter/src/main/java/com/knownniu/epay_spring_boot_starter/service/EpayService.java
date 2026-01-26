package com.knownniu.epay_spring_boot_starter.service;

import java.util.Map;
import java.util.TreeMap;

import com.knownniu.epay_spring_boot_starter.core.EpayCore;
import com.knownniu.epay_spring_boot_starter.request.pagePayRequest;
import com.knownniu.epay_spring_boot_starter.response.apiPayResponse;
import com.knownniu.epay_spring_boot_starter.request.apiPayRequest;

public class EpayService {

    private final EpayCore core;

    public EpayService(EpayCore core) {
        this.core = core;
    }

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

    public String getPayLink(pagePayRequest request) {
        TreeMap<String, String> params = request.toMap();
        params = core.buildRequestParam(params);

        StringBuffer url = new StringBuffer();
        url.append(core.getSubmitUrl());
        url.append("?");
        url.append(core.buildRequestURLParam(params));
        return url.toString();
    }

    public apiPayResponse apiPay(apiPayRequest request) {

    }
}
