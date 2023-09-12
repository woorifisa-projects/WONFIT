package com.woori.wonfit.log.subscribelog.dto;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.*;

import javax.servlet.http.HttpServletRequest;
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
    private String expirePeriod;
    private int subDeposit;
    private int subSavings; // 가입 금액(적금)
    private int monthlyCharge;
    private String monthlyChargeDate; // 월 납입일(적금,대출)
    private String taxDeduction; // 세금우대방법(예금,적금)
    private int fundQuantity; // 펀드 매수 수량(펀드)
    private int loanAmount; // 대출 금액
    private String repaymentMethod; // 원리금균등상환, 원금균등상환, 만기일시상환(대출)
    private boolean subscribeStatus;
    private Deposit deposit;
    private Savings savings;
    private Fund fund;
    private Loan loan;

    public static SubscribeLog To_sub_log(SubscribeLogRequest subscribeLogRequest, Member member,Deposit deposit, Savings savings, Fund fund, Loan loan, String time) {
        return SubscribeLog.builder()
                .id(subscribeLogRequest.getId())
                .member(member)
                .subDeposit(subscribeLogRequest.getSubDeposit())
                .subDate(time)
                .expirePeriod(subscribeLogRequest.getExpirePeriod())
                .subDeposit(subscribeLogRequest.getSubDeposit())
                .subSavings(subscribeLogRequest.getSubSavings())
                .monthlyCharge(subscribeLogRequest.getMonthlyCharge())
                .monthlyChargeDate(subscribeLogRequest.getMonthlyChargeDate())
                .taxDeduction(subscribeLogRequest.getTaxDeduction())
                .fundQuantity(subscribeLogRequest.getFundQuantity())
                .loanAmount(subscribeLogRequest.getLoanAmount())
                .repaymentMethod(subscribeLogRequest.getRepaymentMethod())
                .subscribeStatus(subscribeLogRequest.isSubscribeStatus())
                .deposit(deposit)
                .savings(savings)
                .fund(fund)
                .loan(loan)
                .build();
    }
}