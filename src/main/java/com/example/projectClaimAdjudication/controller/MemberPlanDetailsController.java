package com.example.projectClaimAdjudication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;
import com.example.projectClaimAdjudication.service.MemberDetailsService;
import com.example.projectClaimAdjudication.service.MemberPlanDetailsService;

@RestController
public class MemberPlanDetailsController {

	@Autowired
	MemberPlanDetailsService memberPlanDetailsService;
	
	@Autowired
	MemberDetailsService memberDetailsService;
	
	@PostMapping("/memberPlanDetails")
	private int saveOrUpdateMemberPlanDetails(@RequestBody MemberPlanDetails memberPlanDetails) {
		memberPlanDetailsService.saveOrUpdateMemberPlanDetails(memberPlanDetails);
		return memberPlanDetails.getMemberPlanId();
	}

	@GetMapping("/memberPlanDetails/{id}")
	private MemberPlanDetails getMemberPlanDetails(@PathVariable("id") int id) {

		return memberPlanDetailsService.getMemberPlanDetails(id);
	}

	@GetMapping("/memberPlanDetailsByMemberId/{memberId}")
	private List<MemberPlanDetails> getMemberPlanDetailsByMember(@PathVariable("memberId") Integer memberId) {
		MemberDetails memberDetailsById = memberDetailsService.getMemberDetailsById(memberId);
		return memberPlanDetailsService.getMemberPlanDetailsByMemberId(memberDetailsById);
	}

	@PostMapping("/memberPlanDetails/{id}")
	private int saveOrUpdateMemberPlanDetailsNew(@RequestBody MemberPlanDetails memberPlanDetails,
			@PathVariable("id") int id) {
		MemberDetails memberDetailsById = memberDetailsService.getMemberDetailsById(id);
		memberPlanDetails.setMemberDetail(memberDetailsById);
		memberPlanDetailsService.saveOrUpdateMemberPlanDetails(memberPlanDetails);
		return memberPlanDetails.getMemberPlanId();
	}
}
