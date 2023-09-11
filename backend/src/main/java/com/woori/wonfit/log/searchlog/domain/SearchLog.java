package com.woori.wonfit.log.searchlog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.woori.wonfit.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "search_log")
public class SearchLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "search_word")
    private String searchWord; // 검색어

    @Column(name = "search_date")
    private LocalDateTime searchDate; // 검색 날짜 및 시간

    @Column(name = "search_url")
    private String searchUrl; // 검색 결과 URL

}
