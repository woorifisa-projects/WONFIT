package com.woori.wonfit.log.subscribelog.repository;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribeLogRepository extends JpaRepository<SubscribeLog, Long> {
    List<SubscribeLog> findAllByMemberId(Long memberId);

    SubscribeLog save(SubscribeLog subscribeLog);

    List<SubscribeLog> findByMemberIdAndDepositId(Long memberId, Long depositId);
    List<SubscribeLog> findByMemberIdAndSavingsId(Long memberId, Long SavingsId);
    List<SubscribeLog> findByMemberIdAndFundId(Long memberId, Long FundId);
    List<SubscribeLog> findByMemberIdAndLoanId(Long memberId, Long LoanId);
}