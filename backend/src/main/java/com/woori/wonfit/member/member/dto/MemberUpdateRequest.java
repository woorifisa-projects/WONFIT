package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberUpdateRequest {
    private String name;
    private String registrationNumber; // 회원 주민번호
    private String bankAccountNumber; // 계좌번호
    private String loginId; // 회원 아이디 (영어 소문자, 숫자 포함 5자 이상, 15자 이하)
    private String password; // 회원 패스워드 (영어 대소문자, 숫자 포함 20자 이하)
    private String email; // 회원 이메일
    private String phoneNumber; // 회원 전화번호
    private String address; // 회원 주소
    private String annualIncome;
    private String ageGroup;
    private String refreshToken;

    public static MemberUpdateRequest toNewDetail(Member member) {
        return MemberUpdateRequest.builder()
                .name(member.getName())
                .registrationNumber(member.getRegistrationNumber())
                .bankAccountNumber(member.getBankAccountNumber())
                .loginId(member.getLoginId())
                .password(null)
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .address(member.getAddress())
                .build();
    }
}