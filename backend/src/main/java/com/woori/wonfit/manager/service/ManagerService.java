package com.woori.wonfit.manager.service;

import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundRequest;

public interface ManagerService {

    Fund createFund(FundRequest fundRequest);
}
