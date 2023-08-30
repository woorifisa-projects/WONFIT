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
public class SubscribeLogRequest {
    private Long id;
    private Member member;
    private String subDate;
    private LocalDateTime expireDate;
    private int subDeposit;
    private int monthlyCharge;
    private boolean subscribeStatus;
    private Deposit deposit;
    private Savings savings;
    private Fund fund;
    private Loan loan;

    public static SubscribeLog To_sub_log(SubscribeLogRequest subscribeLogRequest, String time) {
        return SubscribeLog.builder().id(subscribeLogRequest.getId())
                .member(subscribeLogRequest.getMember())
                .subDate(time).expireDate(subscribeLogRequest.getExpireDate())
                .subDeposit(subscribeLogRequest.getSubDeposit())
                .monthlyCharge(subscribeLogRequest.getMonthlyCharge())
                .subscribeStatus(subscribeLogRequest.isSubscribeStatus())
                .deposit(subscribeLogRequest.getDeposit())
                .savings(subscribeLogRequest.getSavings())
                .fund(subscribeLogRequest.getFund())
                .loan(subscribeLogRequest.getLoan())
                .build();
    }
}