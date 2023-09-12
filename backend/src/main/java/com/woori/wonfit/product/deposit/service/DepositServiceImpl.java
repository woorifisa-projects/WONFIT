package com.woori.wonfit.product.deposit.service;

import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.deposit.dto.DepositDTO;
import com.woori.wonfit.product.deposit.repository.DepositRepository;
import com.woori.wonfit.product.deposit.dto.DepositResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private final DepositRepository depositRepository;

    @Override
    public List<DepositResponse> findAll() {
        List<DepositResponse> DepositResponses = depositRepository.findAll().stream()
                .map(Deposit -> new DepositResponse(Deposit.getId(),Deposit.getDepositName(),Deposit.getInterestRate(),Deposit.getPeriod(),Deposit.getTarget(),Deposit.getMinDeposit(),Deposit.getDepositInfo(),Deposit.getDepositType()))
                .collect(Collectors.toList());

        return DepositResponses;
    }


    public void updateDeposit(Long id, DepositDTO request) {
        Deposit deposit = depositRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Deposit not found"));

        Deposit newDeposit = Deposit.builder()
                .id(id)
                .depositName(request.getDepositName())
                .interestRate(request.getInterestRate())
                .period(request.getPeriod())
                .target(request.getTarget())
                .minDeposit(request.getMinDeposit())
                .depositInfo(request.getDepositInfo())
                .depositType(request.getDepositType())
                .build();


        depositRepository.save(newDeposit); // 수정된 내용을 저장
    }

    @Override
    public DepositResponse findById(Long id) {
        Optional<Deposit> deposit = depositRepository.findById(id);

        return DepositResponse.builder()
                .id(deposit.map(Deposit::getId).orElse(0L))
                .depositName(deposit.map(Deposit::getDepositName).orElse("기본값"))
                .interestRate(deposit.map(Deposit::getInterestRate).orElse(0.0))
                .period(deposit.map(Deposit::getPeriod).orElse(0))
                .target(deposit.map(Deposit::getTarget).orElse("기본값"))
                .minDeposit(deposit.map(Deposit::getMinDeposit).orElse(0))
                .depositInfo(deposit.map(Deposit::getDepositInfo).orElse("기본값"))
                .depositType(deposit.map(Deposit::getDepositType).orElse("기본값"))
                .build();
    }

}
