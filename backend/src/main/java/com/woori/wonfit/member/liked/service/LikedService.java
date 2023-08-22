package com.woori.wonfit.member.liked.service;

import com.woori.wonfit.member.liked.domain.Liked;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikedService {
    public Liked getLikedProducts(Long userId);
}
