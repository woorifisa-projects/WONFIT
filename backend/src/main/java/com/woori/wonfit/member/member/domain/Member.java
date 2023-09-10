package com.woori.wonfit.member.member.domain;


import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.loginlog.domain.LoginLog;
import com.woori.wonfit.log.searchlog.domain.SearchLog;
import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.member.dto.MemberDetails;
import com.woori.wonfit.member.member.dto.MemberUpdateRequest;
import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ID: 영문/숫자 15자 이하
    // PW: 영문/숫자/특수문자 포함 8자 이상 최대 20자 이하
    @Column(name = "login_id", length = 15, nullable = false)
    private String loginId; // 회원 아이디 (영어 소문자, 숫자 포함 5자 이상, 15자 이하)

    @Column(name = "password", length = 100, nullable = false)
    private String password; // 회원 패스워드 (영어 대소문자, 숫자 포함 20자 이하)

    @Column(name = "name", length = 10, nullable = false)
    private String name; // 회원 이름

    @Column(name = "email", length = 50, nullable = false)
    private String email; // 회원 이메일

    @Column(name = "registration_number", length = 20, nullable = false)
    private String registrationNumber; // 회원 주민번호

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber; // 회원 전화번호

    @Column(name = "bank_account_number")
    private String bankAccountNumber; // 계좌번호

    @Column(name = "bank_account_password")
    private String bankAccountPassword; // 계좌 비밀번호

    @Column(name = "status")
    @ColumnDefault("true")
    private boolean status; // 회원 상태(정상, 탈퇴)

    @Column(name = "refresh_Token", nullable = true)
    private String refreshToken;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<InvestType> investTypes;

    @OneToOne(mappedBy = "member", cascade = CascadeType.REMOVE)
    private MemberInfo memberInfo;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<LoginLog> loginLog;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Liked> liked;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<SearchLog> searchLogs;

    public static Member toEntity(Long id, MemberUpdateRequest memberUpdateRequest, String password, String refreshToken) {
        return Member.builder()
                .id(id)
                .loginId(memberUpdateRequest.getLoginId())
                .password(password)
                .name(memberUpdateRequest.getName())
                .email(memberUpdateRequest.getEmail())
                .registrationNumber(memberUpdateRequest.getRegistrationNumber())
                .phoneNumber(memberUpdateRequest.getPhoneNumber())
                .status(true)
                .refreshToken(refreshToken)
                .build();
    }
}