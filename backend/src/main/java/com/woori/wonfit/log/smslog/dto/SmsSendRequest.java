package com.woori.wonfit.log.smslog.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SmsSendRequest {
    String type;
    String contentType;
    String countryCode;
    String from;
    String content;
    List<SmsRequest> messages;
}
