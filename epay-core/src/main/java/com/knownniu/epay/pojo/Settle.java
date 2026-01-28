package com.knownniu.epay.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settle {

    private String id;
    private String uid;
    private String batch;
    private String auto;
    private String type;
    private String account;
    private String username;
    private String money;
    private String realmoney;
    private String addtime;
    private String endtime;
    private String status;
    private String transfer_status;
    private String transfer_result;
    private String transfer_date;
    private String result;

}
