package com.woori.wonfit.member.memberinfo.domain;

import com.woori.wonfit.member.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member_info")
public class MemberInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id") // 외래 키를 사용하는 주인인 Member에 대한 참조
    private Member member;

    @Column(name = "private_info_agree")
    private boolean privateInfoAgree;

    @Column(name = "marketing_info_agree")
    private boolean marketingInfoAgree;

    @Column(name = "address")
    private String address;

    @Column(name = "is_married")
    private boolean isMarried;

    @Column(name = "children_count")
    private int childrenCount;

    @Column(name = "is_householder")
    private boolean isHouseholder;

    @Column(name = "is_annuity")
    private boolean isAnnuity;

    @Column(name = "job")
    private String job;

}