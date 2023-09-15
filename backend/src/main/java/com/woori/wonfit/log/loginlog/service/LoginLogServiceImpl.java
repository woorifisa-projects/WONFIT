package com.woori.wonfit.log.loginlog.service;

import com.woori.wonfit.log.loginlog.domain.LoginLog;
import com.woori.wonfit.log.loginlog.dto.LoginLogRequest;
import com.woori.wonfit.log.loginlog.repository.LoginLogRepository;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {
    private final LoginLogRepository loginLogRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<LoginLog> getAllLoginLog(String id) {
        List<LoginLog> loginLogs = loginLogRepository.findAllByMemberId(Long.parseLong(id));
        return loginLogs;
    }

    @Override
    public List<LoginLog> getAllLoginLog(Long id) {
        Member member = memberRepository.findById(id).get();
        List<LoginLog> loginLogs = getAllLoginLog(member.getId().toString());
        return loginLogs;
    }
}
