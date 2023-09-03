package com.woori.wonfit.config;

import com.woori.wonfit.member.member.repository.MemberRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
@RequiredArgsConstructor
@Component
public class InterceptorConfig implements HandlerInterceptor {
    private final JwtUtil jwtUtil;
    private final MemberRepository memberRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            log.info("쿠키를 찾을 수 없습니다");
            return false;
        }

        for (Cookie cookie : cookies) {
            if (!cookie.getName().equals("key")) {
                continue;
            }

            log.info("find cookie");
            String accessToken = cookie.getValue();
            log.info("find accessToken = {}", accessToken);

            try {
                Claims accessTokenValue = jwtUtil.getAccessClaims(accessToken);
                String accessTokenLoginId = (String) accessTokenValue.get("loginId");
                log.info("LoginId in accessToken = {}", accessTokenLoginId);
                String refreshToken = memberRepository.findRefreshTokenByLoginId(accessTokenLoginId).get();
                log.info("refreshToken = {}", refreshToken);
                Claims refreshTokenValue = jwtUtil.getRefreshClaims(refreshToken);
                String refreshTokenLoginId = (String) refreshTokenValue.get("loginId");
                log.info("LoginId in refreshToken = {}", refreshTokenLoginId);

                // Refresh Token과 Access Token에 저장된 loginId 비교
                if (!accessTokenLoginId.equals(refreshTokenLoginId)) {
                    log.error("Invalid token signature");
                    throw new SignatureException("Invalid token signature");
                }

                log.info("accessToken == refreshToken");
                return true;
            } catch (SignatureException e) {
                // Invalid token signature 에러 처리
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token signature");
                return false;
            }
        }
        return true;
    }
}