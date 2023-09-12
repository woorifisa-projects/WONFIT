package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.member.domain.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface InvestTypeService {
    List<InvestType> findByMemberId(String id);

    Cookie save(InvestTypeRequest investType, String id);

    void registInvestment(Member member);


}
