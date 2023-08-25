package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.repository.LikedRepository;
import com.woori.wonfit.log.liked.domain.Liked;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LikedServiceImpl implements LikedService {
    private final LikedRepository likedRepository;

    public LikedServiceImpl(LikedRepository likedRepository) {
        this.likedRepository = likedRepository;
    }

    @Override
    public Liked findByMemberId(Long memberId){
        return likedRepository.findByMemberId(memberId);
    }

}