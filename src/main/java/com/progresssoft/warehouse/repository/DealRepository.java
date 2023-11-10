package com.progresssoft.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progresssoft.warehouse.dto.DealDTO;

@Repository
public interface DealRepository extends JpaRepository<DealDTO, Long>{
}

