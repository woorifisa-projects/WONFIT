package com.woori.wonfit.product.fund.repository;

import com.woori.wonfit.product.fund.domain.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRepository extends JpaRepository<Fund, Long> {
    List<Fund> findAll();
}
