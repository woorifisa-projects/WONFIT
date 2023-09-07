package com.woori.wonfit.log.liked.controller;

import com.woori.wonfit.config.CookieConfig;
import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.liked.dto.LikedRequest;
import com.woori.wonfit.log.liked.dto.LikedResponse;
import com.woori.wonfit.log.liked.service.LikedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/member/mypage/liked")
@RequiredArgsConstructor
public class LikedController {
    private final LikedService likedService;
    private final CookieConfig cookieConfig;

    // 멤버 1명 좋아요 기록 전체 가져오기
    @GetMapping
    public List<Liked> findByMemberId(HttpServletRequest request) {
        String token = cookieConfig.parseCookie(request);
        Long memberId = cookieConfig.getIdFromToken(token);
        List<Liked> list = likedService.findByAllMemberId(memberId);
        return list;
    }

    // 좋아요 기록 저장
    @PostMapping
    public ResponseEntity<LikedResponse> createLiked(@RequestBody LikedRequest likedRequest) {
        Liked liked = LikedRequest.To_Liked(likedRequest);
        Liked createLiked = likedService.save(liked);
        LikedResponse likedResponse = LikedResponse.From_liked(createLiked);
        return new ResponseEntity<>(likedResponse, HttpStatus.OK);
    }

    // 좋아요 기록 삭제
    @DeleteMapping
    public ResponseEntity<String> deleteByLikedId(@PathVariable Long likedId) {
        String result = likedService.deleteById(likedId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}