package com.woori.wonfit.product.deposit.domain;


import com.woori.wonfit.member.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "product_deposit")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "product_deposit_name")
    private String productDepositName; // 예금명

    @Column(name = "product_min_deposit")
    private int productMinDeposit; // 최소 가입금액

    @Column(name = "product_target")
    private String productTarget; // 가입 대상

    @Column(name = "product_deposit_period")
    private String productDepositPeriod; // 가입기간

    @Column(name = "basic_interest_rate")
    private double basicInterestRate; // 기본 금리

    @Column(name = "product_deposit_info")
    private String productDepositInfo; // 상품 설명

    @Column(name ="product_type")
    private String productType; // 상품 타입(안정형, 중립형, 공격형)

    @Column(name ="sorting_options")
    private String sortingOptions; // 정렬 옵션(인기순, 출시순, 금리순)

    @Column(name = "liked_count")
    private short likedCount;

}
