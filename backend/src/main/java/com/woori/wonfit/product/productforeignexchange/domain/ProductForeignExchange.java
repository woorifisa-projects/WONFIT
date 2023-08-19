package com.woori.wonfit.product.productforeignexchange.domain;


import com.woori.wonfit.product.product.domain.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "product_foreign_exchange")
public class ProductForeignExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_foreign_exchange_name")
    private String productForeignExchangeName;

    @Column(name = "product_target")
    private String productTarget; // 가입 대상

    @Column(name = "conversion_rate_info")
    private double conversionRateInfo; // 환율 정보

    @Column(name = "deposit_currency")
    private String depositCurrency; // 예치 통화

    @Column(name = "product_foreign_exchange_period")
    private String productForeignExchangePeriod; // 가입 기간

    @Column(name = "product_foreign_exchange_info")
    private String productForeignExchangeInfo; // 상품 설명

}
