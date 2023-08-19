package com.woori.wonfit.product.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="product_name")
    private String productName;

    @Column(name ="interest_rate")
    private double interestRate;

    @Column(name ="product_type")
    private String productType; // 상품 타입(안정형, 중립형, 공격형)

    @Column(name ="sorting_options")
    private String sortingOptions; // 정렬 옵션(인기순, 출시순, 금리순)

    @Column(name ="sub_product_info")
    private String subProductInfo; // 상품 간단 설명

    @Column(name = "liked_count")
    private short likedCount;
}
