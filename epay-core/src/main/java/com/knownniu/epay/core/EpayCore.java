package com.knownniu.epay.core;

import java.util.Map;
import java.util.TreeMap;

import com.knownniu.epay.config.EpayProperties;
import com.knownniu.epay.util.php_md5;
import com.knownniu.epay.util.http_build_query;

public class EpayCore {
    
    private final EpayProperties config;
    private final String signType = "MD5";

    public EpayCore(EpayProperties config) {
        this.config = config;
    }

    public String getSubmitUrl() {
        return config.getApiUrl() + "/submit.php";
    }

    public String getMapiUrl() {
        return config.getApiUrl() + "/mapi.php";
    }

    public String getApiUrl() {
        return config.getApiUrl() + "/api.php";
    }

    private String getSign(Map<String, Object> params, String key) {
       //  key的ASCII字符串顺序
       TreeMap<String, Object> sorted = new TreeMap<>(params);

       StringBuilder signStr = new StringBuilder();

       for (Map.Entry<String, Object> entry : sorted.entrySet()) {
           String k = entry.getKey();
           String v = entry.getValue().toString();

           if ("sign".equals(k) || "sign_type".equals(k)) {
               continue;
           }

           // PHP中：null != '' 为 false，所以 null 也要排除
           if (v == null || v.equals("")) {
               continue;
           }

           signStr.append(k)
                   .append("=")
                   .append(v)
                   .append("&");
       }

       if (signStr.length() > 0) {
           signStr.deleteCharAt(signStr.length() - 1);
       }

       // 拼接KEY不是&key=
       signStr.append(key);

       return php_md5.md5(signStr.toString());
   }

   public TreeMap<String, Object> buildRequestParam(TreeMap<String, Object> param) {
        String mySign = getSign(param, config.getKey());
        TreeMap<String, Object> result = new TreeMap<>(param);
        result.put("sign", mySign);
        result.put("sign_type", signType);
        return result;
    }
    
    public String buildRequestURLParam(Map<String, Object> params) {
        return http_build_query.encode(params);
    }

}
