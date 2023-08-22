package com.woori.wonfit.product.productfund.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fund_name")
    private String fundName; // 펀드명

    @Column(name = "fund_info")
    private String fundInfo; // 상품 설명

    @Column(name = "fund_risk_grade")
    private String fundRiskGrade; // 투자위험등급

}
