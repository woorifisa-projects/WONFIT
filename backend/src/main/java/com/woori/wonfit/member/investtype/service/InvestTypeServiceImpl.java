package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.config.JwtUtil;
import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.investtype.repository.InvestTypeRepository;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class InvestTypeServiceImpl implements InvestTypeService {
    private final InvestTypeRepository investTypeRepository;
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    @Value("${jwt.token.access}")
    private String secretKey;
    @Override
    public InvestType save(HttpServletRequest request,InvestTypeRequest request1) {
        Cookie[] cookies = request.getCookies();
        long memberId = 0;
        for (Cookie cookie : cookies) {
            if (!cookie.getName().equals("key")) {
                continue;
            }

            String accessToken = cookie.getValue();

            String id = jwtUtil.getId(accessToken, secretKey);
            memberId = Long.parseLong(id);
        }
        String deposit_type = "검사를 진행 해주세요";
        String productType = request1.getProductType();

        int score = request1.getScore();

        if (score >=10 && score <=16) {
            deposit_type = "안정형";
        } else if (score >=17 && score <=23) {
            deposit_type = "중간형";
        } else if (score >=24 && score <=30) {
            deposit_type = "공격형";
        }
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Invalid memberId"));

        InvestType investType = investTypeRepository.findByMemberId(memberId);

        log.info(productType);
        if(productType.equals("예금")){
            investType.setDeposit_type(deposit_type);
            investType.setDepositQuizScore(score);
        }
        else if (productType.equals("적금")){
            investType.setSavings_type(deposit_type);
            investType.setSavingsQuizScore(score);
        }
        else if(productType.equals("펀드")){
            investType.setFund_type(deposit_type);
            investType.setFundQuizScore(score);
        }
        else if(productType.equals("대출")){
            investType.setLoan_type(deposit_type);
            investType.setLoanQuizScore(score);
        }
        investTypeRepository.save(investType);

        return investType;
    }

    @Override
    public void registInvestment(Member member) {
        InvestType investType = InvestType.builder().member(member).build();
        log.info("registInvestment called");
        investTypeRepository.save(investType);
    }

    @Override
    public List<InvestType> findByMemberId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        long memberId = 0;
        for (Cookie cookie : cookies) {
            if (!cookie.getName().equals("key")) {
                continue;
            }

            String accessToken = cookie.getValue();

            String id = jwtUtil.getId(accessToken, secretKey);
            memberId = Long.parseLong(id);


        }
        return investTypeRepository.findAllByMemberId(memberId);
    }
}