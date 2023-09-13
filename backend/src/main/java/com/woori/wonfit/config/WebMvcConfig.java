package com.woori.wonfit.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*") // 허용할 출처
//                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // 허용할 HTTP method
//                .allowCredentials(true) // 쿠키 인증 요청 허용
//                .maxAge(3000);
//    }
//}
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:80", "http://localhost:8080", "https://wonfit.site", "http://wonfit/site", "http://localhost:3000") // 허용할 출처를 패턴으로 지정
                .allowedMethods("*") // 허용할 HTTP method
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000);
    }
}
