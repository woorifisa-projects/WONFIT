package com.woori.wonfit.log.loginlog.controller;

import com.woori.wonfit.log.loginlog.domain.LoginLog;
import com.woori.wonfit.log.loginlog.service.LoginLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/member/mypage/loginlog")
@RestController
@RequiredArgsConstructor
public class LoginLogController {
    private final LoginLogService loginLogService;

    // 멤버 로그인 로그 조회
    @GetMapping
    public ResponseEntity<List<LoginLog>> getAllLoginLog(@AuthenticationPrincipal String id) {
        List<LoginLog> loginLogs = loginLogService.getAllLoginLog(id);
        return new ResponseEntity<>(loginLogs, HttpStatus.OK);
    }

    // 관리자 로그인 로그 조회
    @GetMapping("/by/{id}")
    public ResponseEntity<List<LoginLog>> getAllLoginLog(@PathVariable Long id) {
        log.info("LoginLogController called");
        List<LoginLog> loginLogs = loginLogService.getAllLoginLog(id);
        return new ResponseEntity<>(loginLogs, HttpStatus.OK);
    }
}
