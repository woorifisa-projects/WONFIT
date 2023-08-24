package com.woori.wonfit.log.liked.controller;

import com.woori.wonfit.log.liked.dto.LikedAddRequest;
import com.woori.wonfit.log.liked.dto.LikedMapper;
import com.woori.wonfit.log.liked.dto.LikedResponse;
import com.woori.wonfit.log.liked.service.LikedServiceImpl;
import com.woori.wonfit.log.liked.domain.Liked;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/member/mypage")
@RequiredArgsConstructor
public class LikedController {

    private final LikedServiceImpl likedService;
    private final LikedMapper likedMapper; // DTO 변환을 위한 Mapper

    @GetMapping("/{memberId}/liked")
    public ResponseEntity<List<LikedResponse>> getLikedProductList(@PathVariable Long memberId) {
        List<Liked> likedList = likedService.getLikedProducts(memberId);
        List<LikedResponse> likedDTOList = likedMapper.toDTOList(likedList); // 엔티티 -> DTO 변환
        return ResponseEntity.ok(likedDTOList);
    }

    @PostMapping("/{memberId}/liked/{productId}")
    public ResponseEntity<Liked> addLikedProduct(@RequestBody LikedAddRequest request) {
        return ResponseEntity.ok(likedService.addLikedProduct(request));
    }
}
