package com.woori.wonfit.log.loginlog.repository;

import com.woori.wonfit.log.loginlog.domain.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {

    List<LoginLog> findAllByMemberId(Long id);
}
