package com.woori.wonfit.config;

import com.woori.wonfit.member.member.service.MemberService;
import com.woori.wonfit.member.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    @Value("${jwt.token.secret}")
    private String secretkey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .csrf().disable().headers().frameOptions().disable()
                .and()
//                .authorizeRequests(auth -> auth.antMatchers("/member/**", "/manager/**", "/api/sublogs/member/**","/question", "/api/mypage/**/liked","/product/**").permitAll()
                .authorizeRequests(auth -> auth.antMatchers("/member/login", "/member/register").permitAll()
                        .antMatchers("/member/leave").hasAnyRole("USER").antMatchers("/manager/").hasAnyRole("ADMIN")
                .anyRequest().authenticated())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new JwtFilter(secretkey), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
