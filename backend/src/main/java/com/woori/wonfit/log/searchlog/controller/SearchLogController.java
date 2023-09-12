package com.woori.wonfit.log.searchlog.controller;

import com.woori.wonfit.log.searchlog.dto.SearchLogRequest;
import com.woori.wonfit.log.searchlog.dto.SearchLogResponse;
import com.woori.wonfit.log.searchlog.service.SearchLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member/mypage/searchlog")
@RequiredArgsConstructor
public class SearchLogController {

    private final SearchLogServiceImpl searchLogService;

    // 검색 기록 저장
    @PostMapping
    public ResponseEntity<String> saveSearchLog(@RequestBody SearchLogRequest searchLogRequest, @AuthenticationPrincipal String id) {
        searchLogService.saveSearchLog(Long.parseLong(id), searchLogRequest);
        return new ResponseEntity<>("검색 기록 저장 완료", HttpStatus.OK);
    }

    // 회원 검색 기록 조회
    @GetMapping
    public ResponseEntity<List<SearchLogResponse>> getSearchLog(@AuthenticationPrincipal String id) {
        List<SearchLogResponse> searchLogList = searchLogService.findById(Long.parseLong(id));
        return new ResponseEntity<>(searchLogList, HttpStatus.OK);
    }

    // 회원 검색 기록 삭제
    @DeleteMapping("/{searchWord}")
    public ResponseEntity<String> deleteSearchLog(@PathVariable String searchWord, @AuthenticationPrincipal String id) {
        searchLogService.deleteSearchLog(Long.parseLong(id), searchWord);
        return new ResponseEntity<>("검색 기록 삭제 완료", HttpStatus.OK);
    }
}
