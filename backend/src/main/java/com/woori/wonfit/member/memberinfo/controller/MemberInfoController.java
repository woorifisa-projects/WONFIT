package com.woori.wonfit.member.memberinfo.controller;

import com.woori.wonfit.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberInfoController {
    private final MemberService memberService;


}
