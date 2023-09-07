package com.woori.wonfit.member.member.controller;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.*;
import com.woori.wonfit.member.member.service.MemberServiceImpl;
import com.woori.wonfit.member.memberinfo.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberServiceImpl memberService;
    private final MemberInfoService memberInfoService;

    // 회원 가입
    @PostMapping("wonfit/register")
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterRequest memeberRegisterRequest) {
        MemberDto memberDto = memberService.register(memeberRegisterRequest);
        memberInfoService.saveMemberInfo(memeberRegisterRequest);
        return new ResponseEntity<>(new MemberRegisterResponse(memberDto.getLoginId()), HttpStatus.OK);
    }

    // 로그인
    @PostMapping("wonfit/login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest memberLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = memberService.login(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword(), request);
        response.addCookie(cookie);
        return new ResponseEntity<>(new MemberLoginResponse(memberLoginRequest.getLoginId()), HttpStatus.OK);
    }

    // 로그 아웃
    @PostMapping("member/logout")
    public ResponseEntity<Cookie> logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = memberService.logout(request);
        response.addCookie(cookie);
        return new ResponseEntity<>(cookie, HttpStatus.OK);
    }

    // 회원 탈퇴
    @PostMapping("member/leave")
    public ResponseEntity<String> leaveMember(@RequestBody MemberLoginRequest memberLoginRequest) {
        String message = memberService.leaveMember(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword());
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    // 사용자 전체 조회
    @GetMapping("manager/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> member = memberService.getAllMembers();
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    // 사용자 마이페이지 내 상세정보 조회
    @GetMapping("/member/detail")
    public ResponseEntity<MemberDetails> getMemberDetails(@PathVariable Long id) {
        MemberDetails memberDetails = memberService.findById(id);
        return new ResponseEntity<>(memberDetails, HttpStatus.OK);
    }

    // 사용자 마이페이지 상세정보 수정
    @PatchMapping("/member/detail")
    public ResponseEntity<String> updateMemberDetails(@PathVariable Long id, @RequestBody MemberDetails memberDetails) {
        memberService.updateMemberDetails(id, memberDetails);
        return ResponseEntity.ok("수정이 완료되었습니다.");
    }
}