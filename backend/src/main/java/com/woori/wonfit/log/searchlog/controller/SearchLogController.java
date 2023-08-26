package com.woori.wonfit.log.searchlog.controller;

import com.woori.wonfit.log.searchlog.dto.SearchLogRequest;
import com.woori.wonfit.log.searchlog.dto.SearchLogResponse;
import com.woori.wonfit.log.searchlog.service.SearchLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member/searchlog")
@RequiredArgsConstructor
public class SearchLogController {

    private final SearchLogServiceImpl searchLogService;

    // 검색 기록 저장
    @PostMapping("/{memberid}")
    public ResponseEntity<String> saveSearchLog(@PathVariable Long memberid, @RequestBody SearchLogRequest searchLogRequest) {
        searchLogService.saveSearchLog(memberid, searchLogRequest);
        return new ResponseEntity<>("검색 기록 저장 완료", HttpStatus.OK);
    }

    // 회원 검색 기록 조회
    @GetMapping("/{memberid}")
    public ResponseEntity<List<SearchLogResponse>> getSearchLog(@PathVariable Long memberid) {
        List<SearchLogResponse> searchLogList  = searchLogService.findById(memberid);
        return new ResponseEntity<>(searchLogList, HttpStatus.OK);
    }

    @DeleteMapping("/{memberid}/{searchWord}")
    public ResponseEntity<String> deleteSearchLog(@PathVariable Long memberid, @PathVariable String searchWord) {
        searchLogService.deleteSearchLog(memberid, searchWord);
        return new ResponseEntity<>("검색 기록 삭제 완료", HttpStatus.OK);
    }


}
