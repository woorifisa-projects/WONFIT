package com.woori.wonfit.log.subscribelog.controller;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogRequest;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;
import com.woori.wonfit.log.subscribelog.service.SubscribeLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sublogs")
@RequiredArgsConstructor
public class SubscribeLogController {
    private final SubscribeLogService subscribeLogService;

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String time = date.format(formatter).substring(0, 19);

    @GetMapping("/member/{memberId}")
    public List<SubscribeLogResponse> findByMemberId(@PathVariable Long memberId) {
        List<SubscribeLog> subscribeLogs = subscribeLogService.findByMemberId(memberId);
        List<SubscribeLogResponse> responseList = new ArrayList<>();

        for (SubscribeLog subscribeLog : subscribeLogs) {
            SubscribeLogResponse response = SubscribeLogResponse.From_sub_log(subscribeLog, time);
            responseList.add(response);
        }

        return responseList;
    }

    @PostMapping("/wonfit/subscribe")
    public ResponseEntity<SubscribeLogResponse> createSubscribeLog(@RequestBody SubscribeLogRequest subscribeLogRequest) {

        SubscribeLog subscribeLog = SubscribeLogRequest.To_sub_log(subscribeLogRequest, time);
        SubscribeLog createSubscribeLog = subscribeLogService.save(subscribeLog);
        SubscribeLogResponse subscribeLogResponse = SubscribeLogResponse.From_sub_log(createSubscribeLog, time);
        return ResponseEntity.ok(subscribeLogResponse);
    }
}