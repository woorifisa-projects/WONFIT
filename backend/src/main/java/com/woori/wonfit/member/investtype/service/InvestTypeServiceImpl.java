package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.investtype.repository.InvestTypeRepository;
import com.woori.wonfit.member.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class InvestTypeServiceImpl implements InvestTypeService {
    private final InvestTypeRepository investTypeRepository;

    @Override
    public Cookie save(InvestTypeRequest investTypeRequest, String id) {
        String deposit_type = "검사를 진행 해주세요";

        int score = investTypeRequest.getScore();
        String productType = investTypeRequest.getProductType();

        if (score >= 10 && score <= 16) {
            deposit_type = "safe";
        } else if (score >= 17 && score <= 23) {
            deposit_type = "middle";
        } else if (score >= 24 && score <= 30) {
            deposit_type = "attack";
        }

        InvestType investType = investTypeRepository.findByMemberId(Long.parseLong(id));

        log.info(productType);
        if (productType.equals("deposit")) {
            investType.setDeposit_type(deposit_type);
            investType.setDepositQuizScore(score);
        } else if (productType.equals("savings")) {
            investType.setSavings_type(deposit_type);
            investType.setSavingsQuizScore(score);
        } else if (productType.equals("fund")) {
            investType.setFund_type(deposit_type);
            investType.setFundQuizScore(score);
        } else if (productType.equals("loan")) {
            investType.setLoan_type(deposit_type);
            investType.setLoanQuizScore(score);
        }
        investTypeRepository.save(investType);

        Cookie cookie = new Cookie(productType, deposit_type);
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setPath("/");

        return cookie;
    }

    @Override
    public void registInvestment(Member member) {
        InvestType investType = InvestType.builder().member(member).build();
        log.info("registInvestment called");
        investTypeRepository.save(investType);
    }

    @Override
    public List<InvestType> findByMemberId(String id) {
        return investTypeRepository.findAllByMemberId(Long.parseLong(id));
    }
}