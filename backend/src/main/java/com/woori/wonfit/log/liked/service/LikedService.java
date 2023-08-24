package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.domain.Liked;
import com.woori.wonfit.log.liked.dto.LikedAddRequest;
import com.woori.wonfit.log.liked.dto.LikedMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikedService {
    List<Liked> getLikedProducts(Long memberId);

    Liked addLikedProduct(LikedAddRequest request);

}
