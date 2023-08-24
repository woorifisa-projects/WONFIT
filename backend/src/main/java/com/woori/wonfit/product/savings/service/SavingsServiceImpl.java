package com.woori.wonfit.product.savings.service;

import com.woori.wonfit.product.savings.domain.SavingsRepository;
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
                .map(savings -> new SavingsResponse(savings.getId(), savings.getSavingsName(), savings.getInterestRate(), savings.getPeriod(), savings.getTarget(), savings.getMaxDeposit(), savings.getSavingsInfo(),savings.getSavingsDesc(),savings.getSortingOptions()))
                        .collect(Collectors.toList());

        return getsavings;
    }

}
