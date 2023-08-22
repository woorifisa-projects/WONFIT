package com.woori.wonfit.manager.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository <Manager, Long> {

    List<Manager> findAll();
}