package com.woori.wonfit.log.liked.controller;

import com.woori.wonfit.log.liked.dto.LikedResponse;
import com.woori.wonfit.log.liked.service.LikedService;
import com.woori.wonfit.log.liked.domain.Liked;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/member/mypage")
@RequiredArgsConstructor
public class LikedController {

    private final LikedService likedService;

    @GetMapping("/member/{memberId}")
    public List<Liked> findByMemberId(@PathVariable Long memberId) {
        List<Liked> list = likedService.findByAllMemberId(memberId);
        return list;
    }

}
