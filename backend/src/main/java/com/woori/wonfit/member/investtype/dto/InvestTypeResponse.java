package com.woori.wonfit.member.investtype.dto;

import com.woori.wonfit.log.subscribelog.domain.SubscribeLog;
import com.woori.wonfit.log.subscribelog.dto.SubscribeLogResponse;
import com.woori.wonfit.member.investtype.domain.InvestType;
import com.woori.wonfit.member.member.domain.Member;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvestTypeResponse {
    private Long id;
    private Member member;
    private String deposit_type;
    private String savings_type;
    private String fund_type;
    private String loan_type;

    public static InvestTypeResponse From_InvestType(InvestType investType){
        return InvestTypeResponse.builder()
                .id(investType.getId())
                .member(investType.getMember())
                .deposit_type(investType.getDeposit_type())
                .savings_type(investType.getSavings_type())
                .fund_type(investType.getFund_type())
                .loan_type(investType.getLoan_type())
                .build();

    }
}
