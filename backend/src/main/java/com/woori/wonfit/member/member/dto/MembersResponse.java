package com.woori.wonfit.member.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembersResponse {
    private Long id;
    private String loginId;
    private String name;
    private boolean status;
    private String phoneNumber;

    public MembersResponse(Long id, String loginId, String name, boolean status, String phoneNumber) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.status = status;
        this.phoneNumber = phoneNumber;
    }
}
