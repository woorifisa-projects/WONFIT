package com.woori.wonfit.product.savings.service;

import com.woori.wonfit.product.savings.domain.Savings;
import com.woori.wonfit.product.savings.dto.SavingsDTO;
import com.woori.wonfit.product.savings.dto.SavingsResponse;
import com.woori.wonfit.product.savings.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SavingsServiceImpl implements SavingsService {

    private final SavingsRepository savingsRepository;

    @Override
    public List<SavingsResponse> findAll() {
        List<SavingsResponse> getsavings = savingsRepository.findAll().stream()
                .map(savings -> new SavingsResponse(savings.getId(), savings.getSavingsName(), savings.getInterestRate(), savings.getPeriod(), savings.getTarget(), savings.getMaxDeposit(), savings.getSavingsInfo(), savings.getSavingsType()))
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
                .savingsType(request.getSavingsType())
                .build();


        savingsRepository.save(newSavings); // 수정된 내용을 저장
    }

    @Override
    public SavingsResponse findById(Long id) {
        Optional<Savings> savings = savingsRepository.findById(id);

        return SavingsResponse.builder()
                .id(savings.map(Savings::getId).orElse(0L))
                .savingsName(savings.map(Savings::getSavingsName).orElse("기본값"))
                .interestRate(savings.map(Savings::getInterestRate).orElse(0.0))
                .period(savings.map(Savings::getPeriod).orElse(0))
                .target(savings.map(Savings::getTarget).orElse("기본값"))
                .maxDeposit(savings.map(Savings::getMaxDeposit).orElse(0))
                .savingsInfo(savings.map(Savings::getSavingsInfo).orElse("기본값"))
                .savingsType(savings.map(Savings::getSavingsType).orElse("기본값"))
                .build();
    }
}


