package com.knownniu.epay.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class refundResponse {
    private Integer code;
    private String msg;
    
    @Override
    public String toString() {
        return "refundResponse [code=" + code + ", msg=" + msg + "]";
    }

}
