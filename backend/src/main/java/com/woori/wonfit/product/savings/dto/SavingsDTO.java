package com.woori.wonfit.product.savings.dto;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
public class SavingsDTO {

    private String savingsName;
    private double interestRate;
    private int period;
    private String target;
    private int maxDeposit;
    private String savingsInfo;
    private String savingsDesc;
    private String savingsType;

    public SavingsDTO(String savingsName, double interestRate, int period, String target, int maxDeposit, String savingsInfo, String savingsDesc, String savingsType) {
        this.savingsName = savingsName;
        this.interestRate = interestRate;
        this.period = period;
        this.target = target;
        this.maxDeposit = maxDeposit;
        this.savingsInfo = savingsInfo;
        this.savingsDesc = savingsDesc;
        this.savingsType = savingsType;
    }
}
