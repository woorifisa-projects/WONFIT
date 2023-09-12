package com.woori.wonfit.member.investtype.controller;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.investtype.dto.InvestTypeResponse;
import com.woori.wonfit.member.investtype.service.InvestTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member/recommend/product")
@RequiredArgsConstructor
@Slf4j
public class InvestTypeController {
    private final InvestTypeService investTypeService;

    @GetMapping
    public List<InvestTypeResponse> findByMemberId(String id) {
        List<InvestType> investTypes = investTypeService.findByMemberId(id);
        List<InvestTypeResponse> responseList = new ArrayList<>();

        for (InvestType investType : investTypes) {
            InvestTypeResponse response = InvestTypeResponse.From_InvestType(investType);
            responseList.add(response);
        }
        return responseList;
    }

    @PostMapping
    public ResponseEntity<Cookie> createInvestType(@RequestBody InvestTypeRequest investTypeRequest, @AuthenticationPrincipal String id, HttpServletResponse response) {
        Cookie cookie = investTypeService.save(investTypeRequest, id);
        response.addCookie(cookie);
        return new ResponseEntity<>(cookie, HttpStatus.OK);
    }
}
