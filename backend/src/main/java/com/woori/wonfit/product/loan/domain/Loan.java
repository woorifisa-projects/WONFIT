package com.woori.wonfit.product.loan.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_name")
    private String loanName;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "period")
    private int period;

    @Column(name = "target")
    private String target;

    @Column(name = "loan_limit")
    private long loanLimit;

    @Column(name = "loan_info")
    private String loanInfo;

    @Column(name = "loan_desc")
    private String loanDesc; // 상세 설명

    @Column(name = "loan_type")
    private String loanType; // 안정형, 중립형, 공격형



}
