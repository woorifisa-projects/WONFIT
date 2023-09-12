package com.woori.wonfit.log.smslog.service;

import com.woori.wonfit.log.smslog.domain.Sms;
import com.woori.wonfit.log.smslog.dto.SmsRequest;
import com.woori.wonfit.log.smslog.dto.SmsSendResponse;

import java.util.List;

public interface SmsService {
    SmsSendResponse sendSms(SmsRequest request) throws Exception;

    List<Sms> getAllSms();
}
