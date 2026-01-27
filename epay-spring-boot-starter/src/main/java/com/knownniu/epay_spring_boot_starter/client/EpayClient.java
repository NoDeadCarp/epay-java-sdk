package com.knownniu.epay_spring_boot_starter.client;

import java.util.Map;

import com.knownniu.epay_spring_boot_starter.response.apiPayResponse;
import com.knownniu.epay_spring_boot_starter.response.queryOrderResponse;
import com.knownniu.epay_spring_boot_starter.response.queryOrdersResponse;
import com.knownniu.epay_spring_boot_starter.response.queryPidInfoResponse;
import com.knownniu.epay_spring_boot_starter.response.querySettleResponse;
import com.knownniu.epay_spring_boot_starter.response.refundResponse;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;


public interface EpayClient {

    @RequestLine("POST /mapi.php")
    @Headers("Accept: text/html;charset=utf-8")
    apiPayResponse pay(@QueryMap Map<String, String> params);

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    queryOrderResponse queryOrder(@QueryMap Map<String, String> params);

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    queryOrdersResponse queryOrders(@QueryMap Map<String, String> params);

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    queryPidInfoResponse queryPidInfo(@QueryMap Map<String, String> params);

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    querySettleResponse querySettle(@QueryMap Map<String, String> params);

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    refundResponse refund(@QueryMap Map<String, String> params);
}
