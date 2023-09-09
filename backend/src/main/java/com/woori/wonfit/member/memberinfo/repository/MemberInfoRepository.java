package com.woori.wonfit.member.memberinfo.repository;

import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
    Optional<MemberInfo> findByMemberId(Long id);
}