package com.woori.wonfit.member.subscribelog.domain;


import com.woori.wonfit.member.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "subscribe_log")
public class SubscribeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "subscribe_date")
    private LocalDateTime subDate; // 가입 날짜

    @Column(name = "expire_date")
    private LocalDateTime expireDate; // 만료 날짜

    @Column(name = "sub_status")
    private boolean subStatus; // ACTIVE(가입중), INACTIVE(해지)

}
