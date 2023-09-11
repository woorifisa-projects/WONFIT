package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.Builder;

@Builder
public class MembersResponse {
    private Long id;
    private String name;
    private String loginId;
    private String phoneNumber;
    private boolean status;
}
