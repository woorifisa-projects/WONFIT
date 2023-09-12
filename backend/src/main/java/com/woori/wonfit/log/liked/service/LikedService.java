package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.liked.dto.LikedRequest;
import com.woori.wonfit.log.liked.dto.LikedResponse;

import java.util.List;

public interface LikedService {
    List<Liked> findByAllMemberId(Long memberId);

    String deleteById(Long id);

    LikedResponse save(LikedRequest likedRequest);
}