package com.woori.wonfit.product.savings.repository;

import com.woori.wonfit.product.savings.domain.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {

    List<Savings> findAll();
}
