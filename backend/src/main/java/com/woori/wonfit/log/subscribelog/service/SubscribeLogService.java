package com.woori.wonfit.log.subscribelog.service;




import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;



public interface SubscribeLogService {
    SubscribeLog findByMemberId(Long memberId);

}
