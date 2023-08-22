package com.woori.wonfit.product.loan.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_name")
    private String loanName;

    @Column(name = "loan_limit")
    private String limit;

    @Column(name = "loan_target")
    private String loanTarget; // 가입 대상

    @Column(name = "loan_period")
    private String loanPeriod; // 가입기간

    @Column(name = "basic_interest_rate")
    private double basicInterestRate; // 기본 금리

    @Column(name = "loan_info")
    private String loanInfo; // 상품 설명

}
