package com.woori.wonfit.manager.controller;

import com.woori.wonfit.manager.dto.ManagerResponse;
import com.woori.wonfit.manager.service.ManagerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public List<ManagerResponse> findAll() {
        List<ManagerResponse> list = managerService.findAll();
        log.info("list call {}",list.get(0));
        return list;
    }

}

