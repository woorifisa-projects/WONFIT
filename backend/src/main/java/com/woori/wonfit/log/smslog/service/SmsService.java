package com.woori.wonfit.log.smslog.service;

import com.woori.wonfit.log.smslog.dto.SmsRequest;
import com.woori.wonfit.log.smslog.dto.SmsSendResponse;

public interface SmsService {
    SmsSendResponse sendSms(SmsRequest request) throws Exception;
}
