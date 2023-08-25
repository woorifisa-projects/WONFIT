package com.woori.wonfit.manager.dto;

import com.woori.wonfit.product.loan.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoanRequest {
    private Long id;
    private String loanName;
    private double interestRate;
    private int period;
    private String target;
    private long loanLimit;
    private String loanInfo;
    private String loanDesc;

    @Builder
    public LoanRequest(String loanName, double interestRate, int period, String target, long loanLimit, String loanInfo, String loanDesc){
        this.loanName = loanName;
        this.interestRate = interestRate;
        this.period = period;
        this.target = target;
        this.loanLimit = loanLimit;
        this.loanInfo = loanInfo;
        this.loanDesc = loanDesc;
    }
    public static Loan toLoan(LoanRequest loanRequest) {
        return Loan.builder()
                .loanName(loanRequest.getLoanName())
                .interestRate(loanRequest.getInterestRate())
                .period(loanRequest.getPeriod())
                .target(loanRequest.getTarget())
                .loanLimit(loanRequest.getLoanLimit())
                .loanInfo(loanRequest.getLoanInfo())
                .loanDesc(loanRequest.getLoanDesc())
                .build();
    }

}
