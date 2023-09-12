package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
public class MembersResponse {
    private String name;
    private String loginId;
    private String phoneNumber;
    private boolean status;

    public MembersResponse(String name, String loginId, String phoneNumber, boolean status) {
        this.name = name;
        this.loginId = loginId;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }
}
