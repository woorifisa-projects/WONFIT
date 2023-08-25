package com.woori.wonfit.member.memberinfo.service;

import com.woori.wonfit.member.member.dto.MemberRegisterRequest;
import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
import com.woori.wonfit.member.memberinfo.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberInfoService {
    private final MemberInfoRepository memberInfoRepository;

    public void saveMemberInfo(MemberRegisterRequest memberRegisterRequest){
        MemberInfo memberInfo = memberRegisterRequest.toInfoEntity(memberRegisterRequest);
        memberInfoRepository.save(memberInfo);
    }

    public MemberInfo findByMemberId(Long id){
        Optional<MemberInfo> memberInfo = memberInfoRepository.findById(id);
        return memberInfo.get();
    }
}
