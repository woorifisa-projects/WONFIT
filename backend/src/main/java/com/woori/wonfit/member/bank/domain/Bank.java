package com.woori.wonfit.member.bank.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bank_name")
    private String bankName;
}
