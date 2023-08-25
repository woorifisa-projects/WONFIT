package com.woori.wonfit.log.subscribelog.controller;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;

import com.woori.wonfit.log.subscribelog.service.SubscribeLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/sublogs")
@RequiredArgsConstructor
public class SubscribeLogController {

    private final SubscribeLogService subscribeLogService;

    @GetMapping("/member/{memberId}")
    public SubscribeLogResponse findByMemberId(@PathVariable Long memberId) {
        SubscribeLog subscribeLog = subscribeLogService.findByMemberId(memberId);
        return SubscribeLogResponse.From_sub_log(subscribeLog);
    }


    }