package com.example.projectClaimAdjudication.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="memberIdFK", referencedColumnName = "memberId")
//	private List<MemberPlanDetails> memberPlanList;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<MemberPlanDetails> memberPlanList;
}