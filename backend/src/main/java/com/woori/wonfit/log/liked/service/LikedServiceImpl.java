package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.repository.LikedRepository;
import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LikedServiceImpl implements LikedService {
    private final LikedRepository likedRepository;
    private final MemberRepository memberRepository;
    @Override
    public Liked getLikedProducts(Long memberId) {
        return likedRepository.findByMemberId(memberId);
    }
}