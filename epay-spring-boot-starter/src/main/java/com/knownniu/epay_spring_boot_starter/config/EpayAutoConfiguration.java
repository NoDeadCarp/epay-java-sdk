package com.knownniu.epay_spring_boot_starter.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.knownniu.epay_spring_boot_starter.client.EpayClient;
import com.knownniu.epay_spring_boot_starter.core.EpayCore;
import com.knownniu.epay_spring_boot_starter.service.EpayService;

import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class EpayAutoConfiguration {

    private final EpayProperties properties;

    public EpayAutoConfiguration(EpayProperties properties) {
        this.properties = properties;
    }

    @Bean
    public EpayService epayService(){
        // 内部 new Core，注入配置
        EpayCore core = new EpayCore(properties);
        EpayClient epayClient =  Feign.builder()
                //设置连接和读超时间都是10s
                .options(new Request.Options(10,TimeUnit.SECONDS,10,TimeUnit.SECONDS,true))
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(EpayClient.class,properties.getApiUrl());
        return new EpayService(core,epayClient);
    }
}
