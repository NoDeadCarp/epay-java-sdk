package com.knownniu.epay.enums;

public enum PayTypeEnum {
    ALIPAY("alipay","支付宝"),
    QQPAY("qqpay","QQ钱包"),
    WXPAY("wxpay","微信支付");

    private final String type;
    private final String desc;

    PayTypeEnum(String type,String desc){
        this.type = type;
        this.desc = desc;
    }

    public String getType(){
        return type;
    }

    public String getDesc(){
        return desc;
    }
}
