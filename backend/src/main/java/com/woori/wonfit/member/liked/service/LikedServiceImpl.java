package com.woori.wonfit.member.liked.service;

import com.woori.wonfit.member.liked.domain.Liked;
import com.woori.wonfit.member.liked.repository.LikedRepository;
import com.woori.wonfit.member.member.domain.MemberRepository;
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