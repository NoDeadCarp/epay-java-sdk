package cpm.knownniu.epay_spring_boot_starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cpm.knownniu.epay_spring_boot_starter.core.EpayCore;

@Configuration
public class EpayAutoConfiguration {
    
    private final EpayProperties properties;

    public EpayAutoConfiguration(EpayProperties properties) {
        this.properties = properties;
    }

    @Bean
    public EpayCore epayCore() {
        return new EpayCore(properties);
    }
}
