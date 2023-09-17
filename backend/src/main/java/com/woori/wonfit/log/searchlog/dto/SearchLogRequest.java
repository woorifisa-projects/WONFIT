package com.woori.wonfit.log.searchlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchLogRequest {
    private String searchWord; // 검색어
}
