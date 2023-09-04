package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.repository.SubscribeLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeLogServiceImpl implements SubscribeLogService {
    private final SubscribeLogRepository subscribeLogRepository;

    public SubscribeLogServiceImpl(SubscribeLogRepository subscribeLogRepository) {
        this.subscribeLogRepository = subscribeLogRepository;
    }

    @Override
    public SubscribeLog save(SubscribeLog subscribeLog) {
        return subscribeLogRepository.save(subscribeLog);
    }

    @Override
    public List<SubscribeLog> findByMemberId(Long memberId) {
        return subscribeLogRepository.findAllByMemberId(memberId);
    }
}