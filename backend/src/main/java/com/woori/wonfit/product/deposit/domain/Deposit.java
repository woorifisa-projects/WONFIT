package com.woori.wonfit.product.deposit.domain;


import com.woori.wonfit.member.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "deposit")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "deposit_name")
    private String depositName;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "period")
    private int period;

    @Column(name = "target")
    private String target;

    @Column(name = "min_deposit")
    private int minDeposit;

    @Column(name = "deposit_info")
    private String depositInfo; // 간단 설명

    @Column(name = "deposit_desc")
    private String depositDesc; // 상세 설명

    @Column(name ="sorting_options")
    private String sortingOptions; // 정렬 옵션(인기순, 출시순, 금리순)

}
