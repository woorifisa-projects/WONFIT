package com.woori.wonfit.member.memberinfo.domain;

import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.member.dto.MemberDetails;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "member_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id") // 외래 키를 사용하는 주인인 Member에 대한 참조
    private Member member;

    @Column(name = "marketing_info_agree")
    private boolean marketingInfoAgree;

    @Column(name = "address")
    private String address;

    @Column(name = "is_married")
    private boolean isMarried;

    @Column(name = "children_count")
    private int childrenCount;

    @Column(name = "is_householder")
    private boolean isHouseholder; // 세대주 여부

    @Column(name = "is_annuity")
    private boolean isAnnuity; // 연금 수령 여부

    @Column(name = "job")
    private String job;

    @Column(name="invest_type")
    private String investType; // 투자성향


    public static MemberInfo toEntity(Long id,Member member, MemberDetails memberDetails){
        return MemberInfo.builder()
                .id(id)
                .member(member)
                .marketingInfoAgree(memberDetails.isMarketingInfoAgree())
                .address(memberDetails.getAddress())
                .isMarried(memberDetails.isMarried())
                .childrenCount(memberDetails.getChildrenCount())
                .isHouseholder(memberDetails.isHouseHolder())
                .isAnnuity(memberDetails.isAnnuity())
                .job(memberDetails.getJob())
                .investType(memberDetails.getInvestType())
                .build();
    }
}