package com.woori.wonfit.log.searchlog.service;

import com.woori.wonfit.log.searchlog.dto.SearchLogRequest;
import com.woori.wonfit.log.searchlog.dto.SearchLogResponse;

import java.util.List;

public interface SearchLogService {

    void saveSearchLog(Long id, SearchLogRequest searchLogRequest);

    List<SearchLogResponse> findById(Long memberid);

    void deleteSearchLog(Long memberid, String searchWord);
}
