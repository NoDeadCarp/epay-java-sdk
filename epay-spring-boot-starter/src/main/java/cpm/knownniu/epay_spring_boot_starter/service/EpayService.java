package cpm.knownniu.epay_spring_boot_starter.service;

import cpm.knownniu.epay_spring_boot_starter.config.EpayProperties;
import cpm.knownniu.epay_spring_boot_starter.core.EpayCore;

public class EpayService {

    private final EpayCore core;
    private final EpayProperties properties;

    public EpayService(EpayCore core,EpayProperties properties) {
        this.core = core;
        this.properties = properties;
    }

    

}
