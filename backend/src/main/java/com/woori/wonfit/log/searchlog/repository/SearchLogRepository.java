package com.woori.wonfit.log.searchlog.repository;

import com.woori.wonfit.log.searchlog.domain.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SearchLogRepository extends JpaRepository<SearchLog, Long> {
    List<SearchLog> findByMemberId(Long memberId);
}
