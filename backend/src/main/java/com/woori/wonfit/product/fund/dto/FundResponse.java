package com.woori.wonfit.product.fund.dto;

import lombok.*;


@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FundResponse {

        private Long id;
        private String fundName;
        private double returnRate1;
        private double returnRate2;
        private String fundType; // 안정형, 중립형, 공격형
        private double fundPrice;
        private String fundInfo;
        private String fundDesc; // 상세 설명

}
