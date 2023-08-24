package com.woori.wonfit.member.memberinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MemberInfoDto {
    private String address;
    private String job;
    private int childrenCount;
    private boolean isAnnuity;
    private boolean isHouseHolder;
    private boolean isMarried;
    private boolean marketingInfoAgree;

}
