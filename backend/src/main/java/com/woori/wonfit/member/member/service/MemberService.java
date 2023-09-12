package com.woori.wonfit.member.member.service;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.*;
import org.springframework.http.ResponseCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {
    MemberDto register(MemberRegisterRequest request);

    Cookie login(String loginId, String memberPw, HttpServletRequest request);

    Cookie logout(HttpServletRequest request);

    String extractBrowser(String userAgent);

    String extractDevice(String userAgent);

    List<MembersResponse> getAllMembers();

    MemberUpdateRequest findById(Long id);

    Cookie leaveMember(String loginId, String memberPw, HttpServletRequest request) throws Exception;

    void updateMemberDetails(HttpServletRequest request, Member member);

}
