package com.woori.wonfit.member.investtype.service;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.investtype.repository.InvestTypeRepository;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
import com.woori.wonfit.member.member.repository.MemberRepository;
import com.woori.wonfit.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvestTypeServiceImpl implements InvestTypeService {
    private final InvestTypeRepository investTypeRepository;
    private final MemberRepository memberRepository;

    @Override
    public InvestType save(InvestTypeRequest request , Long memberId) {
        String deposit_type = "검사를 진행 해주세요";
        String productType = request.getProductType();

        int score = request.getScore();

        if (score >=1 && score <=20) {
            deposit_type = "안정형";
        } else if (score >20 && score <=25) {
            deposit_type = "중간형";
        } else if (score >25) {
            deposit_type = "공격형";
        }
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Invalid memberId"));

        InvestType investType = investTypeRepository.findByMemberId(memberId);

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
    public List<InvestType> findByMemberId(Long memberId) {

        return investTypeRepository.findAllByMemberId(memberId);
    }
}