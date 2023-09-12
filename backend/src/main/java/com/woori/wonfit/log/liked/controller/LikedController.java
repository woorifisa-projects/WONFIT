package com.woori.wonfit.log.liked.controller;

import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.liked.dto.LikedRequest;
import com.woori.wonfit.log.liked.dto.LikedResponse;
import com.woori.wonfit.log.liked.service.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member/mypage/liked")
@RequiredArgsConstructor
public class LikedController {
    private final LikedService likedService;

    // 멤버 1명 좋아요 기록 전체 가져오기
    @GetMapping
    public List<Liked> findByMemberId(@AuthenticationPrincipal String id) {
        List<Liked> list = likedService.findByAllMemberId(Long.parseLong(id));
        return list;
    }

    // 좋아요 기록 저장
    @PostMapping
    public ResponseEntity<LikedResponse> createLiked(@RequestBody LikedRequest likedRequest) {
        LikedResponse createLiked = likedService.save(likedRequest);
        return new ResponseEntity<>(createLiked, HttpStatus.OK);
    }

    // 좋아요 기록 삭제
    @DeleteMapping
    public ResponseEntity<String> deleteByLikedId(@PathVariable Long likedId) {
        String result = likedService.deleteById(likedId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}