package com.woori.wonfit.member.investtype.controller;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.investtype.dto.InvestTypeResponse;
import com.woori.wonfit.member.investtype.service.InvestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recommended/product")
@RequiredArgsConstructor
public class InvestTypeController {
    private final InvestTypeService investTypeService;

    @GetMapping("/{memberId}")
    public List<InvestTypeResponse> findByMemberId(@PathVariable Long memberId) {
        List<InvestType> investTypes = investTypeService.findByMemberId(memberId);
        List<InvestTypeResponse> responseList = new ArrayList<>();

        for (InvestType investType : investTypes) {
            InvestTypeResponse response = InvestTypeResponse.From_InvestType(investType);
            responseList.add(response);
        }
        return responseList;
    }
    @PostMapping("/{memberId}/save/inv_type")
    public ResponseEntity<String> createInvestType(@RequestBody InvestTypeRequest request, @PathVariable Long memberId) {
        InvestType createdInvestType = investTypeService.save(request,memberId);
        return new ResponseEntity<>("저장 완료", HttpStatus.OK);
    }
}
