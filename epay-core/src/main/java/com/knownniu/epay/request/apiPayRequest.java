package com.knownniu.epay.request;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class apiPayRequest {

    private Integer pid;
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

    public TreeMap<String, Object> toMap() {
        TreeMap<String, Object> params = new TreeMap<>();

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
