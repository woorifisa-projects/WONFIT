package com.woori.wonfit.log.loginlog.repository;

import com.woori.wonfit.log.loginlog.domain.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
}
