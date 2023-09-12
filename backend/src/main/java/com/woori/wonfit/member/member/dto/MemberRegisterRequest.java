package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MemberRegisterRequest {
    private String loginId; // 회원 아이디
    private String password; // 회원 패스워드
    private String email; // 회원 이메일
    private String name; // 회원 이름
    private Boolean status;
    private String registrationNumber;
    private String phoneNumber;
    private String bankAccountNumber; // 계좌번호
    private String bankAccountPassword;
    private String address;
    private boolean marketingInfoAgree;
    private String refreshToken;

    public Member toEntity(String password) {
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .email(email)
                .name(name)
                .status(status)
                .registrationNumber(registrationNumber)
                .phoneNumber(phoneNumber)
                .bankAccountNumber(bankAccountNumber)
                .bankAccountPassword(bankAccountPassword)
                .address(address)
//                .marketingInfoAgree(marketingInfoAgree)
                .build();
    }
}