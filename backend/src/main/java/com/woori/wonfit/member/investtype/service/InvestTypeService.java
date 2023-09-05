package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.member.domain.Member;

import java.util.List;

public interface InvestTypeService {
    List<InvestType> findByMemberId(Long memberId);

    InvestType save(InvestTypeRequest investType, Long memberId);

    void registInvestment(Member member);
}
