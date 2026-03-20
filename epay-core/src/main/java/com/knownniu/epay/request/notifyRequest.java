package com.knownniu.epay.request;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class notifyRequest {
    
    private Integer pid;
    private String trade_no;
    private String out_trade_no;
    private String type;
    private String name;
    private String money;
    private String trade_status;
    private String param;
    private String sign;
    private String sign_type;

    public TreeMap<String, Object> toMap() {
        TreeMap<String, Object> params = new TreeMap<>();

        if (pid != null) params.put("pid", pid);
        if (type != null) params.put("type", type);
        if (trade_no != null) params.put("trade_no", trade_no);
        if (name != null) params.put("name", name);
        if (money != null) params.put("money", money);
        if (param != null) params.put("param", param);
        if (sign != null) params.put("sign", sign);
        if (sign_type != null) params.put("sign_type", sign_type);
        if (trade_status != null) params.put("trade_status", trade_status);
        if (out_trade_no != null) params.put("out_trade_no", out_trade_no);

        return params;
    }
}
