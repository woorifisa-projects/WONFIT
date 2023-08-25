package com.woori.wonfit.log.liked.dto;

import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LikedRequest {

    private Long id;
    private Deposit deposit;
    private Savings savings;
    private Fund fund;
    private Loan loan;
    private String productType;
    private String investmentType;


    @Builder
    public LikedRequest(Long id, Deposit deposit, Savings savings, Fund fund, Loan loan, String productType, String investmentType) {
        this.id = id;
        this.deposit = deposit;
        this.savings = savings;
        this.fund = fund;
        this.loan = loan;
        this.productType = productType;
        this.investmentType = investmentType;
    }
}
