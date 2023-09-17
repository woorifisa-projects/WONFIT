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
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchLogServiceImpl implements SearchLogService {

    private final SearchLogRepository searchLogRepository;
    private final MemberRepository memberRepository;



    @Override
    public void saveSearchLog(Long memberId, SearchLogRequest searchLogRequest) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + memberId));
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String loginTime = dateTime.format(formatter).substring(0, 19);
        SearchLog searchLog = SearchLog.builder()
                .searchWord(searchLogRequest.getSearchWord())
                .searchDate(loginTime)
                .member(member)
                .build();
        searchLogRepository.save(searchLog);
    }

    @Override
    public List<SearchLogResponse> findById(Long id) {

        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + id));

        List<SearchLog> searchLogList = searchLogRepository.findByMemberId(member.getId());

        return searchLogList.stream()
                .map(searchLog -> SearchLogResponse.builder()
                        .searchWord(searchLog.getSearchWord())
                        .searchDate(String.valueOf(searchLog.getSearchDate()))
                        .searchUrl(searchLog.getSearchUrl())
                        .memberId(member.getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSearchLog(Long memberId, String searchWord) {
        SearchLog searchLog = searchLogRepository.findByMemberIdAndSearchWord(memberId, searchWord);

        if (searchLog != null) {
            searchLogRepository.delete(searchLog);
        } else {
            throw new IllegalArgumentException("해당 검색기록이 없습니다. id=" + memberId);
        }
    }
}
