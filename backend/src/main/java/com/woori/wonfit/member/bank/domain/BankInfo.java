package com.woori.wonfit.member.bank.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonSerialize(using = BankInfoSerializer.class)
public class BankInfo {
    private String bankName;
    private int money;

    public BankInfo(String bankName, int money) {
        this.bankName = bankName;
        this.money = money;
    }
}
