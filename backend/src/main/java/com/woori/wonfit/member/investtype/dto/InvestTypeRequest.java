package com.woori.wonfit.member.investtype.dto;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvestTypeRequest {
    private String productType;
    private int score;
}