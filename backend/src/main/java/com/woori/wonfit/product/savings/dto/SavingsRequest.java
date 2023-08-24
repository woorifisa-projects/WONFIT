package com.woori.wonfit.product.savings.dto;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SavingsRequest {

    private Long id;
    private String savingsName;
    private double interestRate;
    private int period;
    private String target;
    private int maxDeposit;
    private String savingsInfo;
    private String savingsDesc;
    private String sortingOptions;

}
