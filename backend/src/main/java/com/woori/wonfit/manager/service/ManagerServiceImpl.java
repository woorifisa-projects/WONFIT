package com.woori.wonfit.manager.service;

import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositRequest;
import com.woori.wonfit.product.deposit.repository.DepositRepository;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsRequest;
import com.woori.wonfit.product.fund.repository.FundRepository;
import com.woori.wonfit.product.savings.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final FundRepository fundRepository;

    private final SavingsRepository savingsRepository;

    private final DepositRepository depositRepository;

        @Override
        public Fund createFund(FundRequest fundRequest) {
            Fund fund = new Fund();
            fund.setFundName(fundRequest.getFundName());
            fund.setFundInfo(fundRequest.getFundInfo());
            fund.setFundDesc(fundRequest.getFundDesc());
            fund.setReturnRate1(fundRequest.getReturnRate1());
            fund.setReturnRate2(fundRequest.getReturnRate2());
            fund.setFundPrice(fundRequest.getFundPrice());
            fund.setFundType(fundRequest.getFundType());

            return fundRepository.save(fund);
    }

    @Override
    public Savings createSavings(SavingsRequest savingsRequest) {
        Savings savings = new Savings();
        savings.setSavingsName(savingsRequest.getSavingsName());
        savings.setSavingsInfo(savingsRequest.getSavingsInfo());
        savings.setSavingsDesc(savingsRequest.getSavingsDesc());
        savings.setInterestRate(savingsRequest.getInterestRate());
        savings.setPeriod(savingsRequest.getPeriod());
        savings.setTarget(savingsRequest.getTarget());
        savings.setMaxDeposit(savingsRequest.getMaxDeposit());

        return savingsRepository.save(savings);
    }



    @Override
    public Deposit createDeposit(DepositRequest depositRequest) {
        Deposit deposit = new Deposit();
        deposit.setDepositName(depositRequest.getDepositName());
        deposit.setDepositInfo(depositRequest.getDepositInfo());
        deposit.setDepositDesc(depositRequest.getDepositDesc());
        deposit.setInterestRate(depositRequest.getInterestRate());
        deposit.setPeriod(depositRequest.getPeriod());
        deposit.setTarget(depositRequest.getTarget());
        deposit.setMinDeposit(depositRequest.getMinDeposit());

        return depositRepository.save(deposit);
    }



}