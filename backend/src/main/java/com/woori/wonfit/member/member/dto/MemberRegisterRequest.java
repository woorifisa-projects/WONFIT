package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
import com.woori.wonfit.member.memberinfo.dto.MemberInfoDto;
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
    private String registrationNumber;

    private String address;
    private String job;
    private int childrenCount;
    private boolean isAnnuity;
    private boolean isHouseHolder;
    private boolean isMarried;
    private boolean marketingInfoAgree;

    public Member toEntity(String password) {
        return Member.builder()
                .loginId(loginId).password(password)
                .email(email)
                .name(name)
                .registrationNumber(registrationNumber)
                .build();
    }

    public MemberInfo toInfoEntity(MemberRegisterRequest request){
        return MemberInfo.builder()
                .address(request.address)
                .job(request.job)
                .childrenCount(request.childrenCount)
                .isAnnuity(request.isAnnuity)
                .isHouseholder(request.isHouseHolder)
                .isMarried(request.isMarried)
                .marketingInfoAgree(request.marketingInfoAgree)
                .build();
    }
}