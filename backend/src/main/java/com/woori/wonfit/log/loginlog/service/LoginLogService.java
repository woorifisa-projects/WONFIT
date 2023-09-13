package com.woori.wonfit.log.loginlog.service;

import com.woori.wonfit.log.loginlog.domain.LoginLog;
import com.woori.wonfit.log.loginlog.dto.LoginLogRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginLogService {
    List<LoginLog> getAllLoginLog(String id);

    List<LoginLog> getAllLoginLog(LoginLogRequest request);
}
