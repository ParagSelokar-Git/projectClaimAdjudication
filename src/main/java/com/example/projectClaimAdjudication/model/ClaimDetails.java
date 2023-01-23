package com.example.projectClaimAdjudication.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Claim_Details")
public class ClaimDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer claimId;
	private Integer memberPlanId;
	private Integer drugId;
	private Float drugCost;
	private Float fee;
	private Float tax;
	private Float copay;
	private Float planPay;	
	private Date claimDate;
	private String claimType;
	
	@ManyToOne
	private MemberPlanDetails memberPlanDetails;
}
