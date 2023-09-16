package com.woori.wonfit.member.member.dto;

import lombok.Getter;

@Getter
public class MemberDetatilUpdateRequest {
    private String name;
    private String password;
    private String registrationNumber; // 회원 주민번호
    private String bankAccountNumber; // 계좌번호
    private String email; // 회원 이메일
    private String phoneNumber; // 회원 전화번호
    private String address; // 회원 주소
}
