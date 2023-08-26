package com.woori.wonfit.product.loan.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanRequest {

    private Long id;
    private String loanName;
    private double interestRate;
    private int period;

}
