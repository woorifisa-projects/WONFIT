package com.woori.wonfit.product.productdeposit.repository;

import com.woori.wonfit.product.productdeposit.domain.ProductDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<ProductDeposit, Long> {
    List<ProductDeposit> findByMemberId(Long memberId);

    // Custom query methods can be added here
}
