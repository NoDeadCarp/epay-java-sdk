package com.knownniu.epay_spring_boot_starter.enums;

public enum DeviceTypeEnum {
    PC("pc","电脑浏览器"),
    MOBILE("mobile","手机浏览器"),
    QQ("qq","手机QQ内浏览器"),
    WECHAT("wechat","微信内浏览器"),
    ALIPAY("alipay","支付宝客户端");

    private final String type;
    private final String desc;

    DeviceTypeEnum(String type,String desc){
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
