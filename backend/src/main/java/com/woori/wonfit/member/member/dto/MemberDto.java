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
    private String memberLoginId; // 회원 아이디
    private String memberPw; // 회원 패스워드
    private String memberEmail; // 회원 이메일
    private String memberName; // 회원 이름
    private boolean status; // 회원 상태

    public static MemberDto fromEntity(Member member)  {
        MemberDto memberDto = MemberDto.builder()
                .memberLoginId(member.getMemberLoginId())
                .memberPw(member.getMemberPw())
                .memberEmail(member.getMemberEmail())
                .memberName(member.getMemberName())
                .status(member.isStatus())
                .build();
        return memberDto;
    }
}