package com.woori.wonfit.member.investtype.controller;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.service.InvestTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/recommended/product")
@RequiredArgsConstructor
@Slf4j
public class InvestTypeController {
    private final InvestTypeService investTypeService;
    @GetMapping
    public List<InvestTypeResponse> findByMemberId(HttpServletRequest request) {
        log.info(request.getCookies().toString());
        List<InvestType> investTypes = investTypeService.findByMemberId(request);
        List<InvestTypeResponse> responseList = new ArrayList<>();

        for (InvestType investType : investTypes) {
            InvestTypeResponse response = InvestTypeResponse.From_InvestType(investType);
            responseList.add(response);
        }
        return responseList;
    }
    @PostMapping("/save/inv_type")
    public ResponseEntity<String> createInvestType(@RequestBody InvestTypeRequest request1,HttpServletRequest request) {
        InvestType createdInvestType = investTypeService.save(request,request1);
        return new ResponseEntity<>("저장 완료", HttpStatus.OK);
    }
}
