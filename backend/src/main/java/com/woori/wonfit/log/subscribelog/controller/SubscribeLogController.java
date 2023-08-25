package com.woori.wonfit.log.subscribelog.controller;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;

import com.woori.wonfit.log.subscribelog.service.SubscribeLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/sublogs")
@RequiredArgsConstructor
@Slf4j
public class SubscribeLogController {

    private final SubscribeLogService subscribeLogService;


//    @GetMapping("/member/{memberId}")
//    public List<SubscribeLogResponse> findByMemberId(@PathVariable Long memberId) {
//        List<SubscribeLogResponse> list = subscribeLogService.findByMemberId(memberId);
//        log.info("list call {}", list.get(0));
//        return list;
//
//    }

    @GetMapping("/member/{memberId}")
    public SubscribeLogResponse findByMemberId(@PathVariable Long memberId) {
        SubscribeLog subscribeLog = subscribeLogService.findByMemberId(memberId);
        return SubscribeLogResponse.From(subscribeLog);
    }


    }