package com.woori.wonfit.log.smslog.repository;

import com.woori.wonfit.log.smslog.domain.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<Sms, Long> {
}
