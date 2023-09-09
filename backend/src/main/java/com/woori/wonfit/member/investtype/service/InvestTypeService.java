package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.member.domain.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface InvestTypeService {
    List<InvestType> findByMemberId(HttpServletRequest request);

    Cookie save(InvestTypeRequest investType, HttpServletRequest request);

    void registInvestment(Member member);


}
