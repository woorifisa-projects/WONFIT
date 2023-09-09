package com.woori.wonfit.manager.repository;

import com.woori.wonfit.manager.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository <Manager, Long> {
    Optional<Manager> findByLoginId(String id);

}