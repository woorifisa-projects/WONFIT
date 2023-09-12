package com.woori.wonfit.manager.dto;

import com.woori.wonfit.product.loan.domain.Loan;
import lombok.*;

@Getter
@Builder
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

    public static LoanResponse FromLoan(Loan loan) {
        return LoanResponse.builder()
                .id(loan.getId())
                .loanName(loan.getLoanName())
                .interestRate(loan.getInterestRate())
                .period(loan.getPeriod())
                .target(loan.getTarget())
                .loanLimit(loan.getLoanLimit())
                .loanInfo(loan.getLoanInfo())
                .loanType(loan.getLoanType())
                .build();
    }
}