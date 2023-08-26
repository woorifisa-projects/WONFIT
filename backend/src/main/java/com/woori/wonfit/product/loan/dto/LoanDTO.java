package com.woori.wonfit.product.loan.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
public class LoanDTO {

    private String loanName;
    private double interestRate;
    private int period;
    private String target;
    private long loanLimit;
    private String loanInfo;
    private String loanDesc;
    private String loanType;

    public LoanDTO(String loanName, double interestRate, int period, String target, long loanLimit, String loanInfo, String loanDesc, String loanType) {
        this.loanName = loanName;
        this.interestRate = interestRate;
        this.period = period;
        this.target = target;
        this.loanLimit = loanLimit;
        this.loanInfo = loanInfo;
        this.loanDesc = loanDesc;
        this.loanType = loanType;
    }
}
