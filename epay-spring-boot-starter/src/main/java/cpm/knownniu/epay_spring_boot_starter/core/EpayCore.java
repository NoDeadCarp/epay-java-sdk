package cpm.knownniu.epay_spring_boot_starter.core;

import cpm.knownniu.epay_spring_boot_starter.config.EpayProperties;

public class EpayCore {
    
    private final EpayProperties config;

    public EpayCore(EpayProperties config) {
        this.config = config;
    }

}
