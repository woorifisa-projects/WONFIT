package com.woori.wonfit.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Getter
@Component
public class JwtUtil {
    @Value("${jwt.token.access}")
    private String accessKey;

    @Value("${jwt.token.refresh}")
    private String refreshKey;
    public static String getId(String token, String secretKey) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().get("id", String.class);
    }

    public static boolean isExpired(String token, String secretKey) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }

    public Claims getAccessClaims(String token){
        log.info("getClaims called");
        Claims claims = Jwts.parserBuilder().setSigningKey(accessKey).build().parseClaimsJws(token).getBody();
        return claims;
    }
    public Claims getRefreshClaims(String token){
        log.info("getRefreshClaims called");
        Claims claims = Jwts.parserBuilder().setSigningKey(refreshKey).build().parseClaimsJws(token).getBody();
        return claims;
    }

    public static Token createToken(String id, long accessExpireTime, long refreshExpireTime, String roles, String accessKey, String refreshKey) {
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

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(refreshTokenValidateTime)
                .signWith(SignatureAlgorithm.HS256, refreshKey)
                .compact();

        Token token = Token.builder().accessToken(accessToken).refreshToken(refreshToken).key(id).build();

        return token;
    }
}