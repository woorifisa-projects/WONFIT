package com.woori.wonfit.product.fund.domain;

import com.woori.wonfit.manager.domain.Manager;
import com.woori.wonfit.member.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "fund")
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "fund_name")
    private String fundName;

    @Column(name = "return_rate1")
    private double returnRate1;

    @Column(name = "return_rate2")
    private double returnRate2;

    @Column(name = "fund_type")
    private String fundType; // 안정형, 중립형, 공격형

    @Column(name = "fund_price")
    private double fundPrice;

    @Column(name = "fund_info")
    private String fundInfo;

    @Column(name = "fund_desc")
    private String fundDesc; // 상세 설명

    @Column(name ="sorting_options")
    private String sortingOptions; // 정렬 옵션(인기순, 출시순, 금리순)

}
