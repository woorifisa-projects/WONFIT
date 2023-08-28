package com.woori.wonfit.log.liked.controller;

import com.woori.wonfit.log.liked.dto.LikedResponse;
import com.woori.wonfit.log.liked.service.LikedService;
import com.woori.wonfit.log.liked.domain.Liked;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


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

    @DeleteMapping("/delete/member/{likedid}")
    public String deleteByLikedId(@PathVariable Long likedid) {
        String result = likedService.deleteById(likedid);
        return result;
    }
}
