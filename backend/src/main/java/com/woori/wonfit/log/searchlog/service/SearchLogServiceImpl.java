package com.woori.wonfit.log.searchlog.service;

import com.woori.wonfit.log.searchlog.domain.SearchLog;
import com.woori.wonfit.log.searchlog.dto.SearchLogRequest;
import com.woori.wonfit.log.searchlog.dto.SearchLogResponse;
import com.woori.wonfit.log.searchlog.repository.SearchLogRepository;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.repository.MemberRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class SearchLogServiceImpl implements SearchLogService {

    private final SearchLogRepository searchLogRepository;
    private final MemberRepository memberRepository;

    @Override
    public void saveSearchLog(Long memberId, SearchLogRequest searchLogRequest) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + memberId));
        SearchLog searchLog = SearchLog.builder()
                .searchWord(searchLogRequest.getSearchWord())
                .searchDate(LocalDateTime.parse(searchLogRequest.getSearchDate()))
                .searchUrl(searchLogRequest.getSearchUrl())
                .member(member)
                .build();
        searchLogRepository.save(searchLog);
    }


    @Override
    public List<SearchLogResponse> findById(Long memberId) {
        List<SearchLog> searchLogList = searchLogRepository.findByMemberId(memberId);
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + memberId));

        return searchLogList.stream()
                .map(searchLog -> SearchLogResponse.builder()
                        .searchWord(searchLog.getSearchWord())
                        .searchDate(String.valueOf(searchLog.getSearchDate()))
                        .searchUrl(searchLog.getSearchUrl())
                        .memberId(member.getId())
                        .build())
                .collect(Collectors.toList());
    }
}
