package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.FinancialDetails;

public interface FinancialDetailsRepository extends JpaRepository<FinancialDetails, Integer>{

}
