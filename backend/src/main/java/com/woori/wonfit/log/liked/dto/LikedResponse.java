package com.woori.wonfit.log.liked.dto;

import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LikedResponse {
    private Long id;
    private Deposit deposit;
    private Loan loan;
    private Fund fund;
    private Savings savings;
    private String productType;
    private String investmentType;
    private Member member;

    public static LikedResponse From_liked(Liked liked) {
        return LikedResponse.builder().id(liked.getId()).deposit(liked.getDeposit()).loan(liked.getLoan()).fund(liked.getFund()).savings(liked.getSavings()).productType(liked.getProductType()).investmentType(liked.getInvestmentType()).member(liked.getMember()).build();
    }
}