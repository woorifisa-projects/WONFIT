package com.woori.wonfit.product.fund.service;


import com.woori.wonfit.product.fund.dto.FundDTO;
import com.woori.wonfit.product.fund.dto.FundResponse;

import java.util.List;

public interface FundService {

    List<FundResponse> findAll();

    void updateFund(Long id, FundDTO fundDTO);

    FundResponse findById(Long id);
}
