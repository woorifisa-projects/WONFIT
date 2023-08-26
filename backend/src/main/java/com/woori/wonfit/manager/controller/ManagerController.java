package com.woori.wonfit.manager.controller;


import com.woori.wonfit.manager.dto.LoanRequest;
import com.woori.wonfit.manager.dto.LoanResponse;
import com.woori.wonfit.manager.service.ManagerService;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositDTO;
import com.woori.wonfit.product.deposit.dto.DepositRequest;
import com.woori.wonfit.product.deposit.service.DepositService;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundDTO;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.service.FundService;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.loan.dto.LoanDTO;
import com.woori.wonfit.product.loan.service.LoanService;
import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsDTO;
import com.woori.wonfit.product.savings.dto.SavingsRequest;
import com.woori.wonfit.product.savings.service.SavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final LoanService loanService;
    private final DepositService depositService;
    private final SavingsService savingsService;
    private final FundService fundService;

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
    public ResponseEntity<Deposit> createDeposit(@RequestBody DepositRequest depositRequest) {
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

    @DeleteMapping("/product/deposit/{id}")
    public ResponseEntity<Void> deleteDeposit(@PathVariable Long id) {
        managerService.deleteDeposit(id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/product/savings/{id}")
    public ResponseEntity<Void> deleteSavings(@PathVariable Long id) {
        managerService.deleteSavings(id);
        return ResponseEntity.ok().build();

    }


    @DeleteMapping("/product/fund/{id}")
    public ResponseEntity<Void> deleteFund(@PathVariable Long id) {
        managerService.deleteFund(id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/product/loan/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.ok().build();

    }
    @PatchMapping("/product/deposit/{id}")
    public ResponseEntity<String> updateDeposit(@PathVariable Long id, @RequestBody DepositDTO depositDTO) {
        depositService.updateDeposit(id, depositDTO);
        return ResponseEntity.ok("Deposit updated successfully.");
    }

    @PatchMapping("/product/savings/{id}")
    public ResponseEntity<String> updateSavings(@PathVariable Long id, @RequestBody SavingsDTO savingsDTO) {
        savingsService.updateSavings(id, savingsDTO);
        return ResponseEntity.ok("Savings updated successfully.");
    }

    @PatchMapping("/product/fund/{id}")
    public ResponseEntity<String> updateFund(@PathVariable Long id, @RequestBody FundDTO fundDTO) {
        fundService.updateFund(id, fundDTO);
        return ResponseEntity.ok("Fund updated successfully.");

    }

    @PatchMapping("/product/loan/{id}")
    public ResponseEntity<String> updateLoan(@PathVariable Long id, @RequestBody LoanDTO loanDTO) {
        loanService.updateLoan(id, loanDTO);
        return ResponseEntity.ok("Loan updated successfully.");
    }

}



