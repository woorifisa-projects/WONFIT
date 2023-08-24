package com.woori.wonfit.product.fund.service;

import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.dto.FundResponse;
import com.woori.wonfit.product.fund.repository.FundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
                        (fund.getId(), fund.getFundName(), fund.getReturnRate1(), fund.getReturnRate2(), fund.getFundType(), fund.getFundPrice(), fund.getFundInfo(), fund.getFundDesc(), fund.getFundType())).collect(Collectors.toList());


        return getfunds;
    }

    @Override
    public Fund createFund(FundRequest fundRequest) {
        Fund fund = new Fund();
        fund.setFundName(fundRequest.getFundName());
        fund.setFundInfo(fundRequest.getFundInfo());
        fund.setFundDesc(fundRequest.getFundDesc());
        fund.setReturnRate1(fundRequest.getReturnRate1());
        fund.setReturnRate2(fundRequest.getReturnRate2());
        fund.setFundPrice(fundRequest.getFundPrice());
        fund.setFundType(fundRequest.getFundType());

        return fundRepository.save(fund);
    }


}
