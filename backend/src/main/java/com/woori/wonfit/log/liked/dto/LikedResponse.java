package com.woori.wonfit.log.liked.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class LikedResponse {
    private Long id;
    private String depositName;
    private String productType;
    private String investmentType;

    public LikedResponse(Long id, String depositName, String productType, String investmentType) {
        this.id = id;
        this.depositName = depositName;
        this.productType = productType;
        this.investmentType = investmentType;
    }
}
