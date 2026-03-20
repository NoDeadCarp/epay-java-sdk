package com.knownniu.epay.request;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class querySettleRequest {

    private String act;
    private Integer pid;
    private String key;

    public TreeMap<String, Object> toMap() {
        TreeMap<String, Object> params = new TreeMap<>();

        if (act != null) params.put("act", act);
        if (pid != null) params.put("pid", pid);
        if (key != null) params.put("key", key);

        return params;
    }
    
}
