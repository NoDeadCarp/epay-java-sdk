package com.knownniu.epay_spring_boot_starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.knownniu.epay_spring_boot_starter.core.EpayCore;
import com.knownniu.epay_spring_boot_starter.service.EpayService;

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
        return new EpayService(core);
    }
}
