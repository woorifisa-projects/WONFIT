package com.woori.wonfit.config;

import com.woori.wonfit.member.member.repository.MemberRepository;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Setter
@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Value("${jwt.token.access}")
    private String accessKey;
    @Value("${jwt.token.refresh}")
    private String refreshKey;

    private final MemberRepository memberRepository;
    private final CookieConfig cookieConfig;

    private String id;
    private boolean flag = false;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (flag == true) {
            log.info("flag == true");

            String accessToken = cookieConfig.parseCookie(request);
            ;

            // token 안보내면 block
            if (accessToken == null) {
                log.error("Token 값을 찾을 수 없습니다.");
                filterChain.doFilter(request, response);
            }

            // accessToken에서 id값 추출
            Long accessTokenMemberId = cookieConfig.getIdFromToken(accessToken);

            // accessToken과 매칭되는 member의 refreshToken을 가져옴
            String refreshToken = memberRepository.findById(accessTokenMemberId).get().getRefreshToken();
            log.info("refreshToken = {}", refreshToken);

            String refreshTokenMemberId = JwtUtil.getId(refreshToken, refreshKey);

            // Refresh Token과 Access Token에 저장된 loginId 비교
            if (!accessTokenMemberId.toString().equals(refreshTokenMemberId)) {
                log.error("Invalid token signature");
                throw new SignatureException("Invalid token signature");
            }

            log.info("accessToken == refreshToken");

            if (JwtUtil.isExpired(accessToken, accessKey)) {
                log.info("accessToken is expired");
                // refreshToken 만료되면
                if (JwtUtil.isExpired(refreshToken, refreshKey)) {
                    log.error("refreshToken이 만료되었습니다.");
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "refreshToken이 만료 되었습니다.");
                    filterChain.doFilter(request, response);
                } else {
                    accessToken = JwtUtil.createAccessToken(accessTokenMemberId.toString(), 1000 * 60 * 60l, "USER", accessKey);
                    log.info("Regenerated accessToken");
                    Cookie responseCookie = cookieConfig.createCookie(accessToken);
                    response.addCookie(responseCookie);
                }
            }
            id = accessTokenMemberId.toString();
            log.info("ID : {}", id);
        }
        // 권한 부여
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, null, List.of(new SimpleGrantedAuthority("ROLE_USER")));
        // Detail
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);

        System.out.println(flag);
    }

}
