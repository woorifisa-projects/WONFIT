package com.woori.wonfit.product.deposit.controller;

import com.woori.wonfit.product.deposit.dto.DepositResponse;
import com.woori.wonfit.product.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/product/deposit")
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;


    @GetMapping
    public List<DepositResponse> findAll() {
        List<DepositResponse> list;
        try {
            list = depositService.findAll();
            if (!list.isEmpty()) {
                log.info("list call {}", list.get(0));
            } else {
                log.info("No data found in the list.");
            }
        } catch (IndexOutOfBoundsException e) {
            log.error("Index out of bounds error occurred: {}", e.getMessage());
            list = new ArrayList<>(); // Initialize an empty list or handle the situation in an appropriate way
        } catch (Exception e) {
            log.error("An error occurred: {}", e.getMessage());
            list = new ArrayList<>(); // Initialize an empty list or handle the situation in an appropriate way
        }
        return list;
    }

}
