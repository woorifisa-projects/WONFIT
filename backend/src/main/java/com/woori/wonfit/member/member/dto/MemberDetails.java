package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
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
    private String email;
    private String registrationNumber;
    private String job;
    private int childrenCount;
    private boolean isAnnuity;
    private boolean isHouseHolder;
    private boolean isMarried;
    private boolean marketingInfoAgree;
    private String investType; // 투자성향

    public static MemberDetails fromEntity(Member member, MemberInfo memberInfo){
        return MemberDetails.builder()
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .name(member.getName())
                .address(memberInfo.getAddress())
                .phoneNumber(member.getPhoneNumber())
                .email(member.getEmail())
                .registrationNumber(member.getRegistrationNumber())
                .job(memberInfo.getJob())
                .childrenCount(memberInfo.getChildrenCount())
                .isAnnuity(memberInfo.isAnnuity())
                .isHouseHolder(memberInfo.isHouseholder())
                .isMarried(memberInfo.isMarried())
                .marketingInfoAgree(memberInfo.isMarketingInfoAgree())
                .investType(memberInfo.getInvestType())
                .build();
    }

}
