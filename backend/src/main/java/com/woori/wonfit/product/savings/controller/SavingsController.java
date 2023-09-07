package com.woori.wonfit.product.savings.controller;

import com.woori.wonfit.product.savings.dto.SavingsResponse;
import com.woori.wonfit.product.savings.service.SavingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product/savings")
@RequiredArgsConstructor
public class SavingsController {

    private final SavingsService savingsService;

    // 적금 상품 전체 조회
    @GetMapping
    public List<SavingsResponse> findAll() {
        List<SavingsResponse> list = savingsService.findAll();
        log.info("list call {}", list.get(0));
        return list;
    }

    // 적금 상품 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<SavingsResponse> findById(@PathVariable Long id) {
        SavingsResponse savingsResponse = savingsService.findById(id);
        System.out.println("done");
        return ResponseEntity.ok(savingsResponse);
    }
}
