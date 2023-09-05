package com.woori.wonfit.member.member.service;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
import com.woori.wonfit.member.member.dto.MemberDto;
import com.woori.wonfit.member.member.dto.MemberRegisterRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {
    MemberDto register(MemberRegisterRequest request);

    Cookie login(String loginId, String memberPw, HttpServletRequest request);

    List<Member> getAllMembers();

    MemberDetails findById(Long id);

    String leaveMember(String loginId, String memberPw);
}
