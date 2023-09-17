package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.bank.domain.Bank;
import com.woori.wonfit.member.member.domain.Member;
import com.woori.wonfit.member.mydata.domain.MyData;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMydataBankRequest {

    private Long id;
    private int money; // money 필드의 데이터 타입을 int로 변경 (DB 스키마와 일치)

    private Bank bank;
    private Member member;

    // 생성자, getter 및 setter 메서드는 필요에 따라 추가하세요

    // toMydata 메서드 구현
    public static MemberMydataBankRequest toMydata(Member member, Bank bank, MyData myData) {
        return MemberMydataBankRequest.builder()
                .id(member.getId())
                .money(myData.getMoney()) // MyData에서 금액 정보를 가져옵니다.
                .bank(bank)
                .member(member)
                .build();
    }

}
