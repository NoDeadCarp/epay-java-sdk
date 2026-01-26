package com.knownniu.epay_spring_boot_starter.response;

import lombok.Data;

@Data
public class apiPayResponse {
    
    private Integer code;
    private String msg;
    private String trade_no;
    private String payurl;
    private String qrcode;
    private String urlscheme;

}
