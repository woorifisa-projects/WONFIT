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
    public List<Liked> findByAllMemberId(Long memberId) {
        return likedRepository.findAllByMemberId(memberId);
    }

    @Override
    public Liked save(Liked liked) {
        return likedRepository.save(liked);
    }

    @Override
    public String deleteById(Long id) {
        likedRepository.deleteById(id);
        return "삭제가 완료되었습니다.";
    }
}