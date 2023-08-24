package com.woori.wonfit.product.loan.service;

import com.woori.wonfit.product.loan.repository.LoanRepository;
import com.woori.wonfit.product.loan.dto.LoanResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        super();
        this.loanRepository = loanRepository;
    }


    @Override
    public List<LoanResponse> findAll() {
        List<LoanResponse> loans = loanRepository.findAll().stream()

                .map(loan -> new LoanResponse(loan.getId(), loan.getLoanName(), loan.getInterestRate(), loan.getPeriod(), loan.getTarget(), loan.getLoanLimit(), loan.getLoanInfo(),loan.getLoanDesc())).collect(Collectors.toList());


        return loans;
    }
}
