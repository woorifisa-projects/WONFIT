package com.woori.wonfit.log.smslog.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SmsRequest {
    private String to;
    private String content;
}
