package com.woori.wonfit.log.liked.dto;

import com.woori.wonfit.log.liked.domain.Liked;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikedMapper {
    public List<LikedResponse> toDTOList(List<Liked> likedList) {
        return likedList.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public LikedResponse toDTO(Liked liked) {
        // 여기서 엔티티의 필드를 DTO로 매핑해 줍니다.
        return new LikedResponse(
            liked.getId(),
            liked.getDeposit().getDepositName(),
            liked.getProductType(),
            liked.getInvestmentType()
        );
    }
}
