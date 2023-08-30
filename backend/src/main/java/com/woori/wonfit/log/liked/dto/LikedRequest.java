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
public class LikedRequest {
    private Long id;
    private Deposit deposit;
    private Savings savings;
    private Fund fund;
    private Loan loan;
    private String productType;
    private String investmentType;
    private Member member;

    public static Liked To_Liked(LikedRequest likedRequest) {
        return Liked.builder().id(likedRequest.getId()).member(likedRequest.getMember()).deposit(likedRequest.getDeposit()).savings(likedRequest.getSavings()).fund(likedRequest.getFund()).loan(likedRequest.getLoan()).productType(likedRequest.getProductType()).investmentType(likedRequest.getInvestmentType()).build();
    }
}