package com.woori.wonfit.manager.service;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositRequest;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsRequest;
import com.woori.wonfit.product.savings.dto.SavingsResponse;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    Fund createFund(FundRequest fundRequest);

    Savings createSavings(SavingsRequest savingsRequest);

    Deposit createDeposit(DepositRequest depositRequest);

    void deleteFund(Long id);

    void deleteDeposit(Long id);

    void deleteSavings(Long id);
}
