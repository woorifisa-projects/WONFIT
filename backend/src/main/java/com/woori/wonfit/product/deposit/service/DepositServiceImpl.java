package com.woori.wonfit.product.deposit.service;

import com.woori.wonfit.product.deposit.domain.DepositRepository;
import com.woori.wonfit.product.deposit.dto.DepositResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepositServiceImpl implements DepositService {
    private final DepositRepository depositRepository;

    public DepositServiceImpl(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    @Override
    public List<DepositResponse> findAll() {
        List<DepositResponse> DepositResponses = depositRepository.findAll().stream()
                .map(Deposit -> new DepositResponse(Deposit.getId(),Deposit.getMember(),Deposit.getDepositName(),Deposit.getInterestRate(),Deposit.getPeriod(),Deposit.getTarget(),Deposit.getMinDeposit(),Deposit.getDepositInfo(),Deposit.getDepositDesc(),Deposit.getSortingOptions()))
                .collect(Collectors.toList());

        return DepositResponses;
    }
}
