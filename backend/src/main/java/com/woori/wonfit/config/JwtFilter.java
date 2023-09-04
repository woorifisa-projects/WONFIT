package com.woori.wonfit.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final String accessKey;
    private String loginId;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            log.info("쿠키를 찾을 수 없습니다");
        }
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (!cookie.getName().equals("key")) {
                    continue;
                }

                String accessToken = cookie.getValue();
                log.info("accessToken = {}", accessKey);

            // token 안보내면 block
            if(accessToken == null){
                log.error("Token 값을 찾을 수 없습니다.");
                filterChain.doFilter(request,response);
            }
                // token 만료되면
//                if (JwtUtil.isExpired(accessToken, secretkey)) {
//                    log.error("accessToken이 만료되었습니다.");
//                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "accessToken이 만료 되었습니다.");
//                    //filterChain.doFilter(request, response);
//                    filterChain.doFilter(request, response);
//                }
                loginId = JwtUtil.getLoginId(accessToken, accessKey);
                log.info("loginId : {}", loginId);
            }
        }
        // 권한 부여
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginId, null, List.of(new SimpleGrantedAuthority("ROLE_USER")));
        // Detail
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
