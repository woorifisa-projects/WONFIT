package com.woori.wonfit.product.fund.service;


import com.woori.wonfit.product.deposit.dto.DepositResponse;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.fund.dto.FundDTO;
import com.woori.wonfit.product.fund.dto.FundRequest;
import com.woori.wonfit.product.fund.dto.FundResponse;
import com.woori.wonfit.product.savings.dto.SavingsDTO;

import java.util.List;

public interface FundService {

    List<FundResponse> findAll();

    void updateFund(Long id, FundDTO fundDTO);


    FundResponse findById(Long id);
}
