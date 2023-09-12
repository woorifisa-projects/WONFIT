package com.woori.wonfit.log.subscribelog.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogRequest;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "subscribe_log")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id", nullable = true)
    private Member member;

    @Column(name = "subscribe_date")
    private String subDate; // 가입 날짜, 펀드 매수 날짜

    @Column(name = "expire_period", nullable = true)
    private String expirePeriod; // (가입,대출 기간 - 예금,적금,대출)

    @Column(name = "subscribe_deposit", nullable = true)
    private int subDeposit; // 가입 금액(적금)

    @Column(name = "subscribe_savings", nullable = true)
    private int subSavings; // 가입 금액(적금)

    @Column(name = "monthly_charge", nullable = true)
    private int monthlyCharge; //월 납입 금액(적금)

    @Column(name = "monthly_charge_date", nullable = true)
    private String monthlyChargeDate; // 월 납입일(적금,대출)

    @Column(name = "tax_deduction", nullable = true)
    private String taxDeduction; // 세금우대방법(예금,적금)

    @Column(name = "fund_quantity", nullable = true)
    private int fundQuantity; // 펀드 매수 수량(펀드)

    @Column(name = "loan_amount", nullable = true)
    private int loanAmount; // 대출 금액

    @Column(name = "repayment_method", nullable = true)
    private String repaymentMethod; // 원리금균등상환, 원금균등상환, 만기일시상환(대출)

    @Column(name = "subscribe_status")
    private boolean subscribeStatus; // ACTIVE(가입중), INACTIVE(해지)

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "deposit_id", nullable = true)
    private Deposit deposit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "savings_id", nullable = true)
    private Savings savings;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fund_id", nullable = true)
    private Fund fund;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = true)
    private Loan loan;

    public static SubscribeLog toEntity(SubscribeLog request){
        return SubscribeLog.builder()
                .member(request.getMember())
                .subDate(request.getSubDate())
                .expirePeriod(request.getExpirePeriod())
                .subDeposit(request.getSubDeposit())
                .subSavings(request.getSubSavings())
                .monthlyCharge(request.getMonthlyCharge())
                .monthlyChargeDate(request.getMonthlyChargeDate())
                .taxDeduction(request.getTaxDeduction())
                .fundQuantity(request.getFundQuantity())
                .loanAmount(request.getLoanAmount())
                .repaymentMethod(request.getRepaymentMethod())
                .subscribeStatus(request.isSubscribeStatus())
                .deposit(request.getDeposit())
                .savings(request.getSavings())
                .fund(request.getFund())
                .loan(request.getLoan())
                .build();
    }
}
