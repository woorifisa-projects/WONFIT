package com.woori.wonfit.log.liked.domain;

import org.springframework.data.repository.CrudRepository;


public interface LikedRepository extends CrudRepository<Liked, Long> {

    public Liked findByMemberId(Long memberId);
}
