package com.woori.wonfit.product.loan.service;

import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.loan.dto.LoanDTO;
import com.woori.wonfit.product.loan.dto.LoanResponse;
import com.woori.wonfit.product.loan.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .map(loan -> new LoanResponse(loan.getId(), loan.getLoanName(), loan.getInterestRate(), loan.getPeriod(), loan.getTarget(), loan.getLoanLimit(), loan.getLoanInfo(),loan.getLoanDesc(),loan.getLoanType())).collect(Collectors.toList());
        return loans;
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    public void updateLoan(Long id, LoanDTO request) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        Loan newLoan = Loan.builder()
                .id(id)
                .loanName(request.getLoanName())
                .interestRate(request.getInterestRate())
                .period(request.getPeriod())
                .target(request.getTarget())
                .loanLimit(request.getLoanLimit())
                .loanInfo(request.getLoanInfo())
                .loanDesc(request.getLoanDesc())
                .loanType(request.getLoanType())
                .build();


        loanRepository.save(newLoan); // 수정된 내용을 저장
    }

    @Override
    public LoanResponse findById(Long id) {
        Optional<Loan> loan = loanRepository.findById(id);

        return LoanResponse.builder()
                .id(loan.map(Loan::getId).orElse(0L))
                .loanName(loan.map(Loan::getLoanName).orElse("기본값"))
                .interestRate(loan.map(Loan::getInterestRate).orElse(0.0))
                .period(loan.map(Loan::getPeriod).orElse(0))
                .target(loan.map(Loan::getTarget).orElse("기본값"))
                .loanLimit(loan.map(Loan::getLoanLimit).orElse(0L))
                .loanInfo(loan.map(Loan::getLoanInfo).orElse("기본값"))
                .loanDesc(loan.map(Loan::getLoanDesc).orElse("기본값"))
                .loanType(loan.map(Loan::getLoanType).orElse("기본값"))
                .build();
    }

}