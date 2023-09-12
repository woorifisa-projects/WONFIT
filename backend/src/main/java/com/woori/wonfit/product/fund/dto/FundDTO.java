package com.woori.wonfit.product.fund.dto;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
public class FundDTO {

        private String fundName;
        private double returnRate1;
        private double returnRate2;
        private String fundType; // 안정형, 중립형, 공격형
        private double fundPrice;
        private String fundInfo;

        public FundDTO(String fundName, double returnRate1, double returnRate2, String fundType, double fundPrice, String fundInfo) {
                this.fundName = fundName;
                this.returnRate1 = returnRate1;
                this.returnRate2 = returnRate2;
                this.fundType = fundType;
                this.fundPrice = fundPrice;
                this.fundInfo = fundInfo;
        }
}
