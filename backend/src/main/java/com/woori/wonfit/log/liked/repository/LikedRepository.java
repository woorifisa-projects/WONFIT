package com.woori.wonfit.log.liked.repository;

import com.woori.wonfit.log.liked.domain.Liked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface LikedRepository extends JpaRepository<Liked, Long> {
    List<Liked> findAllByMemberId(Long memberId);

    Liked save(Liked liked);

    void deleteById(Long id);
}