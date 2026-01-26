package com.knownniu.epay_spring_boot_starter.client;

import java.util.Map;

import com.knownniu.epay_spring_boot_starter.response.apiPayResponse;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;


public interface EpayClient {

    @RequestLine("POST /mapi.php")
    @Headers("Accept: text/html;charset=utf-8")
    apiPayResponse pay(@QueryMap Map<String, String> params);

}
