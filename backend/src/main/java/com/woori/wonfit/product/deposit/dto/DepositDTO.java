package com.woori.wonfit.product.deposit.dto;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositDTO {

    private String depositName;
    private double interestRate;
    private int period;
    private String target;
    private int minDeposit;
    private String depositInfo;
    private String depositType;
}
