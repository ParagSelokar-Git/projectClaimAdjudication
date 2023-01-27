package com.example.projectClaimAdjudication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectClaimAdjudication.model.ClaimDetails;
import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;
import com.example.projectClaimAdjudication.service.ClaimDetailsService;
import com.example.projectClaimAdjudication.service.MemberPlanDetailsService;

@RestController
public class ClaimDetailsController {
	
	@Autowired
	ClaimDetailsService claimDetailsService;

	@Autowired
	MemberPlanDetailsService memberPlanDetailsService;
	
	@PostMapping("/claimDetails/{memberPlanId}")
	private int saveOrUpdateClaimDetails(@RequestBody ClaimDetails claimDetails,
			@PathVariable("memberPlanId") int memberPlanId) {		
		MemberPlanDetails memberPlanDetails = memberPlanDetailsService.getMemberPlanDetails(memberPlanId);
		claimDetails.setMemberPlanDetails(memberPlanDetails);
		claimDetailsService.saveOrUpdateClaimDetails(claimDetails);
		return claimDetails.getClaimId();
	}
	
	@GetMapping("/claimDetails/{claimId}")
	private ClaimDetails getClaimDetails(@PathVariable("claimId") int claimId) {
		return claimDetailsService.getClaimDetails(claimId);
	}

	@GetMapping("/claimDetailsByMemberPlanId/{memberPlanId}")
	private List<ClaimDetails> getClaimDetailsByMemberPlanId(@PathVariable("memberPlanId") Integer memberPlanId) {		
		MemberPlanDetails memberPlanDetails = memberPlanDetailsService.getMemberPlanDetails(memberPlanId);
		return claimDetailsService.getClaimDetailsByMemberPlanId(memberPlanDetails);
	}
	
	
}
