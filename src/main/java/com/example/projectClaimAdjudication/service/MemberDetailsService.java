package com.example.projectClaimAdjudication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.repository.MemberDetailsRepository;

@Service
public class MemberDetailsService {

	@Autowired
	MemberDetailsRepository memberDetailsRepository;

	public void saveOrUpdateMemberDetails(MemberDetails memberDetails) {
		memberDetailsRepository.save(memberDetails);
	}

	public MemberDetails getMemberDetailsById(int id) {
		return memberDetailsRepository.findById(id).get();
	}
}
