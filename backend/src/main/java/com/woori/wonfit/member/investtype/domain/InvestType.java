package com.woori.wonfit.member.investtype.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.woori.wonfit.member.member.domain.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invest_type")
@Builder
public class InvestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "deposit_type", nullable = true)
    private String deposit_type;

    @Column(name = "savings_type", nullable = true)
    private String savings_type;

    @Column(name = "fund_type", nullable = true)
    private String fund_type;

    @Column(name = "loan_type", nullable = true)
    private String loan_type;

    @Column(name = "deposit_quiz_score", nullable = true)
    private Integer depositQuizScore;

    @Column(name = "savings_quiz_score", nullable = true)
    private Integer savingsQuizScore;

    @Column(name = "fund_quiz_score", nullable = true)
    private Integer fundQuizScore;

    @Column(name = "loan_quiz_score", nullable = true)
    private Integer loanQuizScore;
}
