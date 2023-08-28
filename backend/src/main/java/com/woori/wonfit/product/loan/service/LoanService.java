package com.woori.wonfit.product.loan.service;

import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.loan.dto.LoanDTO;
import com.woori.wonfit.product.loan.dto.LoanResponse;

import java.util.List;

public interface LoanService {

    List<LoanResponse> findAll();

    Loan save(Loan loan);

    void deleteLoan(Long id);

    void updateLoan(Long id, LoanDTO loanDTO);

}
