package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String loginId; // 회원 아이디
    private String password; // 회원 패스워드
    private String email; // 회원 이메일
    private String name; // 회원 이름
    private String phoneNumber; // 회원 전화번호
    private String bankAccountNumber;
    private String bankAccountPassword;
    private String registrationNumber;
    private String address;

    public static MemberDto fromEntity(Member member)  {
        MemberDto memberDto = MemberDto.builder()
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .email(member.getEmail())
                .name(member.getName())
                .address(member.getAddress())
                .bankAccountNumber(member.getBankAccountNumber())
                .phoneNumber(member.getPhoneNumber())
                .bankAccountPassword(member.getBankAccountPassword())
                .registrationNumber(member.getRegistrationNumber())
                .build();
        return memberDto;
    }
}

