package com.woori.wonfit.manager.controller;


import com.woori.wonfit.manager.dto.LoanRequest;
import com.woori.wonfit.manager.dto.LoanResponse;
import com.woori.wonfit.manager.service.ManagerService;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositRequest;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.loan.service.LoanService;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final LoanService loanService;

    @PostMapping("/product/fund")
    public ResponseEntity<Fund> createFund(@RequestBody FundRequest fundRequest) {
        Fund createFund = managerService.createFund(fundRequest);
        return ResponseEntity.ok(createFund);
    }

    @PostMapping("/product/savings")
    public ResponseEntity<Savings> createSavings(@RequestBody SavingsRequest savingsRequest) {
        Savings createSavings = managerService.createSavings(savingsRequest);
        return ResponseEntity.ok(createSavings);
    }

    @PostMapping("/product/deposit")
    public ResponseEntity<Deposit> createDeposit (@RequestBody DepositRequest depositRequest) {
        Deposit createDeposit = managerService.createDeposit(depositRequest);
        return ResponseEntity.ok(createDeposit);
    }
    @PostMapping("/product/loan/")
    public ResponseEntity<LoanResponse> save(@RequestBody LoanRequest loanRequest) {
        Loan loan = LoanRequest.toLoan(loanRequest);
        Loan savedLoan = loanService.save(loan);
        LoanResponse loanResponse = LoanResponse.FromLoan(savedLoan);
        return ResponseEntity.ok(loanResponse);
    }

}

