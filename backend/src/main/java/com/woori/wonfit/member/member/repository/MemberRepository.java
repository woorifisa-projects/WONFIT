package com.woori.wonfit.member.member.repository;


import com.woori.wonfit.member.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberLoginId(String MemberLoginId);
}
