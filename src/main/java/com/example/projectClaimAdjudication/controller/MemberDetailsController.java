package com.example.projectClaimAdjudication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.service.MemberDetailsService;

@RestController
public class MemberDetailsController {

	@Autowired
	MemberDetailsService memberDetailsService;
	
	@PostMapping("/memberDetails")
	private int saveOrUpdateMemberDetails(@RequestBody MemberDetails memberDetails) {
		memberDetailsService.saveOrUpdateMemberDetails(memberDetails);
		return memberDetails.getMemberId();
	}

	@GetMapping("/memberDetails/{id}")
	private MemberDetails getMemberDetails(@PathVariable("id") int id) {
		return memberDetailsService.getMemberDetailsById(id);
	}
}
