package com.woori.wonfit.member.investtype.dto;

import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.member.domain.Member;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvestTypeRequest {
//    private String depositType;
//    private String savingsType;
//    private String fundType;
//    private String loanType;
//    private int depositQuizScore;
//    private int savingsQuizScore;
//    private int fundQuizScore;
//    private int loanQuizScore;
    private String productType;
    private int score;
}