package com.woori.wonfit.manager.repository;

import com.woori.wonfit.manager.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository <Manager, Long> {

}