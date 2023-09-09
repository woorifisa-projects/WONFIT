package com.woori.wonfit.manager.service;

import com.woori.wonfit.manager.dto.ManagerLoginRequest;
import com.woori.wonfit.manager.dto.DeleteMemberRequest;
import com.woori.wonfit.manager.dto.ManagerRegisterRequest;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositRequest;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsRequest;

import javax.servlet.http.Cookie;

public interface ManagerService {

    String managerRegister(ManagerRegisterRequest request);

    Cookie managerLogin(ManagerLoginRequest request);

    Fund createFund(FundRequest fundRequest);

    Savings createSavings(SavingsRequest savingsRequest);

    Deposit createDeposit(DepositRequest depositRequest);

    void deleteFund(Long id);

    void deleteDeposit(Long id);

    void deleteSavings(Long id);

    String deleteMember(DeleteMemberRequest request);
}
