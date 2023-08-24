package com.woori.wonfit.product.fund.service;

import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.dto.FundResponse;

import java.util.List;

public interface FundService {

    List<FundResponse> findAll();

    Fund createFund(FundRequest fundRequest);
}
