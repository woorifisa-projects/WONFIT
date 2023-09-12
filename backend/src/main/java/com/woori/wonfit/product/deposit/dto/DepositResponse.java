package com.woori.wonfit.product.deposit.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositResponse {

    private Long id;
    private String depositName;
    private double interestRate;
    private int period;
    private String target;
    private int minDeposit;
    private String depositInfo;
    private String depositType;

}

