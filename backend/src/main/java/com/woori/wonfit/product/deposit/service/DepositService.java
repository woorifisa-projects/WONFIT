package com.woori.wonfit.product.deposit.service;

import com.woori.wonfit.product.deposit.dto.DepositDTO;
import com.woori.wonfit.product.deposit.dto.DepositResponse;

import java.util.List;

public interface DepositService {
    List<DepositResponse> findAll();

    void updateDeposit(Long id, DepositDTO depositDTO);

    DepositResponse findById(Long id);
}
