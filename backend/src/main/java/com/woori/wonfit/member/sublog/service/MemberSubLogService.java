package com.woori.wonfit.member.sublog.service;

import com.woori.wonfit.member.sublog.domain.SubLog;
import com.woori.wonfit.member.sublog.repository.MemberSubLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberSubLogService {

    @Autowired
    private final MemberSubLogRepository memberSubLogRepository;
    public List<SubLog> getSubLogsByMemberId(Long memberId) {
       return memberSubLogRepository.findByMemberId(memberId);
    }

}
