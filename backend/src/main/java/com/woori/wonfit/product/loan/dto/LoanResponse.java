package com.woori.wonfit.product.loan.dto;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {
    private Long id;
    private String loanName;
    private double interestRate;
    private int period;
    private String target;
    private long loanLimit;
    private String loanInfo;
    private String loanDesc;
    private String loanType;
}
