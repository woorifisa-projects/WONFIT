package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.repository.SubscribeLogRepository;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscribeLogServiceImpl implements SubscribeLogService {

    private final SubscribeLogRepository subscribeLogRepository;

    public SubscribeLogServiceImpl(SubscribeLogRepository subscribeLogRepository) {
        this.subscribeLogRepository = subscribeLogRepository;
    }

    @Override
    public SubscribeLog findByMemberId(Long memberId) {
        return subscribeLogRepository.findByMemberId(memberId);
    }
}
