package com.woori.wonfit.member.investtype.repository;

import com.woori.wonfit.member.investtype.domain.InvestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestTypeRepository extends JpaRepository<InvestType, Long> {
    List<InvestType> findAllByMemberId(Long memberId);

    InvestType findByMemberId(Long memberId);

    InvestType save(InvestType investType);
}
