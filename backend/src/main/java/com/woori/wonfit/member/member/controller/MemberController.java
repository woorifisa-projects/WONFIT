package com.woori.wonfit.member.member.controller;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.*;
import com.woori.wonfit.member.member.service.MemberServiceImpl;
import com.woori.wonfit.member.memberinfo.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberServiceImpl memberService;
    private final MemberInfoService memberInfoService;

    @PostMapping("/register")
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterRequest memeberRegisterRequest) {
        MemberDto memberDto = memberService.register(memeberRegisterRequest);
        memberInfoService.saveMemberInfo(memeberRegisterRequest);
        return new ResponseEntity<>(new MemberRegisterResponse(memberDto.getLoginId()), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest memberLoginRequest, HttpServletRequest request) {
        String result = memberService.login(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword(), request);
        return new ResponseEntity<>(new MemberLoginResponse(result), HttpStatus.OK);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> member = memberService.getAllMembers();
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDetails> getMemberDetails(@PathVariable Long id) {
        MemberDetails memberDetails = memberService.findById(id);
        return new ResponseEntity<>(memberDetails, HttpStatus.OK);
    }

    @PostMapping("/leave")
    public ResponseEntity<String> leaveMember(@RequestBody MemberLoginRequest memberLoginRequest) {
        String message = memberService.leaveMember(memberLoginRequest.getLoginId(), memberLoginRequest.getPassword());
        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}