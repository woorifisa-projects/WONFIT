package com.woori.wonfit.log.smslog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SmsSendResponse {
    String requestId;
    LocalDateTime requestTime;
    String statusCode;
    String statusName;
}