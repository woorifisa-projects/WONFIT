package com.woori.wonfit.member.member.repository;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MembersResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long > {
    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findById(Long id);

    @Query("SELECT NEW com.woori.wonfit.member.member.dto.MembersResponse(m.id, m.loginId, m.name, m.status, m.phoneNumber) FROM Member m")
    List<MembersResponse> selectMembersData();

    @Modifying
    @Query("UPDATE Member m SET m.annualIncome = :annualIncome, m.ageGroup = :ageGroup WHERE m.id = :id")
    void updateMemberMydata(@Param("id") Long id, @Param("annualIncome") String annualIncome, @Param("ageGroup") String ageGroup);

    @Modifying
    @Query("UPDATE Member m SET m.marketingInfoAgree = :marketingInfoAgree WHERE m.id = :id")
    void updateMemberMarketing(@Param("marketingInfoAgree") boolean marketingInfoAgree, @Param("id") Long id);

//    @Query("SELECT m.money, b.bankName FROM MyData m JOIN Bank b ON m.id = b.id WHERE m.id = :id")
//    List<Object[]> getMemberMydataForSelectedBanks(@Param("id") Long id);
@Query("SELECT m.money, b.bankName FROM MyData m JOIN Bank b ON m.id = b.id WHERE m.id = :id AND b.bankName IN :bankNames")
List<Object[]> getMemberMydataForSelectedBanks(@Param("id") Long id, @Param("bankNames") List<String> bankNames);


}
