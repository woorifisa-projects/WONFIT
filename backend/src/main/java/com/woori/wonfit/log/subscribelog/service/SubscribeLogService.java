package com.woori.wonfit.log.subscribelog.service;


import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;


import java.util.List;


public interface SubscribeLogService {
    List<SubscribeLogResponse> findByMemberId(Long memberId);

}
