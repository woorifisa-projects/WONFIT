package com.woori.wonfit.member.sublog.controller;


import com.woori.wonfit.member.sublog.domain.SubLog;
import com.woori.wonfit.member.sublog.service.MemberSubLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sublogs")
@RequiredArgsConstructor
public class MemberSubLogController {

        private final MemberSubLogService memberSubLogService;

    @GetMapping("/member/{memberId}")
    public List<SubLog> getSublogsByMemberId(@PathVariable Long memberId) {
        return memberSubLogService.getSubLogsByMemberId(memberId);

    }
}
