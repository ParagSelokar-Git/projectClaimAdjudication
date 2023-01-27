package com.example.projectClaimAdjudication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectClaimAdjudication.model.ClaimDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;

public interface ClaimDetailsRepository extends JpaRepository<ClaimDetails, Integer> {

	public List<ClaimDetails> findByMemberPlanDetails(MemberPlanDetails id);
}
