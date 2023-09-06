package com.woori.wonfit.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Component
public class CreateCookie {
    public Cookie createCookie(String key, String value){
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }
}
