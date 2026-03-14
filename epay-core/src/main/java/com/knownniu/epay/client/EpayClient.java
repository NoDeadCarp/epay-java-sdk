package com.knownniu.epay.client;

import java.util.Map;

import com.knownniu.epay.response.apiPayResponse;
import com.knownniu.epay.response.queryOrderResponse;
import com.knownniu.epay.response.queryOrdersResponse;
import com.knownniu.epay.response.queryPidInfoResponse;
import com.knownniu.epay.response.querySettleResponse;
import com.knownniu.epay.response.refundResponse;

import feign.*;


public interface EpayClient {

    @RequestLine("POST /mapi.php")
    @Headers("Accept: text/html;charset=utf-8")
    @Body("{body}")
    apiPayResponse pay(@Param("body") String body);

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
