package com.woori.wonfit.product.deposit.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepositRequest {

    private Long id;
    private String depositName;
    private double interestRate;
    private int period;
    private String target;
    private int minDeposit;
    private String depositInfo;
    private String depositDesc;
}

