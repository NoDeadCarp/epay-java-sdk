package com.knownniu.epay_spring_boot_starter.response;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class queryOrdersResponse {

    private Integer code;
    private String msg;
    private Integer count;
    private queryOrderResponse[] data;

    @Override
    public String toString() {
        return "queryOrdersResponse [code=" + code + ", msg=" + msg + ", count=" + count + ", data="
                + Arrays.toString(data) + "]";
    }

}
