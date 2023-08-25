package com.woori.wonfit.member.member.service;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
import com.woori.wonfit.member.member.dto.MemberDto;
import com.woori.wonfit.member.member.dto.MemberRegisterRequest;

import java.util.List;

public interface MemberService {
    MemberDto register(MemberRegisterRequest request);

    String login(String loginId, String memberPw);

    List<Member> getAllMembers();

    MemberDetails findById(Long id);
}
