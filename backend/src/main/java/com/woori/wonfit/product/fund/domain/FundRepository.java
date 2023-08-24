package com.woori.wonfit.product.fund.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface FundRepository extends JpaRepository<Fund, Long> {
}
