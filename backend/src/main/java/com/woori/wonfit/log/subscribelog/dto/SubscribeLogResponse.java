package com.woori.wonfit.log.subscribelog.dto;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeLogResponse {
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

    public static SubscribeLogResponse From_sub_log(SubscribeLog subscribeLog) {
        return SubscribeLogResponse.builder()
                .id(subscribeLog.getId())
                .member(subscribeLog.getMember())
                .subDate(subscribeLog.getSubDate())
                .expireDate(subscribeLog.getExpireDate())
                .subDeposit(subscribeLog.getSubDeposit())
                .monthlyCharge(subscribeLog.getMonthlyCharge())
                .subscribeStatus(subscribeLog.isSubscribeStatus())
                .deposit(subscribeLog.getDeposit())
                .savings(subscribeLog.getSavings())
                .fund(subscribeLog.getFund())
                .loan(subscribeLog.getLoan())
                .build();
    }
}
