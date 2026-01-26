package com.knownniu.epay_spring_boot_starter.core;

import java.util.Map;
import java.util.TreeMap;

import com.knownniu.epay_spring_boot_starter.config.EpayProperties;
import com.knownniu.epay_spring_boot_starter.util.php_md5;
import com.knownniu.epay_spring_boot_starter.util.http_build_query;

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

    private String getSign(Map<String, String> params, String key) {
       //  key的ASCII字符串顺序
       TreeMap<String, String> sorted = new TreeMap<>(params);

       StringBuilder signStr = new StringBuilder();

       for (Map.Entry<String, String> entry : sorted.entrySet()) {
           String k = entry.getKey();
           String v = entry.getValue();

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

   public TreeMap<String, String> buildRequestParam(TreeMap<String, String> param) {
        String mySign = getSign(param, config.getKey());
        TreeMap<String, String> result = new TreeMap<>(param);
        result.put("sign", mySign);
        result.put("sign_type", signType);
        return result;
    }
    
    public String buildRequestURLParam(Map<String, String> params) {
        return http_build_query.encode(params);
    }

}
