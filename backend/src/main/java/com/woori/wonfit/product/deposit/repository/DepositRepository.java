package com.woori.wonfit.product.deposit.repository;

import com.woori.wonfit.product.deposit.domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
    List<Deposit> findByMemberId(Long memberId);

    // Custom query methods can be added here
}
