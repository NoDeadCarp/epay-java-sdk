package cpm.knownniu.epay_spring_boot_starter.core;

import java.util.Map;
import java.util.TreeMap;

import cpm.knownniu.epay_spring_boot_starter.config.EpayProperties;
import cpm.knownniu.epay_spring_boot_starter.util.php_md5;

public class EpayCore {
    
    private final EpayProperties config;

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

    public String getSign(Map<String, String> params, String key) {
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
    
}
