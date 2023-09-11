package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class MemberDetails {
    private String loginId;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;
    private String bankAccountPassword;
    private String email;
    private String registrationNumber;
    private boolean status;
    private boolean marketingInfoAgree;
    private String investType; // 투자성향
}
