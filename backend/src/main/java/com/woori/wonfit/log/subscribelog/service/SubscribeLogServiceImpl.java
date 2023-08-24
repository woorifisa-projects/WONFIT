package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.log.subscribelog.repository.SubscribeLogRepository;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscribeLogServiceImpl implements SubscribeLogService {

    private final SubscribeLogRepository subscribeLogRepository;

    public SubscribeLogServiceImpl(SubscribeLogRepository subscribeLogRepository) {
        super();
        this.subscribeLogRepository = subscribeLogRepository;
    }
    @Override
    public List<SubscribeLogResponse> findByMemberId(Long memberId) {
        return subscribeLogRepository.findByMemberId(memberId).stream() // Use subscribeLogRepository instead of SubscribeLogRepository
                .map(SubscribeLog -> new SubscribeLogResponse(
                        SubscribeLog.getId(),
                        SubscribeLog.getMember(),
                        SubscribeLog.getSubDate(),
                        SubscribeLog.getExpireDate(),
                        SubscribeLog.getSubDeposit(),
                        SubscribeLog.getMonthlyCharge(),
                        SubscribeLog.isSubscribeStatus(),
                        SubscribeLog.getDeposit(),
                        SubscribeLog.getSavings(),
                        SubscribeLog.getFund(),
                        SubscribeLog.getLoan()
                ))
                .collect(Collectors.toList());
    }
}
