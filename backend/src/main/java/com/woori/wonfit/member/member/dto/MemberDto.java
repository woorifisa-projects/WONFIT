package com.woori.wonfit.member.member.dto;


import com.woori.wonfit.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MemberDto {

    private Long id;
    private String loginId; // 회원 아이디
    private String password; // 회원 패스워드
    private String email; // 회원 이메일
    private String name; // 회원 이름
    private String phoneNumber; // 회원 전화번호

    public static MemberDto fromEntity(Member member)  {
        MemberDto memberDto = MemberDto.builder()
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .email(member.getEmail())
                .name(member.getName())
                .build();
        return memberDto;
    }
}

