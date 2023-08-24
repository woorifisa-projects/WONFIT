package com.woori.wonfit.member.memberinfo.repository;

import com.woori.wonfit.member.memberinfo.domain.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

}