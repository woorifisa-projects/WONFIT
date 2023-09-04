package com.woori.wonfit.member.member.repository;


import com.woori.wonfit.member.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findById(Long id);

    @Query("select m.refreshToken from Member m where m.loginId = :loginId")
    Optional<String> findRefreshTokenByLoginId(@Param("loginId") String loginId);

}
