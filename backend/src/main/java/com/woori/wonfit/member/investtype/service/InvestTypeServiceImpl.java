package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.investtype.repository.InvestTypeRepository;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
import com.woori.wonfit.member.member.repository.MemberRepository;
import com.woori.wonfit.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvestTypeServiceImpl implements InvestTypeService {
    private final InvestTypeRepository investTypeRepository;
    private final MemberRepository memberRepository;



    @Override
    public InvestType save(InvestTypeRequest request , Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Member memberEntity = member.get();

        InvestType investType = InvestType.toEntity(request , memberEntity);
        investTypeRepository.save(investType);
        return investType;
    }

    @Override
    public List<InvestType> findByMemberId(Long memberId) {

        return investTypeRepository.findAllByMemberId(memberId);
    }
}
