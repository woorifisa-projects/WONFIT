package com.woori.wonfit.member.searchlog.domain;


import com.woori.wonfit.member.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Table (name = "member_search_log")
public class MemberSearchLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "search_word")
    private String searchWord; // 검색어

    @Column(name = "search_date")
    private LocalDateTime searchDate; // 검색 날짜 및 시간

    @Column(name = "search_url")
    private String searchUrl; // 검색 결과 URL
}
