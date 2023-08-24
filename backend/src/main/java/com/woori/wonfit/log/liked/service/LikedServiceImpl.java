package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.repository.LikedRepository;
import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.liked.dto.LikedAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LikedServiceImpl implements LikedService {
    private final LikedRepository likedRepository;
    @Override
    public List<Liked> getLikedProducts(Long memberId) {
        return likedRepository.findByMemberId(memberId);
    }

    @Override
    public Liked addLikedProduct(LikedAddRequest request) {
        return null;
    }

}