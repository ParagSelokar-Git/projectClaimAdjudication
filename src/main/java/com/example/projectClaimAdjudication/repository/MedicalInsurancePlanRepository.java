package com.example.projectClaimAdjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projectClaimAdjudication.model.MedicalInsurancePlan;

public interface MedicalInsurancePlanRepository extends JpaRepository<MedicalInsurancePlan, Integer> {

	@Query(value="select speciality from medical_insurance_plan where plan_id=?1",nativeQuery=true)
	public Float findSpecialityByPlanId(Integer planId);
}
