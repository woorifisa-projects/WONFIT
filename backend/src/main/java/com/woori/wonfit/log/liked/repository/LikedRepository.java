package com.woori.wonfit.log.liked.repository;

import com.woori.wonfit.log.liked.domain.Liked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LikedRepository extends JpaRepository<Liked, Long> {

    List<Liked> findAllByMemberId(Long memberId);
}
