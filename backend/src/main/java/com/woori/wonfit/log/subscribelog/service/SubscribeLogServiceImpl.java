package com.woori.wonfit.log.subscribelog.service;

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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscribeLogServiceImpl implements SubscribeLogService {
    private final SubscribeLogRepository subscribeLogRepository;
    private final MemberRepository memberRepository;
    private final DepositRepository depositRepository;
    private final SavingsRepository savingsRepository;
    private final FundRepository fundRepository;
    private final LoanRepository loanRepository;

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String time = date.format(formatter).substring(0, 19);

    @Override
    public SubscribeLog save(Long productId, String productType, SubscribeLogRequest subscribeLogRequest, String id) throws Exception {
        Member member = memberRepository.findById(Long.parseLong(id)).get();

        Deposit deposit = null;
        Savings savings = null;
        Fund fund = null;
        Loan loan = null;

        if (productType.equals("deposit")) {
            log.info("productType is ={}", productType);
            if (subscribeLogRepository.findByMemberIdAndDepositId(Long.parseLong(id), productId).size() >= 1) {
                throw new Exception("이미 가입한 상품입니다.");
            } else {
                deposit = depositRepository.findById(productId).orElse(null);
            }
        } else if (productType.equals("savings")) {
            log.info("productType is ={}", productType);
            if (subscribeLogRepository.findByMemberIdAndSavingsId(Long.parseLong(id), productId).size() >= 1) {
                throw new Exception("이미 가입한 상품입니다.");
            } else {
                savings = savingsRepository.findById(productId).orElse(null);
            }
        } else if (productType.equals("fund")) {
            log.info("productType is ={}", productType);
            if (subscribeLogRepository.findByMemberIdAndFundId(Long.parseLong(id), productId).size() >= 1) {
                throw new Exception("이미 가입한 상품입니다.");
            } else {
                fund = fundRepository.findById(productId).orElse(null);
            }
        } else if (productType.equals("loan")) {
            log.info("productType is ={}", productType);
            if (subscribeLogRepository.findByMemberIdAndLoanId(Long.parseLong(id), productId).size() >= 1) {
                throw new Exception("이미 가입한 상품입니다.");
            } else {
                loan = loanRepository.findById(productId).orElse(null);
            }
        }
        SubscribeLog log = SubscribeLogRequest.To_sub_log(subscribeLogRequest, member, deposit, savings, fund, loan, time);

        return subscribeLogRepository.save(log);
    }

    @Override
    public List<SubscribeLogResponse> findById(String id) {
        List<SubscribeLog> subscribeLogs = subscribeLogRepository.findAllByMemberId(Long.parseLong(id));

        List<SubscribeLogResponse> responseList = new ArrayList<>();

        for (SubscribeLog subscribeLog : subscribeLogs) {
            SubscribeLogResponse response = SubscribeLogResponse.From_sub_log(subscribeLog, time);
            responseList.add(response);
        }
        return responseList;
    }
}
