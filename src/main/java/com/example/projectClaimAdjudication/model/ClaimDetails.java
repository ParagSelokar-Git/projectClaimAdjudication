package com.example.projectClaimAdjudication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
