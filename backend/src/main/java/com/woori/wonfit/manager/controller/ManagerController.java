package com.woori.wonfit.manager.controller;


import com.woori.wonfit.manager.service.ManagerService;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/product/fund")
    public ResponseEntity<Fund> createFund(@RequestBody FundRequest fundRequest) {
        Fund createFund =managerService.createFund(fundRequest);
        return ResponseEntity.ok(createFund);
    }

}

