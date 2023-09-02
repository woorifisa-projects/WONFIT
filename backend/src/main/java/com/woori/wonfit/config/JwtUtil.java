package com.woori.wonfit.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtil {
    public static String getLoginId(String token, String secretKey) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().get("loginId", String.class);
    }

    public static boolean isExpired(String token, String secretKey) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }

    public static Token createToken(String loginId, long expireTimeMs, String accessTokenKey, String refreshTokenKey, String roles) {
        Claims claims = Jwts.claims();
        claims.put("roles", roles);
        claims.put("loginId", loginId);

        Date now = new Date();
        Date accessTokenValidateTime = new Date(expireTimeMs);
        Date refreshTokenValidateTime = new Date(expireTimeMs * 24);

        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(accessTokenValidateTime)
                .signWith(SignatureAlgorithm.HS256, accessTokenKey) // key 부분 수정
                .compact();

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(refreshTokenValidateTime)
                .signWith(SignatureAlgorithm.HS256, refreshTokenKey) // key 부분 수정
                .compact();

        Token token = Token.builder().accessToken(accessToken).refreshToken(refreshToken).key(loginId).build();

        return token;
    }
}