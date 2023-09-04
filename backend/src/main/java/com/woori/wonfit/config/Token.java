package com.woori.wonfit.config;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Token {
    private String accessToken;
    private String refreshToken;
    private String key;
}
