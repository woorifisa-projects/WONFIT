package com.woori.wonfit.member.liked.controller;

import com.woori.wonfit.member.liked.domain.Liked;
import com.woori.wonfit.member.liked.service.LikedServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
public class LikedController {

    private final LikedServiceImpl likedService;
    @GetMapping("/{memberId}/liked")
    public ResponseEntity<Liked> getLikedProductList(@PathVariable Long memberId) {
        Liked likedList = likedService.getLikedProducts(memberId);
        return ResponseEntity.ok(likedList);
    }
}
