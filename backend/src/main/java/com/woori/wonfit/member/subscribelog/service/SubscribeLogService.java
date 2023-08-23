package com.woori.wonfit.member.subscribelog.service;

import com.woori.wonfit.member.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.member.subscribelog.repository.SubscribeLogRepository;
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
