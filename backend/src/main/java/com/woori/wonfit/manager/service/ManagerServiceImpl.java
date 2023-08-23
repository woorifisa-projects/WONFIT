package com.woori.wonfit.manager.service;

import com.woori.wonfit.manager.repository.ManagerRepository;
import com.woori.wonfit.manager.dto.ManagerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository){
       super();
       this.managerRepository = managerRepository;
    }

    @Override
    public List<ManagerResponse> findAll() {
        List<ManagerResponse> Questions = managerRepository.findAll().stream()
                .map(manager -> new ManagerResponse(manager.getQuestionContent())).collect(Collectors.toList());

        return Questions;
    }
}

