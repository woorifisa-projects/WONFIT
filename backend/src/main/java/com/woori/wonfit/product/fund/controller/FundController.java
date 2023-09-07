package com.woori.wonfit.product.fund.controller;


import com.woori.wonfit.product.fund.dto.FundResponse;
import com.woori.wonfit.product.fund.service.FundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Slf4j // log 기록
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/fund")
public class FundController {

    private final FundService fundService;

    // 펀드 상품 전체 조회
    @GetMapping
        public List<FundResponse> findAll() {
            List<FundResponse> list = fundService.findAll();
            return list;
        }

    // 펀드 상품 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<FundResponse> findById(@PathVariable Long id) {
        FundResponse fundResponse = fundService.findById(id);
        return ResponseEntity.ok(fundResponse);
    }
}
