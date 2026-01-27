package com.knownniu.epay_spring_boot_starter.response;

import java.util.Arrays;

import com.knownniu.epay_spring_boot_starter.pojo.Settle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class querySettleResponse {

    private Integer code;
    private String msg;
    private Settle[] data;

    @Override
    public String toString() {
        return "querySettleResponse [code=" + code + ", msg=" + msg + ", data=" + Arrays.toString(data) + "]";
    }

}