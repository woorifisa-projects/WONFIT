package com.woori.wonfit.manager.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name ="manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id")
    private Long lgoinId;

    @Column(name = "password")
    private String password;



}


