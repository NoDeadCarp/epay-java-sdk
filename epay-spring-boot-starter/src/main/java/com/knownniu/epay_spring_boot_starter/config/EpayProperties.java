package com.knownniu.epay_spring_boot_starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * EPAY Spring Boot配置类 - 对应核心配置属性的包装类
 */
@Data
@ConfigurationProperties(prefix = "epay")
public class EpayProperties {
    private String pid;
    private String key;
    private String apiUrl;
}


