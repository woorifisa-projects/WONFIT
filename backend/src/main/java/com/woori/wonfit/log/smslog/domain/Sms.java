package com.woori.wonfit.log.smslog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "sender")
    private String sender;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "content")
    private String content;
    @Column(name = "send_date")
    private String sendDate;
}
