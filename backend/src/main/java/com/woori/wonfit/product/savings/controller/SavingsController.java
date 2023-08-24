package com.woori.wonfit.product.savings.controller;

import com.woori.wonfit.product.savings.dto.SavingsResponse;
import com.woori.wonfit.product.savings.service.SavingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/savings")
@RequiredArgsConstructor
public class SavingsController {

    private final SavingsService savingsService;  // final로 선언하여 의존성 주입

    @GetMapping
    public List<SavingsResponse> findAll() {
        List<SavingsResponse> list = savingsService.findAll();
        System.out.println(savingsService);
        log.info("list call {}", list.get(0));
        return list;
    }
}
