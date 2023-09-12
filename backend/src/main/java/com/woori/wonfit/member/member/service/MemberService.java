package com.woori.wonfit.member.member.service;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDto;
import com.woori.wonfit.member.member.dto.MemberRegisterRequest;
import com.woori.wonfit.member.member.dto.MemberUpdateRequest;
import com.woori.wonfit.member.member.dto.MembersResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {
    MemberDto register(MemberRegisterRequest request);

    Cookie login(String loginId, String memberPw, HttpServletRequest request);

    Cookie logout(String id);

    String extractBrowser(String userAgent);

    String extractDevice(String userAgent);

    List<MembersResponse> getAllMembers();

    MemberUpdateRequest findById(String id);

    Cookie leaveMember(String loginId, String memberPw, String id) throws Exception;

    void updateMemberDetails(String id, Member member);

}
