package com.woori.wonfit.product.savings.domain;


import com.woori.wonfit.member.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "savings")
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = true)
    private Member member;

    @Column(name = "savings_name")
    private String savingsName;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "period")
    private int period;

    @Column(name = "target")
    private String target;

    @Column(name = "max_deposit")
    private int maxDeposit;

    @Column(name = "savings_info")
    private String savingsInfo;

    @Column(name = "savings_desc")
    private String savingsDesc; // 상세 설명



}
