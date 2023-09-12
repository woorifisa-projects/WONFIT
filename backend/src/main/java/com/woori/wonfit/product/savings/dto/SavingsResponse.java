package com.woori.wonfit.product.savings.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SavingsResponse {

    private Long id;
    private String savingsName;
    private double interestRate;
    private int period;
    private String target;
    private int maxDeposit;
    private String savingsInfo;
    private String savingsType;

}
