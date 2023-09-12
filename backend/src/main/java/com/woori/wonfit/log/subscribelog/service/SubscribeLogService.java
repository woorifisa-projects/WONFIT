package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SubscribeLogService {
    List<SubscribeLog> findByMemberId(Long memberId);

    SubscribeLog save(Long productId, String productType, SubscribeLogRequest subscribeLogRequest, HttpServletRequest request, String time);
}