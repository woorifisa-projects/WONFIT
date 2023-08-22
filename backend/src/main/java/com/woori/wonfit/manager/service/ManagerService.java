package com.woori.wonfit.manager.service;

import com.woori.wonfit.manager.dto.ManagerResponse;

import java.util.List;

public interface ManagerService {

    List<ManagerResponse> findAll();
}
