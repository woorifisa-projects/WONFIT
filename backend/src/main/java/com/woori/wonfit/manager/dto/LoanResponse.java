package com.woori.wonfit.manager.dto;

import com.woori.wonfit.product.loan.domain.Loan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor

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


    @Builder
    public LoanResponse(Long id, String loanName, double interestRate, int period, String target, long loanLimit, String loanInfo, String loanDesc, String loanType) {
        this.id = id;
        this.loanName = loanName;
        this.interestRate = interestRate;
        this.period = period;
        this.target = target;
        this.loanLimit = loanLimit;
        this.loanInfo = loanInfo;
        this.loanDesc = loanDesc;
        this.loanType = loanType;
    }



public static LoanResponse FromLoan(Loan loan) {
        return LoanResponse.builder()
                .id(loan.getId())
                .loanName(loan.getLoanName())
                .interestRate(loan.getInterestRate())
                .period(loan.getPeriod())
                .target(loan.getTarget())
                .loanLimit(loan.getLoanLimit())
                .loanInfo(loan.getLoanInfo())
                .loanDesc(loan.getLoanDesc())
                .loanType(loan.getLoanType())

                .build();
}

}