package com.woori.wonfit.member.investtype.domain;

import com.woori.wonfit.member.member.domain.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invest_type")
@Builder
public class InvestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "deposit_type",nullable = true)
    private String deposit_type;

    @Column(name = "savings_type",nullable = true)
    private String savings_type;

    @Column(name = "fund_type",nullable = true)
    private String fund_type;

    @Column(name = "loan_type",nullable = true)
    private String loan_type;

    @Column(name = "deposit_quiz_score", nullable = true)
    private Integer depositQuizScore;

    @Column(name = "savings_quiz_score", nullable = true)
    private Integer savingsQuizScore;

    @Column(name = "fund_quiz_score", nullable = true)
    private Integer fundQuizScore;

    @Column(name = "loan_quiz_score", nullable = true)
    private Integer loanQuizScore;



    public static InvestType toEntity(InvestType investType, Member member){
        return InvestType.builder()
                .member(member)
                .deposit_type(investType.getDeposit_type())
                .savings_type(investType.getSavings_type())
                .fund_type(investType.getFund_type())
                .loan_type(investType.getLoan_type())
                .depositQuizScore(investType.getDepositQuizScore())
                .savingsQuizScore(investType.getSavingsQuizScore())
                .fundQuizScore(investType.getFundQuizScore())
                .loanQuizScore(investType.getLoanQuizScore())
                .build();
    }
}
