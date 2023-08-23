package com.woori.wonfit.product.deposit.service;

import com.woori.wonfit.product.deposit.dto.DepositResponse;

import java.util.List;

public interface DepositService {
    List<DepositResponse> findAll();

}
