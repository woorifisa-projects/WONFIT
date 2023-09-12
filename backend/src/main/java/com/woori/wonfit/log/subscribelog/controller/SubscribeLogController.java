package com.woori.wonfit.log.subscribelog.controller;

import com.woori.wonfit.config.CookieConfig;
import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogRequest;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;
import com.woori.wonfit.log.subscribelog.service.SubscribeLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member/mypage/sublog")
@RequiredArgsConstructor
public class SubscribeLogController {
    private final SubscribeLogService subscribeLogService;
    private final CookieConfig cookieConfig;

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String time = date.format(formatter).substring(0, 19);

    // 멤버 1명 상품 가입 기록 전체 조회
    @GetMapping
    public List<SubscribeLogResponse> findByMemberId(HttpServletRequest request) {
        String token = cookieConfig.parseCookie(request);
        Long memberId = cookieConfig.getIdFromToken(token);

        List<SubscribeLog> subscribeLogs = subscribeLogService.findByMemberId(memberId);
        List<SubscribeLogResponse> responseList = new ArrayList<>();

        for (SubscribeLog subscribeLog : subscribeLogs) {
            SubscribeLogResponse response = SubscribeLogResponse.From_sub_log(subscribeLog, time);
            responseList.add(response);
        }

        return responseList;
    }

    @PostMapping("/{product}/{id}")
    public ResponseEntity<String> createSubscribeLog(@PathVariable Long id, @PathVariable String product, @RequestBody SubscribeLogRequest subscribeLogRequest, HttpServletRequest request) {
        SubscribeLog createSubscribeLog = subscribeLogService.save(id, product, subscribeLogRequest, request, time);
        return new ResponseEntity<>("가입완료", HttpStatus.OK);
    }
}
