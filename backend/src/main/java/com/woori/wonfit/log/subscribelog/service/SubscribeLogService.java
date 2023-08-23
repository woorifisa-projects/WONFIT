package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.repository.SubscribeLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscribeLogService {

    private final SubscribeLogRepository subscribeLongRepository;

    public List<SubscribeLog> SubscribeLogsByMemberId(Long memberId) {
        return subscribeLongRepository.findAllByMemberId(memberId);
    }
}
