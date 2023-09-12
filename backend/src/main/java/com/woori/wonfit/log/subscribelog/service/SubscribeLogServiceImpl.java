package com.woori.wonfit.log.subscribelog.service;

import com.woori.wonfit.config.CookieConfig;
import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogRequest;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;
import com.woori.wonfit.log.subscribelog.repository.SubscribeLogRepository;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.repository.MemberRepository;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.repository.DepositRepository;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.repository.FundRepository;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.loan.repository.LoanRepository;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscribeLogServiceImpl implements SubscribeLogService {
    private final SubscribeLogRepository subscribeLogRepository;
    private final CookieConfig cookieConfig;
    private final MemberRepository memberRepository;
    private final DepositRepository depositRepository;
    private final SavingsRepository savingsRepository;
    private final FundRepository fundRepository;
    private final LoanRepository loanRepository;


    @Override
    public SubscribeLog save(Long productId, String productType, SubscribeLogRequest subscribeLogRequest, HttpServletRequest request, String time) {
        String token = cookieConfig.parseCookie(request);
        Long memberId = cookieConfig.getIdFromToken(token);

        Member member = memberRepository.findById(memberId).get();
        Deposit deposit = null;
        Savings savings = null;
        Fund fund = null;
        Loan loan = null;

        if(productType.equals("deposit")){
            log.info("productType is ={}", productType);
            deposit = depositRepository.findById(productId).orElse(null);
        } else if (productType.equals("savings")) {
            log.info("productType is ={}", productType);
            savings = savingsRepository.findById(productId).orElse(null);
        } else if (productType.equals("fund")) {
            log.info("productType is ={}", productType);
            fund = fundRepository.findById(productId).orElse(null);
        } else if (productType.equals("loan")) {
            log.info("productType is ={}", productType);
            loan = loanRepository.findById(productId).orElse(null);
        }

        SubscribeLog log = SubscribeLogRequest.To_sub_log(subscribeLogRequest, member, deposit, savings, fund, loan, time);

        return subscribeLogRepository.save(log);
    }

    @Override
    public List<SubscribeLog> findByMemberId(Long memberId) {
        return subscribeLogRepository.findAllByMemberId(memberId);
    }
}