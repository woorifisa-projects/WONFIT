package com.woori.wonfit.product.fund.service;

import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundResponse;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundDTO;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.dto.FundResponse;
import com.woori.wonfit.product.fund.repository.FundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FundServiceImpl implements FundService {

    private final FundRepository fundRepository;


    @Override
    public List<FundResponse> findAll() {
        List<FundResponse> getfunds = fundRepository.findAll()
                .stream()
                .map(fund -> new FundResponse

                        (fund.getId(), fund.getFundName(), fund.getReturnRate1(), fund.getReturnRate2(), fund.getFundType(), fund.getFundPrice(), fund.getFundInfo(), fund.getFundDesc())).collect(Collectors.toList());


        return getfunds;
    }


    public void updateFund(Long id, FundDTO request) {
        Fund fund = fundRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fund not found"));

        Fund newFund = Fund.builder()
                .id(id)
                .fundName(request.getFundName())
                .returnRate1(request.getReturnRate1())
                .returnRate2(request.getReturnRate2())
                .fundPrice(request.getFundPrice())
                .fundType(request.getFundType())
                .fundInfo(request.getFundInfo())
                .fundDesc(request.getFundDesc())
                .build();

        fundRepository.save(newFund); // 수정된 내용을 저장
    }

    @Override
    public FundResponse findById(Long id) {
        Optional<Fund> fund = fundRepository.findById(id);

        return FundResponse.builder()
                .id(fund.map(Fund::getId).orElse(0L))
                .fundName(fund.map(Fund::getFundName).orElse("기본값"))
                .returnRate1(fund.map(Fund::getReturnRate1).orElse(0.0))
                .returnRate2(fund.map(Fund::getReturnRate2).orElse(0.0))
                .fundPrice(fund.map(Fund::getFundPrice).orElse(0.0))
                .fundInfo(fund.map(Fund::getFundInfo).orElse("기본값"))
                .fundDesc(fund.map(Fund::getFundDesc).orElse("기본값"))
                .fundType(fund.map(Fund::getFundType).orElse("기본값"))
                .build();
    }

}
