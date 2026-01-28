package com.knownniu.epay.config;

import lombok.Data;

/**
 * EPAY配置类（不依赖Spring框架）
 */
@Data
public class EpayProperties {
    private String pid;
    private String key;
    private String apiUrl;
}
