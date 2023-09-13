package com.woori.wonfit.member.mydata.domain;

import com.woori.wonfit.member.bank.domain.Bank;
import com.woori.wonfit.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "mydata")
public class MyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Bank bank;
    @ManyToOne
    private Member member;
    @Column(name = "money", nullable = false)
    private int money;
}
