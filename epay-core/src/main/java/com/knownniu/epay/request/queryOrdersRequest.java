package com.knownniu.epay.request;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class queryOrdersRequest {

    private String act;
    private String pid;
    private String key;
    private String limit;
    private String page;

    public TreeMap<String, String> toMap() {
        TreeMap<String, String> params = new TreeMap<>();

        if (act != null) params.put("act", act);
        if (pid != null) params.put("pid", pid);
        if (key != null) params.put("key", key);
        if (limit != null) params.put("limit", limit);
        if (page != null) params.put("page", page);

        return params;
    }
    
}
