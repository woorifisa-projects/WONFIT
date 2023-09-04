package com.woori.wonfit.member.investtype.domain;

import com.woori.wonfit.member.investtype.dto.InvestTypeRequest;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
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

    @ManyToOne
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

    public static InvestType toEntity(InvestTypeRequest investType, Member member){
        return InvestType.builder()
                .member(member)
                .deposit_type(investType.getDepositType())
                .savings_type(investType.getSavingsType())
                .fund_type(investType.getFundType())
                .loan_type(investType.getLoanType())
                .build();
    }
}
