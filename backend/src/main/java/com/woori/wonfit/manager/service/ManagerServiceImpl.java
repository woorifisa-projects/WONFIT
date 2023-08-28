package com.woori.wonfit.manager.service;

import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositRequest;
import com.woori.wonfit.product.deposit.repository.DepositRepository;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.repository.FundRepository;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsRequest;
import com.woori.wonfit.product.savings.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final FundRepository fundRepository;
    private final SavingsRepository savingsRepository;
    private final DepositRepository depositRepository;

    @Override
    public Fund createFund(FundRequest fundRequest) {
        Fund fund = Fund.builder()
                .fundName(fundRequest.getFundName())
                .fundInfo(fundRequest.getFundInfo())
                .fundDesc(fundRequest.getFundDesc())
                .returnRate1(fundRequest.getReturnRate1())
                .returnRate2(fundRequest.getReturnRate2())
                .fundPrice(fundRequest.getFundPrice())
                .fundType(fundRequest.getFundType())
                .build();

        return fundRepository.save(fund);
    }

    @Override
    public Savings createSavings(SavingsRequest savingsRequest) {
        Savings savings = Savings.builder()
                .savingsName(savingsRequest.getSavingsName())
                .savingsInfo(savingsRequest.getSavingsInfo())
                .savingsDesc(savingsRequest.getSavingsDesc())
                .interestRate(savingsRequest.getInterestRate())
                .period(savingsRequest.getPeriod())
                .target(savingsRequest.getTarget())
                .maxDeposit(savingsRequest.getMaxDeposit())
                .savingsType(savingsRequest.getSavingsType())
                .build();

        return savingsRepository.save(savings);
    }
    @Override
    public Deposit createDeposit(DepositRequest depositRequest) {
        Deposit deposit = Deposit.builder()
                .depositName(depositRequest.getDepositName())
                .depositInfo(depositRequest.getDepositInfo())
                .depositDesc(depositRequest.getDepositDesc())
                .depositType(depositRequest.getDepositType())
                .interestRate(depositRequest.getInterestRate())
                .period(depositRequest.getPeriod())
                .target(depositRequest.getTarget())
                .minDeposit(depositRequest.getMinDeposit())
                .build();

        return depositRepository.save(deposit);
    }

    @Override
    public void deleteFund(Long id) {
        fundRepository.deleteById(id);


}

    @Override
    public void deleteDeposit(Long id) {
        depositRepository.deleteById(id);
    }

    @Override
    public void deleteSavings(Long id) {
        savingsRepository.deleteById(id);

    }





    }

