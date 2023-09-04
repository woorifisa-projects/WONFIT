package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;

import java.util.List;

public interface SubscribeLogService {
   List<SubscribeLog> findByMemberId(Long memberId);

    SubscribeLog save(SubscribeLog subscribeLog);
}