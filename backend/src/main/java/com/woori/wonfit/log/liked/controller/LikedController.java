package com.woori.wonfit.log.liked.controller;

import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.liked.dto.LikedRequest;
import com.woori.wonfit.log.liked.dto.LikedResponse;
import com.woori.wonfit.log.liked.service.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/wonfit/liked-product")
    public ResponseEntity<LikedResponse> createLiked(@RequestBody LikedRequest likedRequest) {
        Liked liked = LikedRequest.To_Liked(likedRequest);
        Liked createLiked = likedService.save(liked);
        LikedResponse likedResponse = LikedResponse.From_liked(createLiked);
        return ResponseEntity.ok(likedResponse);
    }

    @DeleteMapping("/delete/member/{likedId}")
    public String deleteByLikedId(@PathVariable Long likedId) {
        String result = likedService.deleteById(likedId);
        return result;
    }
}