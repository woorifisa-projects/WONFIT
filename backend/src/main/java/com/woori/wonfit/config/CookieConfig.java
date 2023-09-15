package com.woori.wonfit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class CookieConfig {

    @Value("${cookey.jwt.key}")
    private String key;
    @Value("${jwt.token.access}")
    private String accessKey;

    public String parseCookie(HttpServletRequest request) {
        log.info("parseCookie called!");
        Cookie[] cookies = request.getCookies();
        log.info("Cookey key = {}", key);
        for (Cookie cookie : cookies) {
            log.info(cookie.getName());
            if (!cookie.getName().equals(key)) {
                continue;
            }
            String accessToken = cookie.getValue();
            log.info(accessToken);
            if (accessToken == null) {
                log.error("Token 값을 찾을 수 없습니다.");
            }
            log.info("accessToken = {}", accessToken);
            log.info("accessKey = {}", accessKey);

            return accessToken;
        }
        log.info("쿠키를 찾을 수 없습니다");
        return null;
    }

    public Long getIdFromToken(String token) {
        String accessId = JwtUtil.getId(token, accessKey);
        log.info("getIdFromToken In accessId = {}", accessId);
        Long id = Long.parseLong(accessId);
        return id;
    }

    public Cookie createHttpOnlyCookie(String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }

    public Cookie createCookie(String key, String value){
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        return cookie;
    }
}
