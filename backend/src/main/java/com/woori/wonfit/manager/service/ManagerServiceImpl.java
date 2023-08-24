package com.woori.wonfit.manager.service;

import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.domain.FundRepository;
import com.woori.wonfit.product.fund.dto.FundRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final FundRepository fundRepository;

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
        fund.setSortingOptions(fundRequest.getSortingOptions());

        return fundRepository.save(fund);
    }


}
