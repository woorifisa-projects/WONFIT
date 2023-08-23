package com.woori.wonfit.member.sublog.repository;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.sublog.domain.SubLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface MemberSubLogRepository extends JpaRepository<SubLog, Long> {

    List<SubLog> findByMemberId(Long memberId);

}

