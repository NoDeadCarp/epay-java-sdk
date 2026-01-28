package com.knownniu.epay_spring_boot_starter.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.knownniu.epay.client.EpayClient;
import com.knownniu.epay.core.EpayCore;
import com.knownniu.epay.service.EpayService;

import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
@EnableConfigurationProperties(EpayProperties.class)
public class EpayAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public EpayService epayService(EpayProperties properties) {
        // 创建核心配置对象 - 将Spring Boot配置转换为核心配置
        com.knownniu.epay.config.EpayProperties coreProperties = 
            new com.knownniu.epay.config.EpayProperties();
        coreProperties.setPid(properties.getPid());
        coreProperties.setKey(properties.getKey());
        coreProperties.setApiUrl(properties.getApiUrl());
        
        // 创建EpayCore
        EpayCore core = new EpayCore(coreProperties);
        
        // 创建HTTP客户端
        EpayClient epayClient = Feign.builder()
                //设置连接和读超时间都是10s
                .options(new Request.Options(10, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true))
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(EpayClient.class, properties.getApiUrl());
        
        return new EpayService(core, epayClient);
    }
}
