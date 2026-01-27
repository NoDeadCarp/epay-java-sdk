package com.knownniu.epay_spring_boot_starter.request;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class querySettleRequest {

    private String act;
    private String pid;
    private String key;

    public TreeMap<String, String> toMap() {
        TreeMap<String, String> params = new TreeMap<>();

        if (act != null) params.put("act", act);
        if (pid != null) params.put("pid", pid);
        if (key != null) params.put("key", key);

        return params;
    }
    
}
