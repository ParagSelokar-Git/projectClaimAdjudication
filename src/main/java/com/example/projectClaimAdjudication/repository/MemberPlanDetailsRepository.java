package com.example.projectClaimAdjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectClaimAdjudication.model.MemberPlanDetails;

public interface MemberPlanDetailsRepository  extends JpaRepository<MemberPlanDetails, Integer> {
	

}