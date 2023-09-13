package com.woori.wonfit.product.savings.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "savings")
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "savings_type")
    private String savingsType; // 안정형, 중립형, 공격형

    @Column(name = "status")
    private boolean status; // 상품 상태

}
