package com.woori.wonfit.member.member.domain;


import com.woori.wonfit.member.sublog.domain.SubLog;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_login_id", length = 15, nullable = false)
    private String memberLoginId; // 회원 아이디 (10자 이하)

    @Column(name = "member_pw", length = 100, nullable = false)
    private String memberPw; // 회원 패스워드 (20자 이하)

    @Column(name = "member_name", length = 10, nullable = false)
    private String memberName; // 회원 이름

    @Column(name = "member_email", length = 50, nullable = false)
    private String memberEmail; // 회원 이메일

    @Column(name = "member_registration_number", length = 20, nullable = false)
    private String memberRegistrationNumber; // 회원 주민번호

    @Column(name = "member_status")
    @ColumnDefault("1")
    private boolean status; // 회원 상태(정상, 탈퇴)

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubLog> subLogs = new ArrayList<>();


// ID: 영문/숫자 15자 이하
// PW: 영문/숫자/특수문자 포함 8자 이상 최대 20자 이하

}