package com.knownniu.epay_spring_boot_starter.response;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class apiPayResponse {

    private Integer code;
    private String msg;
    private String trade_no;
    private String payurl;
    private String qrcode;
    private String urlscheme;

    @Override
    public String toString() {
        return "apiPayResponse [code=" + code + ", msg=" + msg + ", trade_no=" + trade_no + ", payurl=" + payurl
                + ", qrcode=" + qrcode + ", urlscheme=" + urlscheme + "]";
    }
    
}
