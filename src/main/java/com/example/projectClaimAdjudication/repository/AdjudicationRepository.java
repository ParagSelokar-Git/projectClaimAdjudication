package com.example.projectClaimAdjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectClaimAdjudication.model.MedicalInsurancePlan;


public interface AdjudicationRepository  extends JpaRepository<MedicalInsurancePlan, Integer> {
	

}
