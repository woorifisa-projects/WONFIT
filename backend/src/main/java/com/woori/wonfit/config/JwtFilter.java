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
    private String role;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Filter called!");
        // HTTP OPTIONS 메서드인 경우 필터를 통과시키지 않고 다음 필터로 진행
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            log.info("OPTIONS CALLED    HTTP METHOD = {}", request.getMethod().toString());
            filterChain.doFilter(request, response);
            return;
        }
        String path = request.getRequestURI();
        if (path.startsWith("/wonfit/") || path.startsWith("/product/") || path.startsWith("/manager/login") || path.startsWith("/manager/register")) {
            log.info("request url is /wonfit/ or /product/ or manager/login");
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = cookieConfig.parseCookie(request);

        // token 안보내면 block
        if (accessToken == null) {
            log.error("Token 값을 찾을 수 없습니다.");
            filterChain.doFilter(request, response);
        }

        // accessToken에서 id 및 role 추출
        Long accessTokenMemberId = cookieConfig.getIdFromToken(accessToken);
        String accessTokenMemberRole = JwtUtil.getRole(accessToken, accessKey);
        log.info("accessToken MemberRole = {}", accessTokenMemberRole);

        if (accessTokenMemberRole.equals("USER")) {
            role = "ROLE_USER";
        } else if (accessTokenMemberRole.equals("ADMIN")) {
            role = "ROLE_ADMIN";
        }
        log.info(role);

        // accessToken과 매칭되는 member의 refreshToken을 가져옴
        String refreshToken = memberRepository.findById(accessTokenMemberId).get().getRefreshToken();
        log.info("refreshToken = {}", refreshToken);
        log.info("refreshKey = {}", refreshKey);
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
                accessToken = JwtUtil.createAccessToken(accessTokenMemberId.toString(), 1000 * 60 * 60l, role, accessKey);
                log.info("Regenerated accessToken");
                Cookie responseCookie = cookieConfig.createCookie(accessToken);
                response.addCookie(responseCookie);
            }
        }
        id = accessTokenMemberId.toString();

        // 권한 부여
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, null, List.of(new SimpleGrantedAuthority(role)));
        // Detail
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
