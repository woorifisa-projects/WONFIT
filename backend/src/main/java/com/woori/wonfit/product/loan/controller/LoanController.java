package com.woori.wonfit.product.loan.controller;

import com.woori.wonfit.product.loan.dto.LoanResponse;
import com.woori.wonfit.product.loan.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product/loan")
public class LoanController {

    private LoanService loanService;
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // 대출 상품 전체 조회
    @GetMapping
    public List<LoanResponse> findAll () {
        List<LoanResponse> list = loanService.findAll();
        log.info("list call {}", list.get(0));
        return list;
    }

    // 대출 상품 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> findById(@PathVariable Long id) {
        LoanResponse loanResponse = loanService.findById(id);
        System.out.println("done");
        return ResponseEntity.ok(loanResponse);
    }
}