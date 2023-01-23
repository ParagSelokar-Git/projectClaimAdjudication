package com.example.projectClaimAdjudication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Member_Plan_Details")
public class MemberPlanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberPlanId;
	private Integer memberId;
	private Integer planId;
	private Date startDate;
	private Date endDate;
	private Float remainingDeductableAmount;
	private Float remainingOutOfPocketAmount;
	private String status;
	
	@ManyToOne
	private MemberDetails memberDetail;
	
	@OneToMany(mappedBy = "memberPlanDetails")
	private List<ClaimDetails> claimDetailsList = new ArrayList<>();
}

