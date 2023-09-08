package com.woori.wonfit.log.smslog.controller;

import com.woori.wonfit.log.smslog.domain.Sms;
import com.woori.wonfit.log.smslog.dto.SmsRequest;
import com.woori.wonfit.log.smslog.dto.SmsSendResponse;
import com.woori.wonfit.log.smslog.service.SmsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/manager/sms")
public class SmsController {

    private final SmsService smsService;

    @GetMapping
    public ResponseEntity<List<Sms>> getAllSms(){
        return new ResponseEntity<>(smsService.getAllSms(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest request) throws Exception {
        SmsSendResponse result  = smsService.sendSms(request);

        return new ResponseEntity<>("발송 완료" + result.toString(), HttpStatus.OK);
    }
}
