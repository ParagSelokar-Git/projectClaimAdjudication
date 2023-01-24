package com.example.projectClaimAdjudication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;

public interface MemberPlanDetailsRepository  extends JpaRepository<MemberPlanDetails, Integer> {
	
	public List<MemberPlanDetails> findByMemberDetail(MemberDetails id);

}