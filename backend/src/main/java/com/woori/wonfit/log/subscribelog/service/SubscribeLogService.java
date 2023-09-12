package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogRequest;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;

import java.util.List;

public interface SubscribeLogService {
    SubscribeLog save(Long productId, String productType, SubscribeLogRequest subscribeLogRequest, String id) throws Exception;

    List<SubscribeLogResponse> findById(String id);
}
