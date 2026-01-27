package com.knownniu.epay_spring_boot_starter.request;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class refundRequest {

    private String pid;
    private String key;
    private String act;
    private String trade_no;
    private String out_trade_no;
    private String money;

    public TreeMap<String, String> toMap() {
        TreeMap<String, String> params = new TreeMap<>();

        if (pid != null) params.put("pid", pid);
        if (key != null) params.put("key", key);
        if (act != null) params.put("act", act);
        if (trade_no != null) params.put("trade_no", trade_no);
        if (out_trade_no != null) params.put("out_trade_no", out_trade_no);
        if (money != null) params.put("money", money);

        return params;
    }

}
