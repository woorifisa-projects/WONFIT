package com.woori.wonfit.log.smslog.controller;

import com.woori.wonfit.log.smslog.dto.SmsRequest;
import com.woori.wonfit.log.smslog.dto.SmsSendResponse;
import com.woori.wonfit.log.smslog.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/manager/sms")
public class SmsController {

    private final SmsService smsService;
    @PostMapping
    public String sendSms(@RequestBody SmsRequest request) throws Exception {
        SmsSendResponse result  = smsService.sendSms(request);

        return "발송 완료" + result.toString();
    }
}
