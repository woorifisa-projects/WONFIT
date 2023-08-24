package com.woori.wonfit.product.deposit.service;

import com.woori.wonfit.product.deposit.domain.DepositRepository;
import com.woori.wonfit.product.deposit.dto.DepositResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {
    private final DepositRepository depositRepository;

    @Override
    public List<DepositResponse> findAll() {
        List<DepositResponse> DepositResponses = depositRepository.findAll().stream()
                .map(Deposit -> new DepositResponse(Deposit.getId(),Deposit.getDepositName(),Deposit.getInterestRate(),Deposit.getPeriod(),Deposit.getTarget(),Deposit.getMinDeposit(),Deposit.getDepositInfo(),Deposit.getDepositDesc()))
                .collect(Collectors.toList());

        return DepositResponses;
    }
}
