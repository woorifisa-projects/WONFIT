package com.woori.wonfit.member.bank.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankInfo {
    private String bankName;
    private int money;

    public BankInfo(String bankName, int money) {
        this.bankName = bankName;
        this.money = money;
    }
}
