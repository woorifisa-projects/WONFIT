package com.woori.wonfit.log.liked.service;

import com.woori.wonfit.log.liked.domain.Liked;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikedService {

    List<Liked> findByAllMemberId(Long memberId);

    String deleteById(Long id);


}
