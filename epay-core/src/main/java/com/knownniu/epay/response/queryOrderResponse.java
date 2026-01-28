package com.knownniu.epay.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class queryOrderResponse {
    
    private Integer code;
    private String msg;
    private String trade_no;
    private String out_trade_no;
    private String type;
    private Integer pid;
    private String addtime;
    private String endtime;
    private String name;
    private String money;
    private Integer status;
    private String param;
    private String buyer;

    @Override
    public String toString() {
        return "queryOrderResponse [code=" + code + ", msg=" + msg + ", trade_no=" + trade_no + ", out_trade_no="
                + out_trade_no + ", type=" + type + ", pid=" + pid + ", addtime=" + addtime + ", endtime=" + endtime
                + ", name=" + name + ", money=" + money + ", status=" + status + ", param=" + param + ", buyer=" + buyer
                + "]";
    }
    
}
