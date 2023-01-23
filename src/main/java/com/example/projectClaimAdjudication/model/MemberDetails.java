package com.example.projectClaimAdjudication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Member_Details")
public class MemberDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	private String memberName;
	private Date dob;
	
	@OneToMany(mappedBy = "memberDetail")
	private List<MemberPlanDetails> memberPlanList = new ArrayList<>();
}