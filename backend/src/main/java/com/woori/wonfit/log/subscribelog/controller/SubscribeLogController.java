package com.woori.wonfit.log.subscribelog.controller;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.service.SubscribeLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sublogs")
@RequiredArgsConstructor
public class SubscribeLogController {

    private final SubscribeLogService SubscribeLogService;

    @GetMapping("/member/{memberId}")
    public List<SubscribeLog> getSubscribeLogsByMemberId(@PathVariable Long memberId) {
        return SubscribeLogService.SubscribeLogsByMemberId(memberId);

    }
}
