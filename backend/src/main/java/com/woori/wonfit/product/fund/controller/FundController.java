package com.woori.wonfit.product.fund.controller;


import com.woori.wonfit.product.deposit.dto.DepositResponse;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.dto.FundResponse;
import com.woori.wonfit.product.fund.service.FundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j // log 기록
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/fund")
public class FundController {

    private final FundService fundService;

    @GetMapping
        public List<FundResponse> findAll() {
            List<FundResponse> list = fundService.findAll();
//        log.info("list call {}", list.get(0));
            return list;
        }

    // id 값으로 조회하는 api
    @GetMapping("/{id}")
    public ResponseEntity<FundResponse> findById(@PathVariable Long id) {
        FundResponse fundResponse = fundService.findById(id);
        System.out.println("done");
        return ResponseEntity.ok(fundResponse);
    }





}
