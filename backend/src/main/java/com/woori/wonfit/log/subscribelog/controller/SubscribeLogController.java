package com.woori.wonfit.log.subscribelog.controller;

import com.woori.wonfit.log.subscribelog.dto.SubscribeLogRequest;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;
import com.woori.wonfit.log.subscribelog.service.SubscribeLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member/mypage/sublog")
@RequiredArgsConstructor
public class SubscribeLogController {
    private final SubscribeLogService subscribeLogService;

    // 멤버 1명 상품 가입 기록 전체 조회
    @GetMapping
    public ResponseEntity<List<SubscribeLogResponse>> findById(@AuthenticationPrincipal String id) {
        List<SubscribeLogResponse> subscribeLogs = subscribeLogService.findById(id);
        return new ResponseEntity<>(subscribeLogs, HttpStatus.OK);
    }

    // 상품 가입 하기
    @PostMapping("/{product}/{productid}")
    public ResponseEntity<String> createSubscribeLog(@PathVariable Long productid, @PathVariable String product, @RequestBody SubscribeLogRequest subscribeLogRequest, @AuthenticationPrincipal String id) throws Exception {
        subscribeLogService.save(productid, product, subscribeLogRequest, id);
        return new ResponseEntity<>("가입완료", HttpStatus.OK);
    }
}
