package com.woori.wonfit.product.loan.repository;

import com.woori.wonfit.product.loan.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAll();
    Loan save(Loan loan);

}
