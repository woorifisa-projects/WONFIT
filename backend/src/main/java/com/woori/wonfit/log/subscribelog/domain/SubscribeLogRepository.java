package com.woori.wonfit.log.subscribelog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribeLogRepository extends JpaRepository<SubscribeLog, Long> {

     List<SubscribeLog> findByMemberId(Long memberId);

}
