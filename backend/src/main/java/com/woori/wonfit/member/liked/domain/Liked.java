package com.woori.wonfit.member.liked.domain;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.product.domain.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "liked")
public class Liked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "liked")
    private boolean liked;

}
