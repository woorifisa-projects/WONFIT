package com.woori.wonfit.product.deposit.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "deposit")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "deposit_type")
    private String depositType; // 안정형, 중립형, 공격형



}


