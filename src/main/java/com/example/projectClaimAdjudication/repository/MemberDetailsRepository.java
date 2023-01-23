package com.example.projectClaimAdjudication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectClaimAdjudication.model.MemberDetails;

public interface MemberDetailsRepository  extends JpaRepository<MemberDetails, Integer> {
	

}
