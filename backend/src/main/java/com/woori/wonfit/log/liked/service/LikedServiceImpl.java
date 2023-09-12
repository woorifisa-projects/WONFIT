package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.liked.dto.LikedRequest;
import com.woori.wonfit.log.liked.dto.LikedResponse;
import com.woori.wonfit.log.liked.repository.LikedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedServiceImpl implements LikedService {
    private final LikedRepository likedRepository;

    public LikedServiceImpl(LikedRepository likedRepository) {
        this.likedRepository = likedRepository;
    }

    @Override
    public List<Liked> findByAllMemberId(Long memberId) {
        return likedRepository.findAllByMemberId(memberId);
    }

    @Override
    public LikedResponse save(LikedRequest likedRequest) {
        Liked liked = LikedRequest.To_Liked(likedRequest);
        Liked createLiked = likedRepository.save(liked);
        LikedResponse likedResponse = LikedResponse.From_liked(createLiked);
        return likedResponse;
    }

    @Override
    public String deleteById(Long id) {
        likedRepository.deleteById(id);
        return "삭제가 완료되었습니다.";
    }
}