package com.woori.wonfit.product.deposit.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class DepositDTO {

    private String depositName;
    private double interestRate;
    private int period;
    private String target;
    private int minDeposit;
    private String depositInfo;
    private String depositType;

    @Builder
    public DepositDTO(String depositName, double interestRate, int period, String target, int minDeposit, String depositInfo, String depositDesc, String depositType) {
        this.depositName = depositName;
        this.interestRate = interestRate;
        this.period = period;
        this.target = target;
        this.minDeposit = minDeposit;
        this.depositInfo = depositInfo;
        this.depositType = depositType;
    }
}
