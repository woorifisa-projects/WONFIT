package com.woori.wonfit.log.subscribelog.domain;


import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "subscribe_log")
public class SubscribeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "subscribe_date")
    private LocalDateTime subDate; // 가입 날짜

    @Column(name = "expire_date")
    private LocalDateTime expireDate; // 만료 날짜

    @Column(name = "subscribe_deposit")
    private int subDeposit; // 금융 상품 가입 시 예금 금액

    @Column(name = "monthly_charge")
    private int monthlyCharge; //월 납입 금액

    @Column(name = "subscribe_status")
    private boolean subscribeStatus; // ACTIVE(가입중), INACTIVE(해지)

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

    @ManyToOne
    @JoinColumn(name = "savings_id")
    private Savings savings;

    @ManyToOne
    @JoinColumn(name = "fund_id")
    private Fund fund;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
