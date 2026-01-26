package com.knownniu.epay_spring_boot_starter.request;

import java.util.TreeMap;

import lombok.Data;

@Data
public class apiPayRequest {
    private String pid;
    private String type;
    private String out_trade_no;
    private String notify_url;
    private String return_url;
    private String name;
    private String money;
    private String param;
    private String sign;
    private String sign_type;
    private String clientip;
    private String device;

    public apiPayRequest(){

    }

    public apiPayRequest(String pid, String type, String out_trade_no, String notify_url, String return_url, String name, String money, String param, String sign, String sign_type, String clientip, String device) {
        this.pid = pid;
        this.type = type;
        this.out_trade_no = out_trade_no;
        this.notify_url = notify_url;
        this.return_url = return_url;
        this.name = name;
        this.money = money;
        this.param = param;
        this.sign = sign;
        this.sign_type = sign_type;
        this.clientip = clientip;
        this.device = device;
    }

    public TreeMap<String, String> toMap() {
        TreeMap<String, String> params = new TreeMap<>();

        if (pid != null) params.put("pid", pid);
        if (type != null) params.put("type", type);
        if (out_trade_no != null) params.put("out_trade_no", out_trade_no);
        if (notify_url != null) params.put("notify_url", notify_url);
        if (return_url != null) params.put("return_url", return_url);
        if (name != null) params.put("name", name);
        if (money != null) params.put("money", money);
        if (param != null) params.put("param", param);
        if (sign != null) params.put("sign", sign);
        if (sign_type != null) params.put("sign_type", sign_type);
        if (clientip != null) params.put("clientip", clientip);
        if (device != null) params.put("device", device);

        return params;
    }
}
