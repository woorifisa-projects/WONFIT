package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.domain.Liked;
import org.springframework.stereotype.Service;

@Service
public interface LikedService {
    public Liked getLikedProducts(Long userId);
}
