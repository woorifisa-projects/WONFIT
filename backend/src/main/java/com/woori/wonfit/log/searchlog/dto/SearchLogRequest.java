package com.woori.wonfit.log.searchlog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class SearchLogRequest {

        private String searchWord; // 검색어
        private String searchDate; // 검색 날짜 및 시간
        private String searchUrl; // 검색 결과 URL
}
