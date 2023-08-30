package com.woori.wonfit.log.liked.domain;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.product.deposit.domain.Deposit;
import com.woori.wonfit.product.fund.domain.Fund;
import com.woori.wonfit.product.loan.domain.Loan;
import com.woori.wonfit.product.savings.domain.Savings;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "liked")
@Builder
@AllArgsConstructor
public class Liked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "deposit_id", nullable = true)
    private Deposit deposit;

    @ManyToOne
    @JoinColumn(name = "savings_id", nullable = true)
    private Savings savings;

    @ManyToOne
    @JoinColumn(name = "fund_id", nullable = true)
    private Fund fund;

    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = true)
    private Loan loan;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "investment_type")
    private String investmentType;

}
