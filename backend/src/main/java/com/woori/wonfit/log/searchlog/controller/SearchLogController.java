package com.woori.wonfit.log.searchlog.controller;

import com.woori.wonfit.config.CookieConfig;
import com.woori.wonfit.log.searchlog.dto.SearchLogRequest;
import com.woori.wonfit.log.searchlog.dto.SearchLogResponse;
import com.woori.wonfit.log.searchlog.service.SearchLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/member/mypage/searchlog")
@RequiredArgsConstructor
public class SearchLogController {

    private final SearchLogServiceImpl searchLogService;
    private final CookieConfig cookieConfig;

    // 검색 기록 저장
    @PostMapping
    public ResponseEntity<String> saveSearchLog(@RequestBody SearchLogRequest searchLogRequest, HttpServletRequest request) {
        String token = cookieConfig.parseCookie(request);
        Long memberId = cookieConfig.getIdFromToken(token);
        searchLogService.saveSearchLog(memberId, searchLogRequest);
        return new ResponseEntity<>("검색 기록 저장 완료", HttpStatus.OK);
    }

    // 회원 검색 기록 조회
    @GetMapping
    public ResponseEntity<List<SearchLogResponse>> getSearchLog(@PathVariable Long memberid) {
        List<SearchLogResponse> searchLogList  = searchLogService.findById(memberid);
        return new ResponseEntity<>(searchLogList, HttpStatus.OK);
    }

    // 회원 검색 기록 삭제
    @DeleteMapping("/{searchWord}")
    public ResponseEntity<String> deleteSearchLog(@PathVariable String searchWord, HttpServletRequest request) {
        String token = cookieConfig.parseCookie(request);
        Long memberId  = cookieConfig.getIdFromToken(token);
        searchLogService.deleteSearchLog(memberId, searchWord);
        return new ResponseEntity<>("검색 기록 삭제 완료", HttpStatus.OK);
    }

}
