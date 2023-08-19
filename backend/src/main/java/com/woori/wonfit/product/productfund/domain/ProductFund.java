package com.woori.wonfit.product.productfund.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
