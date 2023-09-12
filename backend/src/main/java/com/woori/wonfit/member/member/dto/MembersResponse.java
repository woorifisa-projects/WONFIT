package com.woori.wonfit.member.member.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MembersResponse {
    private String name;
    private String loginId;
    private String phoneNumber;
    private boolean status;
}
