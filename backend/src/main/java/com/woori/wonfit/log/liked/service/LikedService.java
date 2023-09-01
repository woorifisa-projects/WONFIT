package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.domain.Liked;

import java.util.List;

public interface LikedService {
    List<Liked> findByAllMemberId(Long memberId);

    String deleteById(Long id);

    Liked save(Liked liked);
}