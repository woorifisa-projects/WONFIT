package com.woori.wonfit.product.loan.controller;

import com.woori.wonfit.product.loan.dto.LoanResponse;
import com.woori.wonfit.product.loan.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping
    public List<LoanResponse> findAll () {
        List<LoanResponse> list = loanService.findAll();
        log.info("list call {}", list.get(0));
        return list;



    }
}