package com.woori.wonfit.product.savings.service;

import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsDTO;
import com.woori.wonfit.product.savings.repository.SavingsRepository;
import com.woori.wonfit.product.savings.dto.SavingsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SavingsServiceImpl implements SavingsService {

    private final SavingsRepository savingsRepository;


    @Override
    public List<SavingsResponse> findAll() {
        List<SavingsResponse> getsavings = savingsRepository.findAll().stream()

                .map(savings -> new SavingsResponse(savings.getId(), savings.getSavingsName(), savings.getInterestRate(), savings.getPeriod(), savings.getTarget(), savings.getMaxDeposit(), savings.getSavingsInfo(),savings.getSavingsDesc(),savings.getSavingsType()))

                        .collect(Collectors.toList());

        return getsavings;
    }

    public void updateSavings(Long id, SavingsDTO request) {
        Savings savings = savingsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Savings not found"));

        Savings newSavings = Savings.builder()
                .id(id)
                .savingsName(request.getSavingsName())
                .interestRate(request.getInterestRate())
                .period(request.getPeriod())
                .target(request.getTarget())
                .maxDeposit(request.getMaxDeposit())
                .savingsInfo(request.getSavingsInfo())
                .savingsDesc(request.getSavingsDesc())
                .savingsType(request.getSavingsType())
                .build();


        savingsRepository.save(newSavings); // 수정된 내용을 저장
    }


}


