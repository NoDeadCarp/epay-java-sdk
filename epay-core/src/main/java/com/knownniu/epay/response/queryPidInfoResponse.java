package com.knownniu.epay.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class queryPidInfoResponse {

    private Integer code;
    private Integer pid;
    private String key;
    private Integer active;
    private String money;
    private Integer type;
    private String account;
    private String username;
    private Integer orders;
    private Integer order_today;
    private Integer order_lastday;

    @Override
    public String toString() {
        return "queryPidInfoRequest [code=" + code + ", pid=" + pid + ", key=" + key + ", active=" + active + ", money="
                + money + ", type=" + type + ", account=" + account + ", username=" + username + ", orders=" + orders
                + ", order_today=" + order_today + ", order_lastday=" + order_lastday + "]";
    }

}
