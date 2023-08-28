package com.woori.wonfit.log.subscribelog.dto;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SubscribeLogRequest {

    private Long id;
    private Member member;
    private LocalDateTime subDate;
    private LocalDateTime expireDate;
    private int subDeposit;
    private int monthlyCharge;
    private boolean subscribeStatus;
    private Deposit deposit;
    private Savings savings;
    private Fund fund;
    private Loan loan;

    @Builder
    public SubscribeLogRequest(Member member,LocalDateTime subDate, LocalDateTime expireDate, int subDeposit, int monthlyCharge, boolean subscribeStatus, Deposit deposit, Savings savings, Fund fund, Loan loan) {
        this.member = member;
        this.subDate = subDate;
        this.expireDate = expireDate;
        this.subDeposit = subDeposit;
        this.monthlyCharge = monthlyCharge;
        this.subscribeStatus = subscribeStatus;
        this.deposit = deposit;
        this.savings = savings;
        this.fund = fund;
        this.loan = loan;
    }



}

