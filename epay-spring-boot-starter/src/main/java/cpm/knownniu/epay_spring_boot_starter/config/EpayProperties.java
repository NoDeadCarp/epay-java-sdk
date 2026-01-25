package cpm.knownniu.epay_spring_boot_starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "epay")
public class EpayProperties {
    private String pid;
    private String key;
    private String apiUrl;

    // 生成不同接口 URL
    public String getSubmitUrl() {
        return apiUrl + "submit.php";
    }

    public String getMapiUrl() {
        return apiUrl + "mapi.php";
    }

    public String getApiUrl() {
        return apiUrl + "api.php";
    }
}
