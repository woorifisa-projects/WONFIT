package com.woori.wonfit.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Getter
@Component
public class JwtUtil {
    public static String getId(String token, String secretKey) {
        try {
            log.info("called getid");
            log.info("getid accessToken = {}", token);
            log.info("getId accessKey = {}", secretKey);

            return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().get("id", String.class);
        } catch (ExpiredJwtException e) {
            Claims claims = e.getClaims();
            log.info(claims.get("id", String.class));

            return claims.get("id", String.class);
        }
    }


    public static boolean isExpired(String token, String secretKey) {
        try {
            return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            // JWT 만료되었을 때 true
            return true;
        }
    }


    public static String createAccessToken(String id, long accessExpireTime, long refreshExpireTime, String roles, String accessKey) {
        Claims claims = Jwts.claims();
        claims.put("roles", roles);
        claims.put("id", id);

        Date now = new Date();
        Date accessTokenValidateTime = new Date(now.getTime() + accessExpireTime);
        log.info("accessTokenExpireTime = {}", accessTokenValidateTime);
        Date refreshTokenValidateTime = new Date(now.getTime() + refreshExpireTime);
        log.info("refreshTokenExpireTime = {}", refreshTokenValidateTime);

        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(accessTokenValidateTime)
                .signWith(SignatureAlgorithm.HS256, accessKey)
                .compact();

        return accessToken;
    }
    public static String createRefreshToken(String id, long accessExpireTime, long refreshExpireTime, String roles, String refreshKey) {
        Claims claims = Jwts.claims();
        claims.put("roles", roles);
        claims.put("id", id);

        Date now = new Date();
        Date accessTokenValidateTime = new Date(now.getTime() + accessExpireTime);
        log.info("accessTokenExpireTime = {}", accessTokenValidateTime);
        Date refreshTokenValidateTime = new Date(now.getTime() + refreshExpireTime);
        log.info("refreshTokenExpireTime = {}", refreshTokenValidateTime);

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(refreshTokenValidateTime)
                .signWith(SignatureAlgorithm.HS256, refreshKey)
                .compact();

        return refreshToken;
    }
}