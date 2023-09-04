package com.woori.wonfit.product.savings.service;

import com.woori.wonfit.product.savings.dto.SavingsDTO;
import com.woori.wonfit.product.savings.dto.SavingsResponse;

import java.util.List;

public interface SavingsService {

    List<SavingsResponse> findAll();

    void updateSavings(Long id, SavingsDTO savingsDTO);


    SavingsResponse findById(Long id);
}
