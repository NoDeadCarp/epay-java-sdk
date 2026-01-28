package com.knownniu.epay.request;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class queryOrderRequest {

    private String act;
    private String pid;
    private String key;
    private String trade_no;
    private String out_trade_no;

    public TreeMap<String, String> toMap() {
        TreeMap<String, String> params = new TreeMap<>();

        if (act != null) params.put("act", act);
        if (pid != null) params.put("pid", pid);
        if (key != null) params.put("key", key);
        if (trade_no != null) params.put("trade_no", trade_no);
        if (out_trade_no != null) params.put("out_trade_no", out_trade_no);

        return params;
    }
}
