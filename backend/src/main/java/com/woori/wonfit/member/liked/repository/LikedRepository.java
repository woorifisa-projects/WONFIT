package com.woori.wonfit.member.liked.repository;

import com.woori.wonfit.member.liked.domain.Liked;
import com.woori.wonfit.member.member.domain.Member;
import org.springframework.data.repository.CrudRepository;


public interface LikedRepository extends CrudRepository<Liked, Long> {

    public Liked findByMemberId(Long memberId);
}
