package com.example.projectClaimAdjudication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectClaimAdjudication.model.ClaimDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;
import com.example.projectClaimAdjudication.repository.ClaimDetailsRepository;

@Service
public class ClaimDetailsService {
	
	@Autowired
	ClaimDetailsRepository claimDetailsRepository;
	
	public void saveOrUpdateClaimDetails(ClaimDetails claimDetails) {
		claimDetailsRepository.save(claimDetails);
	}

	public ClaimDetails getClaimDetails(int id) {
		return claimDetailsRepository.findById(id).get();
	}

	public List<ClaimDetails> getClaimDetailsByMemberPlanId(MemberPlanDetails memberPlanId) {

		return claimDetailsRepository.findByMemberPlanDetails(memberPlanId);
	}
	
}
