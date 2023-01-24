package com.example.projectClaimAdjudication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectClaimAdjudication.model.MemberDetails;
import com.example.projectClaimAdjudication.model.MemberPlanDetails;
import com.example.projectClaimAdjudication.repository.MemberPlanDetailsRepository;

@Service
public class MemberPlanDetailsService {
	@Autowired
	MemberPlanDetailsRepository memberPlanDetailsRepository;

	public void saveOrUpdateMemberPlanDetails(MemberPlanDetails memberPlanDetails) {
		memberPlanDetailsRepository.save(memberPlanDetails);
	}

	public MemberPlanDetails getMemberPlanDetails(int id) {
		return memberPlanDetailsRepository.findById(id).get();
	}

	public List<MemberPlanDetails> getMemberPlanDetailsByMemberId(MemberDetails memberId) {

		return memberPlanDetailsRepository.findByMemberDetail(memberId);
	}
}
