package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.config.CookieConfig;
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
    private final CookieConfig cookieConfig;

    @Override
    public Cookie save(InvestTypeRequest investTypeRequest, String id) {
        String symbol = "검사를 진행 해주세요";

        int score = investTypeRequest.getScore();
        String productType = investTypeRequest.getProductType();

        if (score >= 10 && score <= 16) {
            symbol = "safe";
        } else if (score >= 17 && score <= 23) {
            symbol = "middle";
        } else if (score >= 24 && score <= 30) {
            symbol = "attack";
        }

        InvestType investType = investTypeRepository.findByMemberId(Long.parseLong(id));

        log.info(productType);
        if (productType.equals("deposit")) {
            investType.setDeposit_type(symbol);
            investType.setDepositQuizScore(score);
        } else if (productType.equals("savings")) {
            investType.setSavings_type(symbol);
            investType.setSavingsQuizScore(score);
        } else if (productType.equals("fund")) {
            investType.setFund_type(symbol);
            investType.setFundQuizScore(score);
        } else if (productType.equals("loan")) {
            investType.setLoan_type(symbol);
            investType.setLoanQuizScore(score);
        }
        investTypeRepository.save(investType);

        Cookie cookie = cookieConfig.createCookie(productType, symbol);

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